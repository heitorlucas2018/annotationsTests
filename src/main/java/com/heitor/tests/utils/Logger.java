package com.heitor.tests.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private Logger(){}

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    public static void info(Object ...obj) {
        print(ANSI_GREEN, obj);
    }

    public static void alert(Object ...obj) {
        print(ANSI_YELLOW, obj);
    }

    private static void print(String stringColor, Object ...obj) {
        final var msg = new StringBuilder(stringColor).
                append(ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME)+" ");

        for(Object o: obj) {
            if(o instanceof String) {
                msg.append((String) o);
            } else {
                msg.append(o.toString());
            }
            msg.append(" ");
        }
        System.out.println(msg.append(ANSI_RESET));
    }
}
