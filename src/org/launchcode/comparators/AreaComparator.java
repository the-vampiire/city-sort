package org.launchcode.comparators;

import org.launchcode.City;

import java.util.Comparator;

public class AreaComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        double o1Area = o1.getArea();
        double o2Area = o2.getArea();
        double difference = o1Area - o2Area;

        if (difference > 0) return 1;
        else if (difference < 0) return -1;
        return 0;
    }

}
