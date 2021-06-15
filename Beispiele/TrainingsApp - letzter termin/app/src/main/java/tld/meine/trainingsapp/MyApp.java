package tld.meine.trainingsapp;

import android.app.Application;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyApp extends Application {
    private ArrayList<TrainingsProgramm> trainingsprogramme;
    //private DoublyLinkedList teTransferList;
    private int tpIndex;

    public MyApp()
    {
        trainingsprogramme = new ArrayList<TrainingsProgramm>();
    }

    public ArrayList<TrainingsProgramm> getTrainingsprogramme() {
        return trainingsprogramme;
    }

    public TrainingsProgramm getTrainingsprogramm(int i)
    {
        Log.v("x", Integer.toString(i));
        return trainingsprogramme.get(i);
    }

    /*public void setTrainingsprogramme(ArrayList<TrainingsProgramm> trainingsprogramme) {
        this.trainingsprogramme = trainingsprogramme;
    }*/

    /*public DoublyLinkedList getTeTransferList() {
        return teTransferList;
    }

    public void setTeTransferList(DoublyLinkedList teTransferList) {
        this.teTransferList = teTransferList;
    }*/

    public int gettpIndex() {
        return tpIndex;
    }

    public void settpIndex(int tpIndex) {
        this.tpIndex = tpIndex;
    }
}
