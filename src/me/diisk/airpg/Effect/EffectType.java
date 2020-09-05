package me.diisk.airpg.Effect;

import me.diisk.airpg.DamageSource;
import me.diisk.airpg.Entity;

public enum EffectType implements DamageSource{

	
	//RAÇAS
	UNDEAD(0,"Morto-Vivo","Ao morrer possui 100% de chance de renascer no mesmo turno, a chance é reduzida pela metade em cada morte."),
	LUCKY(1,"Sortudo","Possui mais 25% de chance em todos os testes."),
	BLOODSUCKER(2,"Chupador de Sangue","Todo roubo de vida é dobrado."),
	DRAGON_CLAW(3,"Garra de Dragão","Seus ataques causam dano adicional equivalente a 2% da vida máxima do alvo."),
	ELETRIC_ARMOR(4,"Armadura Eletrica","Possui 25% de causar um dano de contra-ataque equivalente a 50% da sua defesa."),
	HEALER(5,"Curandeiro","Todas as habilidades de cura são 100% mais efetivas."),
	CORRUPTION(6,"Corrupção","Todas as habilidades de ataque causam 20% mais dano."),
	SACRIFICE(7,"Sacrificio","Seus ataques possuem 20% de chance de consumir 5% da propria vida máxima para causar dano dobrado."),
	DIVINE_DANCER(8,"Dançarino Divino","Sua evasão é dobrada."),
	ELDER(9,"Ancião","Sua vida máxima é dobrada."),
	LIZARD_BLOOD(10,"Sangue de Lagarto","Sua regeneração de vida é dobrada."),
	PREDATOR(11,"Predador","Seus ataques críticos causam 50% mais dano."),
	DARK_POWER(12,"Poder Sombrio","Aumenta toda cura recebida em 50% além de ignorar as defesas do inimigo."),
	BOUNCY_HEAL(13,"Cura Saltitante","Suas curas possuem 80% de chance de saltar para um alvo adicional diferente, a chance reduz pela metade em cada salto."),
	ENERGY_STEALER(14,"Ladrão de Energia","Seus ataques absorvem 10% da energia atual do alvo, e a transforma em um escudo até o inicio do seu proximo turno."),
	
	
	//CLASSES
	ACCURATE_SHOT(15,"Tiro Certeiro","Seu acerto é dobrado."),
	FURY(16,"Fúria","Seus ataques possuem 20% de chance de absorver 5% da vida máxima para causar como dano adicional."),
	KNIGHT_SPIRIT(17,"Espírito de Cavaleiro","Sua defesa é dobrada."),
	TRAINED_KILLER(18,"Assassino Treinado","Sua chance de acerto crítico é dobrada."),
	THE_RELENTLESS(19,"O Implacável","Todo dano causado é aumentado em 30%."),
	SACRED_PROTECTION(20,"Proteção Sagrada","Suas curas aplicam um escudo adicional até o inicio do seu proximo turno, que absorve dano de até 20% do seu poder de ataque no proximo ataque recebido."),
	NATURAL_POLINATION(21,"Polinização Natural","Suas curas recebem um adicional de 100% aplicado durante as proximas 3 rodadas."),
	LUCKY_HANDS(22,"Mãos da Sorte","Seus ataques causam efeitos aleatorios a cada hit."),
	BUDHA_CONCENTRATION(23,"Concentração de Budha","Cada acerto aumenta em 10% o poder de ataque durante a rodada, e ao evadir de ataques possui 50% de chance de gerar um contra ataque."),
	FAITH_ON_CONTROL(24,"Fé no Controle","Seus ataques possuem 20% de chance de curar 15% da vida máxima do alvo mais injuriado."),
	THE_EXECUTIONER(25,"O carrasco","Seus ataques possuem 20% de chance de executar um alvo com 20% ou menos de vida."),
	BLOOD_STEALER(26,"Ladrão de Sangue","Possui 10% de roubo de vida."),
	
	//(,"",""),
	;
	
	private int id;
	private String name;
	private String description;
	private boolean passive = false;
	
	private EffectType(int id, String name, String description) {
		this.id=id;
		this.name=name;
		this.description=description;
		passive = true;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDeathMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDamageMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSuicideMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
