package de.bcxp.challenge;

public class CountryDetail {
    private int population = 0;
    private int area = 0;


    public CountryDetail(int pop, int ar){
        population = pop;
        area = ar;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public float getPopulationDensity(){
        return ((float)population)/area;
    }
}
