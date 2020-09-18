package me.diisk.airpg;

import java.util.Random;

import me.diisk.airpg.Damage.Damage;
import me.diisk.airpg.Damage.DamageSource;
import me.diisk.airpg.Entity.Entity;

public enum Skill implements DamageSource, HealSource{
	
	DISARMED_PUNCH(0,"Soco Desarmado",10,"Causa 10 dano ao alvo.",100),
	
	PRECISE_SHOT(1,"Tiro Preciso",0.20,.25,"Causa dano bruto baseado no poder de ataque.",100),
	
	FAST_ARROW(2,"Flecha R�pida",0.06,0.08,"Causa dano baseado no poder de ataque, podendo atacar at� 3 vezes por rodada.",33),
	
	BLOODTHIRSTY_ATTACK(3,"Ataque Sanguin�rio",0.07,0.13,"Causa dano baseado no poder de ataque at� 2 vezes por rodada, e cada ataque possui 20% de chance de causar sangramento por 3 rodadas.",50,new double[] {
			0.2,//CHANCE
			3,//RODADAS
			0.05//DANO POR RODADA(VIDA MAXIMA)
	}),
	
	SKULL_SMASH(4,"Esmaga Cr�nio",0.13,0.15,"Causa dano baseado no poder de ataque, e possui 20% de chance de desnortear o alvo at� o inicio do seu proximo turno.",100, new double[] {
			0.2//CHANCE
	}),
	
	BLOODY_EATER(5,"Devoradora Sangrenta",0.15,0.20,"Causa dano bruto baseado no poder de ataque.",100),
	
	STAB(6,"Estocada",0.12,0.15,"Causa dano baseado no poder de ataque ignorando bloqueios e defesas.",100),
	
	FURIOUS_BLADES(7,"L�minas Furiosas",0.03,0.04,"Causa dano baseado no poder de ataque, podendo atacara at� 5 vezes por rodada.",20),
	
	FIREBALL(8,"Bola de Fogo",0.15,0.25,"Causa dano baseado no poder de ataque, consome 100 de energia para causar dano a todos os inimigos.",100,new double[] {
			100//ENERGIA PARA USAR
	}),
	
	ILUMINATED_FIELD(9,"Campo Iluminado",0.15,0.20,"Causa dano baseado no poder de ataque, consome energia para curar todos os aliados em 5% da vida m�xima.",100,new double[] {
			30,//ENERGIA PARA USAR
			0.05//VALOR DA CURA BASEADO NA VIDA MAXIMA DO ALVO
	}),
	
	SPIRITUAL_SEED(10,"Semente Espiritual",0.15,0.20,"Causa dano baseado no poder de ataque, consome energia para curar 10% da vida perdida do alvo mais injuriado.",100, new double[] {
			20,//ENERGIA PARA USAR
			0.15//VALOR DA CURA BASEADO NA VIDA PERDIDA DO ALVO
	}),
	
	ELETRIC_CHARGE(11,"Carga El�trica",0.05,0.07,"Pode atacar enquanto possuir energia.",1,new double[] {
			7//ENERGIA PARA USAR, 7*(4-LVL DA ARMA) VER AINDA O QUE VAI FAZER
	}),
	
	DRUNK_FIST(12,"Punho B�bado",0.02,0.03,"Causa dano baseado no poder de ataque, cada ataque possui 80% de chance de n�o consumir pontos de a��o.",100, new double[] {
			0.8//CHANCE DE NAO CONSUMIR PONTOS
	}),
	
	ACCURATE_ATTACK(13,"Ataque Certeiro",0.12,0.15,"Causa dano baseado no poder de ataque, vida perdida e vida maxima.",100, new double[] {
			0.1,//VIDA PERDIDA
			0.1//VIDA MAXIMA
	}),
	
	CONTROL_ATTACK(14,"Ataque Controlado",0.12,0.15,"Causa dano baseado no poder de ataque, possui 50% de chance de dar um ataque extra na rodada.",99, new double[] {
			0.5,//CHANCE DE DAR ATAQUE EXTRA NA RODADA
			98//ENERGIA A REGENERAR CASO A CHANCE ACIMA FOR SUCESSO
	}),
	
