package com.delhicoders.saarthi.dummy;

import com.delhicoders.saarthi.models.RoutePlace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    private static String[] nameArray = {"Amer Fort", "City Palace", "Nahargarh fort", "Choki Dhani"};
    private static String[] timeArray = {"10 min", "20 min", "30 min", "40 min"};
    private static double[] latArray = {26.9855, 26.9258, 26.9372, 26.9124};
    private static double[] lngArray = {75.8513, 75.8237, 75.8152, 75.7873};
    private static final ArrayList<RoutePlace> ITEMS = new ArrayList<>();

    public static ArrayList<RoutePlace> getDummyPlaces() {
        if (ITEMS.size() == 0) {
            for (int i = 0; i < nameArray.length; i++) {
                RoutePlace item = new RoutePlace(nameArray[i], timeArray[i]);
                item.latitude = latArray[i];
                item.longitude = lngArray[i];
                ITEMS.add(item);
            }
        }
        return ITEMS;
    }
}
