package andrew.Testing;

import java.util.*;

public class Human {
    private String name;
    private int age;
    private int yearOfBirth;
    private String gender;
    private static int countId = 0;
    private int id;

    public static Map<Integer, Human> allHumans = new HashMap<>();

    public Human(String name, int age, int yearOfBirth, String gender) {
        if (name != null && !name.isEmpty() && age > 0 && gender != null){
            this.name = name;
            this.age = age;
            this.yearOfBirth = yearOfBirth;
            this.gender = gender;

            if (!hasHuman() && this.yearOfBirth != 0) {
                countId++;
                this.id = countId;
                allHumans.put(id, this);
            }
        }
    }

    private boolean hasHuman(){
        for (Human human : allHumans.values()){
            if (human.equals(this)){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name) &&
                Objects.equals(yearOfBirth, human.yearOfBirth) &&
                Objects.equals(gender, human.gender);
    }
}
