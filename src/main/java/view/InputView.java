package view;

import camp.nextstep.edu.missionutils.Console;
import messages.ErrorMessages;
import utils.Converter;

public class InputView {
    private final static int MENU_AND_COUNT = 2;
    private final static String DELIMITER = "-";
    private final static String SEPARATOR = ",";

    public String inputVisitDay() {
        String input = Console.readLine();
        validationDay(input);
        return input;
    }

    public String inputMenuAndCount() {
        String input = Console.readLine();
        validationMenuAndCount(input);
        return input;
    }

    public void separateMenu(String input){
        String[] menus = Converter.splitByDelimiter(input,SEPARATOR);
        for(String menu : menus){
            validationMenuAndCount(menu);
        }
    }

    public void validationMenuAndCount(String input) {
        if (invalidDelimiter(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR);
        }
        if (invalidMenuAndCount(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR);
        }
    }

    public void validationDay(String input) {
        if (hasSpace(input) || isEmpty(input) || notNumber(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DAY_ERROR);
        }
    }

    public boolean invalidMenuAndCount(String input) {
        String[] inputs = splitMenuAndCount(input);
        String menu = inputs[0];
        String count = inputs[1];
        if (hasSpace(menu) || isEmpty(menu) || hasSpace(count) || isEmpty(count) || notNumber(count)) {
            return true;
        }
        return false;
    }


    public String[] splitMenuAndCount(String input) {
        return Converter.splitByDelimiter(input, DELIMITER);
    }

    public boolean invalidDelimiter(String input) {
        String[] inputs = splitMenuAndCount(input);
        if (inputs.length < MENU_AND_COUNT) {
            return true;
        }
        return false;
    }

    public boolean hasSpace(String input) {
        if (input.contains(" ")) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(String input) {
        if (input.isBlank()) {
            return true;
        }
        return false;
    }

    public boolean notNumber(String input) {
        if (!input.matches("\\d+")) {
            return true;
        }
        return false;
    }

}
