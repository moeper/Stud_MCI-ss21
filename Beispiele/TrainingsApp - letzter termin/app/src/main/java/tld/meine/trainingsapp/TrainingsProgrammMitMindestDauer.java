package tld.meine.trainingsapp;

import java.util.Calendar;

public class TrainingsProgrammMitMindestDauer extends TrainingsProgramm
{
    private int minTrainigsdauerProEinheit;

    public TrainingsProgrammMitMindestDauer(int kalorienZiel, int minTrainigsdauerProEinheit)
    {
        super(kalorienZiel);
        this.minTrainigsdauerProEinheit = minTrainigsdauerProEinheit;
    }

    @Override
    public void addTrainingseinheit (Trainingseinheit trainingseinheit)
    {
        if(trainingseinheit.getDauerTraining() >= minTrainigsdauerProEinheit)
        {
            super.getTrainingseinheiten().add(trainingseinheit);
            System.out.println("Trainingseinheit hinzugefuegt");
        }
    }
}
