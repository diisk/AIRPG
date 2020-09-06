package me.diisk.airpg;

import static me.diisk.airpg.Utils.*;

public class Damage {

	private boolean critical;
	private double startDamage;
	private double holdedDamage;
	private double additionalDamage = 0;
	private double finalDamage;
	
	private boolean canceled = false;
	
	public Damage(Entity owner, Entity target, DamageSource damageSource) {
		startDamage = damageSource.getStartDamage(owner, target);
		holdedDamage = startDamage*getDamageReductionFor(target.getDefense());
		critical = chance(owner.getCriticalChance()/100.0);
		resetFinalDamage();
	}
	
	public void resetFinalDamage() {
		finalDamage = ((startDamage-holdedDamage)*(critical?2:1))+additionalDamage;
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
