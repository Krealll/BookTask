package com.krealll.day6.controller.command;

import java.util.Map;

public interface ActionCommand {

    Map<String, Object> execute(Map<String, Object> params) ;
}
