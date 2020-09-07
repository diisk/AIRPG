package me.diisk.airpg;

import static me.diisk.airpg.Utils.*;

import me.diisk.airpg.Effect.EffectType;

public class Damage {

	private boolean critical;
	private double startDamage;
	private double holdedDamage;
	private double additionalDamage = 0;
	private double finalDamage;
	private boolean evaded;
	private Entity owner;
	private Entity target;
	
	private boolean canceled = false;
	
	public Damage(Entity owner, Entity target, DamageSource damageSource) {
		this.owner=owner;
		this.target=target;
		evaded = chance(target.getEvasion()/(target.getEvasion()+owner.getAccuracy()));
		if(!evaded) {
			startDamage = damageSource.getStartDamage(owner, target);
			holdedDamage = startDamage*getDamageReductionFor(target.getDefense());
			holdedDamage+=target.getValuesOf(0, EffectType.ENERGY_SHIELD);
			critical = chance(owner.getCriticalChance()/100.0);
			resetFinalDamage();
		}
	}
	
	public void resetFinalDamage() {
		finalDamage = ((startDamage-holdedDamage)*(critical?2+(owner.containsEffect(EffectType.PREDATOR)?EffectType.PREDATOR.getValues()[0]:0):1))+additionalDamage;
		if(finalDamage<0){
			finalDamage=0;
		}
	}
	
	public double getFinalDamage() {
		return finalDamage;
	}
	
	public double getAdditionalDamage() {
		return additionalDamage;
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
