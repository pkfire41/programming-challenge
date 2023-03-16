package de.bcxp.challenge;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.util.HashMap;
import java.lang.String;

public class Countries {
    private HashMap<String, CountryDetail> countries = new HashMap<>();

    public Countries(CSVReader csvReader) throws IOException {
        csvReader.skip(1);
        String[] line = csvReader.readNext();
        String[] values = line[0].split(";");
        while(line != null){
            countries.put(values[0], new CountryDetail(Integer.parseInt(values[3]), Integer.parseInt(values[4])));
            line = csvReader.readNext();
        }
    }

    public int[] getCountryDetails(String countryName){
        return new int[]{countries.get(countryName).getPopulation(), countries.get(countryName).getArea(), Math.round(countries.get(countryName).getPopulationDensity())};
    }

    public String getCountryWithHighestPopulationDensity(){
        String countryWithHighestDensity = "";
        float highestPopulationDensity = 0.0F;
        for(String country : countries.keySet()) {
            if(highestPopulationDensity < countries.get(country).getPopulationDensity()){
                highestPopulationDensity = countries.get(country).getPopulationDensity();
                countryWithHighestDensity = country;
            }
        }
        return countryWithHighestDensity;
    }
}
