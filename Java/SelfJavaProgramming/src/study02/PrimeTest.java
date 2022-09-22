package study02;

import java.util.Scanner;


// 2이상의 숫자를 입력받고, 
// 그 수를 소인수분해하여,
// 약수를 프린트해주는 프로그램
// 약수 -> 1과 자기자신은 모두 포함된다.

public class PrimeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("2 이상의 숫자를 입력하시오>>");
		int num = sc.nextInt();
		for (int i = 2; i <=num; i++) {
			if (num % i == 0) {
				System.out.println(num/i);
				
			}else {
				System.out.println();
				
			}
		}
	}
}
