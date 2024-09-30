package com.streaming.app.streaming.shared.domain.sort;

public class SortDirection {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public static boolean isAsc(String direction) {
        return ASC.toLowerCase().equals(direction.toLowerCase());
    }

    public static boolean isDesc(String direction) {
        return DESC.toLowerCase().equals(direction.toLowerCase());
    }

    public static String of(String value) {
        if (value == null || value.isEmpty()) {
            return ASC;
        }
        return isAsc(value) ? ASC : DESC;
    }

}
