package com.magdaleno.tenten.util.computer.values;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class IntegerValue implements Value {

    private int mValue;

    public IntegerValue(int value) {
        this.mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return String.valueOf(mValue);
    }
}
