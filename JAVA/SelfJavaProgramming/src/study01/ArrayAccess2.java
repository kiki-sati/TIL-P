package study01;

import java.util.Scanner;
// 최소값 뽑아보기 
public class ArrayAccess2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] intArray = new int[5];
		long min=10000000l;
		System.out.println("양수 5개를 입력하세요");
		
		for(int i=0; i<5;i++) {
			intArray[i] = sc.nextInt();
			if(intArray[i] < min)
				min = intArray[i];
		}
		System.out.println("가장 작은 수는" + min + "입니다.");
		
		sc.close();

	}

}
