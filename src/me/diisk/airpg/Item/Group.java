package me.diisk.airpg.Item;

public enum Group {

	LONG_SWORD(0,"Espada Longa"),
	DUAL_AXE(1,"Machados Duplos"),
	GIANT_HAMMER(2,"Martelo Gigante"),
	STAFF(3,"Cajado"),
	NATURE_ESSENCE(4,"Ess�ncia da Natureza"),
	DAGGERS(5,"Adagas"),
	SHORT_SWORD(6,"Espada Curta"),
	DEMONIAC_SCYTHE(7,"Foice Demon�aca"),
	DEMONIAC_ORB(8,"Orbe Demon�aco"),
	LANCE(9,"Lan�a"),
	SHIELD(10,"Escudo"),
	LONG_BOW(11,"Arco Longo"),
	SHORT_BOW(12,"Arco Curto"),
	MACE(13,"Ma�a"),
	GRIMOIRE(14,"Grim�rio"),
	CRUCIFIX(15,"Crucifixo"),
	MAGIC_SWORD(16,"Espada M�gica"),
	BEER_MUG(17,"Caneca de Cerveja"),
	STICK(18,"Bast�o"),
	ARMOR(19,"Armadura"),
	ACCESSORIES(20,"Acess�rios")
	;
	
	private int id;
	private String name;
	
	private Group(int id, String name) {
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
