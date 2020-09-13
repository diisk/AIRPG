package me.diisk.airpg;

import java.util.Random;

public enum Skill implements DamageSource, HealSource{
	
	DISARMED_PUNCH(0,"Soco Desarmado",10,"Causa 10 dano ao alvo.",100),
	
	PRECISE_SHOT(1,"Tiro Preciso",0.20,.25,"Causa dano bruto baseado no poder de ataque.",100),
	
	FAST_ARROW(2,"Flecha Rápida",0.06,0.08,"Causa dano baseado no poder de ataque, podendo atacar até 3 vezes por rodada.",33),
	
	BLOODTHIRSTY_ATTACK(3,"Ataque Sanguinário",0.07,0.13,"Causa dano baseado no poder de ataque até 2 vezes por rodada, e cada ataque possui 20% de chance de causar sangramento por 3 rodadas.",50,new double[] {
			0.2,//CHANCE
			3,//RODADAS
			0.05//DANO POR RODADA(VIDA MAXIMA)
	}),
	
	SKULL_SMASH(4,"Esmaga Crânio",0.13,0.15,"Causa dano baseado no poder de ataque, e possui 20% de chance de desnortear o alvo até o inicio do seu proximo turno.",100, new double[] {
			0.2//CHANCE
	}),
	
	BLOODY_EATER(5,"Devoradora Sangrenta",0.15,0.20,"Causa dano bruto baseado no poder de ataque.",100),
	
	STAB(6,"Estocada",0.12,0.15,"Causa dano baseado no poder de ataque ignorando bloqueios e defesas.",100),
	
	FURIOUS_BLADES(7,"Lâminas Furiosas",0.03,0.04,"Causa dano baseado no poder de ataque, podendo atacara até 5 vezes por rodada.",20),
	
	FIREBALL(8,"Bola de Fogo",0.15,0.25,"Causa dano baseado no poder de ataque, consome 100 de energia para causar dano a todos os inimigos.",100,new double[] {
			100//ENERGIA PARA USAR
	}),
	
	ILUMINATED_FIELD(9,"Campo Iluminado",0.15,0.20,"Causa dano baseado no poder de ataque, consome energia para curar todos os aliados em 5% da vida máxima.",100,new double[] {
			10,//ENERGIA PARA USAR
			0.05//VALOR DA CURA BASEADO NA VIDA MAXIMA DO ALVO
	}),//FAZER
	
	SPIRITUAL_SEED(10,"Semente Espiritual",0.15,0.20,"Causa dano baseado no poder de ataque, consome energia para curar 10% da vida perdida do alvo mais injuriado.",100, new double[] {
			25,//ENERGIA PARA USAR
			0.1//VALOR DA CURA BASEADO NA VIDA PERDIDA DO ALVO
	}),//FAZER
	
	ELETRIC_CHARGE(11,"Carga Elétrica",0.05,0.07,"Pode atacar enquanto possuir energia.",1,new double[] {
			7//ENERGIA PARA USAR, 7*(4-LVL DA ARMA) VER AINDA O QUE VAI FAZER
	}),//FAZER
	
	DRUNK_FIST(12,"Punho Bêbado",0.02,0.03,"Causa dano baseado no poder de ataque, cada ataque possui 80% de chance de não consumir pontos de ação.",100, new double[] {
			0.8//CHANCE DE NAO CONSUMIR PONTOS
	}),//FAZER
	
	ACCURATE_ATTACK(13,"Ataque Certeiro",0.12,0.15,"Causa dano baseado no poder de ataque, vida perdida e vida maxima.",100, new double[] {
			0.1,//VIDA PERDIDA
			0.1//VIDA MAXIMA
	}),//FAZER
	
	CONTROL_ATTACK(14,"Ataque Controlado",0.12,0.15,"Causa dano baseado no poder de ataque, possui 50% de chance de dar um ataque extra na rodada.",100, new double[] {
			0.5//CHANCE DE DAR ATAQUE EXTRA NA RODADA
	}),//FAZER
	
	CURSED_BLADE(15,"Lâmina Amaldiçoada",0.15,0.20,"Causa dano baseado no poder de ataque, caso execute o alvo pode atacar novamente.",100),//FAZER
	
