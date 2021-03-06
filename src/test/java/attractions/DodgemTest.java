package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor youngVisitor;
    Visitor oldVisitor;

    @Before
    public void setUp() {
        dodgems = new Dodgems("Bumper Cars", 5);
        youngVisitor = new Visitor(9, 130, 20.00);
        oldVisitor = new Visitor(14, 150, 20.00);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void canGetDefaultPrice() {
        assertEquals(4.50, dodgems.defaultPrice(), 0.001);
    }

    @Test
    public void canGetCheapEntryIfYoung() {
        assertEquals(2.25, dodgems.priceFor(youngVisitor), 0.001);
    }

    @Test
    public void hasToPayFullPriceIfOld() {
        assertEquals(4.50, dodgems.priceFor(oldVisitor), 0.001);
    }

    @Test
    public void canIncrementVisitorCount() {
        dodgems.incrementVisitCount();
        assertEquals(1, dodgems.getVisitCount());
    }
}
