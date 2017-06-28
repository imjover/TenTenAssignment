package com.magdaleno.tenten.util.computer;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.exception.StackIsEmptyException;
import com.magdaleno.tenten.util.computer.values.Value;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public final class DataTable {

    private List<Value> mSymbolTable = new ArrayList<>();

    /**
     * Returns the latest {@code Value} of the stack stored at the end of the records.
     * The returned {@code Value} is also removed in the stack.
     *
     * @return the latest value of the stack.
     * @throws StackIsEmptyException if the stack has no records. Use PUSH command to add {@code Value} in the stack.
     */
    public Value getLatestValue() throws StackIsEmptyException {
        if(mSymbolTable.size()==0) {
            throw new StackIsEmptyException("Stack table cannot be empty. Send PUSH command to add Value in the stack.");
        }

        int locationOfLastValue = mSymbolTable.size()-1;
        // Get latest value from the stack.
        Value value = mSymbolTable.get(locationOfLastValue);
        // Remove the value from the stack.
        mSymbolTable.remove(locationOfLastValue);
        return value;
    }

    /**
     * Add new {@code Value} in the stack.
     * @param value
     */
    public void add(@NonNull Value value) {
        mSymbolTable.add(checkNotNull(value));
    }
}
