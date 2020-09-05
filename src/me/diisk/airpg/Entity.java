package me.diisk.airpg;

import me.diisk.airpg.Item.Item;
import me.diisk.airpg.Item.Slot;

import static me.diisk.airpg.Attributes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import me.diisk.airpg.Battle.LogLine;
import me.diisk.airpg.CustomList.Ordenable;
import me.diisk.airpg.Effect.Effect;
import me.diisk.airpg.Effect.EffectType;

import static me.diisk.airpg.Utils.*;

public class Entity implements Ordenable{

	public static final int MAX_LEVEL = 30;
	
	public static final int EQUIPMENTS_LENGTH = 12;
	
	public static final int ORDER_BY_INITIATIVE = 0;
	
	private String name;
	private long id;
	
	private int level;
	private Attributes attributes;
	private Team team;
	private HashMap<Entity, Double> aggroList = new HashMap<Entity, Double>();
	
	private double health;
	private double energy = 0;
	private int actionPoints;
	
	private Race race;
	private Classe classe;
	
	private Item[] equipments = new Item[EQUIPMENTS_LENGTH];
	private List<Effect> effects = new ArrayList<Effect>();
	
	public Entity(String name, Race race, Classe classe) {
		this.name=name;
		this.race=race;
		this.classe=classe;
	}
	
	public List<Effect> getEffects() {
		return effects;
	}
	
	public void respawn() {
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
	
	//TESTE
	
	public void addAggroFor(Entity target, double value) {
		if(aggroList.containsKey(target)) {
			aggroList.replace(target, value);
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
	
	private double getEnergyRegen() {
		return attributes.get(ENERGY_REGENERATION);
	}
	
	public double getAttackPower() {
		return attributes.get(ATTACK_POWER);
	}
	
	public double getCriticalChance() {
		return attributes.get(CRITICAL_CHANCE);
	}
	
	public int getDefense() {
		return (int) (attributes.get(DEFENSE)*1);
	}
	
	private double getHealthRegen() {
		return attributes.get(HEALTH_REGENERATION);
	}
	
	private int getMaxHealth() {
		return (int) (attributes.get(MAX_HEALTH)*1);
	}
	
	private int getMaxEnergy() {
		return (int) (attributes.get(MAX_ENERGY)*1);
	}
	
	public boolean isDead() {
		return health<=0;
	}
	
	public void turnOn() {
		actionPoints=100;
	}
	
	public void roundRegen() {
		health+=getHealthRegen();
		energy+=getEnergyRegen();
		if(health>getMaxHealth()) {
			health = getMaxHealth();
		}
		if(energy>getMaxEnergy()) {
			energy = getMaxEnergy();
		}
	}
	
	public void applyEffect(Effect effect) {
		EffectType type = effect.getType();
		List<Effect> efs = getEffectsBy(type);
		Effect eff = null;
		if(efs.size()>0) {
			efs = getEffectsBy(effect.getOwner(), type);
			if(efs.size()>0) {
				if(type.isUnique()) {
					eff = efs.get(0);
				}
			}else {
				if(!type.isDuplicate()) {
					if(type.isUnique()) {
						eff = getEffectsBy(type).get(0);
					}
				}
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
			System.out.println("TESTE ID:"+id);
			for(int i=0;i<id;i++) {
				Effect e = getEffectBy(id);
				if(e==null) {
					break;
				}
			}
			effect.setID(id);
			effects.add(effect);
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
	
	public void removeEffect(int id) {
		for(int i=0;i<effects.size();i++) {
			Effect e = effects.get(i);
			if(e.getID()==id) {
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
	
	public boolean useSkill(Battle battle) {
		Skill skill = Skill.DISARMED_PUNCH;
		Item weapon = equipments[Slot.WEAPON.getID()];
		if(weapon!=null) {
			skill = weapon.getSkill();
		}
		if(energy>=skill.getEnergyCost()) {
			if(actionPoints>=skill.getActionCost()) {
				energy-=skill.getEnergyCost();
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
					switch(skill) {
					case ACCURATE_ATTACK:
						break;
					case BLOODTHIRSTY_ATTACK:
						break;
					case BLOODY_EATER:
						break;
					case CONTROL_ATTACK:
						break;
					case CURSED_BLADE:
						break;
					case DISARMED_PUNCH:
						break;
					case DISEASE_WAVE:
						break;
					case DRUNK_FIST:
						break;
					case ELETRIC_CHARGE:
						break;
					case FAST_ARROW:
						break;
					case FIREBALL:
						break;
					case FURIOUS_BLADES:
						break;
					case HALF_MOON_CUT:
						break;
					case ILUMINATED_FIELD:
						break;
					case PRECISE_SHOT:
						break;
					case SKULL_SMASH:
						break;
					case SPIRITUAL_SEED:
						break;
					case STAB:
						break;		
					}
					target.damage(this, skill, battle);
					return true;
				}
			}
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public void heal(Entity owner, EffectType source) {
		
	}
	
	public String getLogName() {
		return "("+(int)health+"/"+getMaxHealth()+")"+name;
	}
	
	public static void main(String[] args) {
		Team team1 = new Team(new Entity("Teste1", Race.ABYSSAL, Classe.ARCHER));
		Team team2 = new Team(new Entity("Teste2", Race.ABYSSAL, Classe.ARCHER));
		Battle battle = Battle.fight(team1, team2);
		for(LogLine ll:battle.getLogLines()) {
			if(!ll.isCanceled()) {
				System.out.println(ll.getMessage());
			}
		}
		Team winners = battle.getWinners();
		if(winners!=null) {
			String w = "Os vencedores s�o: ";
			for(Entity e:winners.getAllMembers()) {
				w+=e.getName()+",";
			}
			System.out.println(w);
		}else {
			System.out.println("EMPATOU");
		}
	}
	
	public void damage(Entity owner, DamageSource damageSource, Battle battle) {
		Damage damage = new Damage(owner, this, damageSource);
		
		if(!damage.isCanceled()) {
			LogLine ll = battle.addLogLine(translateMessage(owner.getLogName(), getLogName(), ((int)damage.getFinalDamage())+"", damageSource.getDamageMessage()));
			health-=damage.getFinalDamage();
			if(health<=0) {
				ll.cancel();
				die(owner,damageSource,battle);
			}
		}
	}
	
	private void die(Entity killer, DamageSource damageSource,Battle battle) {
		if(killer.equals(this)) {
			battle.addLogLine(translateMessage(name, "", "", damageSource.getSuicideMessage()));
		}else {
			battle.addLogLine(translateMessage(killer.getLogName(), name, "", damageSource.getDeathMessage()));
		}
		health=0;
		List<Effect> es = getEffectsBy(EffectType.UNDEAD);
		if(es.size()>0) {
			Effect e = es.get(0);
			if(chance(e.getValues()[0])) {
				e.setValue(0, e.getValues()[0]/2);
				health = getMaxHealth()*e.getValues()[1];
				battle.addLogLine(translateMessage(name, "", "", e.getType().getUsageMessage()));
			}
		}
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
			default:
				throw new NullPointerException("N�o existem valores nesse ID.");
		}
	}

	@Override
	public String getStringValue(int id) {
		throw new NullPointerException("N�o existem valores nesse ID.");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Entity) {
			return ((Entity) obj).id==id&&(((Entity) obj).name.equalsIgnoreCase(name));
		}
		return false;
	}
	
}