	HALF_MOON_CUT(16,"Corte Meia-Lua",0.18,0.20,"Causa dano baseado no poder de ataque, na propria vida perdida e na vida atual do alvo.",100, new double[] {
			0.66,//PERCENTUAL DO PERCENTUAL DE VIDA PERDIDA
			0.2,//VALOR MINIMO DO PERCENTUAL DA VIDA ATUAL DO ALVO
			0,5//PERCENTUAL DO PERCENTUAL DA VIDA ATUAL DO ALVO COM O VALOR MINIMO SUBTRAIDO
	}),//FAZER
	
	DISEASE_WAVE(17,"Onda de Doenças",0.18,0.20,"Causa dano baseado no poder de ataque, consome 100% de mana para causar uma doença a todos os inimigos por 3 rodadas.",100,new double[] {
			0.25//PERCENTUAL DA MANA MAXIMA QUE VAI SER CAUSADA COM DANO DURANTE 3 RODADAS
	}),//FAZER
	
	//(,"",,,"",100),
	;
	
	private Skill(int id, String name, double minDamage, double maxDamage, String description, int actionCost) {
		config(id, name, minDamage, maxDamage, description, actionCost, 0, new double[0]);
	}
	
	private Skill(int id, String name, double minDamage, double maxDamage, String description, int actionCost, double[] values) {
		config(id, name, minDamage, maxDamage, description, actionCost, 0, values);
	}
	
	private Skill(int id, String name, int baseDamage, String description, int actionCost) {
		config(id, name, 0, 0, description, actionCost, baseDamage, new double[0]);
	}
	
