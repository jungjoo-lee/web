package days01;

import java.util.ArrayList;
import java.util.Vector;

public class Collection01 {
	public static void main(String[] args) {
		Vector v = new Vector();
		ArrayList a = new ArrayList();
		
		v.add(10);
		v.add(20);
		v.add(30);
		
		a.add(10);
		a.add(20);
		a.add(30);
		
		int b = (Integer)a.get(0);
		
		for (int i = 0; i < v.size(); i++) {
			b = (Integer)v.get(i);
			System.out.printf("v[%d] = %d\t\t", i , b);
		}
	}
}
