package com.codecool.helper;

public enum Action {

    SELECT("select"),
    EXIT("exit"),
    SORT("sort"),
    HISTORY("history"),
    CHECK("check");

    private String action;

    Action(String value){
        this.action = value;
    }

    public static Action getInstance(String action) throws NullPointerException{

        Action result = null;

        for(Action elem : values()) {
            if(elem.getValue().equals(action)) {
                result = elem;
            }
        }
        return result;
    }

    public String getValue() {
        return action;
    }
}
