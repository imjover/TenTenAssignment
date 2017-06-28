package com.magdaleno.tenten.util.computer;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.command.contract.Command;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithComputer;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithDataTable;
import com.magdaleno.tenten.util.computer.command.contract.CommandWithOutput;

import java.util.Arrays;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class Computer {

    private int mAddress;
    private List<Command> mCommands;
    private DataTable mDataTable;
    private Output mOutput;
    private boolean mContinueExecution = true;

    public Computer(int length) {
        mCommands = Arrays.asList(new Command[100]); // new ArrayList<>(length);
        mDataTable = new DataTable();
        mOutput = new Output();
    }

    public void setAddress(int address) {
        this.mAddress = address;
    }

    public void insert(@NonNull final Command command) {
        checkNotNull(command);
        Command newCommand = command;

        if(command instanceof CommandWithDataTable) {
            ((CommandWithDataTable) newCommand).addDataTable(mDataTable);
        }
        if(command instanceof CommandWithOutput) {
            ((CommandWithOutput) newCommand).addOutput(mOutput);
        }
        if(command instanceof CommandWithComputer) {
            ((CommandWithComputer) newCommand).addComputer(this);
        }

        mCommands.set(mAddress, command);
        mAddress++; // increment address holder
    }

    public Output getOutput() {
        return mOutput;
    }

    public void execute(@NonNull final int address) throws Exception {
        setAddress(address);
        execute();
    }

    private void execute() throws Exception {
        final Command currentCommand = mCommands.get(mAddress);
        /**
         * Increment mAddress before execution (for calling the next address).
         * This is to allow modification of address within the Command.
         */
        mAddress++;

        // TODO: Look for better way to execute the STOP command
        // STOP Command will return FALSE
        currentCommand.execute();
        if(mContinueExecution) {
            execute();
        }
    }

    public void stopExecution() {
        mContinueExecution = false;
    }

    // TODO: Remove this logger
    public void printStack() {
        System.out.println("--------Stack Table Size: "+mCommands.size()+"--------");
        for(int i=0; i<mCommands.size(); i++) {
            if(mCommands.get(i)!=null) {
                System.out.println(i+": "+mCommands.get(i).getClass().getName());
            }
            else {
                System.out.println(i+": x");
            }
        }
        System.out.println("--------Stack Table Size: "+mCommands.size()+"--------");
    }
}
