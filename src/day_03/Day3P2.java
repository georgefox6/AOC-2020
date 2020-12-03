package day_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3P2 {

    public static int rideSlope(int xIncrement, int yIncrement) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("src/day_03/input.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("src/day_03/test.txt"));
        int x = 0;
        int y = 0;
        int trees = 0;
        String entry = reader.readLine();

        while(entry != null) {
            if (y % yIncrement == 0) {
                if (entry.charAt(x) == '#') {
                    trees++;
                }

                x = x + xIncrement;
                if (x >= entry.length()) {
                    x = x - entry.length();
                }
                entry = reader.readLine();
            }
            y++;
        }
        return trees;
    }

    public static void main(String[] args) throws IOException {
        int a = rideSlope(1, 1);
        int b = rideSlope(3, 1);
        int c = rideSlope(5, 1);
        int d = rideSlope(7, 1);
        int e = rideSlope(1, 2);
        long product = Long.valueOf(a) * Long.valueOf(b) * Long.valueOf(c) * Long.valueOf(d) * Long.valueOf(e);

        System.out.println(a + " " + b + " " + c + " " + d + " " + e);
        System.out.println(product);
    }
}
