package me.diisk.airpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.diisk.airpg.CustomList.CustomList;

public class Battle {

	public class LogLine{
		private String message;
		private boolean canceled = false;
		
		public LogLine(String message) {
			this.message = message;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void cancel() {
			canceled = true;
		}
		
		public boolean isCanceled() {
			return canceled;
		}
	}
	
	private Team team1,team2;
	private int maxRounds,round;
	private List<LogLine> logLines = new ArrayList<LogLine>();
	
	private Battle(Team team1, Team team2) {
		this.team1=team1;
		this.team2=team2;
		maxRounds=(team1.getSize()+team2.getSize())*20;
		CustomList<Entity> ents = getEntities();
		for(int i=0;i<ents.size();i++) {
			ents.get(i).respawn(this);
		}
		Random rand = new Random();
		for(Entity en1:team1.getAllMembers()) {
			for(Entity en2:team2.getAllMembers()) {
				en1.addAggroFor(en2, 1+rand.nextInt(20));
				en2.addAggroFor(en1, 1+rand.nextInt(20));
			}
		}
	}
	
	public int getRound() {
		return round;
	}
	
	public Team getEnemyTeam(Team team) {
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
	
	public LogLine addLogLine(String line) {
		LogLine ll = new LogLine(line);
		logLines.add(ll);
		return ll;
	}
	
	public Team getWinners() {
		if((team1.isAllDead() && team2.isAllDead()) || (!team1.isAllDead() && !team2.isAllDead())) {
			return null;
		}else {
			if(team1.isAllDead()) {
				return team2;
			}else {
				return team1;
			}
		}
	}
	
	public List<LogLine> getLogLines() {
		return logLines;
	}
	
	public boolean isRunning() {
		return !team1.isAllDead()&&!team2.isAllDead()&&round<maxRounds;
	}
	
	public static Battle fight(Team team1, Team team2) {
		Battle battle = new Battle(team1, team2);
		battle.round = 0;
		CustomList<Entity> entities = battle.getEntities();
		entities.orderBy(Entity.ORDER_BY_INITIATIVE, false, true);
		List<Entity> ents = entities.toList();
		all:
		while(true) {
			for(Entity en:ents) {
				if(!battle.isRunning()) {
					break all;
				}
				if(!en.isDead()) {
					if(battle.round>0) {
						battle.addLogLine("Fim do Round");
					}
					battle.round++;
					battle.addLogLine("Iniciando Round "+battle.round+"("+en.getName()+"):");
					for(Entity enn:ents) {
						if(!enn.isDead()) {
							enn.roundUpdate(en);
						}
					}
					en.turnOn();
					while(en.useSkill());
				}
			}
		}
		return battle;
	}
	
}
