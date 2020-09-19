package me.diisk.airpg.Entity;

import me.diisk.airpg.Item.Group;
import me.diisk.airpg.Item.Item;
import me.diisk.airpg.Item.Slot;
import me.diisk.airpg.Item.Type;

import static me.diisk.airpg.Attributes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Battle;
import me.diisk.airpg.Battle.LogLine;
import me.diisk.airpg.HealSource;
import me.diisk.airpg.Skill;
import me.diisk.airpg.Team;
import me.diisk.airpg.CustomList.Ordenable;
import me.diisk.airpg.Damage.Damage;
import me.diisk.airpg.Damage.DamageSource;
import me.diisk.airpg.Effect.Effect;
import me.diisk.airpg.Effect.EffectType;

import static me.diisk.airpg.Utils.*;

public class Entity implements Ordenable{

	public static final int MAX_LEVEL = 30;

	public static final int EQUIPMENTS_LENGTH = 12;
	public static final int INVENTORY_LENGTH = 30;

	public static final int ORDER_BY_INITIATIVE = 0;
	public static final int ORDER_BY_HEALTH = 1;

	protected String name;
	protected long id = -1;

	protected int level = 1;
	protected Attributes attributes;
	protected Team team;
	protected Battle battle;
	protected HashMap<Entity, Double> aggroList = new HashMap<Entity, Double>();

	protected double health;
	protected double energy = 0;
	protected int actionPoints;

	protected Race race;
	protected Classe classe;

	protected Item[] equipments = new Item[EQUIPMENTS_LENGTH];
	protected List<Effect> effects = new ArrayList<Effect>();

	protected Entity(String name, Race race, Classe classe) {
		this.name=name;
		this.race=race;
		this.classe=classe;
	}

	public List<Effect> getEffects() {
		List<Effect> r = new ArrayList<Effect>();
		r.addAll(effects);
		return r;
	}

	public Battle getBattle() {
		return battle;
	}

	public void respawn(Battle battle) {
		this.battle=battle;
		effects.clear();
		applyEffect(new Effect(this, race.getPassive()));
		applyEffect(new Effect(this, classe.getPassive()));
		aggroList.clear();
		attributes = race.getAttributes();
		Attributes mods = classe.getMods();
		for(int i=0;i<Attributes.LENGTH;i++) {
			attributes.add(i, (level-1)*mods.get(i));
			double mod = 0;
			for(Item item:equipments) {
				if(item!=null) {
					mod+=item.getMods().get(i);
					if(item.getGroup()==Group.SHIELD) {
						applyEffect(new Effect(this, -1,EffectType.SHIELD,EffectType.SHIELD.getValues()[0]*(1+item.getGrade().getID())));
					}else if(item.getGroup()==Group.GRIMOIRE) {
						applyEffect(new Effect(this, -1,EffectType.GRIMOIRE,EffectType.GRIMOIRE.getValues()[0]*(1+item.getGrade().getID())));
					}
				}

			}
			if(i==ENERGY_REGENERATION||i==HEALTH_REGENERATION) {
				attributes.multiply(i, 1+mod);
			}else {
				attributes.add(i, mod);
			}
		}
		Random rand = new Random();
		attributes.add(INITIATIVE, rand.nextInt(20));
		health = getMaxHealth();
	}

	public Item getEquipmentBy(Slot slot) {
		return equipments[slot.getID()];
	}

	public void addAggroFor(Entity target, double value) {
		double a = getAggroFor(target);
		if(a>0) {
			aggroList.replace(target, getAggroFor(target)+value);
		}else {
			aggroList.put(target, value);
		}
	}

	public double getAggroFor(Entity target) {
		if(aggroList.containsKey(target)) {
			return aggroList.get(target);
		}
		return 0;
	}

	public double getValuesOf(int pos, EffectType type) {
		double r = 0;
		for(Effect e:getEffectsBy(type)) {
			r+=e.getValues()[pos];
		}
		return r;
	}

	protected double getEnergyRegen() {
		double r = attributes.get(ENERGY_REGENERATION);
		r*=1+getValuesOf(0, EffectType.GRIMOIRE);
		return r;
	}

	public double getAttackPower() {
		return attributes.get(ATTACK_POWER);
	}

	public double getLifeSteal() {
		double r = attributes.get(LIFE_STEAL)/100.0;
		r+=getValuesOf(0, EffectType.BLOOD_STEALER);
		r*=1+getValuesOf(0, EffectType.BLOODSUCKER);
		return r;
	}

