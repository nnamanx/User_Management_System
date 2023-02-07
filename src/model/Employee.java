package model;

public class Employee extends Person{
    long id;
    String profession;

    public Employee(){}

    public Employee(long id, String profession) {
        this.id = id;
        this.profession = profession;
    }

    public Employee(String fullName, String birthdate, long id, String profession) {
        super(fullName, birthdate);
        this.id = id;
        this.profession = profession;
    }

//    Getters
    public long getId() {
        return id;
    }

    public String getProfession() {
        return profession;
    }

//    Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return id + ". Employee: " +
                "\nfull name- " + getFullName() +
                "\nbirth date- " + getBirthDate() +
                "\nprofession- " + profession;
    }
}
