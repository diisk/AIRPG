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
	private ItemCategory[] accessoriesCategories = new ItemCategory[0];
	private ItemCategory[] armorsCategories = new ItemCategory[0];
	
	private ItemGrade[] grades = ItemGrade.values();
	
	private boolean sortGradeByLevel = true;
	private boolean giveWeaponByClasse = true;
	private boolean giveArmorByClasse = false;
	private boolean giveAccessoryByClasse = false;
	
	private double accessorySlotChance = 0.4;
	private double armorSlotChance = 0.8;
	private double weaponSlotChance = 0.9;
	
	private ItemType[] equipments = new ItemType[Slot.EQUIPMENTS_LENGTH];
	
	public List<NPC> getAllPossibilities(int level) {
		List<NPC> r = new ArrayList<NPC>();
		CustomList<ItemType> mod;
		ItemType weapon = equipments[Slot.WEAPON.getID()];
		for(Classe classe:classes) {
			mod = new CustomList<ItemType>();
			for(Slot slot:Slot.values()) {
				ItemType it = equipments[slot.getID()];
				switch(slot) {
				case ARMOR:
				case FEETS:
				case GLOVES:
				case HELMET:
					if(it!=null) {
						mod.add(it);
					}else {
						if(giveArmorByClasse) {
							for(ItemGrade grade:grades) {
								mod.addAll(ItemType.getByFilters(new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, classe.getArmorCategory()),new FilterableFilter(ItemType.OBJECT_ID_GRADE, grade)));
							}	
						}else {
							for(ItemCategory category:armorsCategories) {
								for(ItemGrade grade:grades) {
									mod.addAll(ItemType.getByFilters(new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, category),new FilterableFilter(ItemType.OBJECT_ID_GRADE, grade)));
								}	
							}
						}
					}
					break;
				case NECKLACE:
				case WAIST:
				case RING:
				case RING2:
				case EARRING:
				case EARRING2:
					if(it!=null) {
						mod.add(it);
					}else {
						if(giveAccessoryByClasse) {
							for(ItemGrade grade:grades) {
								mod.addAll(ItemType.getByFilters(new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, classe.getAccessoryCategory()),new FilterableFilter(ItemType.OBJECT_ID_GRADE, grade)));
							}	
						}else {
							for(ItemCategory category:accessoriesCategories) {
								for(ItemGrade grade:grades) {
									mod.addAll(ItemType.getByFilters(new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, category),new FilterableFilter(ItemType.OBJECT_ID_GRADE, grade)));
								}	
							}
						}
					}			
					break;
				case WEAPON:
					if(it!=null) {
						mod.add(it);
					}else {
						if(giveWeaponByClasse) {
							ItemGroup[] groups = classe.getWeaponGroups();
							for(ItemGroup group:groups) {
								for(ItemGrade grade:grades) {
									mod.addAll(ItemType.getByFilters(new FilterableFilter(ItemType.OBJECT_ID_GROUP, group),new FilterableFilter(ItemType.OBJECT_ID_GRADE, grade)));
								}	
							}
						}else {
							if(weaponCategory!=null) {
								for(ItemGrade grade:grades) {
									mod.addAll(ItemType.getByFilters(new FilterableFilter(ItemType.OBJECT_ID_CATEGORY, weaponCategory),new FilterableFilter(ItemType.OBJECT_ID_GRADE, grade)));
								}	
							}
						}
					}
					break;
				
				}
			}
			for(int i=-1;i<;i++) {
				
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
	
	public void setGiveArmorByClasse(boolean giveArmorByClasse) {
		this.giveArmorByClasse = giveArmorByClasse;
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
		this.accessoriesCategories = accessoriesCategories;
	}
	public void setArmorsCategories(ItemCategory... armorsCategories) {
		this.armorsCategories = armorsCategories;
	}
	
}
