package me.diisk.airpg;

public interface DamageSource {
	
	public abstract double getStartDamage(Entity owner, Entity target);
	
	public abstract String getDeathMessage(Entity owner, Entity target);
	
	public abstract String getDamageMessage(Entity owner, Entity target, Damage damage);
	
	public abstract String getSuicideMessage(Entity owner);
	
	public abstract String getName();
	
	public abstract boolean canBeCritical();
	
	public abstract boolean canBeEvaded();
	
	public abstract boolean ignoreDefense();
	
}
