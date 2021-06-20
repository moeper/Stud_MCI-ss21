package com.example.kundenapp;


import java.io.Serializable;

public class Test implements Serializable {

    private String dateOf;
    private String testId;
    private TestState testResult;
    private int icon;

    public Test(String date, String testId, String personId, TestState testResult, int icon){
        this.dateOf = date;
        this.testId = testId;
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
                ", testResult=" + testResult +
                '}';
    }

    public int getIcon(int ic_positiv) {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
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

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public void setTestResult(TestState testResult) {
        this.testResult = testResult;
    }
}
