package study03;

import java.util.Scanner;

//어떤 값을 받아서, 그 값이 소수인지 아닌지를 판단하는 프로그램을 만들기!
//소수 => 약수가 1과 자기 자신만 있는 숫자에요.
//2, 3, 5, 7, 11, 13
//2
//"소수입니다."
//6
//"소수가 아닙니다."

public class PrimTest {

	public static void main(String[] args) {
		System.out.println("2이상의 숫자를 입력해주세요.");
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		
		int i =2;
		while (i<x) {
			if(x%i==0) {
				System.out.println("소수가 아닙니다.");
				break;
			}
			i+=1;
			if(i==x) {
				System.out.println("소수입니다.");
			}
		}
		sc.close();
		}
	}

