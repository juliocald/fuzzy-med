package com.medapp.fuzzy.medapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by andres on 27/04/15.
 */
public class Prescription {
    private int ID;
    private String Doctor; //TODO: Cambiar el String por objeto Contacto
    private ArrayList<String> Medicines;
    private Calendar Expiration;

    public Prescription(){
        Medicines = new ArrayList<String>();
    }

    public void setID(int _id){
        ID = _id;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public int getID() {
        return ID;
    }

    public String getDoctor() {
        return Doctor;
    }

    public void setExpiration(Calendar exp){
        Expiration = exp;
    }

    public void initializeNewPrescription(){
        Expiration = new GregorianCalendar();
        Expiration.setTime(new Date());
        int year = Expiration.get(Calendar.YEAR);
        int month = Expiration.get(Calendar.MONTH);
        int day = Expiration.get(Calendar.DAY_OF_YEAR);
        int hour = Expiration.get(Calendar.HOUR);
        int minute = Expiration.get(Calendar.MINUTE);
        int second = Expiration.get(Calendar.SECOND);
        int ms = Expiration.get(Calendar.MILLISECOND);

        int id = (year + month + day + hour + minute + second + ms);
        this.setID(id);
    }

    public Calendar getExpiration(){
        return Expiration;
    }

    public boolean IsEmpty(){
        return Medicines.isEmpty();
    }

    public void addMedicine(String _med){
        Medicines.add(_med);
    }

    public String getMedicine(int index){
        return Medicines.get(index);
    }

    public boolean deleteMedicine(String _med){
        int size = Medicines.size();
        for(int i = 0; i < size; i++){
            if(Medicines.get(i).compareTo(_med) == 0){
                Medicines.remove(i);
                return true;
            }
        }
        return false;
    }


}
