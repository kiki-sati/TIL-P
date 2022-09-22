package study01;

import java.util.Scanner;

import study02.ScanenrTest;

public class NestedLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 구구단을 입력하시오>>");
		int gugu = sc.nextInt();
		
		// 단을 입력하면 단까지만 나오게 출력
		for(int i=1; i<=gugu; i++) {
			System.out.print(i + "*" + gugu + "=" + i*gugu);                                                                                
			System.out.print('\n');
		}

	}

}
