package study03;

import java.util.Scanner;

// 2 이상의 숫자를 입력받고, 그 수를 소인수분해하여, 약수를 프린트해주는 프로그램!
// 예: 입력: 12 --> 출력: 1, 2, 3, 4, 6, 12
// 힌트: 입력 받은 값을 X라고 했을 때, X의 약수들(a1, a2, a3....)은 X % a 를 했을 때 값이 0이다. 

public class DivisorTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2 이상의 숫자를 입력하시오>>");
		int num = sc.nextInt();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.println(i);
				
			}
		}
	}
}