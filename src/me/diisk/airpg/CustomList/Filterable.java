package me.diisk.airpg.CustomList;



public interface Filterable {

	public class Filter {
		private int id;
		private Object object;
		
		public Filter(int id, Object object) {
			this.id=id;
			this.object=object;
		}
	}
	
	public abstract Object getObject(int id);
	
	public static  CustomList<?> filter(CustomList<? extends Filterable> cl, Filter...filters) {
		CustomList<Object> r = new CustomList<Object>();
		con:
		for(int i=0;i<cl.size();i++) {
			Filterable fa = cl.get(i);
			for(Filter ff:filters) {
				if(fa.getObject(ff.id)!=ff.object) {
					continue con;
				}
			}
			r.add(fa);
		}
		return r;
	}
	
}
