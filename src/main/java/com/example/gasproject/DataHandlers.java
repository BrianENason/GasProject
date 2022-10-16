package com.example.gasproject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataHandlers {
    public static ArrayList<BasicCrudeOil> crudeOilData;  // Array to hold data related to Crude Oil
    public static ArrayList<BasicUnleadedGas> unleadedGasData;  // Array to hold data related to Unleaded Gas
    public static ArrayList<BasicDiesel> dieselData;  // Array to hold data related to Diesel

    /**
     * This method simply creates the 3 arrays based on the data provided in the .csv files
     *
     * This should be called at the beginning of the program and NOT during it's course of running UNLESS a reset of
     * data is needed.
     *
     * FIXME: In future iterations, the data will be obtained using APIs to get the most up-to-date and/or using servers - NOT .csv files. The files are for training and example purposes only!
     *
     * @throws IOException
     */
    public static void createData() throws IOException {
        crudeOilData = ParseData.createCrudeOilData();  // Fill the Crude Oil Array with data
        unleadedGasData = ParseData.createUnleadedGasData();  // Fill the Unleaded Gas Array with data
        dieselData = ParseData.createDieselData();  // Fill the Diesel Array with data

        // FIXME: This is for debug only. Delete before release
        // System.out.println("Crude Oil Size: " + crudeOilData.size() + "\nUnleaded Gas Size: " + unleadedGasData.size() + "\nDiesel Size: " + dieselData.size());
    }

    /**
     * This method will return the smallest of 3 numbers input - in this case, the numbers will be the size of the arrays
     *
     * @return size that is the smallest
     */
    public static int smallestArray() {
        // This is based on the logic of: Math.min(z, (Math.min(x, y)));
        return Math.min(crudeOilData.size(), (Math.min(unleadedGasData.size(), dieselData.size())));
    }

    /**
     * This method will return the largest of 3 numbers input - in this case, the numbers will be the size of the arrays
     *
     * @return size that is the largest
     */
    public static int largestArray() {
        // This is based on the logic of: Math.max(z, (Math.max(x, y)));
        return Math.max(crudeOilData.size(), (Math.max(unleadedGasData.size(), dieselData.size())));
    }

    /**
     * This method will search all 3 arrays and return the name of the smallest one of them
     *
     * @return The name of the smallest array
     */
    public static String smallestArrayName() {
        int minSize = Math.min(crudeOilData.size(), (Math.min(unleadedGasData.size(), dieselData.size())));

        if (minSize == crudeOilData.size()) {return "Crude";}
        else if (minSize == unleadedGasData.size()){return "Unleaded";}
        else if (minSize == dieselData.size()) {return "Diesel";}
        else {return "N/A";}
    }

    /**
     * This method will be called to clean the erroneous data from the "Unleaded" array of values based on the
     * smallest array
     *
     * @param firstDate This is the first date in the smallest array to use as a starting point for the cleaning
     */
    private static void cleanUpUnleaded(LocalDate firstDate) {
        for (int i = 0; i < unleadedGasData.size(); ++i) {
            LocalDate matchDate = unleadedGasData.get(i).getReportDate();
            if (firstDate.isEqual(matchDate)) {
                int clearIndex = i;
                for (int j = 0; j < clearIndex; ++j) {
                    unleadedGasData.remove(0);
                }
            }
        }
    }

    /**
     * This method will be called to clean the erroneous data from the "Diesel" array of values based on the
     * smallest array
     *
     * @param firstDate This is the first date in the smallest array to use as a starting point for the cleaning
     */
    private static void cleanUpDiesel(LocalDate firstDate) {
        for (int i = 0; i < dieselData.size(); ++i) {
            LocalDate matchDate = dieselData.get(i).getReportDate();
            if (firstDate.isEqual(matchDate)) {
                int clearIndex = i;
                for (int j = 0; j < clearIndex; ++j) {
                    dieselData.remove(0);
                }
            }
        }
    }

    /**
     * This method will be called to clean the erroneous data from the "Crude" array of values based on the
     * smallest array
     *
     * @param firstDate This is the first date in the smallest array to use as a starting point for the cleaning
     */
    private static void cleanUpCrude(LocalDate firstDate) {
        for (int i = 0; i < crudeOilData.size(); ++i) {
            LocalDate matchDate = crudeOilData.get(i).getReportDate();
            if (firstDate.isEqual(matchDate)) {
                int clearIndex = i;
                for (int j = 0; j < clearIndex; ++j) {
                    crudeOilData.remove(0);
                }
            }
        }
    }

    /**
     * This method will be called to start the cleanup of the 3 data arrays based on the input from the
     * smallestArrayName() method which will tell the program which array is the smallest, and therefore has the least
     * amount of data. Since all the arrays will have the same "End" data, the size difference is because they all have
     * different starting dates.
     *
     * @param nameOfSmallestArray The name of the array with the smallest object count.
     */
    private static void cleanUpArrays(String nameOfSmallestArray) {
        LocalDate firstDate;
        if (nameOfSmallestArray == "Crude") {
            firstDate = crudeOilData.get(0).getReportDate();
            cleanUpUnleaded(firstDate);
            cleanUpDiesel(firstDate);
        } else if (nameOfSmallestArray == "Unleaded"){
            firstDate = unleadedGasData.get(0).getReportDate();
            cleanUpDiesel(firstDate);
            cleanUpCrude(firstDate);
        } else if (nameOfSmallestArray == "Diesel") {
            firstDate = dieselData.get(0).getReportDate();
            cleanUpUnleaded(firstDate);
            cleanUpCrude(firstDate);
        } else {
            return;
        }
    }

    /**
     * This method will load the last item in each of the object arrays and submit the date of the last object(s)
     * to the end-date match.
     * @return Boolean
     */
    private static boolean getDateFarthest() {
        LocalDate crudeOilFarthest = crudeOilData.get(crudeOilData.size() - 1).getReportDate();
        LocalDate unleadedFarthest = unleadedGasData.get(unleadedGasData.size() - 1).getReportDate();
        LocalDate dieselFarthest = dieselData.get(dieselData.size() - 1).getReportDate();

        if (crudeOilFarthest.equals(unleadedFarthest) && unleadedFarthest.equals(dieselFarthest)) {
            // FIXME: This "Sout" is for debug purposes. Delete before release
            System.out.println("This is a match!!");

            return true;
        } else {
            // FIXME: This "Sout" is for debug purposes. Delete before release
            System.out.println("This is NOT a match!!");

            return false;
        }
    }

    /**
     * This method will submit the furthest dates in each of the object arrays for inspection to make sure they
     * all have the same last date (all the arrays are already sorted by date with the most recent closest).
     *
     * When they are matching, it will then check to make sure they all start with the same date. It does this by
     * checking each of their sizes and then using the date at index[0] of the smallest array to set the beginning date
     * for the other arrays.
     */
    public static void matchEndDatesInArrays() {
        // This will first check to make sure that the "End" dates of the arrays match
        if (getDateFarthest()) {
            String smallest = smallestArrayName();
            cleanUpArrays(smallest);
        } else {
            //FIXME: This is a good place to add for future releases, but since the data is mostly clean already, it is not needed for this version as the "If" will always execute
            System.out.println("This is not to be handled by this run of the program");
        }
    }

    public static void checkSizeOfArrays() {
        System.out.println(
                "Diesel Array Starts at: " + dieselData.get(0).getReportDate() + " and has " + dieselData.size() + " elements!" +
                        "\nUnleaded Array Starts at: " + unleadedGasData.get(0).getReportDate() + " and has " + unleadedGasData.size() + " elements!" +
                        "\nCrude Oil Array Starts at: " + crudeOilData.get(0).getReportDate() + " and has " + crudeOilData.size() + " elements!"
        );
    }



}


