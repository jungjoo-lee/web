package days0503;

class Animal {
	String name;
	int age;
	
	public void cry() {
		System.out.println("웁니다.");
	}
}

// 자식 클래스는 부모클래스에서 물려받은 메서드를 자신의 용도에 맞게 재정의(overriding) 할 수 있습니다.
// 메서드 오버라이딩은 자식클레스에서 부모클래스의 메서드의 내용을 다시 정의하는 문법입니다
// 메서드 오버라이딩으로 메서드를 재정의해서 자식클래스의 객체에서 사용하면 물려받은 메서드는 무시되고
// 새로 재정의한 매서드가 실행됩니다.
// 반드시 메서드의 이름과 리턴 자료형등이 같아야 합니다
// 부모의 재정의되기전 crying() 메서드를 일부러 호출하는것도 가능합니다
class Dog extends Animal {
	@Override
	public void cry() {
		System.out.println("개가 웁니다.");
	}	
}

class Cat extends Animal {
	@Override
	public void cry() {
		System.out.println("고양이가 웁니다.");
	}	
}

public class Extends04 {
	public static void main(String[] args) {

	}
}