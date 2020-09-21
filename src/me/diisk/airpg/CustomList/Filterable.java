package me.diisk.airpg.CustomList;



public interface Filterable {
	
	public abstract Object getObject(int id);
	
	public static  CustomList<?> filter(CustomList<? extends Filterable> cl, FilterableFilter...filters) {
		CustomList<Object> r = new CustomList<Object>();
		con:
		for(int i=0;i<cl.size();i++) {
			Filterable fa = cl.get(i);
			for(FilterableFilter ff:filters) {
				if(fa.getObject(ff.id)!=ff.object) {
					continue con;
				}
			}
			r.add(fa);
		}
		return r;
	}
	
}
