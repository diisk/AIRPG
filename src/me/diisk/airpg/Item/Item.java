package me.diisk.airpg.Item;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Skill;
import me.diisk.airpg.CustomList.Filterable;
import me.diisk.airpg.CustomList.Ordenable;

public class Item implements Ordenable{
	
	private ItemType type;
	private int amount;
	
	public Item(int amount, ItemType type) {
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
	
	public ItemGroup getGroup() {
		return type.getGroup();
	}
	
	public int getAmount() {
		return amount;
	}
	
	public ItemGrade getGrade() {
		return type.getGrade();
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public ItemType getType() {
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

	@Override
	public double getNumberValue(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStringValue(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
