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


}
