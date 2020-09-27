package me.diisk.airpg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class ObjectRAW{

	
	private ObjectRAW() {}
	
	public static <T extends Serializable> boolean objectToFile(T object, String dir) {
		File file = new File(dir).getParentFile();
		if(!file.exists()) {
			file.mkdirs();
		}
		try {
			FileOutputStream fos = new FileOutputStream(dir);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			return true;
		}catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Object fileToObject(String dir) {
		Object r = null;
		try {
			File file = new File(dir);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			r = ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return r;
	}
}
