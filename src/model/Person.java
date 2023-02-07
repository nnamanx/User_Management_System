package model;

public class Person {
    private String fullName;
    private String birthDate;

    public Person(){}

    public Person(String fullName, String birthdate){
        this.fullName = fullName;
        this.birthDate = birthdate;
    }

//Getters
    public String getFullName() {
        return fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

//    Setters
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
