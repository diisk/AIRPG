package me.diisk.airpg.StatisticManager;

public enum StatisticType {
	
	ACCESSORIES(0,"Acess�rios"),
	ARMORS(1,"Armaduras"),
	WEAPONS(2,"Armas"),
	CLASSES(3,"Classes"),
	RACES(4,"Ra�as"),
	ALL(5,"Tudo");
	
	private int id;
	private String name;
	
	StatisticType(int id, String name){
		this.id=id;
		this.name=name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public int getID() {
		return id;
	}
}
