package me.diisk.airpg.Effect;

import me.diisk.airpg.Entity;

public class Effect {

	private int id;
	private Entity owner;
	private double[] values;
	private EffectType type;
	private int rounds;
	
	public Effect(Entity owner, EffectType type){
		config(owner, type.getRounds(), type, type.getValues());
	}
	
	public Effect(Entity owner, int rounds, EffectType type, double...values) {
		config(owner, rounds, type, values);
	}
	
	private void config(Entity owner, int rounds, EffectType type, double...values) {
		this.owner=  owner;
		this.rounds = rounds;
		this.type = type;
		this.values = new double[values.length];
		for(int i=0;i<values.length;i++) {
			this.values[i]=values[i];
		}
	}
	
	public Entity getOwner() {
		return owner;
	}
	
	public boolean update(Entity turnOn, Entity target) {
		if(rounds>0) {
			rounds--;
		}else if(rounds==-2) {
			return !owner.equals(turnOn);
		}
		return rounds!=0;
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public EffectType getType() {
		return type;
	}
	
	public void setOwner(Entity owner) {
		this.owner = owner;
	}
	
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	
	public void setValues(double[] values) {
		this.values = values;
	}
	
	public double[] getValues() {
		return values;
	}
	
	public void setValue(int pos, double value) {
		values[pos] = value;
	}
	
	public void addValues(double[] values) {
		for(int i=0;i<values.length;i++) {
			this.values[i]+=values[i];
		}
	}
	
	public int getRounds() {
		return rounds;
	}
	
}
