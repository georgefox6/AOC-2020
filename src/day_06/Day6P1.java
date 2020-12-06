package day_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day6P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_06/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_06/test.txt"));

        ArrayList<Integer> numberOfDeclarations = new ArrayList<>();
        ArrayList<Character> currentDeclarations = new ArrayList<>();

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {

            //If this is the end of the current declaration information
            if(entry.trim().equals("")){
                int currentNumOfDeclarations = currentDeclarations.size();
                numberOfDeclarations.add(currentNumOfDeclarations);
                currentDeclarations.clear();
            }

            //Add each unique declaration to currentDeclarations
            for(char declaration : entry.toCharArray()){
                if(!currentDeclarations.contains(declaration)){
                    currentDeclarations.add(declaration);
                }
            }

            entry = reader.readLine();
        }

        int sumOfDeclarations = 0;

        for(int num : numberOfDeclarations){
            sumOfDeclarations += num;
        }
        System.out.println(sumOfDeclarations);


    }
}
