package me.diisk.airpg.Item;

public enum Grade {

	NORMAL(0,"Normal"),
	DISTINCT(1,"Distinto"),
	RARE(2,"Raro"),
	LEGENDARY(3,"Lendário")
	;
	
	private String name;
	private int id;
	
	private Grade(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
}
