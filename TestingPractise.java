package andrew.Testing;

import java.util.*;

public class TestingPractise {

    public static int largest(int num1, int num2){
        if(num1 > num2){
            return num1;
        }else{
            return num2;
        }
    }

    public static boolean alphabeticalOrder(String word){
        for(int i = 0; i < word.length() - 1; i++){
            if(word.charAt(i) >= word.charAt(i + 1)){
                return false;
            }
        }

        return true;
    }

    public static boolean productSumGreater(int[] numbers, int value){
        int sum = numbers[0];
        int product = numbers[0];

        for(int i = 1; i < numbers.length; i++){
            sum += numbers[i];
            product *= numbers[i];
        }

        return sum > value && product > value;
    }

    public static Human changeHuman(Human human){
        String newName = "Test";
        int newAge = human.getAge() * 2;
        int newYearOfBirth = human.getYearOfBirth() * 2;
        String newGender = "Test";

        return new Human(newName, newAge, newYearOfBirth, newGender);
    }

    public static List<Human> getByGender(String gender){
        List<Human> listAllHumans = new ArrayList<>();
        for (Human human : Human.allHumans.values()){
            if (Objects.equals(human.getGender(), gender)){
                listAllHumans.add(human);
            }
        }
        return listAllHumans;
    }

    public static List<Human> getOlderAge(int age){
        List<Human> listAllHumans = new ArrayList<>();
        for (Human human : Human.allHumans.values()){
            if (human.getAge() > age){
                listAllHumans.add(human);
            }
        }
        return listAllHumans;
    }

    public static int getHumanAges(){
        int countAge = 0;
        for (Human human : Human.allHumans.values()){
            countAge += human.getAge();
        }
        return countAge;
    }

    public static int getAverageAgeHumans(){
        return getHumanAges() / Human.allHumans.size();
    }

}
