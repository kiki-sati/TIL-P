package study02;

import java.util.Scanner;


public class Circle {
	
	//원의 면적과 둘레를 계산하여 출력하는 프로그램.
	
	public static void main(String[] args) {
		// 파이 상수 선언
		// 원의 둘레 : 2 x π x r , 월의 넓이 : π x r x r
		final double PI = 3.14d;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원의 반지름을 입력하세요>>");
		double r = sc.nextDouble();
		System.out.println("입력받은 반지름의 길이 : " + r);
		System.out.println("원의 둘레 : " + r * 2 * PI);
		System.out.println("원의 넓이 : " + PI * r * r);
		

		
	}

}
