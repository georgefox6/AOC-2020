package day_07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_07/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_07/test2.txt"));

        Map<String, List<String>> map = new HashMap<>();

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {
            //Format the data
            entry = entry.replace(".", "").replace("bags", "").replace("bag", "").replace(".", "");
            String key = entry.split("contain")[0].trim();

            List<String> currentValues = new ArrayList<>();

            for(String value: entry.split("contain")[1].split(",")){

                if(value.charAt(1) != 'n'){
                    int quantity = Integer.parseInt(String.valueOf(value.charAt(1)));
                    value = value.substring(2).trim();
                    for(int i = 0; i < quantity; i++){
                        currentValues.add(value);
                    }
                }
            }

            map.put(key, currentValues);

            entry = reader.readLine();
        }

        String currentBag = "shiny gold";
        int counter = 0;

        for(String a : map.get(currentBag)){
            counter++;
            currentBag = a;

            for(String b : map.get(currentBag)){
                counter++;
                currentBag = b;

                for(String c : map.get(currentBag)){
                    counter++;
                    currentBag = c;

                    for(String d : map.get(currentBag)){
                        counter++;
                        currentBag = d;

                        for(String e : map.get(currentBag)){
                            counter++;
                            currentBag = e;

                            for(String f : map.get(currentBag)){
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
