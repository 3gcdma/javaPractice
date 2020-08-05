import java.util.Arrays;
import java.util.Comparator;

//인터페이스
interface Inter{
	void print(); //body
	
}
//클래스와 인터페이스의 관계 만들기 : 상속
// 오버라이딩
class A implements Inter{
	
	@Override
	public void print() {
		System.out.println("상속 받았쥐!");
	}
	
	public void print2() {
		System.out.println("상속 안받았쥐~");
	}
}

class MyArray{
	public void call(Inter i) {
		
	}
}


public class Study {
	public static void main(String[] args) {
		A a1 = new A();
		Inter i = new A();
		i.print();
		MyArray a = new MyArray();
		a.call(i);
		
		///내부 클래스를 이용한 방식 - > 보편적
		///내부클래스 중 익명 클래스를 많이 사용한다.
		/*
		 * 익명 클레스 형태 : new로 시작
		 * new 상속할 객체타입명() {
		 * 		메서드 정의
		 * 		멤버변수 정의
		 * 		등등
		 * };
		 * 
		 * 정의하는 익명클래스가 Inter 타입을 상속합니다.
		 * new Inter() {
		 * 		void print(){
		 * 			System.out.println("재정의");
		 * 		}
		 * };
		 */
		
		Inter i2 = new Inter() {
			public void print() {
				System.out.println("익명 재정의");
			}
		};
		
		a.call(i2);
		a.call(new Inter() {
			public void print() {
				System.out.println("익명 재정의");
			}
			});
		
		Arrays.sort(new String[] {"3","2","1"}, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return 0;
			}
			
		});
		
	}

}
