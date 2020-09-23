package me.diisk.airpg.Entity;

import static me.diisk.airpg.Attributes.*;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Effect.EffectType;
import me.diisk.airpg.Item.ItemCategory;
import me.diisk.airpg.Item.ItemGroup;
import me.diisk.airpg.Item.ItemType;

public enum Classe {

	ARCHER(0,"Arqueiro","Arqueiros tendem a utilizar arco e flecha como arma principal, possuem um dano absurdo e um acerto elevado.",ItemCategory.LIGHT_WEAPON,EffectType.ACCURATE_SHOT),
	BARBARIAN(1,"Bárbaro","Bárbaros tendem a utilizar machados duplos ou um martelo gigante como arma principal, possuem uma vida absurda.",ItemCategory.HEAVY_WEAPON,EffectType.FURY),
	KNIGHT(2,"Cavaleiro","Cavaleiros tendem a utilizar uma espada longa ou uma lança com escudo como arma principal, possuem um equilibrio entre defesa e ataque.",ItemCategory.HEAVY_WEAPON,EffectType.KNIGHT_SPIRIT), 
	ASSASSIN(3,"Assassino","Assassinos tendem a utilizar adagas como arma principal, possuem uma grande chance de acerto crítico, além de causar um dano elevado.",ItemCategory.LIGHT_WEAPON,EffectType.TRAINED_KILLER),
	SORCERER(4,"Feiticeiro","Feiticeiros tendem a utilizar um cajado e um grimorio, possuem um grande poder de ataque.",ItemCategory.MAGIC_WEAPON,EffectType.THE_RELENTLESS),
	PRIEST(5,"Sacerdote","Sacerdotes tendem a utilizar um crucifixo e um grimorio, possuem um dano equilibrado e um forte poder de cura.",ItemCategory.MAGIC_WEAPON,EffectType.SACRED_PROTECTION),
	DRUID(6,"Druida","Druidas tendem a utilizar uma essências da natureza, possuem uma defesa equilibrada e um forte poder de cura.",ItemCategory.MAGIC_WEAPON,EffectType.NATURAL_POLINATION),
	WARLOCK(7,"Bruxo","Bruxos tendem a utilizar uma espada mágica, possuem uma defesa equilibrada e uma grande quantidade de energia.",ItemCategory.MAGIC_WEAPON,EffectType.LUCKY_HANDS),
	MONK(8,"Monge","Monges tendem a utilizar um bastão ou uma caneca de cerveja, possuem uma baixa defesa e uma enorme evasão.",ItemCategory.LIGHT_WEAPON,EffectType.BUDHA_CONCENTRATION),
	PALADIN(9,"Paladino","Paladinos tendem a utilizar uma maça com escudo, possuem um equilibrio entre ataque e defesa, e uma habilidade de cura.",ItemCategory.HEAVY_WEAPON,EffectType.FAITH_ON_CONTROL),
	NINJA(10,"Ninja","Ninjas tendem a utilizar espada curta, possuem um forte dano e uma habilidade de execução.",ItemCategory.HEAVY_WEAPON,EffectType.THE_EXECUTIONER),
	NECROMANCER(11,"Necromante","Necromantes tendem a utilizar foices ou orbes demoniacos, possuem um roubo de vida absurdo.",ItemCategory.MAGIC_WEAPON,EffectType.BLOOD_STEALER),
	;
	
	private int id;
	private String name;
	private String description;
	private ItemCategory weaponCategory;
	private EffectType passive;
	
