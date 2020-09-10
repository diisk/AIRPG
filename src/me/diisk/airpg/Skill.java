package me.diisk.airpg;

import java.util.Random;

public enum Skill implements DamageSource, HealSource{
	
	DISARMED_PUNCH(0,"Soco Desarmado",25,"Causa 10 dano ao alvo.",100),
	PRECISE_SHOT(1,"Tiro Preciso",0.20,.25,"Causa dano bruto baseado no poder de ataque.",100),
	FAST_ARROW(2,"Flecha Rápida",0.06,0.08,"Causa dano baseado no poder de ataque, podendo atacar até 3 vezes por rodada.",33),
	BLOODTHIRSTY_ATTACK(3,"Ataque Sanguinário",0.07,0.13,"Causa dano baseado no poder de ataque até 2 vezes por rodada, e cada ataque possui 20% de chance de causar sangramento por 3 rodadas.",50),
	SKULL_SMASH(4,"Esmaga Crânio",0.13,0.15,"Causa dano baseado no poder de ataque, e possui 20% de chance de desnortear o alvo até o inicio do seu proximo turno.",100),
	BLOODY_EATER(5,"Devoradora Sangrenta",0.15,.20,"Causa dano bruto baseado no poder de ataque.",100),
	STAB(6,"Estocada",0.12,0.15,"Causa dano baseado no poder de ataque ignorando bloqueios e defesas.",100),
	FURIOUS_BLADES(7,"Lâminas Furiosas",0.03,0.04,"Causa dano baseado no poder de ataque, podendo atacara até 5 vezes por rodada.",20),
	FIREBALL(8,"Bola de Fogo",0.15,0.25,"Causa dano baseado no poder de ataque, consome 100 de energia para causar dano a todos os inimigos.",100),
	ILUMINATED_FIELD(9,"Campo Iluminado",0.15,0.20,"Causa dano baseado no poder de ataque, consome energia para curar todos os aliados em 5% da vida máxima.",100),
	SPIRITUAL_SEED(10,"Semente Espiritual",0.15,0.20,"Causa dano baseado no poder de ataque, consome energia para curar 10% da vida perdida do alvo mais injuriado.",100),
	ELETRIC_CHARGE(11,"Carga Elétrica",0.05,0.07,"Pode atacar enquanto possuir energia.",1),
	DRUNK_FIST(12,"Punho Bêbado",0.02,0.03,"Causa dano baseado no poder de ataque, cada ataque possui 80% de chance de não consumir pontos de ataque.",100),
	ACCURATE_ATTACK(13,"Ataque Certeiro",0.12,0.15,"Causa dano baseado no poder de ataque, vida perdida e vida maxima.",100),
	CONTROL_ATTACK(14,"Ataque Controlado",0.12,0.15,"Causa dano baseado no poder de ataque, possui 50% de chance de dar um ataque extra na rodada.",100),
	CURSED_BLADE(15,"Lâmina Amaldiçoada",0.15,0.20,"Causa dano baseado no poder de ataque, caso execute o alvo pode atacar novamente.",100),
	HALF_MOON_CUT(16,"Corte Meia-Lua",0.18,0.20,"Causa dano baseado no poder de ataque, na propria vida perdida e na vida atual do alvo.",100),
	DISEASE_WAVE(17,"Onda de Doenças",0.18,0.20,"Causa dano baseado no poder de ataque, consome 100% da mana para causar uma doença a todos os inimigos por 3 rodadas.",100),
	
	//(,"",,,"",100),
	;
	
	private Skill(int id, String name, double minDamage, double maxDamage, String description, int actionCost) {
		config(id, name, minDamage, maxDamage, description, actionCost, 0);
	}
	
	private Skill(int id, String name, int baseDamage, String description, int actionCost) {
		config(id, name, 0, 0, description, actionCost, baseDamage);
	}
	
