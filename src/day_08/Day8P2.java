package day_08;

import intcode.Intcode;

import java.io.IOException;

public class Day8P2 {

    public static void main(String[] args) throws IOException {
        Intcode intcode = new Intcode("src/day_08/input.txt");

        //Loop over each instruction
        for(int i=0; i < intcode.instructions.size(); i++){
            if(intcode.instructions.get(i).contains("jmp")){
                intcode.instructions.set(i, intcode.instructions.get(i).replace("jmp","nop"));

                //Try out the loop
                while(!intcode.infiniteLoop && !intcode.isFinished){
                    intcode.nextStep();
                    if(intcode.isFinished){
                        System.out.println("THIS ONE WORKED " + i);
                        System.out.println(intcode.accumulator);
                    }
                }
                intcode = new Intcode("src/day_08/input.txt");
            }
            if(intcode.instructions.get(i).contains("nop")){
                intcode.instructions.set(i, intcode.instructions.get(i).replace("nop","jmp"));

                //Try out the loop
                while(!intcode.infiniteLoop && !intcode.isFinished){
                    intcode.nextStep();
                    if(intcode.isFinished){
                        System.out.println("THIS ONE WORKED " + i);
                        System.out.println(intcode.accumulator);
                    }
                }
                intcode = new Intcode("src/day_08/input.txt");
            }
        }
    }
}
