package ua.training.gj;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by andrew on 18.04.17.
 */
public class TestModel {

    @Test
    public void testRandForRange(){
        Model model = new Model();
        final int MIN_VALUE = 0;
        final int MAX_VALUE = 100;
        final int EXPECTED_COUNT = 25;
        int actualCount = 0;

        for (int i=0; i < EXPECTED_COUNT; i++){
            model.rand(MIN_VALUE,MAX_VALUE);
            int value = model.getRandomValue();
            if (value >= MIN_VALUE && value <= MAX_VALUE){
                actualCount++;
            }
        }
        assertTrue(EXPECTED_COUNT==actualCount);
    }

    @Test
    public void testRandWithEqualMinMax(){
        Model model = new Model();
        final int MIN_VALUE = 50;
        final int MAX_VALUE = 50;
        final int EXPECTED_VALUE = 50;

        model.rand(MIN_VALUE,MAX_VALUE);
        int value = model.getRandomValue();

        assertTrue(EXPECTED_VALUE==value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandWithNonCorrectBarriers(){
        Model model = new Model();
        final int MIN_VALUE = 100;
        final int MAX_VALUE = 50;

        model.rand(MIN_VALUE,MAX_VALUE);
        fail();
    }

    @Test
    public void testChangingMaxBarrier(){
        Model model = new Model();
        model.setRandomValue(40);
        model.setUserValue(70);
        model.searchProcess();
        assertTrue(model.getMaxValue() == model.getUserValue());
    }

    @Test
    public void testChangingMinBarrier(){
        Model model = new Model();
        model.setRandomValue(70);
        model.setUserValue(40);
        model.searchProcess();
        assertTrue(model.getMinValue() == model.getUserValue());
    }

    @Test
    public void testGameUsingEnumSrc(){
        Model model = new Model();
        final int EXPECTED_FAILED_VALUES_CNT = 9;
        int actualFailedValuesCnt = 0;
        TestValues[] testValues = TestValues.values();
        model.setRandomValue(TestValues.SUCCESSFUL_TRY.getValue());
        for(TestValues tv : testValues){
            model.setUserValue(tv.getValue());
            model.searchProcess();
            if(!model.isComplete()){
                actualFailedValuesCnt++;
            }
        }
        assertTrue((EXPECTED_FAILED_VALUES_CNT == actualFailedValuesCnt) &&
                    model.isComplete());
    }

    @Test
    public void testBarrierChangingUsingEnumSrc(){
        int previousMinBarrier = 0;
        int previousMaxBarrier = 100;
        Model model = new Model();
        TestValues[] testValues = TestValues.values();
        model.setRandomValue(TestValues.SUCCESSFUL_TRY.getValue());
        for(int i = 0; i <= testValues.length-2; i++){
            model.setUserValue(testValues[i].getValue());
            model.searchProcess();
            if(model.getRandomValue() > testValues[i].getValue()){
                assertTrue(model.getMinValue() == testValues[i].getValue() &&
                        model.getMaxValue() == previousMaxBarrier);
                previousMinBarrier = model.getMinValue();
            }else{
                assertTrue(model.getMaxValue() == testValues[i].getValue() &&
                        model.getMinValue() == previousMinBarrier);
                previousMaxBarrier = model.getMaxValue();
            }
        }
    }


}
