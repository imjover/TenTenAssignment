package com.magdaleno.tenten.activities.main.usecase;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.magdaleno.tenten.base.UseCase;
import com.magdaleno.tenten.util.computer.Computer;
import com.magdaleno.tenten.util.computer.Output;
import com.magdaleno.tenten.util.computer.command.CallCommand;
import com.magdaleno.tenten.util.computer.command.MultiplyCommand;
import com.magdaleno.tenten.util.computer.command.PrintCommand;
import com.magdaleno.tenten.util.computer.command.PushCommand;
import com.magdaleno.tenten.util.computer.command.ReturnCommand;
import com.magdaleno.tenten.util.computer.command.StopCommand;
import com.magdaleno.tenten.util.computer.values.IntegerValue;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/29/2017.
 */

public class LoadComputerCommands extends UseCase<LoadComputerCommands.RequestValues, LoadComputerCommands.ResponseValue> {

    private final int ADDRESS_MAIN = 0;
    private final int ADDRESS_PRINT_TENTEN = 50;
    private final int STACK_SIZE = 100;

    @Override
    protected void executeUseCase(RequestValues requestValues) {

        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // Instructions for the print_tenten function
        computer.setAddress(ADDRESS_PRINT_TENTEN);
        computer.insert( new MultiplyCommand());
        computer.insert( new PrintCommand());
        computer.insert( new ReturnCommand());

        // The start of the main function
        computer.setAddress(ADDRESS_MAIN);
        computer.insert( new PushCommand(new IntegerValue(1009)));
        computer.insert( new PrintCommand());

        // Return address for when print_tenten function finishes
        computer.insert(new PushCommand(new IntegerValue(6)));

        // Setup arguments and call print_tenten
        computer.insert( new PushCommand(new IntegerValue(101)));
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new CallCommand(new IntegerValue(ADDRESS_PRINT_TENTEN)));

        // Stop the program
        computer.insert( new StopCommand());

        // Execute the program
        try {
            computer.execute(ADDRESS_MAIN);
            // Finish Usecase. Return output.
            getUseCaseCallback().onFinish(new ResponseValue(computer.getOutput()));
        } catch (Exception e) {
            // Finish Usecase. Return error.
            getUseCaseCallback().onError(e.getMessage());
        }
    }

    public static final class RequestValues implements UseCase.RequestValues {
        public RequestValues() {
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {
        private final Output output;

        public ResponseValue(@NonNull Output output) {
            this.output = checkNotNull(output);
        }

        public Output getOutput() {
            return output;
        }
    }
}
