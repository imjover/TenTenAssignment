package com.magdaleno.tenten.util.computer.command;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.Computer;
import com.magdaleno.tenten.util.computer.DataTable;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithComputer;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithDataTable;
import com.magdaleno.tenten.util.computer.exception.InvalidDataTypeException;
import com.magdaleno.tenten.util.computer.exception.StackIsEmptyException;
import com.magdaleno.tenten.util.computer.values.IntegerValue;
import com.magdaleno.tenten.util.computer.values.Value;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.magdaleno.tenten.util.computer.exception.ExceptionMessages.INVALID_DATA_TYPE;

/**
 * "RET"
 * Pop address from stack and set PC to address.
 */
public class ReturnCommand implements CommandWithDataTable, CommandWithComputer {

    private Computer mComputer;
    private DataTable mDataTable;

    @Override
    public void addDataTable(@NonNull DataTable dataTable) {
        this.mDataTable = checkNotNull(dataTable);
    }

    @Override
    public void addComputer(@NonNull Computer computer) {
        this.mComputer = checkNotNull(computer);
    }

    @Override
    public void execute() throws InvalidDataTypeException, StackIsEmptyException {
        Value tempVal1 = mDataTable.getLatestValue();
        IntegerValue var1;

        // Check if data type of argument(s) is correct.
        try {
            var1 = (IntegerValue) tempVal1;
        }
        catch (ClassCastException ex) {
            throw new InvalidDataTypeException(INVALID_DATA_TYPE
                    .replace("<type1>", tempVal1.getClass().getName())
                    .replace("<type2>", IntegerValue.class.getName())
            );
        }

        mComputer.setAddress(var1.getValue());
    }
}
