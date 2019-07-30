import attractions.Attraction;
import attractions.Dodgems;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }

    public int attractionsCount() {
        return this.attractions.size();
    }

    public int stallsCount() {
        return this.stalls.size();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> allReviewed = new ArrayList<IReviewed>(this.attractions);
        ArrayList<IReviewed> allStalls = new ArrayList<IReviewed>(this.stalls);
        allReviewed.addAll(allStalls);

        return allReviewed;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.visitAttraction(attraction);
        attraction.incrementVisitCount();
    }
}

//    ThemePark has a method visit(Visitor, Attraction) calls for the attraction to increment its visitCount by 1
//        and adds the attraction to the visitors visitedAttractions list.