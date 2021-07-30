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
		System.out.println("@Before �޼��� ����");
		cal = new Calculator();
	}

	@After
	public void tearDown() {
		System.out.println("@After �޼��� ����");
	}

	@BeforeClass
	public static void setupForClass() {
		System.out.println("@BeforeClass �޼��� ����");
	}

	@AfterClass
	public static void tearDownForClass() {
		System.out.println("@AfterClass �޼��� ����");
	}

	@Test(expected = RuntimeException.class) // ���� �߻��� ����
	public void test1() {
		System.out.println("@Test ���� �׽�Ʈ �޼���  �޼��� ����");
		throw new RuntimeException();
	}

	
	@Test(timeout = 100) // 100 millisecond �ʰ��� ����
	public void test2() {
		System.out.println("@Test ���� �׽�Ʈ �޼���  �޼��� ����");

		int a = 5;
		int b = 5;

		
		assertEquals("add �޼��� �׽�Ʈ", a + b, cal.add(a, b));
		assertEquals("minus �޼��� �׽�Ʈ", a - b, cal.substract(a, b));
		assertEquals("multiply �޼��� �׽�Ʈ", a * b, cal.multiply(a, b));
		assertEquals("divide �޼��� �׽�Ʈ", a/b, cal.divide(a, b));
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
