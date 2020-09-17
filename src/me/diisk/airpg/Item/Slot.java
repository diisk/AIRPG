package me.diisk.airpg.Item;

public enum Slot {

	HELMET(0,"Capacete"),
	ARMOR(1,"Armadura"),
	FEETS(2,"Botas"),
	GLOVES(3,"Luvas"),
	WEAPON(4,"Arma"),
	WEAPON_SECONDARY(5,"Arma Secund�ria"),
	NECKLACE(6,"Colar"),
	WAIST(7,"Cinto"),
	RING(8,"Anel"),
	RING2(9,"Anel Secund�rio"),
	EARRING(10,"Brinco"),
	EARRING2(11,"Brinco Secund�rio"),
	INVENTORY(13,"Invent�rio")
	;
	
	private int id;
	private String name;
	
	private Slot(int id, String name){
		this.id=id;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public static Slot getSlotBy(int id) {
		for(Slot s:values()) {
			if(s.id==id) {
				return s;
			}
		}
		return null;
	}
	
	public int getID() {
		return id;
	}
	
}
