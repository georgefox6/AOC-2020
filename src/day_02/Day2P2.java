package day_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class Day2P2 {

    public static boolean checkPassword(int index1, int index2, String password, char character) {
        int count = 0;
        if(password.length() > index1 - 1){
            if(password.charAt(index1 - 1) == character){
                count++;
            }
        }
        if(password.length() > index2 - 1){
            if(password.charAt(index2 - 1) == character){
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_02/input.txt"));

        int counter = 0;

        String entry = reader.readLine();
        while(entry != null){

            //Separate each line of the input into its different sections
            String[] arrayOfStrings = entry.split(" ", 0);

            int index1 = parseInt(arrayOfStrings[0].split("-", 2)[0]);

            int index2 = parseInt(arrayOfStrings[0].split("-", 2)[1]);

            char character = arrayOfStrings[1].charAt(0);

            String password = arrayOfStrings[2];

            //Check if the password is valid
            if(checkPassword(index1, index2, password, character)){
                counter++;
            }
            entry = reader.readLine();
        }

        System.out.println(counter);
    }
}
