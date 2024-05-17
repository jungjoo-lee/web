package days0503;

// Object 클래스
// 개발자가 클래스하나를 새롭게 만들면 자동으로 상속(extends)되는 클래스입니다.
// 자바 내부에 존재하는 그리고 새롭게 만들어지는 모든 클래스는 보이진 않는 곳에 extends Object 가 존재합니다.
// 자바 내부에 존재하는 그리고 새롭게 만들어지는 모든 클래스의 부모클래스입니다
// 자바의 클래스는 한클래스당 하나의 부모클래스만 갖을 수 있습니다.
// Object 아닌 다른 클래스를 상속하면 그 클래스에서 extends Object가 지워집니다.
// 이렇게 extends Object 가 지워지는 경우는 상속받은 부모클래스가 이미 Object를 상속하고 있기때문에
// 결국 또 Object 의 자식(손자)클래스가 됩니다.

class UserClass {
	
}

public class Extends06_Object01 {
	public static void main(String[] args) {
		UserClass obj = new UserClass();
	}
}