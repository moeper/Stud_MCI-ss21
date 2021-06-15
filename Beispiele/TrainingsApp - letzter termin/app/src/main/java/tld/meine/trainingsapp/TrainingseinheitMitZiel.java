package tld.meine.trainingsapp;

import java.util.GregorianCalendar;

public class TrainingseinheitMitZiel extends Trainingseinheit implements Trainingsziel
{
    private int kalorienZiel;
    private boolean istZielErreicht = false;

    public TrainingseinheitMitZiel(int dauer , int tag, int monat, int jahr,
                            int hh, int mm, Fitnessgeraet fitnessgeraet,
                            int kalorienZiel)
    {
        super(fitnessgeraet, new GregorianCalendar(jahr, monat, tag, hh, mm));
        super.trainieren(dauer);
        this.kalorienZiel = kalorienZiel;
    }

    @Override
    public void trainieren(int minuten)
    {
        super.trainieren(minuten);
        if(super.zielErreicht(kalorienZiel) && !istZielErreicht)
        {
            System.out.println("Hurra");
            istZielErreicht = true;
        }
    }

    @Override
    public void setKalorienZiel(int kalorienZiel) {
        this.kalorienZiel = kalorienZiel;
        if(!super.zielErreicht(kalorienZiel))
        {
            istZielErreicht = false;
        }
    }

    @Override
    public int getKalorienZiel() {
        return kalorienZiel;
    }

    @Override
    public double getZielerreichungsgrad() {
        return (double)super.verbrauchteKalorien() / kalorienZiel;
    }
}
