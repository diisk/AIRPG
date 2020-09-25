package me.diisk.airpg.Entity.NPC;

import java.util.ArrayList;
import java.util.List;

import me.diisk.airpg.CustomList.CustomList;
import me.diisk.airpg.CustomList.FilterableFilter;
import me.diisk.airpg.Entity.Classe;
import me.diisk.airpg.Entity.Race;
import me.diisk.airpg.Item.ItemCategory;
import me.diisk.airpg.Item.ItemGrade;
import me.diisk.airpg.Item.ItemGroup;
import me.diisk.airpg.Item.Item;
import me.diisk.airpg.Item.ItemType;
import me.diisk.airpg.Item.Slot;

public class NPCGenerator {

	private Classe[] classes = Classe.values();
	private Race[] races = Race.values();

	private ItemCategory weaponsCategories[] = new ItemCategory[] {
			ItemCategory.HEAVY_WEAPON,
			ItemCategory.LIGHT_WEAPON,
			ItemCategory.MAGIC_WEAPON
	};

	private ItemCategory[] accessoriesCategories = new ItemCategory[] {
			ItemCategory.ACCURACY_ACCESSORY
			,ItemCategory.CRITICAL_DAMAGE_ACCESSORY
			,ItemCategory.ENERGY_REGENERATION_ACCESSORY
			,ItemCategory.HEALTH_REGENERATION_ACCESSORY
			,ItemCategory.LIFE_STEAL_ACCESSORY
			,ItemCategory.MAX_ENERGY_ACCESSORY
			,ItemCategory.MAX_HEALTH_ACCESSORY};

	private ItemCategory[] armorsCategories = new ItemCategory[] {
			ItemCategory.HEAVY_ARMOR
			,ItemCategory.LIGHT_ARMOR
			,ItemCategory.MAGIC_ARMOR
	};

	private ItemGrade[] grades = ItemGrade.values();

	private ItemType[] equipments = new ItemType[Slot.EQUIPMENTS_LENGTH];
	
	private boolean giveClasseWeapon = false;
	private boolean giveClasseArmor = false;
	private boolean giveClasseAccessories = false;
	private boolean giveCategoryWeapon = true;

	/*public static void main(String[] args) {
		NPCGenerator ng = new NPCGenerator();
		ng.setGrades(ItemGrade.NORMAL);
		List<NPC> npcs = ng.getAllPossibilities(10);
		for(NPC npc:npcs) {
			System.out.println(npc.getName());
		}
		System.out.println(npcs.size());
	}*/
	
	public ItemType getEquipment(Slot slot) {
		return equipments[slot.getID()];
	}
	
	private static String getGeneratedName(Race race, Classe classe, ItemType weapon, ItemCategory armorCategory, ItemCategory accessoryCategory) {
		String name = race.getName()+"/"+classe.getName();
		if(weapon!=null) {
			name+="/"+weapon.getGroup().name();
		}
		if(armorCategory!=null) {
			name+="/"+armorCategory.name();
		}
		if(accessoryCategory!=null) {
			name+="/"+accessoryCategory.name();
		}
		return name;
	}
	
