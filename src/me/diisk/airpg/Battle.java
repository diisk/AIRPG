package me.diisk.airpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.diisk.airpg.CustomList.CustomList;

public class Battle {

	private Team team1,team2;
	private int maxRounds;
	private List<String> logLines = new ArrayList<String>();
	
	
	private Battle(Team team1, Team team2) {
		this.team1=team1;
		this.team2=team2;
		maxRounds=(team1.getSize()+team2.getSize())*20;
		CustomList<Entity> ents = getEntities();
		for(int i=0;i<ents.size();i++) {
			ents.get(i).respawn();
		}
		Random rand = new Random();
		for(Entity en1:team1.getAllMembers()) {
			for(Entity en2:team2.getAllMembers()) {
				en1.addAggroFor(en2, 1+rand.nextInt(20));
				en2.addAggroFor(en1, 1+rand.nextInt(20));
			}
		}
	}
	
	public Team getEnemiesFor(Team team) {
		if(team.equals(team1)) {
			return team2;
		}else {
			return team1;
		}
	}
	
	public CustomList<Entity> getEntities(){
		CustomList<Entity> cl = new CustomList<Entity>();
		for(Entity m:team1.getAllMembers()) {
			cl.add(m);
		}
		for(Entity m:team2.getAllMembers()) {
			cl.add(m);
		}
		return cl;
	}
	
	public void addLogLine(String line) {
		logLines.add(line);
	}
	
	public List<String> getLogLines() {
		return logLines;
	}
	
	public static Battle fight(Team team1, Team team2) {
		Battle battle = new Battle(team1, team2);
		int round = 0;
		CustomList<Entity> entities = battle.getEntities();
		entities.orderBy(Entity.ORDER_BY_INITIATIVE, false, true);
		List<Entity> ents = entities.toList();
		all:
		while(true) {
			for(Entity en:ents) {
				if(team1.isAllDead() || team2.isAllDead() || round>=battle.maxRounds) {
					break all;
				}
				if(!en.isDead()) {
					round++;
					for(Entity enn:ents) {
						enn.roundRegen();
					}
					en.turnOn();
					while(en.useSkill(battle));
				}
			}
		}
		return battle;
	}
	
}
