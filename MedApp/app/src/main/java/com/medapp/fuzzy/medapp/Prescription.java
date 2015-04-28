package com.medapp.fuzzy.medapp;

import java.util.ArrayList;

/**
 * Created by andres on 27/04/15.
 */
public class Prescription {
    private int ID;
    private String Doctor; //TODO: Cambiar el String por objeto Contacto
    private ArrayList<Medicine> Medicines;

    public Prescription(){}

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

    public boolean IsEmpty(){
        return Medicines.isEmpty();
    }

    public void addMedicine(Medicine _med){
        Medicines.add(_med);
    }

    public Medicine getMedicine(int index){
        return Medicines.get(index);
    }

    public boolean deleteMedicine(Medicine _med){
        int size = Medicines.size();
        for(int i = 0; i < size; i++){
            if(Medicines.get(i).getID() == _med.getID()){
                Medicines.remove(i);
                return true;
            }
        }
        return false;
    }


}
