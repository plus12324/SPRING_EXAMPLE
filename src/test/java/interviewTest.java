import static org.junit.Assert.*;

import org.junit.Test;


public class interviewTest {

	@Test
	public void test() {
		final int [] myArray = new int[] {0,2,3};//배열은 객채다!!!
		int[] objArray = myArray;
		
		objArray[0] = 100;
		String a = "1234";
		String b = "5677";
		a.equals(b);
		assertFalse(objArray[0] == 0);
	}

}
