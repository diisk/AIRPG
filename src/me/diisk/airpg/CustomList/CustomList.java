package me.diisk.airpg.CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.diisk.airpg.CustomList.Filterable.Filter;

public class CustomList <T>{
	
	private Object[] list = new Object[0];
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		return (T[]) list;
	}
	
	public int size() {
		return list.length;
	}

	public void add(T arg0) {
		list = add(list, arg0);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> toList(){
		List<T> r = new ArrayList<T>();
		for(Object t:list) {
			r.add((T) t);
		}
		return r;
	}
	
	public void shuffle() {
		Object[] mod = copy(this.list);
		Object[] list = new Object[0];
		Random r = new Random();
		while(mod.length>0) {
			int i = r.nextInt(mod.length);
			list = add(list, mod[i]);
			mod = remove(mod, i);
		}
		this.list = list;
	}
	
	public void revert() {
		Object[] list = new Object[size()];
		for(int i=0;i<size();i++) {
			list[i] = this.list[size()-(i+1)];
		}
		this.list = list;
	}
	
	public void clear() {
		list = new Object[0];
	}
	
	public void orderBy(int id, boolean alphabetical, boolean decrescent) {
		list = Ordenable.order((CustomList<? extends Ordenable>) this, id, alphabetical, decrescent).list;
	}
	
	public void filterBy(Filter...filters) {
		list = Filterable.filter((CustomList<? extends Filterable>) this, filters).list;
	}
	
	private static Object[] copy(Object[] list) {
		Object[] mod = new Object[list.length];
		for(int i=0;i<list.length;i++) {
			mod[i] = list[i];
		}
		return mod;
	}
	
	public void addAll(T[] arg0) {
		if(arg0.length>0) {
			Object[] mod = new Object[size()+arg0.length];
			for(int i=0;i<size();i++) {
				mod[i] = list[i];
			}
			for(int i=0;i<arg0.length;i++) {
				mod[i+size()] = arg0[i];
			}
			list = mod;
		}
	}
	
	public CustomList<T> copy(){
		CustomList<T> r = new CustomList<T>();
		r.addAll(toArray());
		return r;
	}
	
	private boolean contains(Object[] list, Object arg0) {
		for(int i=0;i<list.length;i++) {
			if(list[i].equals(arg0)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(T arg0) {
		return contains(list, arg0);
	}
	
	private static Object[] add(Object[] list, Object arg0) {
		if(arg0!=null) {
			Object[] mod = new Object[list.length+1];
			mod[list.length] = arg0;
			for(int i=0;i<list.length;i++) {
				mod[i] = list[i];
			}
			return mod;
		}
		return list;
	}
	
	private static Object[] remove(Object[] list, int arg0) {
		if(arg0>=0&&arg0<list.length) {
			Object[] mod = new Object[list.length-1];
			for(int i=0;i<list.length;i++) {
				if(i<arg0) {
					mod[i] = list[i];
				}else if(i>arg0) {
					mod[i-1] = list[i];
				}
			}
			return mod;
		}else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public T get(int i) {
		if(i>=0&&i<size()) {
			return (T) list[i];
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public void remove(int arg0) {
		list = remove(list, arg0);
	}



}
