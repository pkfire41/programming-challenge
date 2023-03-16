package de.bcxp.challenge;

import com.opencsv.CSVReader;

import javax.xml.crypto.KeySelectorException;
import java.io.IOException;
import java.util.HashMap;

public class Weather {
    private HashMap<Integer, Temperatures> dayTemperatures = new HashMap<>();

    public Weather(CSVReader csvReader) throws IOException {
        csvReader.skip(1);
        String[] line = csvReader.readNext();
        while(line != null){
            dayTemperatures.put(Integer.parseInt(line[0]), new Temperatures(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            line = csvReader.readNext();
        }
    }

    public int getMinimumTemperatureOfDay(int dayNumber) throws KeySelectorException {
        if(!dayTemperatures.containsKey(dayNumber)) throw new KeySelectorException("this day doesn't exist");
        Temperatures day = dayTemperatures.get(dayNumber);
        return day.getMinTemperature();
    }

    public int getMaximumTemperatureOfDay(int dayNumber) throws KeySelectorException {
        if(!dayTemperatures.containsKey(dayNumber)) throw new KeySelectorException("this day doesn't exist");
        Temperatures day = dayTemperatures.get(dayNumber);
        return day.getMaxTemperature();
    }

    public int getTemperatureDiffOfDay(int dayNumber) throws KeySelectorException {
        if(!dayTemperatures.containsKey(dayNumber)) throw new KeySelectorException("this day doesn't exist");
        Temperatures day = dayTemperatures.get(dayNumber);
        return day.getTemperatureDiffAbs();
    }

    public int getDayWithSmallestTemperatureSpread(){
        int dayOfSmallestSpread = 1;
        int smallestTempSpread = 0;
        for(int key : dayTemperatures.keySet()) {
            if(key == 1){
                smallestTempSpread = dayTemperatures.get(1).getTemperatureDiffAbs();
            }
            if(smallestTempSpread > dayTemperatures.get(key).getTemperatureDiffAbs()){
                smallestTempSpread = dayTemperatures.get(key).getTemperatureDiffAbs();
                dayOfSmallestSpread = key;
            }
        }
        return dayOfSmallestSpread;
    }

    public int[] getDayAndTempWithSmallestTemperatureSpread(){
        int day = getDayWithSmallestTemperatureSpread();
        return new int[]{day, dayTemperatures.get(day).getTemperatureDiffAbs()};
    }

    public int[] getTemperaturesOfDay(int dayNumber){
        return new int[]{dayTemperatures.get(dayNumber).getMinTemperature(), dayTemperatures.get(dayNumber).getMaxTemperature()};
    }

}
