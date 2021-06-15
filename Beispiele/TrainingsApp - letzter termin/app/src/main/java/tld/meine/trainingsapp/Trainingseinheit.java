package tld.meine.trainingsapp;

import java.util.Calendar;

public class Trainingseinheit implements Muskelunterstuetzung
{
    private int dauerTraining = 0;
    //private LocalDateTime trainingStart; // besser calendar Klasse
    private Calendar trainingStart;
    private final Fitnessgeraet fitnessgeraet;

    public Trainingseinheit(Fitnessgeraet fitnessgeraet)
    {
        this.fitnessgeraet = fitnessgeraet;
    }

    public Trainingseinheit(Fitnessgeraet fitnessgeraet, Calendar trainingStart) {
        this(fitnessgeraet);
        this.trainingStart = trainingStart;
    }

    public boolean zielErreicht(int kalorienZiel){
        if(fitnessgeraet.kalorienverbrauch(dauerTraining) >= kalorienZiel){
            return true;
        } else {
            return false;
        }
    }

    public int erforderlicheTrainingszeit(int kalorienZiel) {
        return (kalorienZiel / fitnessgeraet.kalorienverbrauch(1));
    }

    // Dauer von Training um eins erhoehen
    public void trainieren(){
        trainieren(1);
        //System.out.println("trainieren Dauer: " + dauerTraining);
    }

    // Dauer von Training um minuten erhoehen
    public void trainieren(int minuten){
        dauerTraining += minuten;
        if(dauerTraining > fitnessgeraet.getEmpfohleneTrainigsdauer()){
            System.out.println(this.getClass().getName()+ ": " + "Achtung, Sie trainieren zu lang!!!");
        }


        //10 > 15
        //dauerTraining += 5;
        //System.out.println("trainieren Dauer: " + dauerTraining);
    }

    // aktuell verbrauchte Kalorien durch festgelegtes Fitnessgeraet ausgeben
    public int verbrauchteKalorien() {
        return fitnessgeraet.kalorienverbrauch(dauerTraining);
    }

    public int getDauerTraining() {
        return dauerTraining;
    }

    @Override
    public boolean unterstuetzt(String muskel) {
        if(fitnessgeraet.unterstuetzt(muskel)){
            return true;
        }
        return false;
    }

    public Fitnessgeraet getFitnessgeraet() {
        return fitnessgeraet;
    }
}
