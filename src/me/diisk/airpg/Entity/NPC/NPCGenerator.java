package me.diisk.airpg.Entity.NPC;

import java.util.ArrayList;
import java.util.List;

import me.diisk.airpg.CustomList.CustomList;
import me.diisk.airpg.Entity.Classe;
import me.diisk.airpg.Entity.Race;
import me.diisk.airpg.Item.Category;
import me.diisk.airpg.Item.Grade;
import me.diisk.airpg.Item.Item;

public class NPCGenerator {

	private int maxLevel = 1;
	private int minLevel = 1;
	private Classe[] classes = new Classe[0];
	private Race[] races = new Race[0];
	
	private Category[] weaponCategories = new Category[0];
	private Category[] accessoriesCategories = new Category[0];
	private Category[] armorsCategories = new Category[0];
	
	private Grade[] grades = new Grade[0];
	
	private boolean sortGradeByLevel = true;
	private boolean giveWeaponByClasseGroup = false;
	
	private double accessorySlotChance = 0.4;
	private double armorSlotChance = 0.8;
	private double weaponSlotChance = 0.9;
	
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}
	public void setClasses(Classe[] classes) {
		this.classes = classes;
	}
	public void setRaces(Race[] races) {
		this.races = races;
	}
	public void setWeaponCategories(Category[] weaponCategories) {
		this.weaponCategories = weaponCategories;
	}
	public void setAccessoriesCategories(Category[] accessoriesCategories) {
		this.accessoriesCategories = accessoriesCategories;
	}
	public void setArmorsCategories(Category[] armorsCategories) {
		this.armorsCategories = armorsCategories;
	}
	
}
