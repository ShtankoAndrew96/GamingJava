package ua.training.gj;

/**
 * Created by andrew on 18.04.17.
 */
public enum TestValues {
    FIRST_TRY(5),
    SECOND_TRY(10),
    THIRD_TRY(85),
    FOURTH_TRY(20),
    FIFTH_TRY(35),
    SIXTH_TRY(70),
    SEVENTH_TRY(45),
    EIGHTH_TRY(38),
    NINTH_TRY(44),
    SUCCESSFUL_TRY(41);


    private final int value;

    TestValues(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
