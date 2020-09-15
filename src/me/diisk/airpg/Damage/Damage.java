package me.diisk.airpg.Damage;

import static me.diisk.airpg.Utils.*;

import me.diisk.airpg.Effect.EffectType;
import me.diisk.airpg.Entity.Entity;

public class Damage {

	private boolean critical;
	private double startDamage;
	private double holdedDamage = 0;
	private double additionalDamage = 0;
	private double finalDamage;
	private boolean evaded;
	private Entity owner;
	private Entity target;
	
	private boolean canceled = false;
	
	public Damage(Entity owner, Entity target, DamageSource damageSource, double damageValue) {
		this.owner=owner;
		this.target=target;
		evaded = damageSource.canBeEvaded()?chance(target.getEvasion()/(target.getEvasion()+owner.getAccuracy())):false;
		
		if(!evaded) {
			startDamage = damageValue;
			if(!damageSource.ignoreDefense()) {
				holdedDamage = startDamage*getDamageReductionFor(target.getDefense());
			}
			holdedDamage+=target.getValuesOf(0, EffectType.ENERGY_SHIELD)+target.getValuesOf(0, EffectType.FAITH_SHIELD);
			critical = damageSource.canBeCritical()?chance(owner.getCriticalChance()/100.0):false;
			resetFinalDamage();
		}
	}
	
	public void resetFinalDamage() {
		finalDamage = ((startDamage-holdedDamage)*(critical?2+(owner.containsEffect(EffectType.PREDATOR)?EffectType.PREDATOR.getValues()[0]:0):1))+additionalDamage;
		if(finalDamage<0){
			finalDamage=0;
		}
	}
	
	public boolean isCritical() {
		return critical;
	}
	
	public double getStartDamage() {
		return startDamage;
	}
	
	public double getHoldedDamage() {
		return holdedDamage;
	}
	
	public double getFinalDamage() {
		return finalDamage;
	}
	
	public double getAdditionalDamage() {
		return additionalDamage;
	}
	
	public boolean isEvaded() {
		return evaded;
	}
	
	public void addAdditionalDamage(double additionalDamage) {
		this.additionalDamage+=additionalDamage;
		resetFinalDamage();
	}
	
	public void setAdditionalDamage(double additionalDamage) {
		this.additionalDamage=additionalDamage;
		resetFinalDamage();
	}
	
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
	public void setHoldedDamage(double holdedDamage) {
		this.holdedDamage = holdedDamage;
		resetFinalDamage();
	}
	
	public void setFinalDamage(double finalDamage) {
		this.finalDamage = finalDamage;
	}
	
}
