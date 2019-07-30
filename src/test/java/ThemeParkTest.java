import attractions.Attraction;
import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    private Dodgems dodgems;
    private Playground playground;
    private RollerCoaster rollerCoaster;
    private CandyflossStall candyflossStall;
    private IceCreamStall iceCreamStall;
    private TobaccoStall tobaccoStall;
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ThemePark themePark;
    private Visitor visitor1;

    @Before
    public void before() {
        dodgems = new Dodgems("Bumper Cars", 5);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 9);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        attractions = new ArrayList<Attraction>();
        attractions.add(dodgems);
        attractions.add(playground);
        attractions.add(rollerCoaster);
        stalls = new ArrayList<Stall>();
        stalls.add(candyflossStall);
        stalls.add(iceCreamStall);
        stalls.add(tobaccoStall);
        themePark = new ThemePark(attractions,stalls);
        visitor1 = new Visitor(20, 185, 50.00);
    }

    @Test
    public void themeParkHas3Attractions(){
        assertEquals(3, themePark.attractionsCount());
    }

    @Test
    public void themeParkHas3Stalls() {
        assertEquals(3, themePark.stallsCount());
    }

    @Test
    public void themeParkHas6ReviewedObjects() {
        assertEquals(6, themePark.getAllReviewed().size());
    }

    @Test
    public void canAllowAVisitorToVisitAnAttraction() {
        themePark.visit(visitor1, dodgems);
        assertEquals(1, visitor1.visitedAttractionsCount());
        assertEquals(1, dodgems.getVisitCount());
    }
}
//    ThemePark has a method visit(Visitor, Attraction) calls for the attraction to increment its visitCount by 1
//        and adds the attraction to the visitors visitedAttractions list.