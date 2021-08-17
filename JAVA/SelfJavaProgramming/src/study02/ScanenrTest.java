package study02;

import java.util.Scanner;





public class ScanenrTest {
	
	// Scanner를 이용하여 이름, 도시, 나이, 체중, 독신 여부를 입력 받고 다시 출력하는 프로그램을 작성하기

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요>>");
		String name = sc.next();
		System.out.println("사는 도시를 입력하세요>>");
		String city = sc.next();
		System.out.println("나이를 입력하세요>>");
		String age = sc.next();
		System.out.println("체중을 입력하세요>>");
		double weight = sc.nextDouble();
		System.out.println("독신 여부를 입력하세요(싱글 or 있음)>>");
		String qna = sc.next();
		
		
		//조건에 따라 결과가 나오게 설정. 					
		String msg = null;
		if (qna.equals("싱글")){
			msg = "싱글입니다.";
		} else {
			msg = "만나는 사람이 있습니다.";
		}
		
		System.out.println();
		System.out.println("-------사용자 입력 정보-------");
		System.out.println();
		
		System.out.println("이름 : " + name +","+ "도시 : "+ city +"," + "나이 : "+ age +"," +
							"체중 : " + weight +"," + "독신여부 : " + msg);
		

	}

}
