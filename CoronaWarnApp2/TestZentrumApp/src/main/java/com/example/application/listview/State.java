package com.example.application.listview;

abstract class State {
    public static boolean isCreatedPerson=false;
    public static boolean isCreatedTest=false;

    public static void setIsCreatedPerson(boolean isCreatedPerson) {
        State.isCreatedPerson = isCreatedPerson;
    }

    public static void setIsCreatedTest(boolean isCreatedTest) {
        State.isCreatedTest = isCreatedTest;
    }
}
