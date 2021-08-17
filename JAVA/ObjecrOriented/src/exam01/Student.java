package exam01;

// 클래스 생성

public class Student{
	// 라이브러리로서의 코드 (필드, 생성자, 메소드)

	//실행하기위한 코드 (메인메서드)
	public static void main(String[] args) {
		Student s1 = new Student();
		System.out.println("s1 변수가 Student 객체를 참조합니다.");
		// Student 클래스의 인스턴스(객체)

		Student s2 = new Student();
		System.out.println("s2 변수가 Student 객체를 참조합니다.");
		// Student 클래스의 인스턴스(객체)
		// s1과 s2는 완전히 독립된 서로 다른 객체이다.

	}

}
