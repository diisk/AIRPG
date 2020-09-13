package me.diisk.airpg.Effect;

import me.diisk.airpg.DamageSource;
import me.diisk.airpg.Entity;
import me.diisk.airpg.HealSource;

public enum EffectType implements DamageSource, HealSource{

	
	//RAÃ‡AS
	UNDEAD(0,"Morto-Vivo","Ao morrer possui 100% de chance de renascer com 30% da vida maxima no mesmo turno, a chance e reduzida pela metade em cada morte.",
			new double[] {
			1,
			0.3
			}),
	LUCKY(1,"Sortudo","Possui mais 25% de chance em todos os testes.",//FAZER
			new double[] {
					0.25
			}),
	BLOODSUCKER(2,"Chupador de Sangue","Todo roubo de vida e dobrado.",
			new double[] {
					1
			}),
	DRAGON_CLAW(3,"Garra de Dragao","Seus ataques causam dano adicional equivalente a 2% da vida maxima do alvo.",
			new double[] {
					0.02
			}),
	ELETRIC_ARMOR(4,"Armadura Eletrica","Possui 25% de chance de causar um dano de contra-ataque equivalente a 50% da sua defesa.",
			new double[] {
					0.25,
					0.5
			}),
	HEALER(5,"Curandeiro","Todas as habilidades de cura sao 100% mais efetivas.",//TESTAR
			new double[] {
					1
			}),
	CORRUPTION(6,"Corrupcao","Todas as habilidades de ataque causam 20% mais dano.",
			new double[] {
					0.2
			}),
	SACRIFICE(7,"Sacrificio","Seus ataques possuem 20% de chance de consumir 15% da propria vida maxima para causar dano dobrado.",
			new double[] {
					0.2,
					0.15
			}),
	DIVINE_DANCER(8,"Dancarino Divino","Sua evasao a dobrada.",
			new double[] {
				1	
			}),
	ELDER(9,"Anciao","Sua vida maxima e dobrada.",
			new double[] {
					1
			}),
	LIZARD_BLOOD(10,"Sangue de Lagarto","Sua regeneracao de vida e dobrada.",
			new double[] {
					1
			}),
	PREDATOR(11,"Predador","Seus ataques criticos causam 50% mais dano.",
			new double[] {
					0.5
			}),
	DARK_POWER(12,"Poder Sombrio","Aumenta toda cura recebida em 50% alem de ignorar as defesas do inimigo.",//TESTAR CURA
			new double[] {
					0.5
			}),
	BOUNCY_HEAL(13,"Cura Saltitante","Suas curas possuem 80% de chance de saltar para um alvo adicional diferente, a chance e a cura reduz pela metade em cada salto.",//TESTAR
			new double[] {
					0.8
			}),
	ENERGY_STEALER(14,"Ladrao de Energia","Seus ataques absorvem 10% da energia atual do alvo, e a transforma em um escudo ate o inicio do seu proximo turno.",
			new double[] {
					0.1
			}),
	
	
	//CLASSES
	ACCURATE_SHOT(15,"Tiro Certeiro","Seu acerto e dobrado.",
			new double[] {
					1
			}),
	FURY(16,"Furia","Seus ataques possuem 20% de chance de absorver 5% da vida maxima para causar o dobro como dano adicional.",
			new double[] {
					0.2,
					0.05,
					2
			}),
	KNIGHT_SPIRIT(17,"Espirito de Cavaleiro","Sua defesa e dobrada.",
			new double[] {
					1
			}),
	TRAINED_KILLER(18,"Assassino Treinado","Sua chance de acerto critico e dobrada.",
			new double[] {
					1
			}),
	THE_RELENTLESS(19,"O Implacavel","Todo dano causado e aumentado em 30%.",
			new double[] {
					0.3
			}),
	SACRED_PROTECTION(20,"Protecao Sagrada","Suas curas aplicam um escudo adicional ate o inicio do seu proximo turno, que absorve dano de ate 40% do seu poder de ataque no proximo ataque recebido.",//TESTAR
			new double[] {
					0.4
			}),
	NATURAL_POLINATION(21,"Polinizacao Natural","Suas curas recebem um adicional de 33% por rodada aplicado durante as proximas 3 rodadas.",//TESTAR
			new double[] {
					0.33,
					3
			}),
	LUCKY_HANDS(22,"Maos da Sorte","Seus ataques causam efeitos aleatorios a cada hit.(DEFESA 0, CORTA CURA 50%, 20% DANO ADICIONAL)",
			new double[] {
				1,
				0.5,
				0.2
			}),
	BUDHA_CONCENTRATION(23,"Concentracao de Budha","Cada acerto aumenta em 10% o poder de ataque durante a rodada, e ao evadir de ataques possui 50% de chance de gerar um contra ataque.",
			new double[] {
					0.1,
					0.5
			}),
	FAITH_ON_CONTROL(24,"Fe no Controle","Seus ataques possuem 20% de chance de curar 15% da vida maxima do alvo mais injuriado.",//TESTAR
			new double[] {
				0.2,
				0.15
			}),
	THE_EXECUTIONER(25,"O Carrasco","Seus ataques possuem 20% de chance de executar um alvo com 20% ou menos de vida.",
			new double[] {
				0.2,
				0.2
			}),
	BLOOD_STEALER(26,"Ladrao de Sangue","Possui 10% de roubo de vida.",
			new double[] {
				0.10	
			}),
	
