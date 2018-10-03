package psi.componentwise.eval;

import static org.junit.Assert.*;

import org.junit.Test;
public class TestQuestionFour {

    @Test
    public void customTestsForQuestion2() {
        UserKey b1 = new UserKey("Bill Smith", "BSMITH");
        UserKey b2 = new UserKey("Bill Smith", "BSMITH");
        UserKey b3 = new UserKey("Susan Smith", "SSMITH");
        UserKey b4 = new UserKey(null,null);

        assertEquals(b1, b1);
        assertEquals(b1, b2);
        assertNotEquals(b1, b3);
        assertNotEquals(b1, null);
        assertNotEquals(b1, "Some String");
        assertNotEquals(b4, b1);

        java.util.Hashtable ht = new java.util.Hashtable();
        ht.put(b1,"Some Data");
        String s = (String) ht.get(b2);

        assertEquals(s, "Some Data");
    }

}
