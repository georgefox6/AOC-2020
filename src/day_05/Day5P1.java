package day_05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day5P1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/day_05/input.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_05/test.txt"));

        int highestSeatId = 0;

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

            int seatId = (rowDecimal * 8 ) + columnDecimal;
            if(seatId > highestSeatId){
                highestSeatId = seatId;
            }
            entry = reader.readLine();
        }
        System.out.println("Heighest: " + highestSeatId);
    }
}
