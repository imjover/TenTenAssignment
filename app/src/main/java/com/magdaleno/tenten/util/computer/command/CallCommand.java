package com.magdaleno.tenten.util.computer.command;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.Computer;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithComputer;
import com.magdaleno.tenten.util.computer.values.IntegerValue;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

/**
 * {@code CALL addr}
 * Set the program counter (PC) to `addr.
 */
public class CallCommand implements CommandWithComputer {

    private Computer mComputer;
    private IntegerValue mArg;

    public CallCommand(@NonNull final IntegerValue arg) {
        this.mArg = checkNotNull(arg);
    }

    @Override
    public void addComputer(@NonNull Computer computer) {
        this.mComputer = checkNotNull(computer);
    }

    @Override
    public void execute() {
        mComputer.setAddress(mArg.getValue());
    }
}
