package me.diisk.airpg;

public interface DamageSource {
	
	public abstract double getStartDamage(Entity owner, Entity target);
	
	public abstract String getDeathMessage(Entity owner, Entity target);
	
	public abstract String getDamageMessage(Entity owner, Entity target, int value);
	
	public abstract String getSuicideMessage(Entity owner);
	
	public abstract String getName();
	
}
