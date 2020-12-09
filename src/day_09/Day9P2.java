package day_09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day9P2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_09/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_09/test.txt"));

        ArrayList<Long> data = new ArrayList<>();
        ArrayList<Long> contiguousSet = new ArrayList<>();

        String entry = reader.readLine();
        while(entry != null) {
            data.add(Long.parseLong(entry));
            entry = reader.readLine();
        }

        int badNum = 32321523;
//        int badNum = 127;

        for(int i=0; i < data.size(); i++){
            contiguousSet.clear();
            Long sum = 0L;
            for(int j=0; j < data.size() - i; j++){

                if(sum == badNum){
                    Long max = Collections.max(contiguousSet);
                    Long min = Collections.min(contiguousSet);
                    System.out.println(min + max);
                    return;
                }
                contiguousSet.add(data.get(i + j));
                sum += data.get(i + j);
            }
        }
    }
}
