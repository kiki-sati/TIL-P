package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	//주입받기
	@Autowired
	private Restaurant restaurant;

	// 스프링컨텍스 상에 샘플 호텔 객체가 있으면 넣어 달라고 요청

	@Autowired
	private SampleHotel hotel;

	@Test
	public void testHotel() {
		log.info(hotel);

	}

	
	@Test
	public void test1() {
		System.out.println("test1.............");
		log.info("test1.............");
		log.info(restaurant);
		
	}
	

}
