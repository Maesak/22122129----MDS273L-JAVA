package lab_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lab7 {
    public static void main(String[] args) {
        // Load the iris dataset
        lab7 irisList =  ("iris (2).csv");
        lab7 allSummary = CalculateSummary(irisList);
        
        lab7 virginicaSummary = calculateSummary(filterBySpecies);
        lab7 setosaSummary = calculateSummary(filterBySpecies(irisList, "Iris-setosa"));
        lab7 versicolorSummary = calculateSummary(filterBySpecies(irisList, "Iris-versicolor"));
        lab7 virginicaSummary = calculateSummary(filterBySpecies(irisList, "Iris-virginica"));
        lab7 virginicaSummary = calculateSummary(filterBySpecies(irisList, "Iris-setosa"));
        System.out.println("All Species:");
        System.out.println(allSummary);
        System.out.println("Iris-setosa:");
        System.out.println(setosaSummary);
        System.out.println("Iris-versicolor:");
        System.out.println(versicolorSummary);
        System.out.println("Iris-virginica:");
        System.out.println(virginicaSummary);
        System.out.println();
    }

}
