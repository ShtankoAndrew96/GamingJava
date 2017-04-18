package ua.training.gj;

import java.util.ArrayList;

/**
 * Created by andrew on 17.04.17.
 */
public class Model {

    private int minValue;
    private int maxValue;

    private int randomValue;
    private int userValue;

    private boolean isComplete;

    private ArrayList<Integer> route;

    public Model(){
        minValue = 0;
        maxValue = 100;
        isComplete = false;
        route = new ArrayList<Integer>();
    }

    public void rand(){
        randomValue = minValue + (int) Math.ceil(Math.random() * (maxValue-minValue));
    }

    public void rand(int minValue, int maxValue){
        if(minValue>maxValue){
            throw new IllegalArgumentException();
        }
        randomValue = minValue + (int) Math.ceil(Math.random() * (maxValue-minValue));
    }

    public void searchProcess(){
        if(userValue == randomValue) {
            isComplete = true;
        }else if(userValue < randomValue){
            minValue = userValue;
        }else if(userValue > randomValue){
            maxValue = userValue;
        }
        route.add(userValue);
    }

    public ArrayList<Integer> getRoute(){
        return route;
    }

    public boolean isComplete(){
        return isComplete;
    }

    public void setUserValue(int userValue){
        this.userValue = userValue;
    }

    public int getMinValue(){
        return minValue;
    }

    public  int getMaxValue(){
        return maxValue;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }

    public int getUserValue() {
        return userValue;
    }
}
