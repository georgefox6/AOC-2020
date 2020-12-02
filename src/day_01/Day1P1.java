package day_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1P1 {
    public static void main(String[] args) throws IOException {
        //Read the file
        BufferedReader reader = new BufferedReader(new FileReader("src/day_01/input.txt"));
        ArrayList<Integer> entries = new ArrayList<>();

        //Store the contents of the file in the array list entries
        String entry = reader.readLine();
        while(entry != null){
            entries.add(Integer.parseInt(entry));
            entry = reader.readLine();
        }

        //Loop once over the array list of entries
        for(int expenseA : entries){
            //Loop over the array list of entries a second time
            for(int expenseB : entries){
                if(expenseA + expenseB == 2020){
                    System.out.println(expenseA * expenseB);
                }
            }
        }
    }
}
