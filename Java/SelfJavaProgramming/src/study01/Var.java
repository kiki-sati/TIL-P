package study01;


public class Var {

	public static void main(String[] args) {
		var price = 200;	//price는 int 타입으로 결
		var name = "kitae"; //name은 String 타입으로 결
		var pi = 3.14;		// pi는 double 타입으로 결정
		
		System.out.println("price = " + (price + 1000));
		System.out.println("name = " + name);
		System.out.println("pi = " + (Math.round(pi)));
		System.out.println((int)pi); // 3 강제 타입변환으로 소수점 제거 
		
	}

}
