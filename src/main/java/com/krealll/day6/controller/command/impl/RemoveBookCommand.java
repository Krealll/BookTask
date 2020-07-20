package com.krealll.day6.controller.command.impl;

import com.krealll.day6.controller.RequestParameter;
import com.krealll.day6.controller.ResponseParameter;
import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.exception.ServiceException;
import com.krealll.day6.model.service.BookService;

import java.util.HashMap;
import java.util.Map;

public class RemoveBookCommand implements ActionCommand {

    @Override
    public Map<String, Object> execute(Map<String, Object> params) {
        Map<String, Object> response = new HashMap<>();
        Book book = new Book((String[]) params.get(RequestParameter.AUTHOR),
                (String) params.get(RequestParameter.NAME),
                (int) params.get(RequestParameter.NUMBER_OF_PAGES));
        try {
            new BookService().remove(book);
            response.put(ResponseParameter.RESPONSE_STATUS, ResponseParameter.RESPONSE_STATUS_SUCCESS);
        } catch (ServiceException e) {
            response.put(ResponseParameter.RESPONSE_STATUS, ResponseParameter.RESPONSE_STATUS_FAILURE);
        }
        return response;
    }

}