	private void config(int id, String name, double minDamage, double maxDamage, String description, int actionCost, int baseDamage) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.minDamage=minDamage;
		this.maxDamage=maxDamage;
		this.actionCost=actionCost;
		this.baseDamage = baseDamage;
	}
	
	private String name;
	private String description;
	private double minDamage;
	private double maxDamage;
	private double baseDamage;
	private int energyCost;
	private int actionCost;
	private int id;
	
	public static final int USESKILL_NO_ENERGY = 0;
	public static final int USESKILL_NO_ACTIONPOINTS = 1;
	public static final int USESKILL_SUCCESS = 2;
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getEnergyCost() {
		return energyCost;
	}
	
	public int getActionCost() {
		return actionCost;
	}

	@Override
	public double getStartDamage(Entity owner, Entity target) {
		double r = baseDamage;
		Random random = new Random();
		double variation = 1000;
		r+=owner.getAttackPower()*((variation*minDamage)+(random.nextInt((int)(variation*(maxDamage-minDamage)+1))))/variation;
		return r;
	}

	@Override
	public String getDeathMessage() {
		switch(this) {
		case ACCURATE_ATTACK:
			break;
		case BLOODTHIRSTY_ATTACK:
			break;
		case BLOODY_EATER:
			break;
		case CONTROL_ATTACK:
			break;
		case CURSED_BLADE:
			break;
		case DISARMED_PUNCH:
			return "@owner desintegrou @target com um tapão.";
		case DISEASE_WAVE:
			break;
		case DRUNK_FIST:
			break;
		case ELETRIC_CHARGE:
			break;
		case FAST_ARROW:
			break;
		case FIREBALL:
			break;
		case FURIOUS_BLADES:
			break;
		case HALF_MOON_CUT:
			break;
		case ILUMINATED_FIELD:
			break;
		case PRECISE_SHOT:
			break;
		case SKULL_SMASH:
			break;
		case SPIRITUAL_SEED:
			break;
		case STAB:
			break;
		default:
			break;
		
		}
		return "@owner fumou @target na porrada.";
	}

	@Override
	public String getDamageMessage() {
		switch(this) {
		case ACCURATE_ATTACK:
			break;
		case BLOODTHIRSTY_ATTACK:
			break;
		case BLOODY_EATER:
			break;
		case CONTROL_ATTACK:
			break;
		case CURSED_BLADE:
			break;
		case DISARMED_PUNCH:
			return "@owner deu um soquinho em @target e causou @damage de dano.";
		case DISEASE_WAVE:
			break;
		case DRUNK_FIST:
			break;
		case ELETRIC_CHARGE:
			break;
		case FAST_ARROW:
			break;
		case FIREBALL:
			break;
		case FURIOUS_BLADES:
			break;
		case HALF_MOON_CUT:
			break;
		case ILUMINATED_FIELD:
			break;
		case PRECISE_SHOT:
			break;
		case SKULL_SMASH:
			break;
		case SPIRITUAL_SEED:
			break;
		case STAB:
			break;
		default:
			break;
		}
		return "@owner deu um porradão em @target e causou @damage de dano.";
	}

	@Override
	public String getSuicideMessage() {
		switch(this) {
		case ACCURATE_ATTACK:
			break;
		case BLOODTHIRSTY_ATTACK:
			break;
		case BLOODY_EATER:
			break;
		case CONTROL_ATTACK:
			break;
		case CURSED_BLADE:
			break;
		case DISARMED_PUNCH:
			break;
		case DISEASE_WAVE:
			break;
		case DRUNK_FIST:
			break;
		case ELETRIC_CHARGE:
			break;
		case FAST_ARROW:
			break;
		case FIREBALL:
			break;
		case FURIOUS_BLADES:
			break;
		case HALF_MOON_CUT:
			break;
		case ILUMINATED_FIELD:
			break;
		case PRECISE_SHOT:
			break;
		case SKULL_SMASH:
			break;
		case SPIRITUAL_SEED:
			break;
		case STAB:
			break;
		default:
			break;
		}
		return "@owner se matou, não sei como.";
	}

	@Override
	public String getHealMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