/*
    public static void matchEndDatesInArrays() {
        int crudeOilSize = crudeOilData.size();  // This will hold initial size of Crude Oil array
        int unleadedSize = unleadedGasData.size();  // This will hold initial size of Unleaded Gas array
        int dieselSize = dieselData.size();  // This will hold initial size of Diesel array

        // This will first check to make sure that the "End" dates of the arrays match
        if (getDateFarthest()) {
            int smallestSize = smallestArray(crudeOilSize, unleadedSize, dieselSize);
            int largestSize = largestArray(crudeOilSize, unleadedSize, dieselSize);
            System.out.println("The smallest array is: " + smallestSize + "\nLargest array is: " + largestSize);

            String smallest = smallestArrayName();
            System.out.println(unleadedGasData.get(0).getReportDate());
            cleanUpArrays(smallest);
            System.out.println(unleadedGasData.size() + " : " + unleadedGasData.get(0).getReportDate());
            System.out.println(dieselData.size() + " : " + dieselData.get(0).getReportDate());

            // FIXME: Just to test out the arrays
            for (int i = 0; i < crudeOilSize; ++i) {
                System.out.println(crudeOilData.get(i).getReportDate() +
                        " : " + unleadedGasData.get(i).getReportDate() + " : " + dieselData.get(i).getReportDate());
            }



            // System.out.println("Crude Size: " + crudeOilSize + "\nUnleaded Size: " + unleadedSize + "\nDiesel Size: " + dieselSize);
        } else {
            //Find the closest-to-today's date for matching
        }
    }

        public static int smallestArray(int x, int y, int z) {
        // This is based on the logic of: Math.min(z, (Math.min(x, y)));
        return Math.min(crudeOilData.size(), (Math.min(unleadedGasData.size(), dieselData.size())));
    }

    */
