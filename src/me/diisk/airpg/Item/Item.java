package me.diisk.airpg.Item;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Skill;
import me.diisk.airpg.CustomList.Filterable;
import me.diisk.airpg.CustomList.Ordenable;

public class Item implements Ordenable, Filterable{

	public static final int OBJECT_ID_GROUP = 0;
	public static final int OBJECT_ID_GRADE = 1;
	public static final int OBJECT_ID_CATEGORY = 2;
	public static final int OBJECT_ID_SLOT = 3;
	
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

	@Override
	public Object getObject(int id) {
		switch(id) {
		case OBJECT_ID_CATEGORY:
			return type.getCategory();
		case OBJECT_ID_GRADE:
			return type.getGrade();
		case OBJECT_ID_GROUP:
			return type.getGroup();
		case OBJECT_ID_SLOT:
			return type.getSlot();
		}
		return null;
	}
}
