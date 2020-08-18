import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class SwitcherTest {

    private String trivialSwitcher(Integer number){
        return Switcher.switcher(number)
                .option("null",
                        null)
                .option("one",
                        1)
                .option("two",
                        2)
                .option("three or four",
                        3,4)
                .option("five",
                        5)
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
