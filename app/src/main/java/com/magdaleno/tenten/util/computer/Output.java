package com.magdaleno.tenten.util.computer;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

final public class Output {

    private StringBuilder mOutput;

    @Override
    public String toString() {
        return mOutput.toString();
    }

    /**
     * Appends {@code String} in the {@code Output}.
     * @param string the value
     * @return {@code Output}
     */
    public Output append(String string) {
        if(mOutput==null)
            mOutput = new StringBuilder();
        mOutput.append(string);
        return this;
    }
}
