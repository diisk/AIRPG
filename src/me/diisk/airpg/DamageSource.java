package me.diisk.airpg;

public interface DamageSource {
	
	public abstract double getStartDamage(Entity owner, Entity target);
	
	public abstract String getDeathMessage();
	
	public abstract String getDamageMessage();
	
	public abstract String getSuicideMessage();
	
	public abstract String getName();
	
}
