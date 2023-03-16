package de.bcxp.challenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// will not be used but can be reviewed for the interview
public class CSVReader {
    Scanner csvScanner;

    public CSVReader(String fileName) {
        if(!FileUtility.isFileDesiredType(fileName, "csv")) {throw new IllegalArgumentException("file should be a csv");}
        csvScanner = new Scanner(fileName);
    }

    public String[] readAllCSVLines() {
        List<String> csvLines = new ArrayList<String>();
        do {
            csvLines.add(csvScanner.nextLine());
        } while (csvScanner.hasNext());
        return (String[]) Arrays.stream(csvLines.toArray()).skip(1).toArray();
    }
}
