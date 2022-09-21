package com.example.morderjavainaction.chap04;

import static com.example.morderjavainaction.chap04.Dish.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ex01 {

	public static void main(String[] args) {

		// 자바 7
		getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

		System.out.println("---");

		// 자바 8
		getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);



		/**
		 * 멀티코어 아키텍쳐에서 병렬로 실행 할 수 있다.: stream() -> parallelStream()
		 *
		 */
		List<String> lowCaloricDishesName3 =
			menu.parallelStream()
				.filter(dish -> dish.getCalories() < 400)            // 400 칼로리 이하의 요리 선택
				.sorted(Comparator.comparing(Dish::getCalories)) // 칼로리로 요리 정렬
				.map(Dish::getName) // 요리명 추출
				.collect(toList()); // 모든 요리명을 리스트에 저장


		System.out.println("lowCaloricDishesName2 = " + lowCaloricDishesName3);

	}

	public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
		// 가비지 변수 - 컨테이너 역할만 하는 중간 변수
		List<Dish> lowCaloricDishes = new ArrayList<>();

		// 누적자 요소로 필터링
		for (Dish dish : menu) {
			if (dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}

		List<String> lowCaloricDishesName = new ArrayList<>();

		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish dish1, Dish dish2) {
				return Integer.compare(dish1.getCalories(), dish2.getCalories());
			}
		});

		for (Dish dish : lowCaloricDishes) {
			// 정렬된 리스트를 처리하면서 요리 이름 선택
			lowCaloricDishesName.add(dish.getName());
		}
		return lowCaloricDishesName;
	}

	public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
		return dishes.stream()
			.filter(dish -> dish.getCalories() < 400)            // 400 칼로리 이하의 요리 선택
			.sorted(Comparator.comparing(Dish::getCalories)) // 칼로리로 요리 정렬
			.map(Dish::getName) // 요리명 추출
			.collect(toList()); // 모든 요리명을 리스트에 저장

	}



}

