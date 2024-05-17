package days0503;

import lombok.Data;

@Data
class Line {
	int x;
	int y;
	
	Line(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Extends06_Object03 {
	public static void main(String[] args) {
		// 객체들간의 비교
		String s1 = "Hello";
		String s2 = "Hello";
		
		if (s1 == s2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		String s3 = new String("Hello");
		String s4 = new String("Hello");
		
		if (s3 == s4)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		if (s3.equals(s4))
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		Line a1 = new Line(20, 30);
		Line a2 = new Line(20, 30);
		
		if (a1 == a2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		if (a1.equals(a2))
			System.out.println("같다");
		else
			System.out.println("다르다");
	}
}