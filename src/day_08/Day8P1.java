package day_08;

import intcode.Intcode;

import java.io.IOException;

public class Day8P1 {
    public static void main(String[] args) throws IOException {
        Intcode intcode = new Intcode("src/day_08/input.txt");

        while(!intcode.infiniteLoop){
            intcode.nextStep();
        }

        System.out.println("Final Accumulator: " + intcode.accumulator);
    }
}