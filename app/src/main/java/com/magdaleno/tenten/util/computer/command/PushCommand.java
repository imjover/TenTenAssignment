package com.magdaleno.tenten.util.computer.command;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.DataTable;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithDataTable;
import com.magdaleno.tenten.util.computer.values.Value;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

/**
 * "PUSH arg"
 * Push argument to the stack.
 */
public class PushCommand implements CommandWithDataTable {

    private DataTable mDataTable;
    private Value mArg;

    public PushCommand(@NonNull Value arg) {
        this.mArg = checkNotNull(arg);
    }

    @Override
    public void addDataTable(@NonNull DataTable dataTable) {
        this.mDataTable = checkNotNull(dataTable);
    }

    @Override
    public void execute() {
        mDataTable.add(mArg);
    }
}
