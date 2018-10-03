package psi.componentwise.eval;
/**
 * Assure UserKey returns correct name
 * @author Greg Smith
 * @result String will contain UserKey name information
 */import static org.junit.Assert.*;

import org.junit.Test;

public class TestGetName {

	@Test
	public void testGetName() {
		UserKey key = new UserKey("testString1", "testString2");
		
		String result = key.getName();
		
		assertEquals("testString1", result);
	}
}
