package com.example.application.listview;


import java.io.Serializable;

public class Test implements Serializable {

    private String dateOf;
    private String testId;
    private String personId;
    private TestState testResult;
    private int icon;

    public Test(String date,  String testId,String personId, TestState testResult, int icon){
        this.dateOf = date;
        this.testId = testId;
        this.personId = personId;
        this.testResult = testResult;
        this.icon = icon;
    }

    public Test(){};

    public String getDateOf() {
        return dateOf;
    }


    @Override
    public String toString() {
        return "Test{" +
                "dateOf=" + dateOf +
                ", testId='" + testId + '\'' +
                ", personId='" + personId + '\'' +
                ", testResult=" + testResult +
                '}';
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getPersonId() {
        return personId;
    }

    public String getTestId() {
        return testId;
    }

    public TestState getTestResult(){
        return testResult;
    }

    public void setDateOf(String dateOf) {
        this.dateOf = dateOf;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public void setTestResult(TestState testResult) {
        this.testResult = testResult;
    }
}
