package me.diisk.airpg.Entity;

import me.diisk.airpg.Effect.EffectType;
import static me.diisk.airpg.Attributes.*;

import me.diisk.airpg.Attributes;

public enum Race {

	UNDEAD(0,"Morto-Vivo","N�o possuem alma, s�o frageis e quase imortais, alguns dizem que foram reanimados por uma for�a misteriosa.", EffectType.UNDEAD),
	HUMAN(1,"Humano","S�o adapt�veis oportunistas que possuem grande sorte.",EffectType.LUCKY),
	VAMPIRE(2,"Vampiro","N�o h� nada que n�o fariam por um bom copo de sangue, por onde passam h� matan�a.",EffectType.BLOODSUCKER),
	HALF_DRAGON(3,"Meio-Drag�o","Apesar de serem uma ra�a impura, possuem uma for�a inigual�vel.",EffectType.DRAGON_CLAW),
	AUTOMATO(4,"Aut�mato","S�o feitos de metais raros extremamente resistentes, e possuem um grande poder de ataque.",EffectType.ELETRIC_ARMOR),
	ELF(5,"Elfo","Possuem uma grande afinidade com magias de cura, al�m de possuirem uma grande destreza.",EffectType.HEALER),
	DARK_ELF(6,"Elfo Negro","Ao contr�rio dos elfos, os elfos negros n�o s�o bons com habilidades de cura, mas s�o poderosos com magias de ataque.",EffectType.CORRUPTION),
	HALF_DEMON(7,"Meio-Dem�nio","Uma ra�a fr�gil por ser impura, mas extremamente forte devido aos seus sacrificios.",EffectType.SACRIFICE),
	ANGEL(8,"Anjo","Aqueles conhecidos como dan�arinos por sua agilidade incompar�vel, e extremamente poderosos.",EffectType.DIVINE_DANCER),
	GOLEM(9,"Golem","S�o os anci�es do mundo, aqueles que estavam presentes desde o inicio.",EffectType.ELDER),
	REPTILIAN(10,"Reptiliano","S�o uma ra�a com uma enorme capacidade regenerativa.",EffectType.LIZARD_BLOOD),
	FERAL(11,"Fera","S�o predadores assassinos, costumam a atacar os pontos vitais de suas v�timas.",EffectType.PREDATOR),
	DARKIN(12,"Darkin","Seres temidos e desconhecidos por todos, ninguem sabe o que s�o, e nem de onde vieram.",EffectType.DARK_POWER),
	ABYSSAL(13,"Abyssal","Amantes e controladores da �gua, com um forte poder de cura.",EffectType.BOUNCY_HEAL),
	FAIRY(14,"Fada","Pequenos seres m�gicos e poderosos, mas sua habilidade especial � ajudar os outros.",EffectType.ENERGY_STEALER),
	;
	
	private String name;
	private String description;
	private int id;
	private EffectType passive;
	
	
	private Race(int id, String name, String description,EffectType passive) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.passive = passive;
	}
	
	public Attributes getAttributes() {
		Attributes r = new Attributes();
		r.set(Attributes.ACCURACY, 15);
		r.set(Attributes.ATTACK_POWER, 100);
		r.set(Attributes.ENERGY_REGENERATION, 1);
		r.set(Attributes.HEALTH_REGENERATION, 2);
		r.set(Attributes.MAX_ENERGY, 100);
		r.set(Attributes.MAX_HEALTH, 100);
		switch(this) {
		case ABYSSAL:
			r.set(ACCURACY, 45);
			r.set(ENERGY_REGENERATION, 6);
			break;
		case ANGEL:
			r.set(ENERGY_REGENERATION, 2);
			r.set(ATTACK_POWER, 130);
			r.set(ACCURACY, 30);
			break;
		case AUTOMATO:
			r.set(INITIATIVE, 10);
			r.set(ATTACK_POWER, 120);
			r.set(MAX_ENERGY, 150);
			r.set(DEFENSE, 50);
			break;
		case DARKIN:
			r.set(INITIATIVE, 5);
			r.set(EVASION, 3);
			r.set(MAX_HEALTH, 120);
			r.set(DEFENSE, 20);
			r.set(LIFE_STEAL, 5);
			r.set(ATTACK_POWER, 130);
			break;
		case DARK_ELF:
			r.set(EVASION, 6);
			r.set(ENERGY_REGENERATION, 3);
			r.set(ACCURACY, 30);
			r.set(ATTACK_POWER, 130);
			break;
		case ELF:
			r.set(EVASION, 6);
			r.set(ENERGY_REGENERATION, 5);
			r.set(ATTACK_POWER, 120);
			r.set(ACCURACY, 45);
			break;
		case FAIRY:
			r.set(ACCURACY, 45);
			r.set(ENERGY_REGENERATION, 3);
			r.set(EVASION, 9);
			r.set(MAX_ENERGY, 120);
			break;
		case FERAL:
			r.set(EVASION, 6);
			r.set(ATTACK_POWER, 130);
			r.set(ACCURACY, 30);
			break;
		case GOLEM:
			r.set(ATTACK_POWER, 120);
			r.set(INITIATIVE, 10);
			break;
		case HALF_DEMON:
			r.set(EVASION, 6);
			r.set(MAX_HEALTH, 130);
			r.set(ACCURACY, 30);
			r.set(ATTACK_POWER, 120);
			r.set(INITIATIVE, 5);
			break;
		case HALF_DRAGON:
			r.set(ATTACK_POWER, 110);
			r.set(ACCURACY, 30);
			r.set(MAX_HEALTH, 130);
			r.set(DEFENSE, 10);
			r.set(INITIATIVE, 5);
			break;
		case HUMAN:
			r.set(ENERGY_REGENERATION, 2);
			r.set(MAX_HEALTH, 125);
			r.set(DEFENSE, 10);
			r.set(ACCURACY, 30);
			r.set(INITIATIVE, 5);
			break;
		case REPTILIAN:
			r.set(ATTACK_POWER, 110);
			r.set(MAX_HEALTH, 150);
			r.set(ACCURACY, 30);
			r.set(INITIATIVE, 5);
			break;
		case UNDEAD:
			r.set(MAX_HEALTH, 150);
			r.set(INITIATIVE, 10);
			break;
		case VAMPIRE:
			r.set(ATTACK_POWER, 120);
			r.set(MAX_HEALTH, 130);
			r.set(ACCURACY, 30);
			r.set(INITIATIVE, 5);
			break;
		
		}
		return r;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public EffectType getPassive() {
		return passive;
	}
	
	public int getID() {
		return id;
	}
	
}
