package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@ToString
@RequiredArgsConstructor
//@AllArgsConstructor //생성자주입 
// Setter 주입
// 생성자 주입
// 필드 주입 : 별로 안좋음 
// 최근에 많이 사용 : final 주입(5점대 사용)

public class Restaurant {
	
	//@Setter(onMethod_ = {@Autowired}) 	//내부적으로 set메서드를 만들어준다.
	
	private final Chef chef;

}
