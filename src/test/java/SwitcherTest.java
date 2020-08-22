import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class SwitcherTest {

    private String trivialSwitcher(Integer number){
        return Switcher.switcher(number)
                .val(null,
                        "null")
                .val(1,
                        "one")
                .val(2,
                        "two")
                .val(3,4,
                        "three or four")
                .val(5,
                        "five")
                .orElse("a lot");
    }

    @Test
    public void trivialCases(){
        assertEquals("one",trivialSwitcher(1));
        assertEquals("two",trivialSwitcher(2));
        assertEquals("five",trivialSwitcher(5));
    }

    @Test
    public void shouldReturnWhenTargetIsNull(){
        assertEquals("null",trivialSwitcher(null));
    }

    @Test
    public void shouldReturnWhenDoublePossibilities(){
        assertEquals("three or four",trivialSwitcher(3));
        assertEquals("three or four",trivialSwitcher(4));
    }

    @Test
    public void shouldReturnDefaultValue(){
        assertEquals("a lot",trivialSwitcher(6));
    }

}