	CURSED_BLADE(15,"L�mina Amaldi�oada",0.15,0.20,"Causa dano baseado no poder de ataque, caso execute o alvo pode atacar novamente.",100),//FAZER
	
	HALF_MOON_CUT(16,"Corte Meia-Lua",0.18,0.20,"Causa dano baseado no poder de ataque, na propria vida perdida e na vida atual do alvo.",100, new double[] {
			0.66,//PERCENTUAL DO PERCENTUAL DE VIDA PERDIDA
			0.2,//VALOR MINIMO DO PERCENTUAL DA VIDA ATUAL DO ALVO
			0,5//PERCENTUAL DO PERCENTUAL DA VIDA ATUAL DO ALVO COM O VALOR MINIMO SUBTRAIDO
	}),
	
	DISEASE_WAVE(17,"Onda de Doen�as",0.18,0.20,"Causa dano baseado no poder de ataque, consome 100% de energia para causar uma doen�a a todos os inimigos por 3 rodadas.",100,new double[] {
			3,//NUMERO DE RODADAS
			0.25//PERCENTUAL DA ENERGIA MAXIMA QUE VAI SER CAUSADA COMO DANO DURANTE 3 RODADAS
	}),
	
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
	
	public int getActionCost() {
		return actionCost;
	}
	
