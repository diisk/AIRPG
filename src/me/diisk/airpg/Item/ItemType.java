package me.diisk.airpg.Item;

import me.diisk.airpg.Attributes;
import me.diisk.airpg.Skill;
import me.diisk.airpg.CustomList.CustomList;
import me.diisk.airpg.CustomList.Filterable;
import me.diisk.airpg.CustomList.FilterableFilter;

public enum ItemType implements Filterable{

	LONG_SWORD_1(0,"Espada Longa de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.LONG_SWORD,ItemCategory.HEAVY_WEAPON),
	LONG_SWORD_2(1,"Espadão do Canadá",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.LONG_SWORD,ItemCategory.HEAVY_WEAPON),
	LONG_SWORD_3(2,"Espada Gigante de Aço",Slot.WEAPON,ItemGrade.RARE,ItemGroup.LONG_SWORD,ItemCategory.HEAVY_WEAPON),
	LONG_SWORD_4(3,"Espada Longa de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.LONG_SWORD,ItemCategory.HEAVY_WEAPON),

	DUAL_AXE_1(4,"Machados Duplos de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.DUAL_AXE,ItemCategory.HEAVY_WEAPON),
	DUAL_AXE_2(5,"Machados Duplos Corta Quase Tudo",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.DUAL_AXE,ItemCategory.HEAVY_WEAPON),
	DUAL_AXE_3(6,"Machados Duplos de Cristal Afiado",Slot.WEAPON,ItemGrade.RARE,ItemGroup.DUAL_AXE,ItemCategory.HEAVY_WEAPON),
	DUAL_AXE_4(7,"Machados Duplos de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.DUAL_AXE,ItemCategory.HEAVY_WEAPON),

	GIANT_HAMMER_1(8,"Martelo de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.GIANT_HAMMER,ItemCategory.HEAVY_WEAPON),
	GIANT_HAMMER_2(9,"Martelão do Canadá",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.GIANT_HAMMER,ItemCategory.HEAVY_WEAPON),
	GIANT_HAMMER_3(10,"Martelo do Gigante Acordado",Slot.WEAPON,ItemGrade.RARE,ItemGroup.GIANT_HAMMER,ItemCategory.HEAVY_WEAPON),
	GIANT_HAMMER_4(11,"Martelo de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.GIANT_HAMMER,ItemCategory.HEAVY_WEAPON),

	STAFF_1(12,"Cajado de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.STAFF,ItemCategory.MAGIC_WEAPON),
	STAFF_2(13,"Cajado de Moisés",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.STAFF,ItemCategory.MAGIC_WEAPON),
	STAFF_3(14,"Cajado de Magia Ancestral",Slot.WEAPON,ItemGrade.RARE,ItemGroup.STAFF,ItemCategory.MAGIC_WEAPON),
	STAFF_4(15,"Cajado de Árvore Negra",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.STAFF,ItemCategory.MAGIC_WEAPON),

	NATURE_ESSENCE_1(16,"Artefato Mágico de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.NATURE_ESSENCE,ItemCategory.MAGIC_WEAPON),
	NATURE_ESSENCE_2(17,"Artefato Mágico Desconhecido",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.NATURE_ESSENCE,ItemCategory.MAGIC_WEAPON),
	NATURE_ESSENCE_3(18,"Artefato Mágico Ancestral",Slot.WEAPON,ItemGrade.RARE,ItemGroup.NATURE_ESSENCE,ItemCategory.MAGIC_WEAPON),
	NATURE_ESSENCE_4(19,"Artefato Mágico de Árvore Negra",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.NATURE_ESSENCE,ItemCategory.MAGIC_WEAPON),

	DAGGERS_1(20,"Adagas de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.DAGGERS,ItemCategory.LIGHT_WEAPON),
	DAGGERS_2(21,"Facas de Cortar Pão",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.DAGGERS,ItemCategory.LIGHT_WEAPON),
	DAGGERS_3(22,"Adagas Dente-de-Leão",Slot.WEAPON,ItemGrade.RARE,ItemGroup.DAGGERS,ItemCategory.LIGHT_WEAPON),
	DAGGERS_4(23,"Adagas de Presas Negras",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.DAGGERS,ItemCategory.LIGHT_WEAPON),

	SHORT_SWORD_1(24,"Espada Curta de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.SHORT_SWORD,ItemCategory.HEAVY_WEAPON),
	SHORT_SWORD_2(25,"Pedaço de Cepo de Madeira",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.SHORT_SWORD,ItemCategory.HEAVY_WEAPON),
	SHORT_SWORD_3(26,"Espada de Aço",Slot.WEAPON,ItemGrade.RARE,ItemGroup.SHORT_SWORD,ItemCategory.HEAVY_WEAPON),
	SHORT_SWORD_4(27,"Espada Curta de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.SHORT_SWORD,ItemCategory.HEAVY_WEAPON),

	DEMONIAC_SCYTHE_1(28,"Foice Demoníaca de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.DEMONIAC_SCYTHE,ItemCategory.MAGIC_WEAPON),
	DEMONIAC_SCYTHE_2(29,"Foice de Fazenda Endemoniada",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.DEMONIAC_SCYTHE,ItemCategory.MAGIC_WEAPON),
	DEMONIAC_SCYTHE_3(30,"Foice Demoníaca de Osso",Slot.WEAPON,ItemGrade.RARE,ItemGroup.DEMONIAC_SCYTHE,ItemCategory.MAGIC_WEAPON),
	DEMONIAC_SCYTHE_4(31,"Foice Demoníaca de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.DEMONIAC_SCYTHE,ItemCategory.MAGIC_WEAPON),

	DEMONIAC_ORB_1(32,"Orbe Demoníaco do Saco Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.DEMONIAC_ORB,ItemCategory.MAGIC_WEAPON),
	DEMONIAC_ORB_2(33,"Bolinha de Gude Flutuante",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.DEMONIAC_ORB,ItemCategory.MAGIC_WEAPON),
	DEMONIAC_ORB_3(34,"Orbe Demoníaco do Rei Demônio",Slot.WEAPON,ItemGrade.RARE,ItemGroup.DEMONIAC_ORB,ItemCategory.MAGIC_WEAPON),
	DEMONIAC_ORB_4(35,"Orbe Demoníaco de Mágia Negra",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.DEMONIAC_ORB,ItemCategory.MAGIC_WEAPON),

	LANCE_1(36,"Lança de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.LANCE,ItemCategory.HEAVY_WEAPON),
	LANCE_2(37,"Lança Perfume",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.LANCE,ItemCategory.HEAVY_WEAPON),
	LANCE_3(38,"Lança Pesada de Aço",Slot.WEAPON,ItemGrade.RARE,ItemGroup.LANCE,ItemCategory.HEAVY_WEAPON),
	LANCE_4(39,"Lança de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.LANCE,ItemCategory.HEAVY_WEAPON),

	SHIELD_1(40,"Escudo de Pau Negro",Slot.WEAPON_SECONDARY,ItemGrade.NORMAL,ItemGroup.SHIELD,ItemCategory.HEAVY_WEAPON),
	SHIELD_2(41,"Tampa de Lixo",Slot.WEAPON_SECONDARY,ItemGrade.DISTINCT,ItemGroup.SHIELD,ItemCategory.HEAVY_WEAPON),
	SHIELD_3(42,"Escudo de Cristal",Slot.WEAPON_SECONDARY,ItemGrade.RARE,ItemGroup.SHIELD,ItemCategory.HEAVY_WEAPON),
	SHIELD_4(43,"Carapaça de Demônio Negro",Slot.WEAPON_SECONDARY,ItemGrade.LEGENDARY,ItemGroup.SHIELD,ItemCategory.HEAVY_WEAPON),

	LONG_BOW_1(44,"Arco e Flecha Preciso de Paus Negros",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.LONG_BOW,ItemCategory.LIGHT_WEAPON),
	LONG_BOW_2(45,"Estilingue Preciso",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.LONG_BOW,ItemCategory.LIGHT_WEAPON),
	LONG_BOW_3(46,"Arco e Flecha Preciso do Druida Esquecido",Slot.WEAPON,ItemGrade.RARE,ItemGroup.LONG_BOW,ItemCategory.LIGHT_WEAPON),
	LONG_BOW_4(47,"Arco e Flecha Preciso de Árvore Negra",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.LONG_BOW,ItemCategory.LIGHT_WEAPON),

	SHORT_BOW_1(48,"Arco e Flecha Rápido de Paus Negros",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.SHORT_BOW,ItemCategory.LIGHT_WEAPON),
	SHORT_BOW_2(49,"Estilingue Rápido",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.SHORT_BOW,ItemCategory.LIGHT_WEAPON),
	SHORT_BOW_3(50,"Arco e Flecha Rápido do Rei Lembrado",Slot.WEAPON,ItemGrade.RARE,ItemGroup.SHORT_BOW,ItemCategory.LIGHT_WEAPON),
	SHORT_BOW_4(51,"Arco e Flecha Rápido de Árvore Negra",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.SHORT_BOW,ItemCategory.LIGHT_WEAPON),

	MACE_1(52,"Clava de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.MACE,ItemCategory.HEAVY_WEAPON),
	MACE_2(53,"Esclava",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.MACE,ItemCategory.HEAVY_WEAPON),
	MACE_3(54,"Clava Pesada de Aço",Slot.WEAPON,ItemGrade.RARE,ItemGroup.MACE,ItemCategory.HEAVY_WEAPON),
	MACE_4(55,"Clava de Chifre Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.MACE,ItemCategory.HEAVY_WEAPON),

	GRIMOIRE_1(56,"Livro Sagrado",Slot.WEAPON_SECONDARY,ItemGrade.NORMAL,ItemGroup.GRIMOIRE,ItemCategory.MAGIC_WEAPON),
	GRIMOIRE_2(57,"Grimório do Tim Maia",Slot.WEAPON_SECONDARY,ItemGrade.DISTINCT,ItemGroup.GRIMOIRE,ItemCategory.MAGIC_WEAPON),
	GRIMOIRE_3(58,"Grimório de Loki",Slot.WEAPON_SECONDARY,ItemGrade.RARE,ItemGroup.GRIMOIRE,ItemCategory.MAGIC_WEAPON),
	GRIMOIRE_4(59,"Livro Negro",Slot.WEAPON_SECONDARY,ItemGrade.LEGENDARY,ItemGroup.GRIMOIRE,ItemCategory.MAGIC_WEAPON),

	CRUCIFIX_1(60,"Crucifixo de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.CRUCIFIX,ItemCategory.MAGIC_WEAPON),
	CRUCIFIX_2(61,"Crucifixo Roubado da Igreja",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.CRUCIFIX,ItemCategory.MAGIC_WEAPON),
	CRUCIFIX_3(62,"Crucifixo de Ouro",Slot.WEAPON,ItemGrade.RARE,ItemGroup.CRUCIFIX,ItemCategory.MAGIC_WEAPON),
	CRUCIFIX_4(63,"Crucifixo Sagrado do Demônio Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.CRUCIFIX,ItemCategory.MAGIC_WEAPON),

	MAGIC_SWORD_1(64,"Espada Mágica de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.MAGIC_SWORD,ItemCategory.MAGIC_WEAPON),
	MAGIC_SWORD_2(65,"Espada Mágica de Thundera",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.MAGIC_SWORD,ItemCategory.MAGIC_WEAPON),
	MAGIC_SWORD_3(66,"Espada Mágica Absoluta",Slot.WEAPON,ItemGrade.RARE,ItemGroup.MAGIC_SWORD,ItemCategory.MAGIC_WEAPON),
	MAGIC_SWORD_4(67,"Espada Mágica do Guerreiro Negro",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.MAGIC_SWORD,ItemCategory.MAGIC_WEAPON),

	BEER_MUG_1(68,"Caneca de Cerveja de Pau Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.BEER_MUG,ItemCategory.LIGHT_WEAPON),
	BEER_MUG_2(69,"Caneca de Cerveja com Água",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.BEER_MUG,ItemCategory.LIGHT_WEAPON),
	BEER_MUG_3(70,"Caneca de Cerveja com Cerveja",Slot.WEAPON,ItemGrade.RARE,ItemGroup.BEER_MUG,ItemCategory.LIGHT_WEAPON),
	BEER_MUG_4(71,"Caneca de Cerveja com Cerveja Gelada",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.BEER_MUG,ItemCategory.LIGHT_WEAPON),

	STICK_1(72,"Bastão de Pau de Negro",Slot.WEAPON,ItemGrade.NORMAL,ItemGroup.STICK,ItemCategory.LIGHT_WEAPON),
	STICK_2(73,"Bastão de Gado",Slot.WEAPON,ItemGrade.DISTINCT,ItemGroup.STICK,ItemCategory.LIGHT_WEAPON),
	STICK_3(74,"Bastão da Verdade",Slot.WEAPON,ItemGrade.RARE,ItemGroup.STICK,ItemCategory.LIGHT_WEAPON),
	STICK_4(75,"Bastão de Árvore Negra",Slot.WEAPON,ItemGrade.LEGENDARY,ItemGroup.STICK,ItemCategory.LIGHT_WEAPON),

	HEAVY_HELMET_1(76,"Capacete de Lixo",Slot.HELMET,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_ARMOR_1(77,"Armadura de Lixo",Slot.ARMOR,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_GLOVES_1(78,"Luvas de Lixo",Slot.GLOVES,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_FEETS_1(79,"Botas de Lixo",Slot.FEETS,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),

	HEAVY_HELMET_2(80,"Capacete de Lata",Slot.HELMET,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_ARMOR_2(81,"Armadura de Lata",Slot.ARMOR,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_GLOVES_2(82,"Luvas de Lata",Slot.GLOVES,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_FEETS_2(83,"Botas de Lata",Slot.FEETS,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),

	HEAVY_HELMET_3(84,"Capacete de Aço",Slot.HELMET,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_ARMOR_3(85,"Armadura de Aço",Slot.ARMOR,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_GLOVES_3(86,"Luvas de Aço",Slot.GLOVES,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_FEETS_3(87,"Botas de Aço",Slot.FEETS,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),

	HEAVY_HELMET_4(88,"Capacete de Aço Negro",Slot.HELMET,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_ARMOR_4(89,"Armadura de Aço Negro",Slot.ARMOR,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_GLOVES_4(90,"Luvas de Aço Negro",Slot.GLOVES,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),
	HEAVY_FEETS_4(91,"Botas de Aço Negro",Slot.FEETS,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.HEAVY_ARMOR),

	LIGHT_HOOD_1(92,"Capuz de Lã",Slot.HELMET,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_ARMOR_1(93,"Blusa Lã",Slot.ARMOR,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_GLOVES_1(94,"Luvas de Lã",Slot.GLOVES,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_FEETS_1(95,"Sapatos de Lã",Slot.FEETS,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),

	LIGHT_HOOD_2(96,"Capuz Sujo e Remendado",Slot.HELMET,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_ARMOR_2(97,"Armadura Leve Suja e Remendada",Slot.ARMOR,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_GLOVES_2(98,"Luvas Sujas e Remendadas",Slot.GLOVES,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_FEETS_2(99,"Botas Sujas Remendadas",Slot.FEETS,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),

	LIGHT_HOOD_3(100,"Capuz Remendado",Slot.HELMET,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_ARMOR_3(101,"Armadura Leve Remendada",Slot.ARMOR,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_GLOVES_3(102,"Luvas Remendadas",Slot.GLOVES,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_FEETS_3(103,"Botas Remendadas",Slot.FEETS,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),

	LIGHT_HOOD_4(104,"Capuz de Pelo Negro",Slot.HELMET,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_ARMOR_4(105,"Armadura de Pelo Negro",Slot.ARMOR,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_GLOVES_4(106,"Luvas de Pelo Negro",Slot.GLOVES,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),
	LIGHT_FEETS_4(107,"Botas de Pelo Negro",Slot.FEETS,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.LIGHT_ARMOR),

	MAGIC_HAT_1(108,"Chapéu Mágico sem Mágia",Slot.HELMET,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_CLOAK_1(109,"Manto Mágico sem Mágia",Slot.ARMOR,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_GLOVES_1(110,"Luvas Mágicas sem Mágia",Slot.GLOVES,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_FEETS_1(111,"Botas Mágicas sem Mágia",Slot.FEETS,ItemGrade.NORMAL,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),

	MAGIC_HAT_2(112,"Chapéu Mágico do Champ",Slot.HELMET,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_CLOAK_2(113,"Manto Mágico do Champ",Slot.ARMOR,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_GLOVES_2(114,"Luvas Mágicas do Champ",Slot.GLOVES,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_FEETS_2(115,"Botas Mágicas do Champ",Slot.FEETS,ItemGrade.DISTINCT,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),

	MAGIC_HAT_3(116,"Chapéu Mágico Poderoso",Slot.HELMET,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_CLOAK_3(117,"Manto Mágico Poderoso",Slot.ARMOR,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_GLOVES_3(118,"Luvas Mágicas Poderosas",Slot.GLOVES,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_FEETS_3(119,"Botas Mágicas Poderosas",Slot.FEETS,ItemGrade.RARE,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),

	MAGIC_HAT_4(120,"Chapéu Mágico Anti-Mágia",Slot.HELMET,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_CLOAK_4(121,"Manto Mágico Anti-Mágia",Slot.ARMOR,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_GLOVES_4(122,"Luvas Mágicas Anti-Mágia",Slot.GLOVES,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),
	MAGIC_FEETS_4(123,"Botas Mágicas Anti-Mágia",Slot.FEETS,ItemGrade.LEGENDARY,ItemGroup.ARMOR,ItemCategory.MAGIC_ARMOR),

	ACCURACY_NECKLACE_1(124,"Colar do Menino Vesgo",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_WAIST_1(125,"Cinto do Menino Vesgo",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_RING_1(126,"Anel do Menino Vesgo",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_EARRING_1(127,"Brinco do Menino Vesgo",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),

	ACCURACY_NECKLACE_2(128,"Colar Quasi Ocertey",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_WAIST_2(129,"Cinto Quasi Ocertey",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_RING_2(130,"Anel Quasi Ocertey",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_EARRING_2(131,"Brinco Quasi Ocertey",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),

	ACCURACY_NECKLACE_3(132,"Colar Certeiro",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_WAIST_3(133,"Cinto Certeiro",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_RING_3(134,"Anel Certeiro",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_EARRING_3(135,"Brinco Certeiro",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),

	ACCURACY_NECKLACE_4(136,"Colar Absoluto",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_WAIST_4(137,"Cinto Absoluto",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_RING_4(138,"Anel Absoluto",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),
	ACCURACY_EARRING_4(139,"Brinco Absoluto",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ACCURACY_ACCESSORY),

	MAX_HEALTH_NECKLACE_1(140,"Colar do Menino Leproso",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_WAIST_1(141,"Cinto do Menino Leproso",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_RING_1(142,"Anel do Menino Leproso",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_EARRING_1(143,"Brinco do Menino Leproso",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),

	MAX_HEALTH_NECKLACE_2(144,"Colar Eozei Mimecher",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_WAIST_2(145,"Cinto Eozei Mimecher",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_RING_2(146,"Anel Eozei Mimecher",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_EARRING_2(147,"Brinco Eozei Mimecher",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),

	MAX_HEALTH_NECKLACE_3(148,"Colar do Fujão",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_WAIST_3(149,"Cinto do Fujão",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_RING_3(150,"Anel do Fujão",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_EARRING_3(151,"Brinco do Fujão",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),

	MAX_HEALTH_NECKLACE_4(152,"Colar do Intocável",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_WAIST_4(153,"Cinto do Intocável",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_RING_4(154,"Anel do Intocável",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),
	MAX_HEALTH_EARRING_4(155,"Brinco do Intocável",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_HEALTH_ACCESSORY),

	MAX_ENERGY_NECKLACE_1(156,"Colar do Menino Leproso",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_WAIST_1(157,"Cinto do Menino Leproso",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_RING_1(158,"Anel do Menino Leproso",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_EARRING_1(159,"Brinco do Menino Leproso",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),

	MAX_ENERGY_NECKLACE_2(160,"Colar Eozei Mimecher",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_WAIST_2(161,"Cinto Eozei Mimecher",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_RING_2(162,"Anel Eozei Mimecher",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_EARRING_2(163,"Brinco Eozei Mimecher",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),

	MAX_ENERGY_NECKLACE_3(164,"Colar do Fujão",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_WAIST_3(165,"Cinto do Fujão",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_RING_3(166,"Anel do Fujão",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_EARRING_3(167,"Brinco do Fujão",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),

	MAX_ENERGY_NECKLACE_4(168,"Colar do Intocável",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_WAIST_4(169,"Cinto do Intocável",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_RING_4(170,"Anel do Intocável",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),
	MAX_ENERGY_EARRING_4(171,"Brinco do Intocável",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.MAX_ENERGY_ACCESSORY),

	HEALTH_REGENERATION_NECKLACE_1(172,"Colar Roubado do Menino Morrendo",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_WAIST_1(173,"Cinto Roubado do Menino Morrendo",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_RING_1(174,"Anel Roubado do Menino Morrendo",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_EARRING_1(175,"Brinco Roubado do Menino Morrendo",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),

	HEALTH_REGENERATION_NECKLACE_2(176,"Colar do Mym Rezenerei",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_WAIST_2(177,"Cinto do Mym Rezenerei",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_RING_2(178,"Anel do Mym Rezenerei",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_EARRING_2(179,"Brinco do Mym Rezenerei",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),

	HEALTH_REGENERATION_NECKLACE_3(180,"Colar do Espírito Ronin",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_WAIST_3(181,"Cinto do Espírito Ronin",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_RING_3(182,"Anel do Espírito Ronin",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_EARRING_3(183,"Brinco do Espírito Ronin",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),

	HEALTH_REGENERATION_NECKLACE_4(184,"Colar do Necromancer",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_WAIST_4(185,"Cinto do Necromancer",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_RING_4(186,"Anel do Necromancer",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),
	HEALTH_REGENERATION_EARRING_4(187,"Brinco do Necromancer",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.HEALTH_REGENERATION_ACCESSORY),

	ENERGY_REGENERATION_NECKLACE_1(188,"Colar do Menino Cansado",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_WAIST_1(189,"Cinto do Menino Cansado",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_RING_1(190,"Anel do Menino Cansado",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_EARRING_1(191,"Brinco do Menino Cansado",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),

	ENERGY_REGENERATION_NECKLACE_2(192,"Colar da Ereção Matinal",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_WAIST_2(193,"Cinto da Ereção Matinal",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_RING_2(194,"Anel da Ereção Matinal",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_EARRING_2(195,"Brinco da Ereção Matinal",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),

	ENERGY_REGENERATION_NECKLACE_3(196,"Colar Concentrado",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_WAIST_3(197,"Cinto Concentrado",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_RING_3(198,"Anel Concentrado",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_EARRING_3(199,"Brinco Concentrado",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),

	ENERGY_REGENERATION_NECKLACE_4(200,"Colar Cheio de Chi",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_WAIST_4(201,"Cinto Cheio de Chi",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_RING_4(202,"Anel Cheio de Chi",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),
	ENERGY_REGENERATION_EARRING_4(203,"Brinco Cheio de Chi",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.ENERGY_REGENERATION_ACCESSORY),

	CRITICAL_DAMAGE_NECKLACE_1(204,"Colar do Menino Pelado",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_WAIST_1(205,"Cinto do Menino Pelado",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_RING_1(206,"Anel do Menino Pelado",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_EARRING_1(207,"Brinco do Menino Pelado",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),

	CRITICAL_DAMAGE_NECKLACE_2(208,"Colar Cenhar Madora",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_WAIST_2(209,"Cinto Cenhar Madora",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_RING_2(210,"Anel Cenhar Madora",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_EARRING_2(211,"Brinco Cenhar Madora",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),

	CRITICAL_DAMAGE_NECKLACE_3(212,"Colar Armin",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_WAIST_3(213,"Cinto Armin",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_RING_3(214,"Anel Armin",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_EARRING_3(215,"Brinco Armin",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),

	CRITICAL_DAMAGE_NECKLACE_4(216,"Colar do Colosso",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_WAIST_4(217,"Cinto do Colosso",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_RING_4(218,"Anel do Colosso",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),
	CRITICAL_DAMAGE_EARRING_4(219,"Brinco do Colosso",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.CRITICAL_DAMAGE_ACCESSORY),

	LIFE_STEAL_NECKLACE_MAGIC_1(220,"Colar do Menino Selado",Slot.NECKLACE,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_WAIST_MAGIC_1(221,"Cinto do Menino Selado",Slot.WAIST,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_RING_MAGIC_1(222,"Anel do Menino Selado",Slot.RING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_EARRING_MAGIC_1(223,"Brinco do Menino Selado",Slot.EARRING,ItemGrade.NORMAL,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),

	LIFE_STEAL_NECKLACE_MAGIC_2(224,"Colar Poderoso Magicka",Slot.NECKLACE,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_WAIST_MAGIC_2(225,"Cinto Poderoso Magicka",Slot.WAIST,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_RING_MAGIC_2(226,"Anel Poderoso Magicka",Slot.RING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_EARRING_MAGIC_2(227,"Brinco Poderoso Magicka",Slot.EARRING,ItemGrade.DISTINCT,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),

	LIFE_STEAL_NECKLACE_MAGIC_3(228,"Colar Anti-Magia",Slot.NECKLACE,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_WAIST_MAGIC_3(229,"Cinto do Anti-Magia",Slot.WAIST,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_RING_MAGIC_3(230,"Anel do Anti-Magia",Slot.RING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_EARRING_MAGIC_3(231,"Brinco do Anti-Magia",Slot.EARRING,ItemGrade.RARE,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),

	LIFE_STEAL_NECKLACE_MAGIC_4(232,"Colar do Bruxo",Slot.NECKLACE,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_WAIST_MAGIC_4(233,"Cinto do Bruxo",Slot.WAIST,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_RING_MAGIC_4(234,"Anel do Bruxo",Slot.RING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	LIFE_STEAL_EARRING_MAGIC_4(235,"Brinco do Bruxo",Slot.EARRING,ItemGrade.LEGENDARY,ItemGroup.ACCESSORIES,ItemCategory.LIFE_STEAL_ACCESSORY),
	;
	
	public static void main(String[] args) {
		/*ItemType[] ts = values();
		for(int i=0;i<ts.length;i++) {
			ItemType t = ts[i];
			if(i%4==0) {
				System.out.println();
			}
			System.out.println(t.name()+"("+i+",\""+t.name+"\",Slot."+t.slot.name()+",ItemGrade."+t.grade.name()+",ItemGroup."+t.group.name()+",ItemCategory."+t.category.name()+"),");
		}*/
	}
	
	private int id;
	private String name;
	private Slot slot;
	private ItemGroup group;
	private ItemGrade grade;
	private ItemCategory category;
	
	private ItemType(int id,String name,Slot slot,ItemGrade grade,ItemGroup group,ItemCategory category) {
		this.id=id;
		this.name=name;
		this.slot=slot;
		this.group=group;
		this.grade=grade;
		this.category=category;
	}
	
	public Attributes getMods() {
		Attributes r = new Attributes();
		switch(group) {
		case ACCESSORIES:
			switch(category) {
			case ACCURACY_ACCESSORY:
				r.set(Attributes.ACCURACY, 1*(grade.getID()+1));
				break;
			case CRITICAL_DAMAGE_ACCESSORY:
				r.set(Attributes.CRITICAL_CHANCE, 1*(grade.getID()+1));
				break;
			case ENERGY_REGENERATION_ACCESSORY:
				r.set(Attributes.ENERGY_REGENERATION, 1*(grade.getID()+1));
				break;
			case HEALTH_REGENERATION_ACCESSORY:
				r.set(Attributes.HEALTH_REGENERATION, 1*(grade.getID()+1));
				break;
			case LIFE_STEAL_ACCESSORY:
				r.set(Attributes.LIFE_STEAL, 1*(grade.getID()+1));
				break;
			case MAX_ENERGY_ACCESSORY:
				r.set(Attributes.MAX_ENERGY, 0.08*(grade.getID()+1));
				break;
			case MAX_HEALTH_ACCESSORY:
				r.set(Attributes.HEALTH_REGENERATION, 0.05*(grade.getID()+1));
				break;
			}
			break;
		case ARMOR:
			switch(category) {
			case HEAVY_ARMOR:
				r.set(Attributes.EVASION, 1*(grade.getID()+1));
				r.set(Attributes.ATTACK_POWER, 2*(grade.getID()+1));
				r.set(Attributes.DEFENSE, 3*(grade.getID()+1));
				break;
			case LIGHT_ARMOR:
				r.set(Attributes.EVASION, 3*(grade.getID()+1));
				r.set(Attributes.ATTACK_POWER, 2*(grade.getID()+1));
				r.set(Attributes.DEFENSE, 1*(grade.getID()+1));
				break;
			case MAGIC_ARMOR:
				r.set(Attributes.EVASION, 2*(grade.getID()+1));
				r.set(Attributes.ATTACK_POWER, 3*(grade.getID()+1));
				r.set(Attributes.DEFENSE, 1*(grade.getID()+1));
				break;
			}
			break;
		case BEER_MUG:
			r.set(Attributes.INITIATIVE, 4);
			r.set(Attributes.ACCURACY, 8*(grade.getID()+1));
			break;
		case CRUCIFIX:
			r.set(Attributes.INITIATIVE, 3);
			r.set(Attributes.ACCURACY, 12*(grade.getID()+1));
			break;
		case DAGGERS:
			r.set(Attributes.INITIATIVE, 5);
			r.set(Attributes.ACCURACY, 12*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 5*(grade.getID()+1));
			break;
		case DEMONIAC_ORB:
			r.set(Attributes.INITIATIVE, 3);
			r.set(Attributes.ACCURACY, 10*(grade.getID()+1));
			break;
		case DEMONIAC_SCYTHE:
			r.set(Attributes.INITIATIVE, 4);
			r.set(Attributes.ACCURACY, 12*(grade.getID()+1));
			break;
		case DUAL_AXE:
			r.set(Attributes.INITIATIVE, 1);
			r.set(Attributes.ACCURACY, 10*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 1*(grade.getID()+1));
			break;
		case GIANT_HAMMER:
			r.set(Attributes.INITIATIVE, 1);
			r.set(Attributes.ACCURACY, 9*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 7*(grade.getID()+1));
			break;
		case LANCE:
			r.set(Attributes.INITIATIVE, 1);
			r.set(Attributes.ACCURACY, 8*(grade.getID()+1));
			break;
		case LONG_BOW:
			r.set(Attributes.INITIATIVE, 2);
			r.set(Attributes.ACCURACY, 4*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 25*(grade.getID()+1));
			break;
		case LONG_SWORD:
			r.set(Attributes.INITIATIVE, 3);
			r.set(Attributes.ACCURACY, 10*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 5*(grade.getID()+1));
			r.set(Attributes.LIFE_STEAL, 5*(grade.getID()+1));
			break;
		case MACE:
			r.set(Attributes.INITIATIVE, 2);
			r.set(Attributes.ACCURACY, 10*(grade.getID()+1));
			break;
		case MAGIC_SWORD:
			r.set(Attributes.INITIATIVE, 3);
			r.set(Attributes.ACCURACY, 10*(grade.getID()+1));
			break;
		case NATURE_ESSENCE:
			r.set(Attributes.INITIATIVE, 4);
			r.set(Attributes.ACCURACY, 12*(grade.getID()+1));
			break;
		case SHORT_BOW:
			r.set(Attributes.INITIATIVE, 4);
			r.set(Attributes.ACCURACY, 4*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 5*(grade.getID()+1));
			break;
		case SHORT_SWORD:
			r.set(Attributes.INITIATIVE, 1);
			r.set(Attributes.ACCURACY, 10*(grade.getID()+1));
			r.set(Attributes.CRITICAL_CHANCE, 1*(grade.getID()+1));
			break;
		case STAFF:
			r.set(Attributes.INITIATIVE, 3);
			r.set(Attributes.ACCURACY, 8*(grade.getID()+1));
			break;
		case STICK:
			r.set(Attributes.INITIATIVE, 3);
			r.set(Attributes.ACCURACY, 8*(grade.getID()+1));
			break;
		}
		return r;
	}
	
	public boolean isTwoHanded() {
		if(slot==Slot.WEAPON) {
			switch(group) {
			case BEER_MUG:
			case DAGGERS:
			case DEMONIAC_SCYTHE:
			case DUAL_AXE:
			case GIANT_HAMMER:
			case LONG_BOW:
			case LONG_SWORD:
			case NATURE_ESSENCE:
			case SHORT_BOW:
			case SHORT_SWORD:
			case MAGIC_SWORD:
			case STICK:
				return true;
			}
		}
		return false;
	}
	
	public static final int OBJECT_ID_GROUP = 0;
	public static final int OBJECT_ID_GRADE = 1;
	public static final int OBJECT_ID_CATEGORY = 2;
	public static final int OBJECT_ID_SLOT = 3;
	
	@Override
	public Object getObject(int id) {
		switch(id) {
		case OBJECT_ID_CATEGORY:
			return getCategory();
		case OBJECT_ID_GRADE:
			return getGrade();
		case OBJECT_ID_GROUP:
			return getGroup();
		case OBJECT_ID_SLOT:
			return getSlot();
		}
		return null;
	}
	
	public Skill getSkill() {
		if(slot==Slot.WEAPON) {
			switch(group) {
			case BEER_MUG:
				return Skill.DRUNK_FIST;
			case CRUCIFIX:
				return Skill.ILUMINATED_FIELD;
			case DAGGERS:
				return Skill.FURIOUS_BLADES;
			case DEMONIAC_ORB:
				return Skill.DISEASE_WAVE;
			case DEMONIAC_SCYTHE:
				return Skill.HALF_MOON_CUT;
			case DUAL_AXE:
				return Skill.BLOODTHIRSTY_ATTACK;
			case GIANT_HAMMER:
				return Skill.SKULL_SMASH;
			case LANCE:
				return Skill.STAB;
			case LONG_BOW:
				return Skill.PRECISE_SHOT;
			case LONG_SWORD:
				return Skill.BLOODY_EATER;
			case MACE:
				return Skill.CONTROL_ATTACK;
			case MAGIC_SWORD:
				return Skill.ELETRIC_CHARGE;
			case NATURE_ESSENCE:
				return Skill.SPIRITUAL_SEED;
			case SHORT_BOW:
				return Skill.FAST_ARROW;
			case SHORT_SWORD:
				return Skill.CURSED_BLADE;
			case STAFF:
				return Skill.FIREBALL;
			case STICK:
				return Skill.ACCURATE_ATTACK;
			}
		}
		return null;
	}
	
	public static CustomList<ItemType> getByFilters(FilterableFilter...filters){
		CustomList<ItemType> r = new CustomList<ItemType>();
		r.addAll(values());
		return (CustomList<ItemType>) Filterable.filter(r, filters);
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Slot getSlot() {
		return slot;
	}
	
	public ItemGroup getGroup() {
		return group;
	}
	
	public ItemGrade getGrade() {
		return grade;
	}
	
	public ItemCategory getCategory() {
		return category;
	}
	
}
