package com.magdaleno.tenten.util.computer.command.contract;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.Output;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public interface CommandWithOutput extends Command {
    void addOutput(@NonNull final Output output);
}
