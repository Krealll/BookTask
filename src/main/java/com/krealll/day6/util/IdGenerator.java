package com.krealll.day6.util;

public class IdGenerator {

    private final static long MIN_ID = 1;
    private final static long MAX_ID = 1_000_000;

    private static long id;

    private IdGenerator(){}

    public static long generateId(){
        id++;
        if(id>MAX_ID){
            id=MIN_ID;
        }

        return id;
    }
}
