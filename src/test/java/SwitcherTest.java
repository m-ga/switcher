import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class SwitcherTest {

    private String trivialSwitcher(Integer number){
        return Switcher.switcher(number)
                .option(null,
                        "null")
                .option(1,
                        "one")
                .option(2,
                        "two")
                .option(3,4,
                        "three or four")
                .option(5,
                        "five")
                .byDefault("a lot");
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
