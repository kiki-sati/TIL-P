package study01;
// 2-11. if-else 사용하기
// 나이를 입력 받아 20대인지 판별하는 프로그램을 작성 
import java.util.Scanner;
public class Twenties {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		// 나이가 20-29 사이인지 확인
		if ((age>=20 && age<=29)) {
			System.out.print("20대이십니다.");
			System.out.println("청춘을 즐겨라 !!");
		} else {
			System.out.println("20대가 아닙니다.");
			System.out.println("평온한 하루 되세요");
		}
	}
}