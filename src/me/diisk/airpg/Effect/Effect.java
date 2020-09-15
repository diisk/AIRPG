package me.diisk.airpg.Effect;

import static me.diisk.airpg.Utils.*;

import java.util.Random;

import me.diisk.airpg.Battle;
import me.diisk.airpg.Entity.Entity;

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
		if(rounds==-2) {
			this.rounds = owner.getBattle().getRoundsToRestart();
		}
		this.type = type;
		this.values = new double[values.length];
		for(int i=0;i<values.length;i++) {
			this.values[i]=values[i];
		}
	}
	
	public Entity getOwner() {
		return owner;
	}
	
	public void onApply(Entity target) {
		switch(type) {
		case BOUNCING_REBOUND:
			target.removeEffect(id,true);
			target.heal(owner, (int) values[1], type);
			for(Entity e:owner.getTeam().getAliveMembers()) {
				if(!e.equals(target)) {
					if(chance(values[0])) {
						e.applyEffect(new Effect(owner, 1, type, new double[] {values[0]/2,values[1]/2}));
					}
					break;
				}
			}
			break;
		case BLEEDING:
		case STUNNED:
		case FAITH_SHIELD:
		case MARK_OF_DEATH:
			target.getBattle().addLogLine(type.getUsageMessage(owner, target));
			break;
		}
	}
	
	public void onRemove(boolean forced, Entity target) {
		
	}
	
	public boolean update(Entity target) {
		if(rounds>0) {
			rounds--;
		}
		switch(type) {
		case CELL_REGENERATION:
			target.heal(owner, (int) values[0], type);
			break;
		case BLEEDING:
			target.damage(owner, type, values[2]*target.getMaxHealth());
			break;
		case MARK_OF_DEATH:
			target.damage(owner, type, values[0]);
			break;
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
		if(rounds==-2) {
			this.rounds=owner.getBattle().getRoundsToRestart();
		}
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
