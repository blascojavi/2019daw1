
import org.junit.Test;

import static org.junit.Assert.*;

public class MensAndWomensTest {


@Test
public void calcNumberOfMen() {
        MensAndWomens testCalcMens = new MensAndWomens();
        int expected = 6;

        assertEquals(expected , testCalcMens.calcNumberOfMen(10,4) );
        }
}