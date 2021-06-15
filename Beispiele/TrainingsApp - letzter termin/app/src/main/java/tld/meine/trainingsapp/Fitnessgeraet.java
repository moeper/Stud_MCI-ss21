package tld.meine.trainingsapp;

public class Fitnessgeraet
{

    private String name;
    private String typ;
    private Muskelgruppe muskelgruppe;
    private int empfohleneTrainingsdauer;
    private int avgKalorienPerHour;
    private boolean benoetigtStrom;

    public Fitnessgeraet(String name, String typ, Muskelgruppe muskelgruppe,
                         int empfohleneTrainigsdauer, int avgKalorienPerHour,
                         boolean benoetigtStrom)
    {
        this.name = name;
        this.typ = typ;
        this.muskelgruppe = muskelgruppe;
        this.empfohleneTrainingsdauer = empfohleneTrainigsdauer;
        this.avgKalorienPerHour = avgKalorienPerHour;
        this.benoetigtStrom = benoetigtStrom;
    }

    public int kalorienverbrauch (int minuten){
        // Integer Division, Kalorien unter 60 == Endlosschleife
        double verbrauch = (avgKalorienPerHour / 60.0) * minuten;
        //System.out.println("kalorienverbrauch: " + verbrauch);
        return (int)verbrauch;
    }

    public int kalorienverbrauch (int stunden, int minuten){
        return kalorienverbrauch(60*stunden+minuten);
    }

    public boolean unterstuetzt(String muskel){
        return muskelgruppe.enthaelt(muskel);
    }

    public boolean unterstuetzt(Muskelgruppe muskelgruppe){
        return muskelgruppe == this.muskelgruppe ? true : false;
    }

    public boolean benoetigtStromversorgung(){
        return benoetigtStrom;
    }

    public int getEmpfohleneTrainigsdauer() {
        return empfohleneTrainingsdauer;
    }

    /*public int erforderlicheTrainingszeit(int kalorienZiel)
    {

        return
    }*/

    public String getName() {
        return name;
    }
}
