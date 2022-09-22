package study01;

import java.util.Scanner;

public class ScannerEx2 {

	// 술을 마실 수 있는 나이인지 프로그램 만들기 
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("술 가능 여부 확인");
		System.out.println("나이를 입력하세요>>");
		int age = scanner.nextInt();
		
		// 19세 초과, 20대 이상가능 
		
		System.out.println((age>19)?("마실 수 있습니다."):("마실 수 없습니다."));
		
		scanner.close();
	}

}
