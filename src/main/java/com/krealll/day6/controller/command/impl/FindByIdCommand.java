package com.krealll.day6.controller.command.impl;

import com.krealll.day6.controller.RequestParameter;
import com.krealll.day6.controller.ResponseParameter;
import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.exception.ServiceException;
import com.krealll.day6.model.service.BookService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FindByIdCommand implements ActionCommand {

    @Override
    public Map<String, Object> execute(Map<String, Object> params) {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            Book book;
            Optional<Book> bookOptional = new BookService().findById((long) params.get(RequestParameter.ID));
            if(bookOptional.isPresent()){
                book = bookOptional.get();
                responseMap.put(ResponseParameter.RESPONSE_STATUS,ResponseParameter.RESPONSE_STATUS_SUCCESS);
                responseMap.put(ResponseParameter.RESPONSE_RESULT,book);
            } else {
                responseMap.put(ResponseParameter.RESPONSE_STATUS,ResponseParameter.RESPONSE_STATUS_FAILURE);
            }
        } catch (ServiceException e) {
            responseMap.put(ResponseParameter.RESPONSE_STATUS, ResponseParameter.RESPONSE_STATUS_FAILURE);
        }
        return responseMap;
    }

}
