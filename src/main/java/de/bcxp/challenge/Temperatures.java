package de.bcxp.challenge;

public class Temperatures {
    private int maxTemperature;
    private int minTemperature;
    public Temperatures(int mxT, int mnT){
        maxTemperature = mxT;
        minTemperature = mnT;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getTemperatureDiffAbs() {
        return Math.abs(maxTemperature - minTemperature);
    }
}
