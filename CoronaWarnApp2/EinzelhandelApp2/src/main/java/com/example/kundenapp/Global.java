package com.example.kundenapp;

public class Global {
    public static Integer flaeche;
    public static Integer dauer;
    public static String name;
    public static boolean qrCodeCreated;


    public static void setQrCodeCreated(boolean qrCodeCreated) {
        Global.qrCodeCreated = qrCodeCreated;
    }

    public static boolean isQrCodeCreated() {
        return qrCodeCreated;
    }

    public static Integer getDauer() {
        return dauer;
    }

    public static Integer getFlaeche() {
        return flaeche;
    }

    public static String getName() {
        return name;
    }

    public static void setDauer(Integer dauer) {
        Global.dauer = dauer;
    }

    public static void setFlaeche(Integer flaeche) {
        Global.flaeche = flaeche;
    }

    public static void setName(String name) {
        Global.name = name;
    }
}
