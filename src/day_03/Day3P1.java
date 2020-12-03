package day_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_03/input.txt"));

        int x = 0;
        int y = 0;
        int trees = 0;
        String entry = reader.readLine();
        while(entry != null){
            if(entry.charAt(y) == '#'){
                trees++;
            }
            x++;
            y = y + 3;
            if(y >= entry.length()){
                y = y - entry.length();
            }
            entry = reader.readLine();
        }
        System.out.println(trees);
    }
}
