package psi.componentwise.eval;
/**
 * Write object to stream then read from stream to assure object serialization
 * @author Greg Smith
 * @result The object written to the input stream is the same object as the one read from the stream
 */
import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

public class TestSerialization {

	@Test
	public void testSerializationMethod() throws IOException, ClassNotFoundException{
		UserKey key1 = new UserKey("testString1", "testString2");
		
		ByteArrayOutputStream bstream1 = new ByteArrayOutputStream();
		ObjectOutputStream ostream1 = new ObjectOutputStream(bstream1);

		ostream1.writeObject(key1);
		byte[] serialized = bstream1.toByteArray();
		
		ByteArrayInputStream bstream2 = new ByteArrayInputStream(serialized);
		ObjectInputStream istream = new ObjectInputStream(bstream2);
		
		Object key2 = istream.readObject();
		
		assertTrue(key2 instanceof UserKey);
		assertEquals(key1, key2);
	}

}
