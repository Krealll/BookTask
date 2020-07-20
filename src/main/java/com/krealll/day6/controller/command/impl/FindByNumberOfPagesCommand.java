package com.krealll.day6.controller.command.impl;

import com.krealll.day6.controller.RequestParameter;
import com.krealll.day6.controller.ResponseParameter;
import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.exception.ServiceException;
import com.krealll.day6.model.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindByNumberOfPagesCommand implements ActionCommand {

    @Override
    public Map<String, Object> execute(Map<String, Object> params) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            List<Book> books = new BookService().findByNumberOfPages((int) params.get(RequestParameter.NUMBER_OF_PAGES));
            responseMap.put(ResponseParameter.RESPONSE_STATUS,ResponseParameter.RESPONSE_STATUS_SUCCESS);
            responseMap.put(ResponseParameter.RESPONSE_RESULT,books);
        } catch (ServiceException e) {
            responseMap.put(ResponseParameter.RESPONSE_STATUS, ResponseParameter.RESPONSE_STATUS_FAILURE);
        }
        return responseMap;
    }

}
