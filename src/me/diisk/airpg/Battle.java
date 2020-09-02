package me.diisk.airpg;

import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Random;

import me.diisk.airpg.CustomList.CustomList;

public class Battle {

	private Team team1,team2;
	private int maxRounds;
	
	
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
	
	public static Battle fight(Team team1, Team team2) {
		Battle battle = new Battle(team1, team2);
		int round = 0;
		CustomList<Entity> entities = battle.getEntities();
		entities.orderBy(Entity.ORDER_BY_INITIATIVE, false, true);
		List<Entity> ents = entities.toList();
		while(!team1.isAllDead() && !team2.isAllDead() && round<battle.maxRounds) {
			for(Entity en:ents) {
				if(!en.isDead()) {
					round++;
					for(Entity enn:ents) {
						enn.roundRegen();
					}
				}
			}
			
			
		}
		return battle;
	}
	
}
