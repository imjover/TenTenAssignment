package com.magdaleno.tenten.util.computer.values;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

/**
 * The {@code Value} equivalent of {@code String}.
 */
public class StringValue implements Value {

    private String mValue;

    public StringValue(String value) {
        this.mValue = value;
    }

    /**
     * @return the value of {@code Value}.
     */
    public String getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return mValue;
    }
}
