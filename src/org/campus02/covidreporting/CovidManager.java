package org.campus02.covidreporting;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class CovidManager {
    // Incidence: state, date, int number
    //DataProvider: ArrayList<Incidence> getData()

    private ArrayList<Incidence> recordedValues;

    public CovidManager(ArrayList<Incidence> recordedValues) {
        this.recordedValues = recordedValues;
    }

    public HashMap<String, Integer> groupByState() {
        HashMap<String, Integer> result = new HashMap<>();
        // TODO: Je Bundesland soll die Anzahl (Incidence.getNumber()) der Fälle ermittelt werden
        /*
        for (int i = 0; i < recordedValues.size(); i++) {
            if ( i == 0 || !result.containsKey(recordedValues.get(i).getState())) {
                result.put(recordedValues.get(i).getState(), recordedValues.get(i).getNumber());
            } else {
                Integer value = result.get(recordedValues.get(i).getState());
                //result.remove(recordedValues.get(i).getState()); unnötig
                result.put(recordedValues.get(i).getState(), recordedValues.get(i).getNumber() + value);
            }
        }
        */
        //   iter !!!!
        for (Incidence incidence : recordedValues) {
            if (!result.containsKey(incidence.getState())) {
                result.put(incidence.getState(), incidence.getNumber());
            } else {
                Integer state = result.get(incidence.getState());
                //result.remove(recordedValue.getState()); unnötig
                result.put(incidence.getState(), incidence.getNumber() + state);
            }
        }

        return result;
    }

    public HashMap<String, Integer> groupByDate() {
        HashMap<String, Integer> result = new HashMap<>();
        // TODO: Je Tag (getDate()) soll die Anzahl (Incidence.getNumber()) der Fälle ermittelt werden

        for (int i = 0; i < recordedValues.size(); i++) {
            if (i == 0 || !result.containsKey(recordedValues.get(i).getDate())) {
                result.put(recordedValues.get(i).getDate(), recordedValues.get(i).getNumber());
            }
            else {
                Integer amountPerDay = (Integer) result.get(recordedValues.get(i).getDate());
                result.put(recordedValues.get(i).getDate(), recordedValues.get(i).getNumber() + amountPerDay);
            }
        }
        return result;
    }

    public int findHighestValue() {
        // TODO: Es soll der höchste gemeldete Wert (Incidence.getNumber()) gefunden werden
        int maxAmount = 0;
        for (int i = 0; i < recordedValues.size(); i++) {
            if (recordedValues.get(i).getNumber() > maxAmount){
                maxAmount = recordedValues.get(i).getNumber();
            }
        }
        return maxAmount;
    }

    public int getAverageValueAfter(String date) {
        /* TODO: Es soll der durchschnittliche Wert nach einem
            bestimmten Datum gefunden werden. date ist beispielsweise 2021-08-01 */
        int counter = 0;
        int value = 0;
        for (int i = 0; i < recordedValues.size(); i++) {
            if (date.equals(recordedValues.get(i).getDate())){
                value = value + recordedValues.get(i).getNumber();
                counter ++;
            }
        }
        int averageValue = value / counter;

        return averageValue;
    }

    public Incidence findIncidenceWithHighestValues() {
        /* TODO: Es soll die Meldung (Incidence)
        mit dem höchsten Wert gefunden werden. Tipp: Es gibt schon eine Methode,
        die eventuell einen kleinen Teil erledigt*/

        int highestValue = findHighestValue();
        Incidence incidence = recordedValues.get(highestValue);
        return incidence;
    }

    public HashMap<String, ArrayList<Incidence>> getAllElementsToState() {
        // TODO: Alle Elemente je Bundesland retour liefern
        HashMap<String, ArrayList<Incidence>> incidencePerBundesland = new HashMap<>();

        for (Incidence incident : recordedValues) {
            String bundesland = incident.getState();
            if (!incidencePerBundesland.containsKey(bundesland)){
                ArrayList<Incidence> listOfIncidents =  new ArrayList<>();
                incidencePerBundesland.put(bundesland, listOfIncidents);
            }

            ArrayList<Incidence> listOfIncidence = incidencePerBundesland.get(bundesland);
            listOfIncidence.add(incident);
            incidencePerBundesland.put(bundesland, listOfIncidence); //eigenlich unnötig

        }


        return incidencePerBundesland;
    }

    public ArrayList<Incidence> findValuesAbove(int referenceValue) {
        ArrayList<Incidence> result = new ArrayList<>();
        // TODO: Alle Werte über dem Referenzwert sollen retour geliefert werden
        for (int i = 0; i < recordedValues.size(); i++) {
            if (recordedValues.get(i).getNumber() > referenceValue){
                result.add(recordedValues.get(i));
            }
        }
        return result;
    }
}
