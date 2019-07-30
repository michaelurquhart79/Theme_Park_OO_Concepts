package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor youngTall;
    Visitor youngShort;
    Visitor oldTall;
    Visitor oldShort;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        youngTall = new Visitor(10, 150, 20.00);
        youngShort = new Visitor(10, 130, 20.00);
        oldTall = new Visitor( 15, 210, 20.00);
        oldShort = new Visitor(20, 130, 20.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void notAllowedIfUnderAgeButTallEnough(){
        assertEquals(false, rollerCoaster.isAllowedTo(youngTall));
    }

    @Test
    public void notAllowedIfUnderAgeAndNotTallEnough(){
        assertEquals(false, rollerCoaster.isAllowedTo(youngShort));
    }

    @Test
    public void notAllowedIfOverAgeButNotTallEnough(){
        assertEquals(false, rollerCoaster.isAllowedTo(oldShort));
    }

    @Test
    public void AllowedIfOverAgeAndTallEnough(){
        assertEquals(true, rollerCoaster.isAllowedTo(oldTall));
    }


}
