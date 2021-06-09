package com.example.test_zentrum;

public class Test {

    private String dateOf;
    private String timeOf;
    private String testId;
    private String personId;
    private TestState testResult;

    public Test(String date, String time, String personId, String testId, TestState testResult){
        this.dateOf = date;
        this.timeOf = time;
        this.personId = personId;
        this.testId = testId;
        this.testResult = testResult;
    }

    public Test(){};

    public String getDateOf() {
        return dateOf;
    }

    public String getTimeOf() {
        return timeOf;
    }

    @Override
    public String toString() {
        return "Test{" +
                "dateOf=" + dateOf +
                ", timeOf=" + timeOf +
                ", testId='" + testId + '\'' +
                ", personId='" + personId + '\'' +
                ", testResult=" + testResult +
                '}';
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

    public void setTimeOf(String timeOf) {
        this.timeOf = timeOf;
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
