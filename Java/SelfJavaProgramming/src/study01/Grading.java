package study01;

//2-13 : 다중 if-else문을 이용하여 입력 받은 성적에 대해 학점을 부여하는 
//       프로그램을 작성하라. 

import java.util.Scanner;

public class Grading {

	public static void main(String[] args) {
		// 점수선언 (else 생략)
		char grade ='F';
		Scanner sc = new Scanner(System.in);

		System.out.println("점수를 입력하세요: ");
		int num = sc.nextInt();

		// A는 90점~100점
		if (num >= 90) {
			grade = 'A';

			// B는 80점 이상
		} else if (num >= 80) {
			grade = 'B';

			// C는 70점 이상
		} else if (num >= 70) {
			grade = 'C';

			// D는 60점 이상
		} else if (num >= 60) {
			grade = 'D';

			// 나머지는 F
		//} else {
			//grade = 'F';

		}
		System.out.println("학점은" + grade + "입니다.");
		sc.close();
	}
}