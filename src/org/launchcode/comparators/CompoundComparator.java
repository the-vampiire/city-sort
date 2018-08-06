package org.launchcode.comparators;
import org.launchcode.City;
import java.util.Comparator;

public class CompoundComparator implements Comparator<City> {
    private Comparator<City>[] comparators;

    private Comparator<City>[] mapComparators(String[] comparisonOrder) {
        Comparator<City>[] output = new Comparator[comparisonOrder.length];
        int index = 0;
        for (String comparatorName : comparisonOrder) {
            output[index] = this.getComparator(comparatorName);
            ++index;
        }
        return output;
    }

    private Comparator<City> getComparator(String name) {
        switch (name) {
            case "name": return new NameComparator();
            case "area": return new AreaComparator();
            case "state": return new StateComparator();
            case "population": return new PopulationComparator();
            default:
                throw new IllegalArgumentException(String.format(
                        "Comparator [%s] does not exist", name
                ));
        }
    }

    public CompoundComparator(String[] comparisonOrder) {
        this.comparators = this.mapComparators(comparisonOrder);
    }


    @Override
    public int compare(City o1, City o2) {
        int comparison = 0;
        for (Comparator<City> comparator : this.comparators) {
            comparison = comparator.compare(o1, o2);
            if (comparison != 0) break;
        }
        return comparison;
    }
}
