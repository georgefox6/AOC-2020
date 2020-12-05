package day_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day5P2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_05/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_05/test.txt"));

        ArrayList<Integer> seatIds = new ArrayList<>();

        //Read each line of the input
        String entry = reader.readLine();
        while(entry != null) {

            //Convert the row from FBBFBF format to Binary to Decimal
            String row = entry.substring(0,7);
            row = row.replace('F', '0');
            row = row.replace('B', '1');
            int rowDecimal = Integer.parseInt(row,2);

            //Convert the column from RLR format to Binary to Decimal
            String column = entry.substring(7, 10);
            column = column.replace('R', '1');
            column = column.replace('L', '0');
            int columnDecimal = Integer.parseInt(column, 2);

            //Calculate the seat ID
            int seatId = (rowDecimal * 8 ) + columnDecimal;
            seatIds.add(seatId);
            entry = reader.readLine();
        }

        for(int i = 0; i < 866; i++){
            if(!seatIds.contains(i)){
                System.out.println("NOT IN LIST: " + i);
            }
        }
    }
}
