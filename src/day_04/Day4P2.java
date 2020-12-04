package day_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4P2 {
    public static boolean checkData(String entry){
        String[] data = entry.split(":");
        switch (data[0]){
            case "byr":
                int date = Integer.parseInt(data[1]);
                if(date >= 1920 && date <= 2002){
                    return true;
                }
                break;
            case "iyr":
                date = Integer.parseInt(data[1]);
                if(date >= 2010 && date <= 2020){
                    return true;
                }
                break;
            case "eyr":
                date = Integer.parseInt(data[1]);
                if(date >= 2020 && date <= 2030){
                    return true;
                }
                break;
            case "hgt":
                if(data[1].contains("in")){
                    int height = Integer.parseInt(data[1].substring(0, data[1].length() -2));
                    if(height >= 59 && height <= 76){
                        return true;
                    }
                } else if(data[1].contains("cm")){
                    int height = Integer.parseInt(data[1].substring(0, data[1].length() -2));
                    if(height >= 150 && height <= 193){
                        return true;
                    }
                }
                break;
            case "hcl":
                if(data[1].charAt(0) == '#'){
                    String colour = data[1].substring(1, data[1].length());
                    if(colour.matches("[a-fA-F0-9]{6}")){
                        return true;
                    }
                }
                break;
            case "ecl":
                if(data[1].contains("amb") || data[1].contains("blu") || data[1].contains("brn") || data[1].contains("gry") || data[1].contains("grn") || data[1].contains("hzl") || data[1].contains("oth")){
                    return true;
                }
                break;
            case "pid":
                if(data[1].matches("[0-9]{9}")){
                    return true;
                }
        }
        return false;
    }
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
                //Check if it meets the 7 criteria
                if(currentChecklist == 7){
                    validPassports++;
                }
                currentChecklist = 0;
            } else {
                //Split the line up into the different data
                String[] passportFields = entry.split(" ", 0);

                //For each field check if the data is valid
                for(String field : passportFields){
                    if(checkData(field)){
                        currentChecklist++;
                    }
                }
            }
            entry = reader.readLine();
        }
        System.out.println(validPassports);
    }
}
