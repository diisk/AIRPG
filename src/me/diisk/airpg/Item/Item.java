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
	
}
