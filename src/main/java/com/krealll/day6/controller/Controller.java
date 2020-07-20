package com.krealll.day6.controller;

import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.controller.provider.CommandProvider;

import java.util.Map;

public class Controller {

    public Map<String, Object> doCommand(String action, Map<String,Object> parameters) {
        ActionCommand currentCommand = CommandProvider.defineCommand(action);
        Map<String,Object> result = currentCommand.execute(parameters);
        return result;
    }

}
