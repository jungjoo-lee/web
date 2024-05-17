package days0503;

import lombok.Data;

@Data
class Point {
	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Extends06_Object02 {
	public static void main(String[] args) {
		Point p = new Point(30, 20);
		
		System.out.println(p.toString());
	}
}