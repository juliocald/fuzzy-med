package com.medapp.fuzzy.medapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by andres on 26/04/15.
 */
public class Medicine {
    private String Name;
    private int ID;
    private String Dose;
    private String Details;

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

    public void initializeNewMedicine(){
        Calendar calendar = new GregorianCalendar();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int ms = calendar.get(Calendar.MILLISECOND);

        int id = (year + month + day + hour + minute + second + ms);
        this.setID(id);
    }

    public void setDetails(String _details){
        Details = _details;
    }

    public String getDetails(){
        return Details;
    }


}
