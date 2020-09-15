package me.diisk.airpg;

import me.diisk.airpg.Entity.Entity;

public interface HealSource {

	public abstract String getHealMessage(Entity owner, Entity target, int value);
	
	public abstract String getName();
	
	public abstract double getStartHeal(Entity owner, Entity target);
	
	public abstract boolean isExpansiveHeal();
	
}
