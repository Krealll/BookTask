package com.krealll.day6.controller.provider;

import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.controller.command.type.*;
import com.krealll.day6.controller.command.impl.*;

public class CommandProvider {

    public static ActionCommand defineCommand(String command){
        ActionCommand resultCommand = null;
        if(command!=null){
            try {
                resultCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
            } catch (IllegalArgumentException e){
                resultCommand = new EmptyCommand();
            }
        }
        return resultCommand;
    }
}
