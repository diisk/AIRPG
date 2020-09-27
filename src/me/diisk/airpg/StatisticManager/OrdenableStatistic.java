package me.diisk.airpg.StatisticManager;

import java.io.Serializable;
import java.text.DecimalFormat;

import me.diisk.airpg.CustomList.Ordenable;

public class OrdenableStatistic implements Ordenable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int VALUE_ID_WINSP = 0;
	public static final int VALUE_ID_DRAWSP = 1;
	public static final int VALUE_ID_LOOSESP = 2;
	public static final int VALUE_ID_PARTICIPATIONP = 3;
	
	String name;
	int wins;
	int draws;
	int looses;
	double totalBattles;
	
	double winsPercent;
	double drawsPercent;
	double loosesPercent;
	double participationPercent;
	
	public OrdenableStatistic(String name, int[] values, int allBattlesCount) {
		this.name=name;
		wins = values[0];
		draws = values[1];
		looses = values[2];
		totalBattles = wins+draws+looses;
		winsPercent=wins/totalBattles*100;
		drawsPercent=draws/totalBattles*100;
		loosesPercent=looses/totalBattles*100;
		participationPercent=totalBattles/allBattlesCount*100;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return name+": Wins: "+wins+"("+df.format(winsPercent).replaceFirst(",", ".")+"%) Looses: "+looses+"("+df.format(loosesPercent).replaceFirst(",", ".")+"%) Draws: "+draws+"("+df.format(drawsPercent).replaceFirst(",", ".")+"%) Participation: "+df.format(participationPercent).replaceFirst(",", ".")+"%";
	}
	
	
	@Override
	public double getNumberValue(int id) {
		switch(id) {
		case VALUE_ID_WINSP:
			return winsPercent;
		case VALUE_ID_DRAWSP:
			return drawsPercent;
		case VALUE_ID_LOOSESP:
			return loosesPercent;
		case VALUE_ID_PARTICIPATIONP:
			return participationPercent;
		}
		return 0;
	}

	@Override
	public String getStringValue(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