	private Classe(int id, String name, String description,ItemCategory weaponCategory, EffectType passive) {
		this.id=id;
		this.name=name;
		this.description=description;
		this.weaponCategory=weaponCategory;
		this.passive = passive;
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ItemGroup[] getWeaponGroups() {
		switch(this) {
		case ARCHER:
			return new ItemGroup[] {ItemGroup.LONG_BOW,ItemGroup.SHORT_BOW};
		case ASSASSIN:
			return new ItemGroup[] {ItemGroup.DAGGERS};
		case BARBARIAN:
			return new ItemGroup[] {ItemGroup.DUAL_AXE, ItemGroup.GIANT_HAMMER};
		case DRUID:
			return new ItemGroup[] {ItemGroup.NATURE_ESSENCE};
		case KNIGHT:
			return new ItemGroup[] {ItemGroup.LONG_SWORD};
		case MONK:
			return new ItemGroup[] {ItemGroup.STICK, ItemGroup.BEER_MUG};
		case NECROMANCER:
			return new ItemGroup[] {ItemGroup.DEMONIAC_ORB,ItemGroup.DEMONIAC_SCYTHE};
		case NINJA:
			return new ItemGroup[] {ItemGroup.SHORT_SWORD};
		case PALADIN:
			return new ItemGroup[] {ItemGroup.MACE};
		case PRIEST:
			return new ItemGroup[] {ItemGroup.CRUCIFIX};
		case SORCERER:
			return new ItemGroup[] {ItemGroup.STAFF};
		case WARLOCK:
			return new ItemGroup[] {ItemGroup.MAGIC_SWORD};
		
		}
		return new ItemGroup[0];
	}
	
	public ItemCategory getCategory() {
		switch(this) {
		case ARCHER:
		case ASSASSIN:
		case MONK:
			return ItemCategory.LIGHT_WEAPON;
		case BARBARIAN:
		case KNIGHT:
		case NINJA:
		case PALADIN:
			return ItemCategory.HEAVY_WEAPON;
		case DRUID:
		case NECROMANCER:
		case PRIEST:
		case SORCERER:
		case WARLOCK:
			return ItemCategory.MAGIC_WEAPON;
		}
		return null;
	}
	
	public ItemCategory getArmorCategory() {
		switch(this) {
		case ARCHER:
			//return new ItemGroup[] {ItemGroup.LONG_BOW,ItemGroup.SHORT_BOW};
		case ASSASSIN:
			//return new ItemGroup[] {ItemGroup.DAGGERS};
		case BARBARIAN:
			//return new ItemGroup[] {ItemGroup.DUAL_AXE, ItemGroup.GIANT_HAMMER};
		case DRUID:
			//return new ItemGroup[] {ItemGroup.NATURE_ESSENCE};
		case KNIGHT:
			//return new ItemGroup[] {ItemGroup.LONG_SWORD};
		case MONK:
			//return new ItemGroup[] {ItemGroup.STICK, ItemGroup.BEER_MUG};
		case NECROMANCER:
			//return new ItemGroup[] {ItemGroup.DEMONIAC_ORB,ItemGroup.DEMONIAC_SCYTHE};
		case NINJA:
			//return new ItemGroup[] {ItemGroup.SHORT_SWORD};
		case PALADIN:
			//return new ItemGroup[] {ItemGroup.MACE};
		case PRIEST:
			//return new ItemGroup[] {ItemGroup.CRUCIFIX};
		case SORCERER:
			//return new ItemGroup[] {ItemGroup.STAFF};
		case WARLOCK:
			//return new ItemGroup[] {ItemGroup.MAGIC_SWORD};
		
		}
		return null;
	}
	
	public ItemCategory getAccessoryCategory() {
		switch(this) {
		case ARCHER:
			//return new ItemGroup[] {ItemGroup.LONG_BOW,ItemGroup.SHORT_BOW};
		case ASSASSIN:
			//return new ItemGroup[] {ItemGroup.DAGGERS};
		case BARBARIAN:
			//return new ItemGroup[] {ItemGroup.DUAL_AXE, ItemGroup.GIANT_HAMMER};
		case DRUID:
			//return new ItemGroup[] {ItemGroup.NATURE_ESSENCE};
		case KNIGHT:
			//return new ItemGroup[] {ItemGroup.LONG_SWORD};
		case MONK:
			//return new ItemGroup[] {ItemGroup.STICK, ItemGroup.BEER_MUG};
		case NECROMANCER:
			//return new ItemGroup[] {ItemGroup.DEMONIAC_ORB,ItemGroup.DEMONIAC_SCYTHE};
		case NINJA:
			//return new ItemGroup[] {ItemGroup.SHORT_SWORD};
		case PALADIN:
			//return new ItemGroup[] {ItemGroup.MACE};
		case PRIEST:
			//return new ItemGroup[] {ItemGroup.CRUCIFIX};
		case SORCERER:
			//return new ItemGroup[] {ItemGroup.STAFF};
		case WARLOCK:
			//return new ItemGroup[] {ItemGroup.MAGIC_SWORD};
		
		}
		return null;
	}
	
	public ItemCategory getWeaponCategory() {
		return weaponCategory;
	}
	
	public EffectType getPassive() {
		return passive;
	}
	
	public Attributes getMods() {
		Attributes r = new Attributes();
		r.set(MAX_HEALTH, 100);
		r.set(ATTACK_POWER, 50);
		switch(this) {
		case ARCHER:
			r.set(EVASION, 25);
			r.set(ATTACK_POWER, 100);
			break;
		case ASSASSIN:
			r.set(ATTACK_POWER, 80);
			r.set(CRITICAL_CHANCE, 20);
			break;
		case BARBARIAN:
			r.set(MAX_HEALTH, 150);
			r.set(ATTACK_POWER, 65);
			r.set(CRITICAL_CHANCE, 30);
			r.set(HEALTH_REGENERATION, 5);
			break;
		case DRUID:
			r.set(ATTACK_POWER, 65);
			r.set(HEALTH_REGENERATION, 2);
			r.set(ENERGY_REGENERATION, 4);
			r.set(MAX_ENERGY, 25);
			r.set(MAX_HEALTH, 125);
			break;
		case KNIGHT:
			r.set(DEFENSE, 50);
			r.set(CRITICAL_CHANCE, 20);
			r.set(ATTACK_POWER, 80);
			r.set(MAX_HEALTH, 125);
			break;
		case MONK:
			r.set(EVASION, 50);
			r.set(DEFENSE, 25);
			r.set(ACCURACY, 50);
			break;
		case NECROMANCER:
			r.set(MAX_HEALTH, 150);
			r.set(ATTACK_POWER, 80);
			r.set(ENERGY_REGENERATION, 3);
			break;
		case NINJA:
			r.set(ATTACK_POWER, 100);
			r.set(EVASION, 20);
			break;
		case PALADIN:
			r.set(MAX_HEALTH, 125);
			r.set(DEFENSE, 25);
			r.set(MAX_ENERGY, 25);
			r.set(CRITICAL_CHANCE, 50);
			r.set(ENERGY_REGENERATION, 3);
			break;
		case PRIEST:
			r.set(ATTACK_POWER, 80);
			r.set(MAX_ENERGY, 50);
			r.set(ENERGY_REGENERATION, 6);
			break;
		case SORCERER:
			r.set(ATTACK_POWER, 100);
			r.set(ENERGY_REGENERATION, 3);
			break;
		case WARLOCK:
			r.set(MAX_HEALTH, 125);
			r.set(MAX_ENERGY, 50);
			r.set(ENERGY_REGENERATION, 10);
			break;
		}
		
		for(int i=0;i<LENGTH;i++){
			double v = r.get(i);
			if(v>0) {
				r.set(i, v/(Entity.MAX_LEVEL-1));
			}
		}
		return r;
	}
	
}
