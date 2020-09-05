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
	private int maxRounds;
	private List<LogLine> logLines = new ArrayList<LogLine>();
	
	public static void main(String[] args) {
		Team t1 = new Team(new Entity("Teste1", Race.UNDEAD, Classe.ARCHER));
		Team t2 = new Team(new Entity("Teste2", Race.UNDEAD, Classe.ARCHER));
		Battle battle = fight(t1, t2);
		CustomList<Entity> ents = battle.getEntities();
		for(int i=0;i<ents.size();i++) {
			Entity en = ents.get(i);
			//System.out.println(en.getEffects().size());
		}
		for(LogLine ll:battle.getLogLines()) {
			if(!ll.isCanceled()) {
				System.out.println(ll.getMessage());
			}
			
		}
	}
	
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
					if(round>0) {
						battle.addLogLine("Fim do Round");
					}
					round++;
					battle.addLogLine("Iniciando Round "+round+":");
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
