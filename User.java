package andrew.Testing;

import java.util.*;

public class User {
    public static void main(String[] args) {

        new User ("Justin", 35, Sex.MALE);
        new User ("Alisha", 34, Sex.FEMALE);
        new User ("Mary", 7, Sex.FEMALE);

        System.out.println("All users:");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("All users: MALE");
        User.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("All users: FEMALE");
        User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("==============================");
        System.out.println("All users: " + User.getHowManyUsers());
        System.out.println("All users MALE: " + User.getHowManyUsers(Sex.MALE));
        System.out.println("All users FEMALE: " + User.getHowManyUsers(Sex.FEMALE));
        System.out.println("==============================");
        System.out.println("General age: " + User.getAllAgeUsers());
        System.out.println("General age MALE: " + User.getAllAgeUsers(Sex.MALE));
        System.out.println("General age FEMALE: " + User.getAllAgeUsers(Sex.FEMALE));
        System.out.println("===============================");
        System.out.println("Average age : " + User.getAverageAgeOfAllUsers());
        System.out.println("Average age MALE: " + User.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("Average age FEMALE: " + User.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("===============================");
    }

    private int id;
    private String name;
    private int age;
    private Sex sex;
    private static int countId = 0;

    private static Map<Integer, User> allUsers = new HashMap<>();

    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null){
            this.name = name;
            this.age = age;
            this.sex = sex;

            if (!hasUser()) {
                countId++;
                this.id = countId;
                allUsers.put(id, this);
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
            Objects.equals(name, user.name) &&
            sex == user.sex;
    }

    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getAllUsers(Sex sex){
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()){
            if (user.sex == sex){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }
    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (User user : getAllUsers(sex)){
            countAge += user.age;

        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }
    public static int getAverageAgeOfAllUsers(Sex sex) {
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

}
