package me.diisk.airpg.Item;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Skill;

public class Item {

	private Type type;
	private int amount;
	
	public Item(int amount, Type type) {
		this.amount=amount;
		this.type=type;
	}
	
	public Attributes getMods() {
		return type.getMods();
	}
	
	public Skill getSkill() {
		return type.getSkill();
	}
	
	public Slot getSlot() {
		return type.getSlot();
	}
	
	public Group getGroup() {
		return type.getGroup();
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Grade getGrade() {
		return type.getGrade();
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			if(((Item) obj).type==type) {
				if(((Item) obj).amount==amount) {
					return true;
				}
			}
		}
		return false;
	}
}
