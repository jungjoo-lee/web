package days0503;

class NormalA {}

class NormalB {}

class SuperC {
   int superNum;
   
   void abc() {
      System.out.println("super method");
   }
}

class SubC extends SuperC {
   int subNum;
   
   public SubC(SuperC superC) {}
   
   void abc() {
      System.out.println("sub method");
   }
}

class SubSubC extends SubC {
	int subsubNum;
	
	public SubSubC(SubC subC) {
		super(subC);
	}
}

public class Extends05_TypeCasting {
	public static void main(String[] args) {
		SubSubC ssc = new SubSubC(new SubC(new SuperC()));
	}
}