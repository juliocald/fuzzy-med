package com.medapp.fuzzy.medapp;

/**
 * Created by andres on 26/04/15.
 */
public class Medicine {
    private String Name;
    private int ID;
    private String Dose;

    public Medicine(String name){
        Name = name;
    }

    public String getName(){
        return Name;
    }

    public int getID(){
        return ID;
    }

    public String getDose(){
        return Dose;
    }

    public void setDose(String dose) {
        Dose = dose;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
