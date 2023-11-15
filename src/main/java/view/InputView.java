package view;

import camp.nextstep.edu.missionutils.Console;
import messages.InformationMassage;

public class InputView {
    private final static int MENU_AND_COUNT = 2;
    private final static String DELIMITER = "-";
    private final static String SEPARATOR = ",";

    public String inputVisitDay() {
        System.out.println(InformationMassage.WELCOME_MESSAGE);
        System.out.println(InformationMassage.INPUT_VISIT_DAY_MESSAGE);
        String input = Console.readLine();
        return input;
    }

    public String inputMenuAndCount() {
        System.out.println(InformationMassage.INPUT_MENU_MESSAGE);
        String input = Console.readLine();
        return input;
    }
    public void printSentence(String notice,int input){
        System.out.printf(notice,input);
    }


}
