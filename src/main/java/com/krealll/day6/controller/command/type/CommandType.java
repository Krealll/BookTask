package com.krealll.day6.controller.command.type;

import com.krealll.day6.controller.command.ActionCommand;
import com.krealll.day6.controller.command.impl.*;

public enum CommandType {
    ADD_BOOK(new AddBookCommand()),
    FIND_ALL_BOOKS(new FindAllBooksCommand()),
    FIND_BY_AUTHOR(new FindByAuthorCommand()),
    FIND_BY_NUMBER_OF_PAGES(new FindByNumberOfPagesCommand()),
    FIND_BY_NAME(new FindByNameCommand()),
    FIND_BY_ID(new FindByIdCommand()),
    SORT_BY_NAME(new SortByNameCommand()),
    SORT_BY_NUMBER_OF_PAGES(new SortByNumberOfPagesCommand()),
    SORT_BY_AUTHOR(new SortByAuthorCommand()),
    SORT_BY_ID(new SortByIdCommand()),
    REMOVE_BOOK(new RemoveBookCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }

}

