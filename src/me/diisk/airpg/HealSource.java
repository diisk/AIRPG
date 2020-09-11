package me.diisk.airpg;

public interface HealSource {

	public abstract String getHealMessage(Entity owner, Entity target, int value);
	
	public abstract String getName();
	
	public abstract double getStartHeal(Entity owner, Entity target);
	
}
