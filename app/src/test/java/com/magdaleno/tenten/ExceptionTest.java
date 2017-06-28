package com.magdaleno.tenten;

import com.magdaleno.tenten.util.computer.Computer;
import com.magdaleno.tenten.util.computer.command.CallCommand;
import com.magdaleno.tenten.util.computer.command.MultiplyCommand;
import com.magdaleno.tenten.util.computer.command.PrintCommand;
import com.magdaleno.tenten.util.computer.command.PushCommand;
import com.magdaleno.tenten.util.computer.command.ReturnCommand;
import com.magdaleno.tenten.util.computer.command.StopCommand;
import com.magdaleno.tenten.util.computer.exception.InvalidDataTypeException;
import com.magdaleno.tenten.util.computer.exception.StackIsEmptyException;
import com.magdaleno.tenten.util.computer.values.IntegerValue;
import com.magdaleno.tenten.util.computer.values.StringValue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class ExceptionTest {

    private final int STACK_SIZE = 100;
    private final int ADDRESS_MAIN = 0;

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void pushCommandIsMissing_exceptionTest() throws Exception {
        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);
        computer.setAddress(ADDRESS_MAIN);

        // Intentionally remove the PUSH command here to trigger StackIsEmptyException
        computer.insert( new PrintCommand());
        computer.insert( new StopCommand());

        // Expected exception
        expectedException.expect( StackIsEmptyException.class);
        computer.execute(ADDRESS_MAIN);
    }

    @Test
    public void invalidDataType_arg1_test() throws Exception {
        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // The start of the main function
        computer.setAddress(ADDRESS_MAIN);
        computer.insert( new PushCommand(new StringValue("ten")));
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new MultiplyCommand());
        computer.insert( new PrintCommand());

        // Stop the program
        computer.insert( new StopCommand());

        // Expected exception
        expectedException.expect( InvalidDataTypeException.class);
        computer.execute(ADDRESS_MAIN);
    }

    @Test
    public void invalidDataType_arg2_test() throws Exception {
        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // The start of the main function
        computer.setAddress(ADDRESS_MAIN);
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new PushCommand(new StringValue("ten")));
        computer.insert( new MultiplyCommand());
        computer.insert( new PrintCommand());

        // Stop the program
        computer.insert( new StopCommand());

        // Expected exception
        expectedException.expect( InvalidDataTypeException.class);
        computer.execute(ADDRESS_MAIN);
    }

    @Test
    public void outOfBounceAddress_test() throws Exception {
        final int address = 101;

        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // Instructions for the print_tenten function
        computer.setAddress(address);

        // Stop the program
        expectedException.expect( ArrayIndexOutOfBoundsException.class);
        computer.insert( new StopCommand());

        // Execute the program
        computer.execute(ADDRESS_MAIN);
    }
}
