package com.example.morderjavainaction.chap04;

import static com.example.morderjavainaction.chap04.Dish.*;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Collectors;

public class ex02 {

	public static void main(String[] args) {
		List<String> threeHighCaloricDishNames = menu.stream() // 메뉴 리스트에서 스트림을 얻음
			//파이프라인 연산 만들기 -> 고칼로리 요리를 필터링
			.filter(dish -> dish.getCalories() > 300).map(Dish::getName) // 요리명 추출
			.limit(3) // 선착순 3개
			.collect(toList()); // 결과 다른 리스트 저장

		System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);
	}
}
