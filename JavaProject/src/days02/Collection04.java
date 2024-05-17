package days02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Collection04 {
	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<>();
		HashMap<Integer, String> hm = new HashMap<>();
		
		// Collection에 데이터를 추가하는 메서드 : put
		ht.put("One", 1);
		ht.put("Two", 2);
		ht.put("Three", 3);
		
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");
		
		// Collection에 데이터를 얻는 메서드 : get
		System.out.println(ht.get("Three"));
		System.out.println(hm.get(3));
		
		// 키값은 중복된 값으로 두개의 키값이 저장되지 않습니다.
		// 저장된 데이터들을 서로 구분하기 위해
		
		// 같은 키값으로 다른 value를 저장하면, 기존 value가 지워지고 새로운 value로 대체됩니다.
		
		// value 값은 다른 key 값으로 얼마든지 중복되어 저장될 수 있습니다.
		
		// 제네릭이 지정된 ArrayList에 아무 데이터나 다 저장하려면
		ArrayList<Object> list = new ArrayList<>();
		
		
	}
}
