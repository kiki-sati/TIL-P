package study02;

public class Multi {
	
	//곱하기 함수를 선언하여 void main에서 실행하기.
	
	void multi (int a, int b) {
		
		System.out.println("곱셈 : " + a + " x " + b + " = " + a*b );
		
	}

	public static void main(String[] args) {
		Multi mul = new Multi();
		
		mul.multi(5, 4);

	}

}
