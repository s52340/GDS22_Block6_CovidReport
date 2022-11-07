package org.campus02.covidreporting;

import java.util.ArrayList;
import java.util.Hashtable;

public class CovidReportDemoApp {
    public static void main(String[] args) {

        ArrayList<Incidence> recordedValues = DataProvider.getData();
        CovidManager covidManager = new CovidManager(recordedValues);

        System.out.println("Count of recorded Records: " + recordedValues.size());

        System.out.println("totalIncidencesState = " + covidManager.groupByState());

        System.out.println("groupByDate(recordedValues) = " + covidManager.groupByDate());

        System.out.println("findHighestValue(recordedValues) = " + covidManager.findHighestValue());

        System.out.println("getAverageValueAfter(recordedValues, \"2021-10-01\") = " + covidManager.getAverageValueAfter("2021-10-01"));

        System.out.println("findDayStateWithHighestValues(recordedValues) = " + covidManager.findIncidenceWithHighestValues());

        System.out.println("getAllElementsByState(recordedValues) = " + covidManager.getAllElementsToState());

        System.out.println("findValuesAbove(recordedValues, 200) = " + covidManager.findValuesAbove(200));

    }
}
