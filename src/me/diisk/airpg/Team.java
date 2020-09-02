package me.diisk.airpg;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private int id;
	private Entity leader;
	private List<Entity> members = new ArrayList<Entity>();
	
	public Team(Entity leader) {
		this.leader = leader;
	}
	
	public List<Entity> getMembers() {
		return members;
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