	public double getCriticalChance() {
		double r = attributes.get(CRITICAL_CHANCE);
		r*=1+getValuesOf(0, EffectType.TRAINED_KILLER);
		return r;
	}

	public int getDefense() {
		double r = (attributes.get(DEFENSE)*1);
		r*=1+getValuesOf(0, EffectType.KNIGHT_SPIRIT);
		return (int)r;
	}

	public int getEvasion() {
		double r = attributes.get(EVASION);
		r*=1+getValuesOf(0, EffectType.DIVINE_DANCER);
		return (int)r;
	}

	public int getAccuracy() {
		double r = attributes.get(ACCURACY);
		r*=1+getValuesOf(0, EffectType.ACCURATE_SHOT);
		return (int)r;
	}

	protected double getHealthRegen() {
		double r = attributes.get(HEALTH_REGENERATION);
		r*=1+getValuesOf(0, EffectType.LIZARD_BLOOD);
		return r;
	}

	public int getMaxHealth() {
		double r = attributes.get(MAX_HEALTH);
		r*=1+getValuesOf(0, EffectType.ELDER);
		return (int) r;
	}

	public int getMaxEnergy() {
		return (int) (attributes.get(MAX_ENERGY)*1);
	}

	public boolean isDead() {
		return health<=0;
	}

	public void turnOn() {
		actionPoints=100;
	}

	public void roundUpdate() {
		health+=getHealthRegen();
		energy+=getEnergyRegen();
		if(health>getMaxHealth()) {
			health = getMaxHealth();
		}
		if(energy>getMaxEnergy()) {
			energy = getMaxEnergy();
		}
		for(Effect e:getEffects()) {
			if(!e.update(this)) {
				removeEffect(e.getID(), false);
			}
		}
	}

	public void applyEffect(Effect effect) {
		EffectType type = effect.getType();
		List<Effect> efs = getEffectsBy(type);
		Effect eff = null;
		for(Effect ef:getEffectsBy(type)) {
			if(ef.getOwner().equals(effect.getOwner())) {
				eff = null;
				if(type.isUnique()) {
					eff = ef;
				}
				break;
			}else {
				eff = ef;
			}
		}
		if(eff!=null) {
			if(!eff.getOwner().equals(effect.getOwner())&&type.isDuplicate()) {
				eff = null;
			}
		}
		if(eff==null) {
			int id = -1;
			for(int i=0;i<effects.size();i++) {
				Effect e = effects.get(i);
				if(e.getID()>id) {
					id=e.getID();
				}
			}
			id++;
			for(int i=0;i<id;i++) {
				Effect e = getEffectBy(id);
				if(e==null) {
					break;
				}
			}
			effect.setID(id);
			effects.add(effect);
			effect.onApply(this);
		}else {
			switch(type.getCategory()) {
			case EffectType.TIME_ADD_AND_VALUE_ADD:
				eff.setOwner(effect.getOwner());
				eff.setRounds(eff.getRounds()+effect.getRounds());
				eff.addValues(effect.getValues());
				break;
			case EffectType.TIME_ADD_AND_VALUE_NOTHING:
				eff.setOwner(effect.getOwner());
				eff.setRounds(eff.getRounds()+effect.getRounds());
				break;
			case EffectType.TIME_ADD_AND_VALUE_RESET:
				eff.setOwner(effect.getOwner());
				eff.setRounds(eff.getRounds()+effect.getRounds());
				eff.setValues(effect.getValues());
				break;
			case EffectType.TIME_NOTHING_AND_VALUE_ADD:
				eff.setOwner(effect.getOwner());
				eff.addValues(effect.getValues());
				break;
			case EffectType.TIME_NOTHING_AND_VALUE_RESET:
				eff.setOwner(effect.getOwner());
				eff.setValues(effect.getValues());
				break;
			case EffectType.TIME_RESET_AND_VALUE_ADD:
				eff.setOwner(effect.getOwner());
				eff.setRounds(effect.getRounds());
				eff.addValues(effect.getValues());
				break;
			case EffectType.TIME_RESET_AND_VALUE_NOTHING:
				eff.setOwner(effect.getOwner());
				eff.setRounds(effect.getRounds());
				break;
			case EffectType.TIME_RESET_AND_VALUE_RESET:
				eff.setOwner(effect.getOwner());
				eff.setRounds(effect.getRounds());
				eff.setValues(effect.getValues());
				break;
			}
		}
	}

