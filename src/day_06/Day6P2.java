package day_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day6P2 {
    private static Set<Character> alphabetList(){
        Set<Character> alphabet = new HashSet<>();

        for (char c : "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase().toCharArray()) {
            alphabet.add(c);
        }

        return alphabet;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_06/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_06/test.txt"));

        ArrayList<Integer> numberOfDeclarations = new ArrayList<>();
        Set<Character> commonDeclarations = alphabetList();

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {

            //If this is the end of the current declaration information
            if(entry.trim().equals("")){
                int currentNumOfDeclarations = commonDeclarations.size();
                numberOfDeclarations.add(currentNumOfDeclarations);
                commonDeclarations.clear();
                commonDeclarations = alphabetList();
            } else {

                Set<Character> charList = new HashSet<>();

                for (char c : entry.toCharArray()) {
                    charList.add(c);
                }

                commonDeclarations.retainAll(charList);

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
