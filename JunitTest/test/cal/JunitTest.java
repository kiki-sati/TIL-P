package cal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {

	Calculator cal;

	@Before
	public void setup() {
		System.out.println("@Before 메서드 실행");
		cal = new Calculator();
	}

	@After
	public void tearDown() {
		System.out.println("@After 메서드 실행");
	}

	@BeforeClass
	public static void setupForClass() {
		System.out.println("@BeforeClass 메서드 실행");
	}

	@AfterClass
	public static void tearDownForClass() {
		System.out.println("@AfterClass 메서드 실행");
	}

	@Test(expected = RuntimeException.class) // 예외 발생을 예상
	public void test1() {
		System.out.println("@Test 단위 테스트 메서드  메서드 실행");
		throw new RuntimeException();
	}

	
	@Test(timeout = 100) // 100 millisecond 초과시 에러
	public void test2() {
		System.out.println("@Test 단위 테스트 메서드  메서드 실행");

		int a = 5;
		int b = 5;

		
		assertEquals("add 메서드 테스트", a + b, cal.add(a, b));
		assertEquals("minus 메서드 테스트", a - b, cal.substract(a, b));
		assertEquals("multiply 메서드 테스트", a * b, cal.multiply(a, b));
		assertEquals("divide 메서드 테스트", a/b, cal.divide(a, b));
		// fail(String)
		assertTrue(true);
		//assertNull("[assertNull]", "");
		assertNull("[assertNull]", null);
		assertNotNull("[assertNotNull]", "");
		//assertNotNull("[assertNotNull]", null);
		assertSame("[assertSame]", 1, 1);
		//assertSame("[assertSame]", 1, 10);
		//assertNotSame("[assertNotSame]", 1, 1);
		assertNotSame("[assertNotSame]", 1, 10);
		assertTrue("[assertTrue]", true);
		//assertTrue("[assertTrue]", false);
	}

}
