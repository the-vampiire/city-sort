package org.launchcode;

import org.launchcode.comparators.CompoundComparator;
import org.launchcode.comparators.NameComparator;
import org.launchcode.comparators.StateComparator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<City> cities = CityData.loadData();

        // TODO - Use different comparators here
//        NameComparator comparator = new NameComparator();
//        cities.sort(comparator);

//        StateComparator stateComparator = new StateComparator();
//        cities.sort(stateComparator);

        String[] comparisonOrder = new String[]{"area", "population"};
        CompoundComparator compound = new CompoundComparator(comparisonOrder);
        cities.sort(compound);

        printCities(cities);

    }

    private static void printCities(ArrayList<City> cities) {

        System.out.println(City.getTableHeader());

        for(City c : cities) {
            System.out.println(c);
        }

    }
}

//    CITY NAME        STATE NAME                   POPULATION   AREA
/**
 * comparison order: "state", "name"
 * Bellevue            Washington                    122363      32.0
 * Everett             Washington                    103019      33.4
 * Kent                Washington                     92411      28.6
 * Renton              Washington                     90927      23.5
 * Seattle             Washington                    608660      83.9
 * Spokane             Washington                    208916      59.2
 * Tacoma              Washington                    198397      49.7
 * Vancouver           Washington                    161791      46.5
 */

/**
 * comparison order: "state", "area"
 * Renton              Washington                     90927      23.5
 * Kent                Washington                     92411      28.6
 * Bellevue            Washington                    122363      32.0
 * Everett             Washington                    103019      33.4
 * Vancouver           Washington                    161791      46.5
 * Tacoma              Washington                    198397      49.7
 * Spokane             Washington                    208916      59.2
 * Seattle             Washington                    608660      83.9
 */

/**
 * comparison order: "state", "population"
 * Renton              Washington                     90927      23.5
 * Kent                Washington                     92411      28.6
 * Everett             Washington                    103019      33.4
 * Bellevue            Washington                    122363      32.0
 * Vancouver           Washington                    161791      46.5
 * Tacoma              Washington                    198397      49.7
 * Spokane             Washington                    208916      59.2
 * Seattle             Washington                    608660      83.9
 */

/**
 * comparison order: "state", "area", "population"
 * Renton              Washington                     90927      23.5
 * Kent                Washington                     92411      28.6
 * Bellevue            Washington                    122363      32.0
 * Everett             Washington                    103019      33.4
 * Vancouver           Washington                    161791      46.5
 * Tacoma              Washington                    198397      49.7
 * Spokane             Washington                    208916      59.2
 * Seattle             Washington                    608660      83.9
 */

/**
 * comparison order: "area", "population" (area duplicates sorting by population)
 *
 * South Bend          Indiana                       101168      41.5
 * Simi Valley         California                    124237      41.5
 *
 * McAllen             Texas                         129877      48.3
 * Boston              Massachusetts                 617594      48.3
 *
 * College Station     Texas                          93857      49.6
 * Chula Vista         California                    243916      49.6
 *
 * Pueblo              Colorado                      106595      53.6
 * Killeen             Texas                         127921      53.6
 *
 * Cary                North Carolina                135234      54.3
 * Fort Collins        Colorado                      143986      54.3
 *
 * West Palm Beach     Florida                        99919      55.3
 * Murfreesboro        Tennessee                     108755      55.3
 *
 * Spokane             Washington                    208916      59.2
 * San Bernardino      California                    209924      59.2
 *
 * Wichita Falls       Texas                         104553      72.1
 * Midland             Texas                         111147      72.1
 * Grand Prairie       Texas                         175396      72.1
 * 
 * Des Moines          Iowa                          203433      80.9
 * Baltimore           Maryland                      620961      80.9
 *
 */
