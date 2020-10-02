package me.diisk.airpg.StatisticManager;

import java.io.Serializable;
import java.text.DecimalFormat;

import me.diisk.airpg.CustomList.Ordenable;

public class OrdenableStatistic implements Ordenable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int VALUE_ID_VICTORIESP = MainStatisticUI.VICTORY;
	public static final int VALUE_ID_DRAWSP = MainStatisticUI.DRAW;
	public static final int VALUE_ID_DEFEATSP = MainStatisticUI.DEFEAT;
	public static final int VALUE_ID_PARTICIPATIONP = MainStatisticUI.PARTICIPATION;
	
	private String name;
	private int victories;
	private int draws;
	private int defeats;
	private double participation;
	
	private double victoriesPercent;
	private double drawsPercent;
	private double defeatsPercent;
	private double participationsPercent;
	
	public OrdenableStatistic(String name, int[] values, int allBattlesCount) {
		this.name=name;
		victories = values[0];
		draws = values[1];
		defeats = values[2];
		participation = victories+draws+defeats;
		victoriesPercent=victories/participation*100;
		drawsPercent=draws/participation*100;
		defeatsPercent=defeats/participation*100;
		participationsPercent=participation/allBattlesCount*100;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.##");
		return name+": Wins: "+victories+"("+df.format(victoriesPercent).replaceFirst(",", ".")+"%) Looses: "+defeats+"("+df.format(defeatsPercent).replaceFirst(",", ".")+"%) Draws: "+draws+"("+df.format(drawsPercent).replaceFirst(",", ".")+"%) Participation: "+df.format(participationsPercent).replaceFirst(",", ".")+"%";
	}
	
	public String getName() {
		return name;
	}
	
	public String getVictories() {
		DecimalFormat df = new DecimalFormat("#.##");
		return victories+"("+df.format(victoriesPercent).replaceFirst(",", ".")+"%)";
	}
	
	public String getDefeats() {
		DecimalFormat df = new DecimalFormat("#.##");
		return defeats+"("+df.format(defeatsPercent).replaceFirst(",", ".")+"%)";
	}
	
	public String getDraws() {
		DecimalFormat df = new DecimalFormat("#.##");
		return draws+"("+df.format(drawsPercent).replaceFirst(",", ".")+"%)";
	}
	
	public String getParticipations() {
		DecimalFormat df = new DecimalFormat("#.##");
		return participation+"("+df.format(participationsPercent).replaceFirst(",", ".")+"%)";
	}
	
	
	@Override
	public double getNumberValue(int id) {
		switch(id) {
		case VALUE_ID_VICTORIESP:
			return victoriesPercent;
		case VALUE_ID_DRAWSP:
			return drawsPercent;
		case VALUE_ID_DEFEATSP:
			return defeatsPercent;
		case VALUE_ID_PARTICIPATIONP:
			return participationsPercent;
		}
		return 0;
	}

	@Override
	public String getStringValue(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
