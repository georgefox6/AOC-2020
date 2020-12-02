package day_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Day2P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_02/input.txt"));

        int counter = 0;

        String entry = reader.readLine();
        while(entry != null){

            //Separate each line of the input into its different sections
            String[] arrayOfStrings = entry.split(" ", 0);

            int min = parseInt(arrayOfStrings[0].split("-", 2)[0]);

            int max = parseInt(arrayOfStrings[0].split("-", 2)[1]);

            String character = String.valueOf(arrayOfStrings[1].charAt(0));

            String password = arrayOfStrings[2];

            int count = password.length() - password.replace(character, "").length();

            //Check if the password is valid
            if(count >= min && count <= max){
                counter++;
            }

            entry = reader.readLine();
        }

        System.out.println(counter);
    }
}
