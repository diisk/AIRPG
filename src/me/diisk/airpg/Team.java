package me.diisk.airpg;

import java.util.ArrayList;
import java.util.List;

import me.diisk.airpg.CustomList.CustomList;

public class Team {

	private int id;
	private Entity leader;
	private List<Entity> members = new ArrayList<Entity>();
	
	public Team(Entity leader) {
		this.leader = leader;
		leader.setTeam(this);
	}
	
	public List<Entity> getMembers() {
		return members;
	}
	
	public List<Entity> getRandomHealList(){
		List<Entity> list = new ArrayList<Entity>();
		for(Entity e:getAliveMembers()) {
			if(e.getHealthPercent()<=0.4) {
				list.add(e);
			}else if(e.getHealthPercent()<=0.7) {
				if(Utils.chance(0.5)) {
					list.add(e);
				}
			}
		}
		return list;
	}
	
	public List<Entity> getAliveMembers(){
		CustomList<Entity> cl = new CustomList<Entity>();
		for(Entity e:getAllMembers()) {
			if(!e.isDead()) {
				cl.add(e);
			}
		}
		cl.orderBy(Entity.ORDER_BY_HEALTH, false, false);
		return cl.toList();
	}
	
	public List<Entity> getAllMembers(){
		List<Entity> r = new ArrayList<Entity>();
		r.add(leader);
		r.addAll(members);
		return r;
	}
	
	public boolean isAllDead() {
		if(leader.isDead()) {
			for(Entity m:members) {
				if(!m.isDead()) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return members.size()+1;
	}
	
	public void addMember(Entity member) {
		members.add(member);
		member.setTeam(this);
	}
	
	public Entity getLeader() {
		return leader;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Team) {
			return ((Team) obj).leader.equals(leader);
		}
		return false;
	}
	
}
