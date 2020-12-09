package day_07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7P1 {
    public static boolean openBag(String currentBag, Map<String, List<String>> map){
        System.out.println("current bag: " + currentBag);
        //If current bag == "o other" -> false

        if(currentBag.equals("o other")){
//            System.out.println(currentBag);
            return false;
        }

        //If current bag == "shiny gold" -> return true

        if(currentBag.equals("shiny gold")){

            return true;
        }

        //Loop by calling open bag with the next bag

        for(String bag : map.get(currentBag)){
            return openBag(bag, map);
        }

        System.out.println(currentBag);
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_07/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_07/test.txt"));

        Map<String, List<String>> map = new HashMap<>();

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {
            entry = entry.replace(".", "");
            entry = entry.replace("bags", "");
            entry = entry.replace("bag", "");
            entry = entry.replace(".", "");
            String key = entry.split("contain")[0].trim();

            List<String> currentValues = new ArrayList<>();

            for(String value: entry.split("contain")[1].split(",")){
//                System.out.println("Key: " + key);
//                System.out.println("values: " + value);
                value = value.substring(2).trim();
                currentValues.add(value);
            }
//            System.out.println("END");

            map.put(key, currentValues);


            entry = reader.readLine();
        }

        int counter = 0;
        for(String key: map.keySet()){
//            System.out.println(openBag(key, map));
//            System.out.println(" - ");

            if(openBag(key, map)){
                counter++;
            }
//            System.out.println(openBag(key, map));
        }
        System.out.println(counter);

    }

}