	public List<Effect> getEffectsBy(Entity owner, EffectType type){
		List<Effect> r = new ArrayList<Effect>();
		for(Effect e:effects) {
			if(e.getOwner().equals(owner) && type == e.getType()) {
				r.add(e);
			}
		}
		return r;
	}

	public List<Effect> getEffectsBy(Entity owner){
		List<Effect> r = new ArrayList<Effect>();
		for(Effect e:effects) {
			if(e.getOwner().equals(owner)) {
				r.add(e);
			}
		}
		return r;
	}

	public List<Effect> getEffectsBy(EffectType type){
		List<Effect> r = new ArrayList<Effect>();
		for(Effect e:effects) {
			if(type == e.getType()) {
				r.add(e);
			}
		}
		return r;
	}

	public void removeEffect(int id, boolean forced) {
		for(int i=0;i<effects.size();i++) {
			Effect e = effects.get(i);
			if(e.getID()==id) {
				e.onRemove(forced, this);
				effects.remove(i);
				break;
			}
		}
	}

	public boolean containsEffect(EffectType type) {
		for(Effect e:effects) {
			if(e.getType()==type) {
				return true;
			}
		}
		return false;
	}

	public Effect getEffectBy(int id) {
		for(Effect e:effects) {
			if(e.getID()==id) {
				return e;
			}
		}
		return null;
	}

