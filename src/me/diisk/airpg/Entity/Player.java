package me.diisk.airpg.Entity;

import me.diisk.airpg.Item.Item;
import me.diisk.airpg.Item.Slot;

public class Player extends Entity {

	private Item[] inventory = new Item[INVENTORY_LENGTH];
	
	protected Player(long id, String name, Race race, Classe classe) {
		super(id, name, race, classe);
		// TODO Auto-generated constructor stub
	}
	
	public boolean desequip(Slot slot) {
		if(getEquipmentBy(slot)!=null) {
			if(getFreeInventorySize()>=2) {
				Item item = getEquipmentBy(slot);
				inventory[getFreeInventorySlot()]=item;
				equipments[slot.getID()]=null;
			}else {
				return false;
			}
		}
		return true;
	}

	private void removeItem(Item item) {
		for(int i=0;i<INVENTORY_LENGTH;i++) {
			Item it = inventory[i];
			if(it.getType()==item.getType()) {
				if(it.getAmount()>item.getAmount()) {
					it.setAmount(it.getAmount()-item.getAmount());
				}else {
					inventory[i]=null;
				}
				break;
			}
		}
	}

	public boolean equip(Item item) {
		if(getEquipmentBy(item.getSlot())==null) {
			equipments[item.getSlot().getID()]=item;
			removeItem(item);
		}else {
			switch(item.getSlot()) {
			case INVENTORY:
				return false;
			case EARRING:
				if(getEquipmentBy(Slot.EARRING2)==null) {
					equipments[Slot.EARRING2.getID()]=item;
					removeItem(item);
					break;
				}
			case RING:
				if(getEquipmentBy(Slot.RING2)==null) {
					equipments[Slot.RING2.getID()]=item;
					removeItem(item);
					break;
				}
			default:
				if(desequip(item.getSlot())) {
					equip(item);
				}else {
					return false;
				}
				break;
			}
		}
		return true;
	}

	public int getFreeInventorySize() {
		int r = 0;
		for(int i=0;i<INVENTORY_LENGTH;i++) {
			Item item = inventory[i];
			if(item==null) {
				r++;
			}
		}
		return r;
	}

	public int getFreeInventorySlot() {
		for(int i=0;i<INVENTORY_LENGTH;i++) {
			Item item = inventory[i];
			if(item==null) {
				return i;
			}
		}
		return -1;
	}

}
