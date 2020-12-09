package day_09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day9P1 {
    public static boolean checkAddition(ArrayList<Integer> preamble, int num){
        for(int a : preamble){
            for(int b : preamble){
                if(a + b == num){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_09/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_09/test.txt"));

        ArrayList<Integer> preamble = new ArrayList<>();

        int i=0;
        String entry = reader.readLine();
        while(entry != null) {
            int num = Integer.parseInt(entry);
            //Build the preamble
            if(i < 25){
                preamble.add(num);
            } else {
                if(checkAddition(preamble, num)){
                    preamble.remove(0);
                    preamble.add(num);
                } else {
                    System.out.println("This num doesn't have the correct property: " + num);
                    entry = null;
                }
            }


            i++;
            if(entry != null){
                entry = reader.readLine();
            }

        }
    }
}