	public boolean useSkill() {
		Skill skill = Skill.DISARMED_PUNCH;
		Item weapon = equipments[Slot.WEAPON.getID()];
		if(weapon!=null) {
			skill = weapon.getSkill();
		}
		if(actionPoints>=skill.getActionCost()) {
			actionPoints-=skill.getActionCost();
			Entity target = null;
			double ag1 = 0;
			for(Entity e:aggroList.keySet()) {
				if(!e.isDead()) {
					if(target==null) {
						target = e;
						ag1 = aggroList.get(e);
					}else {
						double ag2 = aggroList.get(e);
						if(ag2>ag1) {
							target = e;
							ag1 = ag2;
						}
					}
				}
			}
			if(target!=null) {
				double mod;
				switch(skill) {
				case ACCURATE_ATTACK:
					break;
				case BLOODTHIRSTY_ATTACK:
					break;
				case BLOODY_EATER:
					break;
				case CONTROL_ATTACK:
					if(chance(skill.getValues()[0])) {
						actionPoints+=skill.getValues()[1];
					}
					break;
				case CURSED_BLADE:
					break;
				case DISARMED_PUNCH:
					break;
				case DISEASE_WAVE:
					if(energy>=getMaxEnergy()) {
						energy = 0;
						for(Entity e:target.getTeam().getAliveMembers()) {
							e.applyEffect(new Effect(this, (int)skill.getValues()[0], EffectType.MARK_OF_DEATH, getMaxEnergy()*skill.getValues()[1]));
						}
						return true;
					}
					break;
				case DRUNK_FIST:
					if(chance(skill.getValues()[0])) {
						actionPoints=100;
					}
					break;
				case ELETRIC_CHARGE:
					if(actionPoints<99) {
						mod = skill.getValues()[0];
						if(energy>=mod) {
							energy-=mod;
						}else {
							return false;
						}
					}
					break;
				case FAST_ARROW:
					break;
				case FIREBALL:
					mod = skill.getValues()[0];
					if(energy>=mod) {
						energy-=mod;
						battle.addLogLine(skill.getUsageMessage(this, this));
						for(Entity e:target.getTeam().getAliveMembers()) {
							e.damage(this, skill);
						}
						return true;
					}
					break;
				case FURIOUS_BLADES:
					break;
				case HALF_MOON_CUT:
					break;
				case ILUMINATED_FIELD:
					mod = skill.getValues()[0];
					if(energy>=mod) {
						List<Entity> ts = team.getRandomHealList();
						if(ts.size()>=3 || (ts.size()>=1&&ts.get(0).getHealthPercent()<=0.4)) {
							energy-=mod;
							battle.addLogLine(skill.getUsageMessage(this, this));
							for(Entity e:team.getAliveMembers()) {
								e.heal(this, skill);
							}
							return true;
						}
					}
					break;
				case PRECISE_SHOT:
					break;
				case SKULL_SMASH:
					break;
				case SPIRITUAL_SEED:
					mod = skill.getValues()[0];
					if(energy>=mod) {
						List<Entity> ts = team.getRandomHealList();
						for(Entity e:ts) {
							if(e.getHealthPercent()<=0.6) {
								energy-=mod;
								e.heal(this, skill);
								return true;
							}
						}
					}
					break;
				case STAB:
					break;		
				}
				target.damage(this, skill);
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public double getHealthPercent(){
		return health/getMaxHealth();
	}

	public void heal(Entity owner, HealSource healSource) {
		heal(owner, (int) healSource.getStartHeal(owner,this), healSource);
	}

	public void heal(Entity owner, int value, HealSource healSource) {
		double maxHeal = getMaxHealth()-health;
		double finalHeal = value;

		finalHeal*=1+owner.getValuesOf(0, EffectType.HEALER)+getValuesOf(0, EffectType.DARK_POWER)-getValuesOf(1, EffectType.CURSE_OF_HEAL);
		battle.addLogLine(healSource.getHealMessage(owner,this,(int) finalHeal));
		for(Entity e:battle.getEnemyTeam(team).getAliveMembers()) {
			e.addAggroFor(owner, finalHeal);//ALTERAR AGGRO SE PRECISAR
		}
		if(finalHeal>maxHeal) {
			health = getMaxHealth();
		}else {
			health+=finalHeal;
		}
		if(healSource!=EffectType.LIFE_STEAL) {
			if(owner.containsEffect(EffectType.BOUNCY_HEAL)) {
				if(healSource.isExpansiveHeal()) {
					double mod = EffectType.BOUNCY_HEAL.getValues()[0];
					List<Entity> injurieds = owner.team.getAliveMembers();
					for(Entity e:injurieds) {
						if(!e.equals(this)) {
							if(chance(mod)) {
								e.applyEffect(new Effect(owner, 1, EffectType.BOUNCING_REBOUND, new double[] {mod/2,value*mod}));
							}
							break;
						}
					}
				}	
			}
			if(owner.containsEffect(EffectType.SACRED_PROTECTION)) {
				applyEffect(new Effect(owner, -2, EffectType.FAITH_SHIELD, EffectType.SACRED_PROTECTION.getValues()[0]*owner.getAttackPower()));
			}
			if(owner.containsEffect(EffectType.NATURAL_POLINATION) && healSource!=EffectType.CELL_REGENERATION) {
				applyEffect(new Effect(owner, (int)EffectType.NATURAL_POLINATION.getValues()[1], EffectType.CELL_REGENERATION, EffectType.NATURAL_POLINATION.getValues()[0]*value));
			}
		}
	}

	public String getLogName() {
		return "("+(int)health+"/"+getMaxHealth()+")"+name;
	}

	public double getLostHealth() {
		return getMaxHealth()-health;
	}

	public static void main(String[] args) {
		Entity e1 = new Entity("Golinight", Race.ABYSSAL, Classe.DRUID);
		e1.equipments[Slot.WEAPON.getID()] = new Item(1, Type.DEMONIAC_ORB_1);
		e1.equipments[Slot.WEAPON_SECONDARY.getID()] = new Item(1, Type.GRIMOIRE_4);
		Team team1 = new Team(e1);
		//team1.addMember(new Entity("Autonight", Race.AUTOMATO, Classe.KNIGHT));
		//team1.addMember(new Entity("Golinight2", Race.GOLEM, Classe.KNIGHT));
		Entity e2 = new Entity("Vampancer", Race.DARKIN, Classe.NECROMANCER);
		e2.equipments[Slot.WEAPON.getID()] = new Item(1, Type.STAFF_1);
		Team team2 = new Team(e2);
		//team2.addMember(new Entity("Darkancer", Race.DARKIN, Classe.NECROMANCER)); 
		//team2.addMember(new Entity("Abymancer", Race.ABYSSAL, Classe.NECROMANCER));
		Battle battle = Battle.fight(team1, team2);
		for(LogLine ll:battle.getLogLines()) {
			if(!ll.isCanceled()) {
				System.out.println(ll.getMessage());
			}
		}
		Team winners = battle.getWinners();
		if(winners!=null) {
			String w = "Os vencedores sao: ";
			for(Entity e:winners.getAllMembers()) {
				w+=e.getName()+",";
			}
			System.out.println(w);
		}else {
			System.out.println("EMPATOU");
		}
	}

	public void damage(Entity owner, DamageSource damageSource) {
		damage(owner, damageSource, damageSource.getStartDamage(owner, this));
	}

	public void damage(Entity owner, DamageSource damageSource, double damageValue) {
		Damage damage = new Damage(owner, this, damageSource, damageValue);
		if(damageSource.canBeEvaded()&&containsEffect(EffectType.SHIELD)&&!damageSource.ignoreDefense()) {
			if(chance(getValuesOf(0, EffectType.SHIELD))) {
				battle.addLogLine(getName()+" defendeu "+damageSource.getName()+" de "+owner.getName()+".");
				return;
			}
		}
		if(!damage.isCanceled()) {
			if(!damage.isEvaded()) {
				if(containsEffect(EffectType.ENERGY_SHIELD)) {
					Effect e = getEffectsBy(this,EffectType.ENERGY_SHIELD).get(0);
					removeEffect(e.getID(),true);
				}
				if(containsEffect(EffectType.FAITH_SHIELD)) {
					Effect e = getEffectsBy(EffectType.FAITH_SHIELD).get(0);
					removeEffect(e.getID(),true);
				}
				if(owner.containsEffect(EffectType.DRAGON_CLAW)) {
					damage.addAdditionalDamage(EffectType.DRAGON_CLAW.getStartDamage(owner, this));
				}
				if(owner.containsEffect(EffectType.BUDHA_CONCENTRATION)) {
					owner.applyEffect(new Effect(owner, 1, EffectType.BUDHA_HANDS, EffectType.BUDHA_CONCENTRATION.getValues()));
				}
				if(owner.containsEffect(EffectType.CORRUPTION)) {
					damage.addAdditionalDamage(EffectType.CORRUPTION.getValues()[0]*damage.getFinalDamage());
				}
				if(owner.containsEffect(EffectType.THE_RELENTLESS)) {
					damage.addAdditionalDamage(EffectType.THE_RELENTLESS.getValues()[0]*damage.getFinalDamage());
				}
				if(owner.containsEffect(EffectType.SACRIFICE)) {
					double percent = owner.getHealthPercent();
					if(percent>=EffectType.SACRIFICE.getValues()[1]*2 && chance(EffectType.SACRIFICE.getValues()[0])) {
						battle.addLogLine(owner.name+" usou "+EffectType.SACRIFICE.getName()+".");
						owner.health-=owner.getMaxHealth()*EffectType.SACRIFICE.getValues()[1];
						damage.addAdditionalDamage(damage.getFinalDamage());
					}
				}
				if(owner.containsEffect(EffectType.FURY)) {
					double mod = owner.getHealthPercent();
					if(mod>=EffectType.FURY.getValues()[1]*2 && chance(EffectType.FURY.getValues()[0])) {
						battle.addLogLine(owner.name+" usou "+EffectType.FURY.getName()+".");
						mod = owner.getMaxHealth()*EffectType.FURY.getValues()[1];
						owner.health-=mod;
						damage.addAdditionalDamage(mod*EffectType.FURY.getValues()[2]);
					}
				}
				if(owner.containsEffect(EffectType.DARK_POWER)) {
					damage.setHoldedDamage(0);
				}
				if(owner.containsEffect(EffectType.ENERGY_STEALER)) {
					if(energy>0){
						int stealed = (int) (energy*EffectType.ENERGY_STEALER.getValues()[0]);
						if(energy<stealed){
							stealed = (int) energy;
						}
						energy-=stealed;
						battle.addLogLine(owner.name+" roubou "+((int)stealed)+" de energia de "+name+".");
						owner.applyEffect(new Effect(owner,-2,EffectType.ENERGY_SHIELD,new double[]{stealed}));
					}
				}

				if(owner.containsEffect(EffectType.LUCKY_HANDS)) {
					if(chance(0.33)) {
						battle.addLogLine(owner.getName()+" causou "+EffectType.CURSE_OF_HEAL.getName()+" em "+getName()+".");
						applyEffect(new Effect(owner,-2,EffectType.CURSE_OF_HEAL,EffectType.LUCKY_HANDS.getValues()));
					}else {
						if(chance(0.5)) {
							battle.addLogLine(owner.getName()+" causou "+EffectType.CURSE_OF_DEFENSE.getName()+" em "+getName()+".");
							applyEffect(new Effect(owner,-2,EffectType.CURSE_OF_DEFENSE,EffectType.LUCKY_HANDS.getValues()));
						}else {
							damage.addAdditionalDamage(damage.getAdditionalDamage()*EffectType.LUCKY_HANDS.getValues()[2]);
						}
					}
				}
				LogLine ll = battle.addLogLine(damageSource.getDamageMessage(owner, this, damage));
				for(Entity e:team.getAliveMembers()) {
					double a = damage.getFinalDamage();
					if(e.equals(this)) {
						a*=1.5;//ALTERAR SE PRECISAR AGGRO
					}
					e.addAggroFor(owner, a);
				}
				if(owner.containsEffect(EffectType.THE_EXECUTIONER)) {
					if(getHealthPercent()<=EffectType.THE_EXECUTIONER.getValues()[1] && chance(EffectType.THE_EXECUTIONER.getValues()[0])) {
						ll.cancel();
						damage.setFinalDamage(health);
						damageSource=EffectType.THE_EXECUTIONER;
					}
				}
				health-=damage.getFinalDamage();
				if(health<=0) {
					ll.cancel();
					die(owner,damageSource);
				}else {
					if(containsEffect(EffectType.ELETRIC_ARMOR)) {
						if(chance(EffectType.ELETRIC_ARMOR.getValues()[0])) {
							owner.damage(this, EffectType.ELETRIC_ARMOR);
						}
					}
					if(damageSource == Skill.BLOODTHIRSTY_ATTACK) {
						if(chance(Skill.BLOODTHIRSTY_ATTACK.getValues()[0])) {
							applyEffect(new Effect(owner, (int)Skill.BLOODTHIRSTY_ATTACK.getValues()[1], EffectType.BLEEDING, Skill.BLOODTHIRSTY_ATTACK.getValues()));
						}
					}else if(damageSource == Skill.SKULL_SMASH) {
						if(chance(Skill.SKULL_SMASH.getValues()[0])) {
							applyEffect(new Effect(owner, -2, EffectType.STUNNED));
						}
					}
				}
				if(battle.isRunning()) {
					if(owner.getLifeSteal()>0) {
						owner.heal(owner, (int) (owner.getLifeSteal()*damage.getFinalDamage()), EffectType.LIFE_STEAL);
					}
					if(owner.containsEffect(EffectType.FAITH_ON_CONTROL)) {
						if(chance(EffectType.FAITH_ON_CONTROL.getValues()[0])) {
							for(Entity e:owner.getTeam().getAliveMembers()) {
								e.heal(owner, EffectType.FAITH_ON_CONTROL);
								break;
							}
						}
					}
				}
			}else {
				if(owner.getAccuracy()>getEvasion()) {
					battle.addLogLine(owner.getName()+" errou "+damageSource.getName()+" em "+getName()+".");
				}else {
					battle.addLogLine(getName()+" desviou de "+damageSource.getName()+" de "+owner.getName()+".");
				}
				if(containsEffect(EffectType.BUDHA_CONCENTRATION)) {
					if(chance(EffectType.BUDHA_CONCENTRATION.getValues()[1])) {
						battle.addLogLine("Contra ataque de "+getName()+".");
						Skill skill = Skill.DISARMED_PUNCH;
						Item weapon = equipments[Slot.WEAPON.getID()];
						if(weapon!=null) {
							skill = weapon.getSkill();
						}
						owner.damage(this, skill);
					}
				}
			}
		}
	}

	protected void die(Entity killer, DamageSource damageSource) {
		if(killer.equals(this)) {
			battle.addLogLine(damageSource.getSuicideMessage(this));
		}else {
			battle.addLogLine(damageSource.getDeathMessage(killer, this));
		}
		List<Effect> es = getEffectsBy(EffectType.UNDEAD);
		if(es.size()>0) {
			Effect e = es.get(0);
			if(chance(e.getValues()[0])) {
				e.setValue(0, e.getValues()[0]*0.5);

				health = getMaxHealth()*e.getValues()[1];
				battle.addLogLine(e.getType().getUsageMessage(this,this));
				return;
			}
		}
		health=0;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	public double getNumberValue(int id) {
		switch(id) {
		case ORDER_BY_INITIATIVE:
			return attributes.get(INITIATIVE);
		case ORDER_BY_HEALTH:
			return health;
		default:
			throw new NullPointerException("Nao existem valores nesse ID.");
		}
	}

	@Override
	public String getStringValue(int id) {
		throw new NullPointerException("Nao existem valores nesse ID.");
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Entity) {
			return ((Entity) obj).id==id&&(((Entity) obj).name.equalsIgnoreCase(name));
		}
		return false;
	}

}
