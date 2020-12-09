package day_07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day7P1 {
    public static boolean openBag(String currentBag, Map<String, List<String>> map) {
        //If current bag == "o other" -> false
        if (currentBag.equals("o other")) {
            return false;
        }

        //If current bag == "shiny gold" -> return true
        if (currentBag.equals("shiny gold")) {

            return true;
        }

        //Loop by calling open bag with the next bag
        for (String bag : map.get(currentBag)) {
            if(openBag(bag, map)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_07/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_07/test.txt"));

        Map<String, List<String>> map = new HashMap<>();

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {
            //Format the data
            entry = entry.replace(".", "").replace("bags", "").replace("bag", "").replace(".", "");
            String key = entry.split("contain")[0].trim();

            List<String> currentValues = new ArrayList<>();

            for(String value: entry.split("contain")[1].split(",")){
                value = value.substring(2).trim();
                currentValues.add(value);
            }

            map.put(key, currentValues);

            entry = reader.readLine();
        }

        int counter = 0;
        for(String key: map.keySet()){
            if(openBag(key, map)){
                counter++;
            }
        }
        counter--;
        System.out.println(counter);
    }
}
