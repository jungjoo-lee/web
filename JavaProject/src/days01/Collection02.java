package days01;

import java.util.ArrayList;

public class Collection02 {
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add(10);
		a.add(1.1);
		a.add("Hello");
		
		Integer i0 = (Integer)a.get(0);
		Double i1 = (Double)a.get(1);
		String i2 = (String)a.get(2);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for (int i = 0; i < a.size(); i++) {
			int b = list.get(i);
			System.out.printf("list[%d] = %d\t\t", i ,b);
		}
	}
}
