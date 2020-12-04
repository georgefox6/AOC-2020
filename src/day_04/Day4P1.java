package day_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_04/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_04/test.txt"));

        int currentChecklist = 0;
        int validPassports = 0;

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {
            //If this is the end of the current passport information
            if(entry.trim().equals("")){
                if(currentChecklist == 7){
                    validPassports++;

                }
                currentChecklist = 0;
            } else {
                if(entry.contains("byr")){
                    currentChecklist++;
                }
                if(entry.contains("iyr")){
                    currentChecklist++;
                }
                if(entry.contains("eyr")){
                    currentChecklist++;
                }
                if(entry.contains("hgt")){
                    currentChecklist++;
                }
                if(entry.contains("hcl")){
                    currentChecklist++;
                }
                if(entry.contains("ecl")){
                    currentChecklist++;
                }
                if(entry.contains("pid")){
                    currentChecklist++;
                }
            }
            entry = reader.readLine();
        }
        System.out.println(validPassports);
    }
}
