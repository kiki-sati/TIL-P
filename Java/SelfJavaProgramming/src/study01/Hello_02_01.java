package study01;


public class Hello_02_01 {
	public static double sum(double n, double m) {
		return n + m;
	}

	// main() 메소드에서 실행 시
	public static void main(String[] args) {
		/*
		 * int -> float 20 -> 20.1
		 */

		double i = 20.0;
		double s;
		char a;
		s = sum(i, 10.0); // sum() 메소드 호출
		a = '?';
		System.out.println(a); // 문자 '?' 화면 출력
		System.out.println("Hello"); // "Hello" 문자열 화면 출력
		System.out.println(s); // 정수 s 값 화면 출력
	}

}
