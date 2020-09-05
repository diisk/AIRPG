package me.diisk.airpg;

import static me.diisk.airpg.Utils.*;

public class Damage {

	private boolean critical;
	private double startDamage;
	private double holdedDamage;
	private double finalDamage;
	
	private boolean canceled = false;
	
	public Damage(Entity owner, Entity target, DamageSource damageSource) {
		startDamage = damageSource.getStartDamage(owner, target);
		holdedDamage = startDamage*getDamageReductionFor(target.getDefense());
		critical = chance(owner.getCriticalChance()/100.0);
		finalDamage = (startDamage-holdedDamage)*(critical?2:1);
	}
	
	private void updateFinalDamage() {
		finalDamage = (startDamage-holdedDamage)*(critical?2:1);
	}
	
	public double getFinalDamage() {
		return finalDamage;
	}
	
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	public boolean isCanceled() {
		return canceled;
	}
	
	public void setHoldedDamage(double holdedDamage) {
		this.holdedDamage = holdedDamage;
		updateFinalDamage();
	}
	
	public void setFinalDamage(double finalDamage) {
		critical = false;
		startDamage = finalDamage;
		holdedDamage = 0;
		this.finalDamage = finalDamage;
	}
	
}
