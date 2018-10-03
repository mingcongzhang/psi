package psi.componentwise.eval;
/**
 * Assure UserKey returns correct userid
 * @author Greg Smith
 * @result String will contain correct UserKey userid information
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetUserID {

	@Test
	public void testGetUserID() {
		UserKey key = new UserKey("testString1", "testString2");
		
		String result = key.getUserID();
		
		assertEquals("testString2", result);
	}

}
