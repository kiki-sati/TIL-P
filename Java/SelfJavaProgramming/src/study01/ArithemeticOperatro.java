//초단위 정수를 입력받고, 몇 시간, 몇 분 ,몇 초인지 구하여 출력하는 프로그램.

package study01;

import java.util.Scanner;

public class ArithemeticOperatro {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int time = scanner.nextInt();	//정수 입력
		int second = time % 60; //60으로 나눈 나머지는 초
		int minute = (time / 60) % 60; // 60으로 나눈 몫을 다시 60으로 나눈 나머지는 분
		int hour = (time / 60 )/60; //60으로 나눈 목을 다시 60으로 나눈 몫은 시간
		
		System.out.println(time + "초는");
		System.out.println(hour + "시간, ");
		System.out.println(minute + "분, ");
		System.out.println(second + "초입니다. ");
		scanner.close();

	}

}
