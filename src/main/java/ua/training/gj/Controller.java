package ua.training.gj;

import java.util.Scanner;

/**
 * Created by andrew on 17.04.17.
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model=model;
        this.view=view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        model.rand();

        while (!model.isComplete()){
            model.setUserValue(getIntAndRangeValidation(sc));
            model.searchProcess();
        }

        view.printMessage(View.SUCCESS);
        view.printRoute(model);

    }

    public int getIntFromScanner(Scanner sc){
        view.printInputMessage(model.getMinValue(), model.getMaxValue());
        while(!sc.hasNextInt()){
            view.printMessage(View.ERROR_INPUT);
            view.printInputMessage(model.getMinValue(), model.getMaxValue());
            sc.next();
        }
        return sc.nextInt();
    }

    public int getIntAndRangeValidation(Scanner sc) {
        int value = getIntFromScanner(sc);
        while (!(model.getMinValue() < value && model.getMaxValue() > value)) {
            view.printMessage(View.ERROR_RANGE);
            value = getIntFromScanner(sc);
        }
        return value;
    }
}
