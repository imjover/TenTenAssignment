package com.magdaleno.tenten.util.computer.command;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.Computer;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithComputer;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * {@code STOP}
 * Exit the program.
 */
public class StopCommand implements CommandWithComputer {

    private Computer mComputer;

    @Override
    public void addComputer(@NonNull Computer computer) {
        this.mComputer = checkNotNull(computer);
    }

    @Override
    public void execute() {
        mComputer.stopExecution();
    }
}
