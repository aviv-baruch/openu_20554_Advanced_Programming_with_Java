package q2;

import java.util.ArrayList;
import java.util.Arrays;

public class TemperatureData {
    // Temperature data for each year
    final private ArrayList<ArrayList<Integer>> temperatureData = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(50, 31, 12, 42, 47, 6, 24, 35, 9, 45, 39, 16)),
            new ArrayList<>(Arrays.asList(19, 10, 34, 41, 8, 30, 46, 28, 48, 13, 22, 1)),
            new ArrayList<>(Arrays.asList(50, 0, 33, 2, 27, 25, 36, 23, 43, 17, 20, 14)),
            new ArrayList<>(Arrays.asList(49, 26, 4, 29, 5, 0, 44, 38, 18, 7, 50, 32)),
            new ArrayList<>(Arrays.asList(37, 11, 15, 31, 42, 9, 19, 47, 16, 12, 6, 25))
    ));
    // Available years for temperature data
    final private ArrayList<Integer> years = new ArrayList<>(Arrays.asList(2018, 2019, 2020, 2021, 2022));

    /**
     * Returns the temperature data for a given year.
     *
     * @param year The year for which to retrieve the temperature data.
     * @return The temperature data for the given year.
     */
    public ArrayList<Integer> getTemperatureForYear(int year) {
        // Find the index of the year
        int index = this.years.indexOf(year);
        // Return the temperature data at that index
        return this.temperatureData.get(index);
    }
}
