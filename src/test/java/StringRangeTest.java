import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringRangeTest {

    private static String alphabetically(String name){
        return Switcher.switcher(name)
                .in(null,"Bob", true,
                        "Before Bob")
                .in("Bob","Tom", true,
                        "between Bob and Tom")
                .in( "Tom",null, true,
                        "after Tom")
                .orElse("Bob or Tom");
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
