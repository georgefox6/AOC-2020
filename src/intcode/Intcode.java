package intcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Intcode {
    public int accumulator;
    public ArrayList<String> instructions;
    public ArrayList<Integer> completedInstructions;
    public boolean isFinished;
    public boolean infiniteLoop;
    public int pointer;

    public Intcode(String input) throws IOException {
        this.accumulator = 0;
        this.instructions = new ArrayList<>();
        this.completedInstructions = new ArrayList<>();
        this.isFinished = false;
        this.infiniteLoop = false;
        this.pointer = 0;

        BufferedReader reader = new BufferedReader(new FileReader(input));

        //Read each line of the input
        String entry = reader.readLine();
        while (entry != null) {
            //add each instruction to the instructions array list
            instructions.add(entry);
            entry = reader.readLine();
        }
    }

    public void nextStep(){
        //Check if we are in an infinite loop
        if(this.completedInstructions.contains(pointer)){
            this.infiniteLoop = true;
            return;
        }

        //Check if we have exceeded the length of the instructions
        if(pointer >= instructions.size()){
            this.isFinished = true;
            return;
        }

        this.completedInstructions.add(pointer);

        String operation = this.instructions.get(pointer).substring(0,3);
        int argument = (this.instructions.get(pointer).charAt(4) == '-' ? - Integer.parseInt(instructions.get(pointer).substring(5)) : Integer.parseInt(instructions.get(pointer).substring(5)));

        switch(operation){
            case "acc":
                this.accumulator += argument;
                this.pointer++;
                break;
            case"jmp":
                pointer += argument;
                break;
            case "nop":
                this.pointer++;
                break;
        }


    }

}