	public List<NPC> getAllPossibilities(int level) {
		List<NPC> r = new ArrayList<NPC>();
		List<Slot> armorSlots = new ArrayList<Slot>();
		List<Slot> accessorySlots = new ArrayList<Slot>();
		Slot slot = null;
		for(int i=0;i<6;i++) {
			if(i<4) {
				switch(i) {
				case 0:
					slot = Slot.HELMET;
					break;
				case 1:
					slot = Slot.ARMOR;
					break;
				case 2:
					slot = Slot.GLOVES;
					break;
				case 3:
					slot = Slot.FEETS;
					break;
				}
				if(equipments[slot.getID()]==null) {
					armorSlots.add(slot);
				}
			}
			switch(i) {
			case 0:
				slot = Slot.EARRING;
				break;
			case 1:
				slot = Slot.EARRING2;
				break;
			case 2:
				slot = Slot.NECKLACE;
				break;
			case 3:
				slot = Slot.WAIST;
				break;
			case 4:
				slot = Slot.RING;
				break;
			case 5:
				slot = Slot.RING2;
				break;
			}
			if(equipments[slot.getID()]==null) {
				accessorySlots.add(slot);
			}
		}
		
		CustomList<ItemType> mod;
		
		for(Race race:races) {
			for(Classe classe:classes) {
				ItemCategory[] armorCategories = giveClasseArmor?new ItemCategory[] {classe.getArmorCategory()}:armorSlots.size()>0?armorsCategories:new ItemCategory[] {null};
				ItemCategory[] accessoryCategories = giveClasseAccessories?new ItemCategory[] {classe.getAccessoryCategory()}:accessorySlots.size()>0?accessoriesCategories:new ItemCategory[] {null};
				ItemGroup[] classeGroups = giveClasseWeapon?classe.getWeaponGroups():new ItemGroup[] {null};
				boolean skipWeapon = false;
				if(getEquipment(Slot.WEAPON)!=null) {
					if(classe.canUse(getEquipment(Slot.WEAPON))) {
						skipWeapon=true;
					}
				}
				ItemCategory[] weaponCategories = giveCategoryWeapon?new ItemCategory[] {classe.getCategory()}:weaponsCategories;
				for(ItemGrade grade:grades) {
					ItemType[] weapons;
					if(!skipWeapon) {
						mod = new CustomList<ItemType>();
						for(ItemGroup group:classeGroups) {
							if(group==null) {
								for(ItemCategory weaponCategory:weaponCategories) {
									if(weaponCategory!=null) {
										mod.addAll(ItemType.getByFilters(
												new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,weaponCategory),
												new FilterableFilter(ItemType.OBJECT_ID_GRADE,grade),
												new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON)
												));
									}
								}
							}else {
								mod.addAll(ItemType.getByFilters(
										new FilterableFilter(ItemType.OBJECT_ID_GROUP,group),
										new FilterableFilter(ItemType.OBJECT_ID_GRADE,grade),
										new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON)
										));
							}
						}
						if(mod.size()>0) {
							weapons = mod.toArray(new ItemType[mod.size()]);
						}else {
							weapons = new ItemType[] {null};
						}
					}else {
						weapons = new ItemType[] {getEquipment(Slot.WEAPON)};
					}
					
					for(ItemType weapon:weapons) {
						for(ItemCategory armorCategory:armorCategories) {
							for(ItemCategory accessoryCategory:accessoryCategories) {
								NPC npc = new NPC(level, getGeneratedName(race, classe, weapon, armorCategory, accessoryCategory), race, classe);
								if(weapon!=null) {
									npc.setEquipment(Slot.WEAPON, new Item(1, weapon));
									if(!weapon.isTwoHanded()) {
										npc.setEquipment(Slot.WEAPON_SECONDARY, new Item(1, ItemType.getByFilters(
												new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,classe.getCategory()),
												new FilterableFilter(ItemType.OBJECT_ID_GRADE,weapon.getGrade()),
												new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON_SECONDARY)
												).get(0)));
									}
								}
								for(int i=0;i<6;i++) {
									if(i<4) {
										switch(i) {
										case 0:
											slot = Slot.HELMET;
											break;
										case 1:
											slot = Slot.ARMOR;
											break;
										case 2:
											slot = Slot.GLOVES;
											break;
										case 3:
											slot = Slot.FEETS;
											break;
										}
										if(!armorSlots.contains(slot)) {
											npc.setEquipment(slot, new Item(1, getEquipment(slot)));
										}else {
											if(armorCategory!=null) {
												npc.setEquipment(slot, new Item(1, ItemType.getByFilters(
														new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,armorCategory),
														new FilterableFilter(ItemType.OBJECT_ID_GRADE,grade),
														new FilterableFilter(ItemType.OBJECT_ID_SLOT,slot)
														).get(0)));
											}
										}
									}
									switch(i) {
									case 0:
										slot = Slot.EARRING;
										break;
									case 1:
										slot = Slot.EARRING2;
										break;
									case 2:
										slot = Slot.NECKLACE;
										break;
									case 3:
										slot = Slot.WAIST;
										break;
									case 4:
										slot = Slot.RING;
										break;
									case 5:
										slot = Slot.RING2;
										break;
									}
									if(!accessorySlots.contains(slot)) {
										npc.setEquipment(slot, new Item(1, getEquipment(slot)));
									}else {
										if(accessoryCategory!=null) {
											npc.setEquipment(slot, new Item(1, ItemType.getByFilters(
													new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,accessoryCategory),
													new FilterableFilter(ItemType.OBJECT_ID_GRADE,grade),
													new FilterableFilter(ItemType.OBJECT_ID_SLOT,slot)
													).get(0)));
										}
									}
								}
								r.add(npc);
							}
						}
					}
				}
			}
		}
		
		return r;
	}
	
	public void setGiveCategoryWeapon(boolean giveCategoryWeapon) {
		this.giveCategoryWeapon = giveCategoryWeapon;
	}
	
	public void setGiveClasseAccessories(boolean giveClasseAccessories) {
		this.giveClasseAccessories = giveClasseAccessories;
	}
	
	public void setGiveClasseArmor(boolean giveClasseArmor) {
		this.giveClasseArmor = giveClasseArmor;
	}
	
	public void setGiveClasseWeapon(boolean giveClasseWeapon) {
		this.giveClasseWeapon = giveClasseWeapon;
	}

	public void clearEquipments() {
		equipments = new ItemType[Slot.EQUIPMENTS_LENGTH];
	}

	public void setEquipment(Slot slot, ItemType itemType) {
		equipments[slot.getID()] = itemType;
	}

	public void setGrades(ItemGrade... grades) {
		this.grades = grades;
	}
	public void setClasses(Classe...classes) {
		this.classes = classes;
	}
	public void setRaces(Race... races) {
		this.races = races;
	}
	
	public void setAccessoriesCategories(ItemCategory... accessoriesCategories) {
		this.accessoriesCategories = accessoriesCategories;
	}
	
	public void setArmorsCategories(ItemCategory... armorsCategories) {
		this.armorsCategories = armorsCategories;
	}
	
	public void setWeaponsCategories(ItemCategory... weaponsCategories) {
		this.weaponsCategories = weaponsCategories;
	}

}
