package com.magdaleno.tenten.util.computer.command.contract;

import android.support.annotation.NonNull;

import com.magdaleno.tenten.util.computer.DataTable;

/**
 * Created by John Oliver "Jover" Magdaleno on 6/28/2017.
 */

public interface CommandWithDataTable extends Command {
    void addDataTable(@NonNull final DataTable dataTable);
}
