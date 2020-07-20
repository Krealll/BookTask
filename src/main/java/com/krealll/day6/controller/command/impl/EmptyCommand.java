package com.krealll.day6.controller.command.impl;

import com.krealll.day6.controller.ResponseParameter;
import com.krealll.day6.controller.command.ActionCommand;

import java.util.HashMap;
import java.util.Map;

public class EmptyCommand implements ActionCommand {

    @Override
    public Map<String, Object> execute(Map<String, Object> params) {
        Map<String, Object> response = new HashMap<>();
        response.put(ResponseParameter.RESPONSE_STATUS, ResponseParameter.RESPONSE_STATUS_FAILURE);
        return response;
    }

}
