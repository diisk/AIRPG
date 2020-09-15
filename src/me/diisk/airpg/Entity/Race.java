package me.diisk.airpg.Entity;

import me.diisk.airpg.Effect.EffectType;
import static me.diisk.airpg.Attributes.*;

import me.diisk.airpg.Attributes;

public enum Race {

	UNDEAD(0,"Morto-Vivo","Não possuem alma, são frageis e quase imortais, alguns dizem que foram reanimados por uma força misteriosa.", EffectType.UNDEAD),
	HUMAN(1,"Humano","São adaptáveis oportunistas que possuem grande sorte.",EffectType.LUCKY),
	VAMPIRE(2,"Vampiro","Não há nada que não fariam por um bom copo de sangue, por onde passam há matança.",EffectType.BLOODSUCKER),
	HALF_DRAGON(3,"Meio-Dragão","Apesar de serem uma raça impura, possuem uma força inigualável.",EffectType.DRAGON_CLAW),
	AUTOMATO(4,"Autômato","São feitos de metais raros extremamente resistentes, e possuem um grande poder de ataque.",EffectType.ELETRIC_ARMOR),
	ELF(5,"Elfo","Possuem uma grande afinidade com magias de cura, além de possuirem uma grande destreza.",EffectType.HEALER),
	DARK_ELF(6,"Elfo Negro","Ao contrário dos elfos, os elfos negros não são bons com habilidades de cura, mas são poderosos com magias de ataque.",EffectType.CORRUPTION),
	HALF_DEMON(7,"Meio-Demônio","Uma raça frágil por ser impura, mas extremamente forte devido aos seus sacrificios.",EffectType.SACRIFICE),
	ANGEL(8,"Anjo","Aqueles conhecidos como dançarinos por sua agilidade incomparável, e extremamente poderosos.",EffectType.DIVINE_DANCER),
	GOLEM(9,"Golem","São os anciões do mundo, aqueles que estavam presentes desde o inicio.",EffectType.ELDER),
	REPTILIAN(10,"Reptiliano","São uma raça com uma enorme capacidade regenerativa.",EffectType.LIZARD_BLOOD),
	FERAL(11,"Fera","São predadores assassinos, costumam a atacar os pontos vitais de suas vítimas.",EffectType.PREDATOR),
	DARKIN(12,"Darkin","Seres temidos e desconhecidos por todos, ninguem sabe o que são, e nem de onde vieram.",EffectType.DARK_POWER),
	ABYSSAL(13,"Abyssal","Amantes e controladores da água, com um forte poder de cura.",EffectType.BOUNCY_HEAL),
	FAIRY(14,"Fada","Pequenos seres mágicos e poderosos, mas sua habilidade especial é ajudar os outros.",EffectType.ENERGY_STEALER),
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
