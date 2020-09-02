package me.diisk.airpg;

import java.util.Random;

public class Teste {

	public static boolean chance(double chance) {
		return Math.random()<chance;
	}
	
	public static boolean rollDice(double v1, double v2) {
		v1+=1;
		v2+=1;
		return chance(v1/(v1+v2));
	}
	
	public static double getDamageReductionFor(int defense) {
		if(defense>0) {
			return defense/224.0;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println("1: "+getDamageReductionFor(1));
		System.out.println("100: "+getDamageReductionFor(100));
		System.out.println("148: "+getDamageReductionFor(148));
	}
	
}
