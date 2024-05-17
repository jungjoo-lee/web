package days0503;

class SuperA {
	int superNum;
	
	SuperA() {
		System.out.println("하이1");
	}
}

class SubA extends SuperA {
	int subNum;
	
	SubA() {
		super();
		System.out.println("하이2");
	}
}

public class Extends02 {
	public static void main(String[] args) {
		SubA s1 = new SubA();
	}
}