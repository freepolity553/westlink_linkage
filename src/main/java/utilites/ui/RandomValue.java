package utilites.ui;

import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RandomValue {


    public RandomValue(WebDriver driver) {
    }

    public CharSequence pmcNum (int length) {
//        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        //int length = 2; // Можно поменять в зависимости от требований
        //String values = Capital_chars + Small_chars + numbers ;
        //String values = numbers;
        Random randomGenerator = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = randomGenerator.nextInt(numbers.length());

            // get character specified by index
            // from the string
            char randomChar = numbers.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = randomGenerator.nextInt(numbers.length());

            // get character specified by index
            // from the string
            char randomChar = numbers.charAt(index);

            // append the character to string builder
            sb1.append(randomChar);
        }

        return sb+"-"+sb1;


    }
    public static CharSequence randomInt(int length) {
        String numbers = "0123456789";
        Random randomGenerator = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = randomGenerator.nextInt(numbers.length());

            // get character specified by index
            // from the string
            char randomChar = numbers.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        return sb;
    }

}

