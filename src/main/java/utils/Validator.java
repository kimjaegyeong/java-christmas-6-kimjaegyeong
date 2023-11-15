package utils;

import messages.ErrorMessages;

public class Validator {
    public static String[] separateMenu(String input, String separator) {
        return Converter.splitByDelimiter(input, separator);
    }

    public static void validationMenus(String input, String separator, String delimiter, int count) {
        String[] menus = separateMenu(input, separator);
        for (String menu : menus) {
            validationMenuAndCount(menu, delimiter, count);
        }
    }

    public static void validationMenuAndCount(String input, String delimiter, int count) {
        if (invalidDelimiter(input, delimiter, count)) {

            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR);
        }
        if (invalidMenuAndCount(input, delimiter)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR);
        }
    }

    public static void validationDay(String input) {
        if (hasSpace(input) || isEmpty(input) || notNumber(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DAY_ERROR);
        }
    }

    public static boolean invalidMenuAndCount(String input, String delimiter) {

        String[] inputs = splitMenuAndCount(input,delimiter);
        String menu = inputs[0];
        String count = inputs[1];
        if (hasSpace(menu) || isEmpty(menu) || hasSpace(count) || isEmpty(count) || notNumber(count)) {
            return true;
        }
        return false;
    }


    public static String[] splitMenuAndCount(String input, String delimiter) {
        return Converter.splitByDelimiter(input, delimiter);
    }

    public static boolean invalidDelimiter(String input, String delimiter, int count) {
        String[] inputs = splitMenuAndCount(input, delimiter);
        if (inputs.length == count) {
            return false;
        }
        return true;
    }

    public static boolean hasSpace(String input) {
        if (input.contains(" ")) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String input) {
        if (input.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean notNumber(String input) {
        if (!input.matches("\\d+")) {
            return true;
        }
        return false;
    }

}
