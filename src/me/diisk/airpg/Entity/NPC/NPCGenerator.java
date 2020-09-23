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

	private int maxLevel = 1;
	private int minLevel = 1;
	private Classe[] classes = Classe.values();
	private Race[] races = Race.values();

	private ItemCategory weaponCategory = null;

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

	private boolean sortGradeByLevel = true;
	private boolean giveWeaponByClasse = false;
	private boolean giveWeaponByClasseCategory = true;
	private boolean giveArmorByClasseCategory = false;
	private boolean giveAccessoryByClasse = false;

	private double accessorySlotChance = 0.4;
	private double armorSlotChance = 0.8;
	private double weaponSlotChance = 0.9;

	private ItemType[] equipments = new ItemType[Slot.EQUIPMENTS_LENGTH];

	/*public static void main(String[] args) {
		NPCGenerator ng = new NPCGenerator();
		ng.setGrades(ItemGrade.NORMAL);
		List<NPC> npcs = ng.getAllPossibilities(10);
		for(NPC npc:npcs) {
			System.out.println(npc.getName());
		}
		System.out.println(npcs.size());
	}*/
	
	private static String getGeneratedName(Race race, Classe classe, ItemType weapon, ItemCategory armorCategory, ItemCategory accessoryCategory) {
		String name = race.getName()+"/"+classe.getName();
		if(weapon!=null) {
			name+="/"+weapon.name();
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

		ItemType[] weapons = new ItemType[] {null};
		CustomList<ItemType> mod = new CustomList<ItemType>();
		if(equipments[Slot.WEAPON.getID()]!=null) {
			weapons = new ItemType[] {equipments[Slot.WEAPON.getID()]};
		}else {
			if(!giveWeaponByClasse&&!giveWeaponByClasseCategory) {
				if(weaponCategory!=null) {
					mod.addAll(ItemType.getByFilters( new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON), new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, weaponCategory)));
					weapons = new ItemType[mod.size()];
					for(int i=0;i<weapons.length;i++) {
						weapons[i] = mod.get(i);
					}
				}
			}
		}
		for(Classe classe:classes) {
			if(equipments[Slot.WEAPON.getID()]==null&&giveWeaponByClasse) {
				mod.clear();
				for(ItemGroup group:classe.getWeaponGroups()) {
					mod.addAll(ItemType.getByFilters( new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON), new FilterableFilter(ItemType.OBJECT_ID_GROUP, group)));
				}
				weapons = new ItemType[mod.size()];
				for(int i=0;i<weapons.length;i++) {
					weapons[i] = mod.get(i);
				}
			}else if(equipments[Slot.WEAPON.getID()]==null&&giveWeaponByClasseCategory) {
				mod.clear();
				mod.addAll(ItemType.getByFilters( new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON), new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, classe.getCategory())));
				weapons = new ItemType[mod.size()];
				for(int i=0;i<weapons.length;i++) {
					weapons[i] = mod.get(i);
				}
			}
			for(ItemGrade grade:grades) {
				for(ItemType weapon:weapons) {
					if(weapon!=null&&equipments[Slot.WEAPON.getID()]==null) {
						if(weapon.getGrade()!=grade) {
							continue;
						}
					}
					for(Race race:races) {
						for(ItemCategory armorCategory:armorsCategories) {
							ItemType[] armors = new ItemType[4];
							Slot slot = null;
							for(int i=0;i<4;i++) {
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
								armors[i] = equipments[slot.getID()];
								if(armors[i]==null && armorCategory!=null) {
									armors[i] = ItemType.getByFilters(
											new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,armorCategory),
											new FilterableFilter(ItemType.OBJECT_ID_GRADE,grade),
											new FilterableFilter(ItemType.OBJECT_ID_SLOT,slot)).get(0);
								}
							}
							for(ItemCategory accessoryCategory:accessoriesCategories) {
								ItemType[] accessories = new ItemType[6];
								for(int i=0;i<6;i++) {
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
									accessories[i] = equipments[slot.getID()];
									if(accessories[i]==null&&accessoryCategory!=null) {
										slot=slot==Slot.EARRING2?Slot.EARRING:slot;
										slot=slot==Slot.RING2?Slot.RING:slot;
										accessories[i] = ItemType.getByFilters(
												new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,accessoryCategory),
												new FilterableFilter(ItemType.OBJECT_ID_GRADE,grade),
												new FilterableFilter(ItemType.OBJECT_ID_SLOT,slot)).get(0);
									}
								}
								NPC npc = new NPC(level, getGeneratedName(race, classe, weapon, armorCategory, accessoryCategory), race, classe);
								if(weapon!=null) {
									npc.setEquipment(Slot.WEAPON,new Item(1, weapon));
									if(!weapon.isTwoHanded()) {
										npc.setEquipment(Slot.WEAPON_SECONDARY, new Item(1, ItemType.getByFilters(
												new FilterableFilter(ItemType.OBJECT_ID_CATEGORY,weapon.getCategory()),
												new FilterableFilter(ItemType.OBJECT_ID_SLOT,Slot.WEAPON_SECONDARY),
												new FilterableFilter(ItemType.OBJECT_ID_GRADE,weapon.getGrade())
												).get(0)));
									}
								}
								ItemType imod = null;
								for(int i=0;i<6;i++) {
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
									if(i<4) {
										imod = armors[i];
										if(imod!=null) {
											npc.setEquipment(slot, new Item(1, imod));
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
									imod = accessories[i];
									if(imod!=null) {
										npc.setEquipment(slot, new Item(1, imod));
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

	public void clearEquipments() {
		equipments = new ItemType[Slot.EQUIPMENTS_LENGTH];
	}

	public void setEquipment(Slot slot, ItemType itemType) {
		equipments[slot.getID()] = itemType;
	}

	public void setSortGradeByLevel(boolean sortGradeByLevel) {
		this.sortGradeByLevel = sortGradeByLevel;
	}

	public void setGiveWeaponByClasse(boolean giveWeaponByClasse) {
		this.giveWeaponByClasse = giveWeaponByClasse;
	}

	public void setGrades(ItemGrade... grades) {
		this.grades = grades;
	}

	public void setAccessorySlotChance(double accessorySlotChance) {
		this.accessorySlotChance = accessorySlotChance;
	}
	
	public void setGiveWeaponByClasseCategory(boolean giveWeaponByClasseCategory) {
		this.giveWeaponByClasseCategory = giveWeaponByClasseCategory;
	}

	public void setArmorSlotChance(double armorSlotChance) {
		this.armorSlotChance = armorSlotChance;
	}

	public void setWeaponSlotChance(double weaponSlotChance) {
		this.weaponSlotChance = weaponSlotChance;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}
	public void setClasses(Classe...classes) {
		this.classes = classes;
	}
	public void setRaces(Race... races) {
		this.races = races;
	}
	public void setWeaponCategories(ItemCategory weaponCategory) {
		this.weaponCategory=weaponCategory;
	}
	public void setAccessoriesCategories(ItemCategory... accessoriesCategories) {
		if(accessoriesCategories==null || accessoriesCategories.length==0) {
			this.accessoriesCategories = new ItemCategory[] {null};
		}else {
			this.accessoriesCategories = accessoriesCategories;
		}
	}
	public void setArmorsCategories(ItemCategory... armorsCategories) {
		if(armorsCategories==null || armorsCategories.length==0) {
			this.armorsCategories = new ItemCategory[] {null};
		}else{
			this.armorsCategories = armorsCategories;
		}

	}

}
