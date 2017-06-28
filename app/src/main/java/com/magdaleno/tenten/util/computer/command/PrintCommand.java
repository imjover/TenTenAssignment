package com.magdaleno.tenten.util.computer.command;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.DataTable;
import com.magdaleno.tenten.util.computer.Output;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithDataTable;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithOutput;
import com.magdaleno.tenten.util.computer.exception.StackIsEmptyException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * {@code PRINT}
 * Pop value from stack and print it.
 */
public class PrintCommand implements CommandWithDataTable, CommandWithOutput {

    private DataTable mDataTable;
    private Output mOutput;

    @Override
    public void addDataTable(@NonNull DataTable dataTable) {
        this.mDataTable = checkNotNull(dataTable);
    }

    @Override
    public void addOutput(@NonNull Output output) {
        this.mOutput = output;
    }

    @Override
    public void execute() throws StackIsEmptyException {
        mOutput.append("\n")
                .append(mDataTable.getLatestValue().toString());
    }
}
