package me.diisk.airpg;

public class Attributes {

	public static final int INITIATIVE = 0;
	public static final int MAX_HEALTH = 1;
	public static final int MAX_ENERGY = 2;
	public static final int ENERGY_REGENERATION = 3;
	public static final int HEALTH_REGENERATION = 4;
	public static final int ACCURACY = 5;
	public static final int EVASION = 6;
	public static final int ATTACK_POWER = 7;
	public static final int DEFENSE = 8;
	public static final int CRITICAL_CHANCE = 9;
	public static final int LIFE_STEAL = 10;
	public static final int LENGTH = 11;
	
	private double[] values = new double[LENGTH];
	
	public Double get(int attribute){
		return values[attribute];
	}
	
	public void set(int attribute, double value){
		values[attribute]=value;
	}
	
	public void add(int attribute, double value){
		values[attribute]+=value;
	}
	
	public void multiply(int attribute, double value){
		values[attribute]*=value;
	}
	
	public void copy(Attributes attributes) {
		for(int i=0;i<LENGTH;i++) {
			set(i, attributes.get(i));
		}
	}
	
	public static String getName(int attribute) {
		switch(attribute) {
		case INITIATIVE:
			return "Iniciativa";
		case MAX_HEALTH:
			return "Vida Máxima";
		case MAX_ENERGY:
			return "Energia Máxima";
		case ENERGY_REGENERATION:
			return "Regeneração de Energia";
		case HEALTH_REGENERATION:
			return "Regeneração de Vida";
		case ACCURACY:
			return "Acerto";
		case EVASION:
			return "Evasão";
		case ATTACK_POWER:
			return "Poder de Ataque";
		case DEFENSE:
			return "Defesa";
		case CRITICAL_CHANCE:
			return "Chance de Acerto Crítico";
		case LIFE_STEAL:
			return "Roubo de Vida";
		}
		return null;
	}
	
	@Override
	public String toString() {
		String v = "";
		for(int i=0;i<LENGTH;i++) {
			double value = get(i);
			if(value!=0) {
				if(v.length()>0) {
					v+=",";
				}
				v+=getName(i)+":"+value;
			}
		}
		return v.length()>0?v:null;
	}
	
}