	private void config(int id, String name, double minDamage, double maxDamage, String description, int actionCost, int baseDamage, double[] values) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.minDamage=minDamage;
		this.maxDamage=maxDamage;
		this.actionCost=actionCost;
		this.baseDamage = baseDamage;
		this.values=values;
	}
	
	private String name;
	private String description;
	private double minDamage;
	private double maxDamage;
	private double baseDamage;
	private int energyCost;
	private int actionCost;
	private int id;
	private double[] values;
	
	public static final int USESKILL_NO_ENERGY = 0;
	public static final int USESKILL_NO_ACTIONPOINTS = 1;
	public static final int USESKILL_SUCCESS = 2;
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double[] getValues() {
		return values;
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
	
	public String getUsageMessage(Entity owner, Entity target) {
		switch(this) {
		case FIREBALL:
			return owner.getName()+" usou bola de fogo gigante.";
		case ILUMINATED_FIELD:
			return owner.getName()+" usou "+getName()+".";
		}
		return name()+" SEM VALOR USAGEMESSAGE";
	}

	@Override
	public double getStartDamage(Entity owner, Entity target) {
		double r = baseDamage;
		Random random = new Random();
		double variation = 1000;
		r+=owner.getAttackPower()*((variation*minDamage)+(random.nextInt((int)(variation*(maxDamage-minDamage)+1))))/variation;
		switch(this) {
		case ACCURATE_ATTACK:
			r+=(owner.getLostHealth()*values[0])+(owner.getMaxHealth()*values[1]);
			break;
		case HALF_MOON_CUT:
			double lostHealthPercent = 1-owner.getHealthPercent();
			double targetActualHealthPercent = target.getHealthPercent();
			if(targetActualHealthPercent<values[1]) {
				targetActualHealthPercent=0;
			}else {
				targetActualHealthPercent-=values[1];
			}
			r*=1+(lostHealthPercent*values[0])+(targetActualHealthPercent*values[2]);
			break;
		}
		return r;
	}

	@Override
	public String getDeathMessage(Entity killer, Entity target) {
		switch(this) {
		case ACCURATE_ATTACK:
			break;
		case BLOODTHIRSTY_ATTACK:
			return killer.getName()+" fez picadinho de "+target.getName()+".";
		case BLOODY_EATER:
			break;
		case CONTROL_ATTACK:
			break;
		case CURSED_BLADE:
			break;
		case DISARMED_PUNCH:
			return killer.getName()+" desintegrou "+target.getName()+" com um tapão.";
		case DISEASE_WAVE:
			break;
		case DRUNK_FIST:
			break;
		case ELETRIC_CHARGE:
			break;
		case FAST_ARROW:
			break;
		case FIREBALL:
			return killer.getName()+" explodiu "+target.getName()+" com seu bolão de fogo.";
		case FURIOUS_BLADES:
			break;
		case HALF_MOON_CUT:
			break;
		case ILUMINATED_FIELD:
			break;
		case PRECISE_SHOT:
			break;
		case SKULL_SMASH:
			return killer.getName()+" esmagou "+target.getName()+" com seu martelão.";
		case SPIRITUAL_SEED:
			break;
		case STAB:
			break;
		default:
			break;
		
		}
		return killer.getName()+" fumou "+target.getName()+" na porrada.";
	}

	@Override
	public String getDamageMessage(Entity owner, Entity target, Damage damage) {
		int value = (int) damage.getFinalDamage();
		switch(this) {
		case ACCURATE_ATTACK:
			return owner.getLogName()+" deu uma paulada em "+target.getLogName()+" e causou "+value+" de dano.";
		case BLOODTHIRSTY_ATTACK:
			return owner.getLogName()+" cortou "+target.getLogName()+" e causou "+value+" de dano.";
		case BLOODY_EATER:
			break;
		case CONTROL_ATTACK:
			break;
		case CURSED_BLADE:
			break;
		case DISARMED_PUNCH:
			return owner.getLogName()+" deu um soquinho em "+target.getLogName()+" e causou "+value+" de dano.";
		case DISEASE_WAVE:
			break;
		case DRUNK_FIST:
			break;
		case ELETRIC_CHARGE:
			break;
		case FAST_ARROW:
			break;
		case FIREBALL:
			return owner.getLogName()+" brincou de queimada com "+target.getLogName()+" e causou "+value+" de dano.";
		case FURIOUS_BLADES:
			break;
		case HALF_MOON_CUT:
			return owner.getLogName()+" passou a lambida em "+target.getLogName()+" e causou "+value+" de dano.";
		case ILUMINATED_FIELD:
			break;
		case PRECISE_SHOT:
			break;
		case SKULL_SMASH:
			return owner.getLogName()+" martelou "+target.getLogName()+" e causou "+value+" de dano.";
		case SPIRITUAL_SEED:
			break;
		case STAB:
			break;
		default:
			break;
		}
		return owner.getLogName()+" deu um porradão em "+target.getLogName()+" e causou "+value+" de dano.";
	}

	@Override
	public String getSuicideMessage(Entity owner) {
		return owner.getName()+" se matou com "+name()+", não sei como.";
	}

	@Override
	public String getHealMessage(Entity owner, Entity target, int value) {
		switch(this) {
		case ILUMINATED_FIELD:
			return owner.getLogName()+" iluminou "+target.getLogName()+" o curando em "+value+" de vida.";
		}
		return name()+" NAO DEFINIDO HEALMESSAGE";
	}

	@Override
	public double getStartHeal(Entity owner, Entity target) {
		switch(this) {
		case ILUMINATED_FIELD:
			return target.getMaxHealth()*values[1];
		}
		return 0;
	}

	@Override
	public boolean canBeCritical() {
		switch(this) {
		case ACCURATE_ATTACK:
		case BLOODTHIRSTY_ATTACK:
		case BLOODY_EATER:
		case CONTROL_ATTACK:
		case CURSED_BLADE:
		case DISARMED_PUNCH:
		case DRUNK_FIST:
		case FAST_ARROW:
		case FURIOUS_BLADES:
		case PRECISE_SHOT:
		case SKULL_SMASH:
		case STAB:
			return true;
		}
		return false;
	}

	@Override
	public boolean canBeEvaded() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean ignoreDefense() {
		switch(this) {
		case STAB:
			return true;
		}
		return false;
	}

	@Override
	public boolean isSingleTargetHeal() {
		switch(this) {
		case ILUMINATED_FIELD:
			return false;
		}
		return true;
	}
	
}
