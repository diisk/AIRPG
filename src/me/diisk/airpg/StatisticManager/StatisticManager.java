package me.diisk.airpg.StatisticManager;

import java.io.Serializable;

import me.diisk.airpg.DateTime;
import me.diisk.airpg.CustomList.CustomList;

public class StatisticManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int RACES = 0;
	public static final int CLASSES = 1;
	public static final int WEAPONS = 2;
	public static final int ARMORS = 3;
	public static final int ACCESSORIES = 4;
	public static final int ALL = 5;
	
	private OrdenableStatistic[][] oss = new OrdenableStatistic[6][0];
	private int allBattlesCount;
	private int totalDraws;
	private long duration;
	private int npcsCount;
	private int level;
	
	public StatisticManager(int level, int allBattlesCount, int totalDraws, DateTime duration, int npcsCount) {
		this.allBattlesCount=allBattlesCount;
		this.totalDraws=totalDraws;
		this.duration=duration.toMilliSeconds();
		this.npcsCount=npcsCount;
		this.level=level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void addOrdenableStatistic(int type, OrdenableStatistic os) {
		OrdenableStatistic[] m = new OrdenableStatistic[oss[type].length+1];
		m[m.length-1]=os;
		for(int i=0;i<m.length-1;i++) {
			m[i]=oss[type][i];
		}
		oss[type]=m;
	}
	
	public int getAllBattlesCount() {
		return allBattlesCount;
	}
	
	public int getTotalDraws() {
		return totalDraws;
	}
	
	public int getWinAndLoses() {
		return allBattlesCount-totalDraws;
	}
	
	public int getNPCsCount() {
		return npcsCount;
	}
	
	public DateTime getDuration() {
		return new DateTime(duration);
	}
	
	public CustomList<OrdenableStatistic> getOrdenableStatisc(int type){
		CustomList<OrdenableStatistic> r = new CustomList<OrdenableStatistic>();
		r.addAll(oss[type]);
		return r;
	}
	
}
