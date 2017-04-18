package ua.training.gj;

import java.util.ArrayList;

/**
 * Created by andrew on 17.04.17.
 */
public class View {

    static String INPUT_VALUE = "Input value in range ";
    static String ERROR_INPUT = "Error input. ";
    static String ERROR_RANGE = "Error range. ";
    static String ROUTE = "Route: ";
    static String SPACE = " ";
    static String SUCCESS = "Success!";
    static String RGHT_BR = ")";
    static String LFT_BR = "(";
    static String COMMA = ",";


    public void printMessage(String message){
        System.out.println(message);
    }

    public void printInputMessage(int min, int max){
        printMessage(View.INPUT_VALUE + View.LFT_BR + min +
                View.COMMA + max + View.RGHT_BR);
    }

    public void printRoute(Model model){
        String output = ROUTE + LFT_BR + SPACE;
        for(Integer value : model.getRoute()){
            output += value + SPACE;
        }
        output += RGHT_BR;
        printMessage(output);
    }
}
