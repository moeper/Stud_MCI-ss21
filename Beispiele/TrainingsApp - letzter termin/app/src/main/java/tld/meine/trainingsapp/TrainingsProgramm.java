package tld.meine.trainingsapp;

import java.util.ArrayList;

public class TrainingsProgramm implements Trainingsziel, Muskelunterstuetzung
{

    //private ArrayList<Trainingseinheit> trainingseinheiten;
    private DoublyLinkedList trainingseinheiten;
    private int kalorienZiel;
    private String name;
    private int index;

    public TrainingsProgramm(int kalorienZiel) {
        //trainingseinheiten = new ArrayList<Trainingseinheit>();
        trainingseinheiten = new DoublyLinkedList();
        this.kalorienZiel = kalorienZiel;
        this.name = name;
    }

    public void addTrainingseinheit (Trainingseinheit trainingseinheit)
    {
        trainingseinheiten.add(trainingseinheit);
    }

    @Override
    public void setKalorienZiel(int kalorienZiel) {
        this.kalorienZiel = kalorienZiel;
    }

    @Override
    public int getKalorienZiel() {
        return kalorienZiel;
    }

    @Override
    public double getZielerreichungsgrad() {
        int gesamtVerbrauchteKalorien = 0;
        //for(Trainingseinheit x : trainingseinheiten)
        //for(int i = 0; i < trainingseinheiten.size(); i++)
        {
            gesamtVerbrauchteKalorien += trainingseinheiten.next().verbrauchteKalorien();
        }
        //System.out.println("TrainingsProgramm.getZielerreichungsgrad: " + gesamtVerbrauchteKalorien);
        return (double)gesamtVerbrauchteKalorien / kalorienZiel;
    }

    public DoublyLinkedList getTrainingseinheiten() {
        return trainingseinheiten;
    }

    @Override
    public boolean unterstuetzt(String muskel) {
        //for(Trainingseinheit x : trainingseinheiten)
        for(int i = 0; i < trainingseinheiten.size(); i++)
        {
            //if(trainingseinheiten.next().unterstuetzt(muskel)){
            if(trainingseinheiten.getCurrent().unterstuetzt(muskel)){
                return true;
            }
            trainingseinheiten.next();
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
