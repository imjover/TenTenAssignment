package com.magdaleno.tenten.util.computer.command;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.DataTable;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithDataTable;
import com.magdaleno.tenten.util.computer.exception.InvalidDataTypeException;
import com.magdaleno.tenten.util.computer.exception.StackIsEmptyException;
import com.magdaleno.tenten.util.computer.values.IntegerValue;
import com.magdaleno.tenten.util.computer.values.Value;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.magdaleno.tenten.util.computer.exception.ExceptionMessages.INVALID_DATA_TYPE;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

/**
 * "CALL addr"
 * Set the program counter (PC) to `addr.
 */
public class MultiplyCommand implements CommandWithDataTable {

    private DataTable mDataTable;

    @Override
    public void addDataTable(@NonNull DataTable dataTable) {
        this.mDataTable = checkNotNull(dataTable);
    }

    @Override
    public void execute() throws StackIsEmptyException, InvalidDataTypeException {
        Value tempVal1 = mDataTable.getLatestValue();
        Value tempVal2 = mDataTable.getLatestValue();
        IntegerValue var2, var1;

        // Check if data type of argument(s) is correct.
        try {
            var2 = (IntegerValue) tempVal2;
        }
        catch (ClassCastException ex) {
            throw new InvalidDataTypeException(INVALID_DATA_TYPE
                    .replace("<type1>", tempVal2.getClass().getName())
                    .replace("<type2>", IntegerValue.class.getName())
            );
        }

        try {
            var1 = (IntegerValue) tempVal1;
        }
        catch (ClassCastException ex) {
            throw new InvalidDataTypeException(INVALID_DATA_TYPE
                    .replace("<type1>", tempVal1.getClass().getName())
                    .replace("<type2>", IntegerValue.class.getName())
            );
        }

        int answer = var1.getValue() * var2.getValue();

        // Add answer to stack.
        mDataTable.add(new IntegerValue(answer));
    }
}
