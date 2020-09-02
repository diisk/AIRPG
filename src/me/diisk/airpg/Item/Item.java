package me.diisk.airpg.Item;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Skill;

public class Item {

	private Type type;
	
	
	public Attributes getMods() {
		return type.getMods();
	}
	
	public Skill getSkill() {
		return type.getSkill();
	}
	
}
