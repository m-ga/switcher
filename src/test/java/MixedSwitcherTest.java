import org.junit.Test;

import java.time.LocalDate;

import static java.time.DayOfWeek.*;
import static org.junit.Assert.assertEquals;

public class MixedSwitcherTest {

    private String weekPart(LocalDate date){
        return Switcher.switcher(date.getDayOfWeek())
                .range(MONDAY, THURSDAY,
                        "work")
                .option(FRIDAY,
                        "almost weekend")
                .option(SATURDAY, SUNDAY,
                        "weekend")
                .byDefault("something went wrong");
    }

    @Test
    public void shouldRecognizeRange(){
        assertEquals("work", weekPart(LocalDate.of(2001,1,1)));
        assertEquals("work", weekPart(LocalDate.of(2001,1,2)));
        assertEquals("work", weekPart(LocalDate.of(2001,1,3)));
        assertEquals("work", weekPart(LocalDate.of(2001,1,4)));
    }

    @Test
    public void shouldRecognizeSingleValue(){
        assertEquals("almost weekend", weekPart(LocalDate.of(2001,1,5)));
    }

    @Test
    public void shouldRecognizeDoubleValue(){
        assertEquals("weekend", weekPart(LocalDate.of(2001,1,6)));
        assertEquals("weekend", weekPart(LocalDate.of(2001,1,7)));
    }

}
