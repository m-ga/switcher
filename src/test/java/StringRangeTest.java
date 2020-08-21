import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringRangeTest {

    private static String alphabetically(String name){
        return Switcher.switcher(name)
                .range(null,"Bob", true,
                        "Before Bob")
                .range("Bob","Tom", true,
                        "between Bob and Tom")
                .range( "Tom",null, true,
                        "after Tom")
                .byDefault("Bob or Tom");
    }

    @Test
    public void shouldMatchRangeWithNullFrom(){
        assertEquals("Before Bob", alphabetically("Adam"));
    }

    @Test
    public void shouldMatchRangeWithNonNullFromAndTo(){
        assertEquals("between Bob and Tom", alphabetically("Chris"));
        assertEquals("between Bob and Tom", alphabetically("Rob"));
    }

    @Test
    public void shouldReturnDefaultValue() {
        assertEquals("Bob or Tom", alphabetically("Bob"));
        assertEquals("Bob or Tom", alphabetically("Tom"));
    }

    @Test
    public void shouldMatchRangeWithNullTo(){
        assertEquals("after Tom", alphabetically("Zack"));
    }

}
