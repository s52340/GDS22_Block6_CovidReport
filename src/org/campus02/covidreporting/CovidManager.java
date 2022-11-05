package org.campus02.covidreporting;

import java.util.ArrayList;
import java.util.HashMap;

public class CovidManager {

    private ArrayList<Incidence> recordedValues;

    public CovidManager(ArrayList<Incidence> recordedValues) {
        this.recordedValues = recordedValues;
    }

    public HashMap<String, Integer> groupByState() {
        HashMap<String, Integer> result = new HashMap<>();
        // TODO: Je Bundesland soll die Anzahl der Fälle ermittelt werden

        return result;
    }

    public HashMap<String, Integer> groupByDate() {
        HashMap<String, Integer> result = new HashMap<>();
        // TODO: Je Tag (getDate()) soll die Anzahl der Fälle ermittelt werden

        return result;
    }

    public int findHighestValue() {
        // TODO: Es soll der höchste gemeldete Wert gefunden werden

        return 0;
    }

    public int getAverageValueAfter(String date) {
        /* TODO: Es soll der durchschnittliche Wert nach einem
            bestimmten Datum gefunden werden. date ist beispielsweise 2021-08-01 */
        return 0;
    }

    public Incidence findIncidenceWithHighestValues() {
        /* TODO: Es soll die Meldung (Incidence)
        mit dem höchsten Wert gefunden werden. Tipp: Es gibt schon eine Methode,
        die eventuell einen kleinen Teil erledigt*/


        return null;
    }

    public HashMap<String, ArrayList<Incidence>> getAllElementsToState() {
        // TODO: Alle Elemente je Bundesland retour liefern

        return null;
    }

    public ArrayList<Incidence> findValuesAbove(int referenceValue) {
        ArrayList<Incidence> result = new ArrayList<>();
        // TODO: Alle Werte über dem Referenzwert sollen retour geliefert werden

        return result;
    }
}
