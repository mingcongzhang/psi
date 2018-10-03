package psi.componentwise.eval;
/**
 * Assure UserKey object correctly handles equality
 * @author Greg Smith
 * @result The two UserKey objects are considered equal
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestEquals {

	@Test
	public void testEqualsObject() {
		UserKey key1 = new UserKey("Test1", "Test2");
		UserKey key2 = new UserKey("Test1", "Test2");
		
		assertEquals((key1.equals(key1) && key2.equals(key2)), true);
		assertEquals(key1.hashCode() == key2.hashCode(), true);


	}

}
