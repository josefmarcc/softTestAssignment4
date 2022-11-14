package JSONParser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class JSONParserTests {

    private JSONParser parser;
    @BeforeAll
    public void setUp() {
        parser = new JSONParser();
    }

    @Test
    public void testEmpty() {
        assertNull(parser.parse(""));
    }

    @Test
    public void testTrue() {
        assertTrue((Boolean) parser.parse("true"));
    }

    @Test
    public void testFalse() {
        assertFalse((Boolean) parser.parse("false"));
    }

    @Test
    public void testNumber() {
        assertEquals(parser.parse("0"), 0);
    }

    @Test
    public void testDouble() {
        assertEquals(parser.parse("0.1"), 0.1);
    }

    @Test
    public void testUnfinishedQuote() {
        assertNull(parser.parse("\""));
    }
    @Test
    public void testString() {
        assertEquals(parser.parse("\"aString\""),  "aString");
    }
}
