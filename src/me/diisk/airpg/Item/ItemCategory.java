package me.diisk.airpg.Item;

public enum ItemCategory {

	MAGIC_WEAPON(0,"Arma Mágica"),
	LIGHT_WEAPON(1,"Arma Leve"),
	HEAVY_WEAPON(2,"Arma Pesada"),
	MAX_HEALTH_ACCESSORY(3,"Acessório de Vida Máxima"),
	HEALTH_REGENERATION_ACCESSORY(4,"Acessório de Regeneração de Vida"),
	ENERGY_REGENERATION_ACCESSORY(5,"Acessório de Regeneração de Energia"),
	ACCURACY_ACCESSORY(6,"Acessório de Acerto"),
	CRITICAL_DAMAGE_ACCESSORY(7,"Acessório de Chance de Acerto Crítico"),
	MAX_ENERGY_ACCESSORY(8,"Acessório de Energia Máxima"),
	LIFE_STEAL_ACCESSORY(9,"Acessório de Roubo de Vida"),
	HEAVY_ARMOR(10,"Armadura Pesada"),
	LIGHT_ARMOR(11,"Armadura Leve"),
	MAGIC_ARMOR(12,"Armadura Mágica")
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
