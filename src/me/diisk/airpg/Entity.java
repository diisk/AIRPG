package me.diisk.airpg;

import me.diisk.airpg.Item.Item;
import me.diisk.airpg.Item.Slot;

import static me.diisk.airpg.Attributes.*;

import java.util.HashMap;
import java.util.Random;

import me.diisk.airpg.CustomList.CustomList;
import me.diisk.airpg.CustomList.Ordenable;
import me.diisk.airpg.Effect.Effect;
import me.diisk.airpg.Effect.EffectType;

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
	
	public Entity(String name, Race race, Classe classe) {
		this.name=name;
		this.race=race;
		this.classe=classe;
	}
	
	public void respawn() {
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
				attributes.multiply(i, mod);
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
		//FAZER AINDA
	}
	
	public boolean useSkill(Battle battle) {
		Skill skill = Skill.DISARMED_PUNCH;
		Item weapon = equipments[Slot.WEAPON.getID()];
		if(weapon!=null) {
			skill = weapon.getSkill();
		}
		if(energy>=skill.getEnergyCost()) {
			if(actionPoints>=skill.getActionCost()) {
				Entity target = null;
				double ag1 = 0;
				for(Entity e:aggroList.keySet()) {
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
			}
		}
		return false;
	}
	
	public void heal(Entity owner, double value, EffectType source) {
		
	}
	
	public void damage(Entity damager, double value, EffectType source) {
		
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
				throw new NullPointerException("Não existem valores nesse ID.");
		}
	}

	@Override
	public String getStringValue(int id) {
		throw new NullPointerException("Não existem valores nesse ID.");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Entity) {
			return ((Entity) obj).id==id&&(((Entity) obj).name.equalsIgnoreCase(name));
		}
		return false;
	}
	
}
