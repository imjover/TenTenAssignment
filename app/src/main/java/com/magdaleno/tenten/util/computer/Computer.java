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

    /**
     * Set the max length of the {@code Computer}'s stack.
     * @param length
     */
    public Computer(int length) {
        mCommands = Arrays.asList(new Command[100]); // new ArrayList<>(length);
        mDataTable = new DataTable();
        mOutput = new Output();
    }

    /**
     * Set the current address of the stack.
     * @param address
     */
    public void setAddress(int address) {
        this.mAddress = address;
    }

    /**
     * Insert new {@code Command} in the stack at the current address.
     *
     * <p>Note: Address is incremented at the end of the method,
     * this is to allow adding of new {@code Command}s without setting the address everytime.</p>
     * @param command
     */
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

    /**
     * @return the {@code Output} of the {@code Computer}'s executed commands.
     */
    public Output getOutput() {
        return mOutput;
    }

    /**
     * Initiates the execution of all inserted {@code Command}s in the {@code Computer}.
     * @param address an {@code int} which is the starting point of the execution.
     * @throws Exception
     */
    public void execute(@NonNull final int address) throws Exception {
        setAddress(address);
        execute();
    }

    /**
     * Recursive method that executes all inserted {@code Command}s in the {@code Computer}.
     * @throws Exception
     */
    private void execute() throws Exception {
        final Command currentCommand = mCommands.get(mAddress);
        /**
         * Increment mAddress before execution (for calling the next address).
         * This is to allow modification of address within the Command.
         */
        mAddress++;
        currentCommand.execute();

        // mContinueExecution will be set to false by the STOP command.
        if(mContinueExecution) {
            execute();
        }
    }

    /**
     * Signals the execution of {@code Command}s to stop.
     */
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
