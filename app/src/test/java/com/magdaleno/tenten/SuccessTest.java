package com.magdaleno.tenten;

import com.magdaleno.tenten.util.computer.Computer;
import com.magdaleno.tenten.util.computer.command.CallCommand;
import com.magdaleno.tenten.util.computer.command.MultiplyCommand;
import com.magdaleno.tenten.util.computer.command.PrintCommand;
import com.magdaleno.tenten.util.computer.command.PushCommand;
import com.magdaleno.tenten.util.computer.command.ReturnCommand;
import com.magdaleno.tenten.util.computer.command.StopCommand;
import com.magdaleno.tenten.util.computer.exception.StackIsEmptyException;
import com.magdaleno.tenten.util.computer.values.IntegerValue;
import com.magdaleno.tenten.util.computer.values.StringValue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public class SuccessTest {

    private final int STACK_SIZE = 100;
    private final int ADDRESS_MAIN = 0;

    @Test
    public void print_successTest() throws Exception {
        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // The start of the main function
        computer.setAddress(ADDRESS_MAIN);
        computer.insert( new PushCommand(new IntegerValue(1009)));
        computer.insert( new PrintCommand());
        computer.insert( new PushCommand(new IntegerValue(1010)));
        computer.insert( new PrintCommand());

        // Stop the program
        computer.insert( new StopCommand());

        // Execute the program
        computer.execute(ADDRESS_MAIN);

        assertEquals(computer.getOutput().toString(), "\n1009\n1010");
    }

    @Test
    public void multiply_successTest() throws Exception {
        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // The start of the main function
        computer.setAddress(ADDRESS_MAIN);
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new MultiplyCommand());
        computer.insert( new PrintCommand());

        // Stop the program
        computer.insert( new StopCommand());

        // Execute the program
        computer.execute(ADDRESS_MAIN);

        assertEquals(computer.getOutput().toString(), "\n100");
    }

    @Test
    public void printAndMultiply_successTest() throws Exception {
        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // The start of the main function
        computer.setAddress(ADDRESS_MAIN);
        computer.insert( new PushCommand(new StringValue("Test Printing")));
        computer.insert( new PrintCommand());
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new PushCommand(new IntegerValue(10)));
        computer.insert( new MultiplyCommand());
        computer.insert( new PrintCommand());

        // Stop the program
        computer.insert( new StopCommand());

        // Execute the program
        computer.execute(ADDRESS_MAIN);

        assertEquals(computer.getOutput().toString(), "\nTest Printing\n100");
    }

    @Test
    public void all_successTest() throws Exception {
        final int address_printTenTen = 50;

        // Create new computer with a stack of 100 addresses
        Computer computer = new Computer(STACK_SIZE);

        // Instructions for the print_tenten function
        computer.setAddress(address_printTenTen);
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
        computer.insert( new CallCommand(new IntegerValue(address_printTenTen)));

        // Stop the program
        computer.insert( new StopCommand());

        // Execute the program
        computer.execute(ADDRESS_MAIN);

        assertEquals(computer.getOutput().toString(), "\n1009\n1010");
    }
}
