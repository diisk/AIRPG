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
	private int attackPoints;
	
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
		attackPoints=100;
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
	
	public int useSkill() {
		Skill skill = Skill.DISARMED_PUNCH;
		Item weapon = equipments[Slot.WEAPON.getID()];
		if(weapon!=null) {
			skill = weapon.getSkill();
		}
		
		return 0;
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
