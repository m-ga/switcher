import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerRangeTest {

    private static String nameRange(Integer number){
        return Switcher.switcher(number)
                .range(null,0,
                        "below zero")
                .range(1,2,
                        "one or two")
                .range(4,null,
                        "four or more")
                .byDefault("three");
    }

    @Test
    public void shouldMatchRangeWithNullFrom(){
        assertEquals("below zero", nameRange(-1));
        assertEquals("below zero", nameRange(0));
    }

    @Test
    public void shouldMatchRangeWithNonNullFromAndTo(){
        assertEquals("one or two", nameRange(1));
        assertEquals("one or two", nameRange(2));
    }

    @Test
    public void shouldReturnDefaultValue() {
        assertEquals("three", nameRange(3));
    }

    @Test
    public void shouldMatchRangeWithNullTo(){
        assertEquals("four or more", nameRange(4));
        assertEquals("four or more", nameRange(5));
    }

}
