package days02;

class MemberCall {
	int iv = 10; // 인스턴스 변수
	static int sv = 20; // 스태틱 변수
	
	void instanceMethod1() { // 인스턴스 메서드
		
	}
	
	static void staticMethod() { // 스태틱 메서드
		
	}
}

public class ClassStatic03 {
	public static void main(String[] args) {
		// 스태틱 멤버는 객체 생성없이 바로 사용이 가능
		MemberCall.sv = 300;
		MemberCall.staticMethod();
		
		// 인스턴스 메서드는 객체생성 후에 사용이 가능
		MemberCall mc = new MemberCall();
		mc.iv = 30;
		mc.instanceMethod1();
	}
}
