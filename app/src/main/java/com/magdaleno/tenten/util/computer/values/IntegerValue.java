package com.magdaleno.tenten.util.computer.values;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

/**
 * The {@code Value} equivalent of {@code int}.
 */
public class IntegerValue implements Value {

    private int mValue;

    public IntegerValue(int value) {
        this.mValue = value;
    }

    /**
     * @return the value of {@code Value}.
     */
    public int getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }
}
