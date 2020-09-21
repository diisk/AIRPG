package me.diisk.airpg.Item;

public enum ItemCategory {

	MAGIC_WEAPON(0,"Arma M�gica"),
	LIGHT_WEAPON(1,"Arma Leve"),
	HEAVY_WEAPON(2,"Arma Pesada"),
	MAX_HEALTH_ACCESSORY(3,"Acess�rio de Vida M�xima"),
	HEALTH_REGENERATION_ACCESSORY(4,"Acess�rio de Regenera��o de Vida"),
	ENERGY_REGENERATION_ACCESSORY(5,"Acess�rio de Regenera��o de Energia"),
	ACCURACY_ACCESSORY(6,"Acess�rio de Acerto"),
	CRITICAL_DAMAGE_ACCESSORY(7,"Acess�rio de Chance de Acerto Cr�tico"),
	MAX_ENERGY_ACCESSORY(8,"Acess�rio de Energia M�xima"),
	LIFE_STEAL_ACCESSORY(9,"Acess�rio de Roubo de Vida"),
	HEAVY_ARMOR(10,"Armadura Pesada"),
	LIGHT_ARMOR(11,"Armadura Leve"),
	MAGIC_ARMOR(12,"Armadura M�gica")
	;
	
	private int id;
	private String name;
	
	private ItemCategory(int id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
}
