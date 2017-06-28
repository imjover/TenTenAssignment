package com.magdaleno.tenten.util.computer.values;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class StringValue implements Value {

    private String mValue;

    public StringValue(String value) {
        this.mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return mValue;
    }
}
