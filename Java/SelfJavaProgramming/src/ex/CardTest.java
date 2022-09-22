package ex;

import javax.swing.text.Caret;

public class CardTest {
	

	public static void main(String[] args) {
		
		// 객체생성
		Card c1 = new Card();
		c1.kind = "HEART";
		c1.number = 7;
		
		//인스턴스변수의 값을 변경
		Card c2 = new Card();
		c2.kind = "Spade";
		c2.number = 4;
		
		System.out.println("c1은 " + c1.kind + "," + c1.number + "이며, 크기는 (" + 
							Card.width + "," + Card.height+") 입니다.");
		
		System.out.println("c2은 " + c2.kind + "," + c2.number + "이며, 크기는 (" + 
				Card.width + "," + Card.height+") 입니다.");
		
		// width와 height의 값을 변경 (클래스변수)
		Card.height = 50;
		Card.width = 80;
		
		System.out.println("c1은 " + c1.kind + "," + c1.number + "이며, 크기는 (" + 
							Card.width + "," + Card.height+") 입니다.");

		System.out.println("c2은 " + c2.kind + "," + c2.number + "이며, 크기는 (" + 
							Card.width + "," + Card.height+") 입니다.");
		

	}

}

class Card{
	// iv (인스턴스 변수)
	String kind;
	int number;
	
	// cv (클래스변수)
	static int width = 100;
	static int height = 250;
}