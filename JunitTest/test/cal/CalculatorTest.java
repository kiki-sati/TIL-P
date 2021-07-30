package cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	//private Calculator calculator = new Calculator();
	private Calculator calculator;
	
	@Before
	public void setup() {
		calculator = new Calculator();
		System.out.println("setup()");

	}

	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();
		System.out.println(calculator.add(10,2));
	}

	@Test
	public void testSubstract() {
		Calculator calculator = new Calculator();
		assertEquals(9,  calculator.substract(20, 10));
	}

	@Test
	public void testMultiply() {
		assertEquals(9,  calculator.multiply(3, 3));		
	}

	@Test
	public void testDivide() {
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown");
	}

}