	public String getUsageMessage(Entity owner, Entity target) {
		switch(this) {
		case FIREBALL:
			return owner.getName()+" usou bola de fogo gigante.";
		}
		return owner.getName()+" usou "+getName()+".";
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
			return killer.getName()+" espancou "+target.getName()+" a pauladas.";
		case BLOODTHIRSTY_ATTACK:
			return killer.getName()+" fez picadinho de "+target.getName()+".";
		case BLOODY_EATER:
			return killer.getName()+" partiu "+target.getName()+" em peda�os.";
		case CONTROL_ATTACK:
			return killer.getName()+" deixou "+target.getName()+" todo furado.";
		case CURSED_BLADE:
			return killer.getName()+" executou "+target.getName()+" a sangue frio.";
		case DISARMED_PUNCH:
			return killer.getName()+" desintegrou "+target.getName()+" com um tap�o.";
		case DISEASE_WAVE:
			return killer.getName()+" decomp�s "+target.getName()+" com as bolas do demonio.";
		case DRUNK_FIST:
			return killer.getName()+" espancou "+target.getName()+" com seus punhos bebados.";
		case ELETRIC_CHARGE:
			return killer.getName()+" levou "+target.getName()+" pra disney.";
		case FAST_ARROW:
			return killer.getName()+" perfurou "+target.getName()+" com suas flechas.";
		case FIREBALL:
			return killer.getName()+" explodiu "+target.getName()+" com seu bol�o de fogo.";
		case FURIOUS_BLADES:
			return killer.getName()+" comeu p�o com "+target.getName()+".";
		case HALF_MOON_CUT:
			return killer.getName()+" dividiu "+target.getName()+" com um corte meia-lua.";
		case ILUMINATED_FIELD:
			return killer.getName()+" exorcisou "+target.getName()+".";
		case PRECISE_SHOT:
			return killer.getName()+" acertou uma flecha no cora��o de "+target.getName()+".";
		case SKULL_SMASH:
			return killer.getName()+" esmagou "+target.getName()+" com seu martel�o.";
		case SPIRITUAL_SEED:
			return killer.getName()+" transformou "+target.getName()+" em adubo.";
		case STAB:
			return killer.getName()+" furou "+target.getName()+" com sua estocada.";
		}
		return killer.getName()+" fumou "+target.getName()+" na porrada.";
	}

	@Override
	public String getDamageMessage(Entity owner, Entity target, Damage damage) {
		int value = (int) damage.getFinalDamage();
		String r = owner.getLogName()+" deu um porrad�o em "+target.getLogName()+" e causou "+value+" de dano.";
		switch(this) {
		case ACCURATE_ATTACK:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seu porrete.";
		case BLOODTHIRSTY_ATTACK:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seus farejadores de sangue.";
		case BLOODY_EATER:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com sua devoradora sangrenta.";
		case CONTROL_ATTACK:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com sua bolinha da miley cyrus.";
		case CURSED_BLADE:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seus 15 centimetros.";
		case DISEASE_WAVE:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com as bolas do demonio.";
		case DRUNK_FIST:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com sua cerveja geladinha (ou n�o).";
		case ELETRIC_CHARGE:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seu espad�o de mel.";
		case FAST_ARROW:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seu arquinho.";
		case FURIOUS_BLADES:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com suas facas rasga-lixo.";
		case HALF_MOON_CUT:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seu corta mato.";
		case PRECISE_SHOT:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seu arco kid bengala.";
		case SKULL_SMASH:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com seu martel�o.";
		case STAB:
			return owner.getLogName()+" causou "+value+" de dano a "+target.getLogName()+" com a sua estocada.";
		case FIREBALL:
			return owner.getLogName()+" brincou de queimada com "+target.getLogName()+" e causou "+value+" de dano.";
		case ILUMINATED_FIELD:
			return owner.getLogName()+" orou por "+target.getLogName()+" causando "+value+" de dano.";
		case SPIRITUAL_SEED:
			return owner.getLogName()+" plantou uma semente em "+target.getLogName()+" causando "+value+" de dano.";
		}
		if(damage.isCritical()) {
			switch(this) {
			case ACCURATE_ATTACK:
				return owner.getLogName()+" deu uma paulada em "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case BLOODTHIRSTY_ATTACK:
				return owner.getLogName()+" cortou "+target.getLogName()+" com seu machado causando "+value+" de dano cr�tico.";
			case BLOODY_EATER:
				return owner.getLogName()+" usou sua dan�a sangrenta em "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case CONTROL_ATTACK:
				return owner.getLogName()+" usou sua bolinha de demoli��o em "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case CURSED_BLADE:
				return owner.getLogName()+" esfaqueou "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case DISARMED_PUNCH:
				return owner.getLogName()+" deu um soquinho em "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case DRUNK_FIST:
				return owner.getLogName()+" usou soco bebado em "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case FAST_ARROW:
				return owner.getLogName()+" acertou a flecha na orelha de "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case FURIOUS_BLADES:
				return owner.getLogName()+" mutilou "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case PRECISE_SHOT:
				return owner.getLogName()+" acertou o p� de "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case SKULL_SMASH:
				return owner.getLogName()+" martelou "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			case STAB:
				return owner.getLogName()+" perfurou "+target.getLogName()+" causando "+value+" de dano cr�tico.";
			}
		}
		return r;
	}

	@Override
	public String getSuicideMessage(Entity owner) {
		return owner.getName()+" se matou com "+name()+", n�o sei como.";
	}

	@Override
	public String getHealMessage(Entity owner, Entity target, int value) {
		switch(this) {
		case ILUMINATED_FIELD:
			if(owner.equals(target)) {
				return owner.getLogName()+" se iluminou se curando em "+value+" de vida.";
			}else {
				return owner.getLogName()+" iluminou "+target.getLogName()+" o curando em "+value+" de vida.";
			}
		case SPIRITUAL_SEED:
			if(owner.equals(target)) {
				return owner.getLogName()+" se regenerou em "+value+" de vida.";
			}else {
				return owner.getLogName()+" regenerou "+target.getLogName()+" o curando em "+value+" de vida.";
			}
		}
		return name()+" NAO DEFINIDO HEALMESSAGE";
	}

	@Override
	public double getStartHeal(Entity owner, Entity target) {
		switch(this) {
		case ILUMINATED_FIELD:
			return target.getMaxHealth()*values[1];
		case SPIRITUAL_SEED:
			return target.getLostHealth()*values[1];
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
	public boolean isExpansiveHeal() {
		switch(this) {
		case ILUMINATED_FIELD:
			return false;
		}
		return true;
	}
	
}
