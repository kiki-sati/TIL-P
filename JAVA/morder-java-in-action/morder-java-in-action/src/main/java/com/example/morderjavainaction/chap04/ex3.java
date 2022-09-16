package com.example.morderjavainaction.chap04;

import static com.example.morderjavainaction.chap04.Dish.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ex3 {

	public static void main(String[] args) {
		// 컬렉션 - for-each (외부반복)
		List<String> names = new ArrayList<>();
		// 메뉴 리스트를 명시적으로 순차 반복함
		for (Dish dish : menu) {
			names.add(dish.getName()); //이름을 추출해서 리스트에 추가
		}

		System.out.println("names = " + names);

		// 스트림 (내부반복)
		List<String> names2 = menu.stream()
			.map(Dish::getName)
			.collect(toList());

		System.out.println("names2 = " + names2);
	}
}
