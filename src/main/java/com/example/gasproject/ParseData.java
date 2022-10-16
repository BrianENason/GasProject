package com.example.gasproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ParseData {

    public static ArrayList<BasicCrudeOil> createCrudeOilData() throws IOException {
        ArrayList<BasicCrudeOil> crudeOilList = new ArrayList<>();

        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("Modified Crude Oil Price Historic.csv"));

            while ((line = br.readLine()) != null) {
                String[] parseLine = line.split(splitBy);
                BasicCrudeOil oilElement = new BasicCrudeOil(
                        parseLine[0], parseLine[1], parseLine[2]
                );
                crudeOilList.add(oilElement);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return crudeOilList;
    }

    public static ArrayList<BasicUnleadedGas> createUnleadedGasData() throws IOException {
        ArrayList<BasicUnleadedGas> unleadedGasList = new ArrayList<>();

        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("Modified Unleaded Gas Price Per Gallon Historic.csv"));

            while ((line = br.readLine()) != null) {
                String[] parseLine = line.split(splitBy);
                BasicUnleadedGas gasElement = new BasicUnleadedGas(
                        parseLine[0], parseLine[1]
                );
                unleadedGasList.add(gasElement);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return unleadedGasList;
    }

    public static ArrayList<BasicDiesel> createDieselData() throws IOException {
        ArrayList<BasicDiesel> dieselGasList = new ArrayList<>();

        String line = "";
        String splitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("Modified Diesel Price Per Gallon Historic.csv"));

            while ((line = br.readLine()) != null) {
                String[] parseLine = line.split(splitBy);
                BasicDiesel gasElement = new BasicDiesel(
                        parseLine[0], parseLine[1]
                );
                dieselGasList.add(gasElement);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return dieselGasList;
    }
}
