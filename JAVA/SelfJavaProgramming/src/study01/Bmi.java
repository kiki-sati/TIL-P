package study01;

import java.util.Scanner;

public class Bmi {

	public static void main(String[] args) {
		
		System.out.println("==========================");
		System.out.println("=====나의 체질량지수(BMI)===== ");
		System.out.println("==========================");
		
		Scanner s = new Scanner(System.in);
		System.out.println("키를 입력하세요");
		double height = s.nextDouble();
		System.out.println("몸무게를 입력하세요");
		double weight = s.nextDouble();
		double bmi = weight / (height*height) * 10000;
		
		System.out.println("당신의 BMI 지시수는 " + (String.format("%.2f",bmi)) + "입니다.");
		

	}

}
