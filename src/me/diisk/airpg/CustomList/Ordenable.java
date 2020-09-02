package me.diisk.airpg.CustomList;

public interface Ordenable {

	public abstract double getNumberValue(int id);
	
	public abstract String getStringValue(int id);
	
	public static CustomList<?> order(CustomList<? extends Ordenable> cl, int id, boolean alphabetical, boolean crescent) {
		CustomList<Object> r = new CustomList<Object>();
		CustomList<? extends Ordenable> mod = cl.copy();
		if(alphabetical) {
			if(crescent) {
				while(mod.size()>0) {
					Ordenable m = null;
					int pos = -1;
					for(int i=0;i<mod.size();i++) {
						Ordenable o = mod.get(i);
						if(m==null) {
							m=o;
							pos=i;
						}else {
							if(comeAfterThat(o.getStringValue(id), m.getStringValue(id))) {
								m=o;
								pos=i;
							}
						}
					}
					mod.remove(pos);
					r.add(m);
				}
			}else {
				while(mod.size()>0) {
					Ordenable m = null;
					int pos = -1;
					for(int i=0;i<mod.size();i++) {
						Ordenable o = mod.get(i);
						if(m==null) {
							m=o;
							pos=i;
						}else {
							if(comeBeforeThat(o.getStringValue(id), m.getStringValue(id))) {
								m=o;
								pos=i;
							}
						}
					}
					mod.remove(pos);
					r.add(m);
				}
			}
		}else {
			if(crescent) {
				while(mod.size()>0) {
					Ordenable m = null;
					int pos = -1;
					for(int i=0;i<mod.size();i++) {
						Ordenable o = mod.get(i);
						if(m==null) {
							m=o;
							pos=i;
						}else {
							if(o.getNumberValue(id)>m.getNumberValue(id)) {
								m=o;
								pos=i;
							}
						}
					}
					mod.remove(pos);
					r.add(m);
				}
			}else {
				while(mod.size()>0) {
					Ordenable m = null;
					int pos = -1;
					for(int i=0;i<mod.size();i++) {
						Ordenable o = mod.get(i);
						if(m==null) {
							m=o;
							pos=i;
						}else {
							if(o.getNumberValue(id)<m.getNumberValue(id)) {
								m=o;
								pos=i;
							}
						}
					}
					mod.remove(pos);
					r.add(m);
				}
			}
		}
		return r;
	}
	
	static boolean comeBeforeThat(String str1, String str2) {
		if(str1!=null&&str2!=null) {
			if(str1.length()>0&&str2.length()>0) {
				char f1 = str1.charAt(0);
				char f2 = str2.charAt(0);
				if(f1 == str2.charAt(0)) {
					return comeBeforeThat(str1.replaceFirst(f1+"", ""), str2.replaceFirst(f1+"", ""));
				}else {
					String a = "0123456789ABCDEFGHIJKLMNOPWRSTUVWXYZ";
					if(a.contains(f1+"")&&a.contains(f2+"")) {
						if(a.indexOf(f1)<a.indexOf(f2)) {
							return true;
						}else {
							return false;
						}
					}else {
						if(a.contains(f1+"")) {
							return false;
						}else {
							return true;
						}
					}
				}
			}else {
				if(str1.length()<=0) {
					return true;
				}else {
					return false;
				}
			}
		}else {
			throw new NullPointerException();
		}
	}
	
	static boolean comeAfterThat(String str1, String str2) {
		if(str1!=null&&str2!=null) {
			if(str1.length()>0&&str2.length()>0) {
				char f1 = str1.charAt(0);
				char f2 = str2.charAt(0);
				if(f1 == str2.charAt(0)) {
					return comeAfterThat(str1.replaceFirst(f1+"", ""), str2.replaceFirst(f1+"", ""));
				}else {
					String a = "0123456789ABCDEFGHIJKLMNOPWRSTUVWXYZ";
					if(a.contains(f1+"")&&a.contains(f2+"")) {
						if(a.indexOf(f1)>a.indexOf(f2)) {
							return true;
						}else {
							return false;
						}
					}else {
						if(a.contains(f1+"")) {
							return true;
						}else {
							return false;
						}
					}
				}
			}else {
				if(str1.length()<=0) {
					return false;
				}else {
					return true;
				}
			}
		}else {
			throw new NullPointerException();
		}
	}
	
}
