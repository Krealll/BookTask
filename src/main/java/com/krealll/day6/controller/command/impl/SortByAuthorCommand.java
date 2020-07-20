package com.krealll.day6.controller.command.impl;

import com.krealll.day6.controller.ResponseParameter;
import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByAuthorCommand implements ActionCommand {

    @Override
    public Map<String, Object> execute(Map<String, Object> params) {
        Map<String, Object> response = new HashMap<>();
        List<Book> books = new BookService().sortByAuthor();
        response.put(ResponseParameter.RESPONSE_STATUS, ResponseParameter.RESPONSE_STATUS_SUCCESS);
        response.put(ResponseParameter.RESPONSE_RESULT, books);
        return response;
    }

}