	//EFFECTS
	ENERGY_SHIELD(27,"Escudo de Energia","Absorve uma parte do dano recebido durante o proximo ataque.",EffectType.TIME_NOTHING_AND_VALUE_ADD,true,false),
	
	CURSE_OF_HEAL(28,"Maldição da Cura","Reduz toda cura recebida.",EffectType.TIME_RESET_AND_VALUE_NOTHING,true,false),//FAZER AINDA
	
	CURSE_OF_DEFENSE(29,"Maldição da Defesa","Reduz a defesa.",EffectType.TIME_RESET_AND_VALUE_NOTHING,true,false),
	
	BUDHA_HANDS(30,"Mão de Budha","Aumenta o poder de ataque em cada acerto durante a rodada.",EffectType.TIME_RESET_AND_VALUE_ADD,true,false),
	
	BOUNCING_REBOUND(31,"Rebate Saltitante","Recebeu um efeito de cura saltitante recentemente.",EffectType.DO_NOTHING,false,true),
	
	FAITH_SHIELD(32,"Escudo de Fe","Absorve uma parte do dano recebido durante o proximo ataque.",EffectType.TIME_RESET_AND_VALUE_RESET,true,false),
	
	CELL_REGENERATION(33,"Regeneração Celular","Esta com efeito de cura por rodada.",EffectType.TIME_RESET_AND_VALUE_RESET,false,false),
	
	LIFE_STEAL(34,"Roubo de Vida","Cura ao causar dano a um inimigo."),
	
	//(,"",""),
	;
	
	private int id;
	private String name;
	private String description;
	private boolean passive;
	
	private boolean unique;
	private boolean duplicate;
	private int category;
	
	public static final int DO_NOTHING = 0;
	public static final int TIME_RESET_AND_VALUE_ADD = 1;
	public static final int TIME_RESET_AND_VALUE_RESET = 2;
	public static final int TIME_RESET_AND_VALUE_NOTHING = 3;
	public static final int TIME_ADD_AND_VALUE_RESET = 4;
	public static final int TIME_ADD_AND_VALUE_ADD = 5;
	public static final int TIME_ADD_AND_VALUE_NOTHING = 6;
	public static final int TIME_NOTHING_AND_VALUE_RESET = 7;
	public static final int TIME_NOTHING_AND_VALUE_ADD = 8;
	
	private int rounds = 0;
	private double[] values = new double[0];
	
	private EffectType(int id, String name, String description, double[] values) {
		config(id, name, description, true, -1, values, DO_NOTHING, true, false);
	}
	
	private EffectType(int id, String name, String description, int category, boolean unique, boolean duplicate) {
		config(id, name, description, true, -1, new double[0], category, unique, duplicate);
	}
	
	private EffectType(int id, String name, String description) {
		config(id, name, description, true, 0, new double[0], DO_NOTHING, true, false);
	}
	
