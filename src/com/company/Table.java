package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Table {
	void makeTable(int i, Node node) {
		HashMap<Integer, Node> hmap = new HashMap<Integer, Node>();
		//Adding elements to HashMap
		hmap.put(i, node);
		try
		{
			FileOutputStream fos =
				new FileOutputStream("nodes.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hmap);
			oos.close();
			fos.close();
			System.out.printf("Serialized HashMap data is saved in hashmap.ser");
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
