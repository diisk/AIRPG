package me.diisk.airpg.Entity.NPC;

import me.diisk.airpg.Entity.Classe;
import me.diisk.airpg.Entity.Entity;
import me.diisk.airpg.Entity.Race;
import me.diisk.airpg.Item.Item;
import me.diisk.airpg.Item.Slot;

public class NPC extends Entity {

	NPC(int level, String name, Race race, Classe classe) {
		super(name, race, classe);
		this.level=level;
	}
	
	public void setEquipment(Slot slot, Item item) {
		equipments[slot.getID()] = item;
	}

}
