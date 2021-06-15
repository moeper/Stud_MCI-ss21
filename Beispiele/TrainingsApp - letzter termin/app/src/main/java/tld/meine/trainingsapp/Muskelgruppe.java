package tld.meine.trainingsapp;

public class Muskelgruppe
{
    private String bezeichnung;
    private String[] muskeln;

    public Muskelgruppe(String bezeichnung, String[] muskeln) {
        this.bezeichnung = bezeichnung;
        this.muskeln = muskeln;
    }

    public boolean enthaelt(String muskel){
        for(String m : muskeln) {
            if(m == muskel)
                return true;
        }
        return false;
    }
}
