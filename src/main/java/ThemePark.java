import attractions.Attraction;
import behaviours.IReviewed;
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
}