	private void config(int id, String name, String description, boolean passive, int rounds, double[] values, int category, boolean unique, boolean duplicate) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.passive = passive;
		this.rounds=rounds;
		this.values=values;
		this.category = category;
		this.unique = unique;
		this.duplicate = duplicate;
	}
	
	public int getRounds() {
		return rounds;
	}
	
	public double[] getValues() {
		return values;
	}
	
	public boolean isDuplicate() {
		return duplicate;
	}
	
	public boolean isUnique() {
		return unique;
	}
	
	public int getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isPassive() {
		return passive;
	}
	
	public int getID() {
		return id;
	}

	@Override
	public double getStartDamage(Entity owner, Entity target) {
		switch(this){
		case DRAGON_CLAW:
			return values[0]*target.getMaxHealth();
		case ELETRIC_ARMOR:
			return values[1]*owner.getDefense();
		}
		return 0;
	}

	@Override
	public String getDeathMessage(Entity killer, Entity target) {
		switch(this){
		case DRAGON_CLAW:
			return killer.getName()+" rasgou "+target.getName()+" com sua garra de dragao.";
		case ELETRIC_ARMOR:
			return killer.getName()+" desintegrou "+target.getName()+" com um choquinho.";
		case THE_EXECUTIONER:
			return killer.getName()+" executou "+target.getName()+" com um paranaue ninja.";
		}
		return name()+" SEM VALOR DEFINIDO EM DEATHMESSAGE";
	}

	@Override
	public String getDamageMessage(Entity owner, Entity target, int value) {
		switch(this){
		case DRAGON_CLAW:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com sua garra de dragao.";
		case ELETRIC_ARMOR:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com um choquinho.";
		}
		return name()+" SEM VALOR DEFINIDO EM DAMAGEMESSAGE";
	}

	@Override
	public String getSuicideMessage(Entity owner) {
		switch(this){
		case DRAGON_CLAW:
			return owner.getName()+" morreu tentando se masturbar com sua garra de dragao..";
		case ELETRIC_ARMOR:
			return owner.getName()+" se queimou vestindo a roupinha eletrica.";
		case THE_EXECUTIONER:
			return "O cara se executou mano, COMO??? "+owner.getName()+" reporta o admin plz!!!";
		}
		return name()+" SEM VALOR DEFINIDO EM SUICIDEMESSAGE";
	}
	
	public String getUsageMessage() {
		switch(this) {
		case ACCURATE_SHOT:
			break;
		case BLOODSUCKER:
			break;
		case BLOOD_STEALER:
			break;
		case BOUNCY_HEAL:
			break;
		case BUDHA_CONCENTRATION:
			break;
		case CORRUPTION:
			break;
		case DARK_POWER:
			break;
		case DIVINE_DANCER:
			break;
		case DRAGON_CLAW:
			break;
		case ELDER:
			break;
		case ELETRIC_ARMOR:
			break;
		case ENERGY_STEALER:
			break;
		case FAITH_ON_CONTROL:
			break;
		case FURY:
			break;
		case HEALER:
			break;
		case KNIGHT_SPIRIT:
			break;
		case LIZARD_BLOOD:
			break;
		case LUCKY:
			break;
		case LUCKY_HANDS:
			break;
		case NATURAL_POLINATION:
			break;
		case PREDATOR:
			break;
		case SACRED_PROTECTION:
			break;
		case SACRIFICE:
			break;
		case THE_EXECUTIONER:
			break;
		case THE_RELENTLESS:
			break;
		case TRAINED_KILLER:
			break;
		case UNDEAD:
			return "O morto vivo @owner ressucitou CAUSE THIS IS THRILLER OH OH...";
		}
		return name()+" SEM VALOR DEFINIDO EM USAGEMESSAGE";
	}

	@Override
	public String getHealMessage(Entity owner, Entity target, int value) {
		if(!owner.equals(target)) {
			switch(this) {
			case BOUNCING_REBOUND:
				return owner.getLogName()+" curou "+value+" de vida de "+target.getLogName()+" com "+BOUNCY_HEAL.getName()+".";
			case CELL_REGENERATION:
				return owner.getLogName()+" curou "+value+" de vida de "+target.getLogName()+" com "+getName()+".";
			case FAITH_ON_CONTROL:
				return owner.getLogName()+" curou "+value+" de vida de "+target.getLogName()+" com "+getName()+".";
			}
		}else {
			switch(this) {
			case BOUNCING_REBOUND:
				return owner.getLogName()+" curou "+value+" da propria vida com "+BOUNCY_HEAL.getName()+".";
			case CELL_REGENERATION:
				return owner.getLogName()+" curou "+value+" da propria vida com "+getName()+".";
			case FAITH_ON_CONTROL:
				return owner.getLogName()+" curou "+value+" da propria vida com "+getName()+".";
			case LIFE_STEAL:
				return owner.getLogName()+" roubou "+value+" de vida.";
			}
		}
		return name()+" SEM VALOR DEFINIDO EM HEALMESSAGE";
	}

	@Override
	public double getStartHeal(Entity owner, Entity target) {
		switch(this) {
		case FAITH_ON_CONTROL:
			return target.getMaxHealth()*values[1];
		}
		return 0;
	}
	
}
