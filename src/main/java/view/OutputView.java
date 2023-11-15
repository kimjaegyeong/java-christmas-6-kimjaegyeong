package view;

import domain.Giveaway;
import domain.date.Day;
import domain.event.ChristmasEvent;
import domain.event.Event;
import domain.event.SpecialEvent;
import domain.event.WeekendEvent;
import messages.EventMessage;

public class OutputView {
    private final static String START_SYMBOL = "<";
    private final static String END_SYMBOL = ">";
    private final static String COUNT_SYMBOL = "개";
    private final static String MONEY_SYMBOL = "원";
    public static final String THOUSAND_SEPARATOR = ",";
    public static final String BENEFITS_PREFIX = "-";

    public void printOrderMenu(String menu, String count) {
        System.out.println(menu + " " + count + COUNT_SYMBOL);
    }

    public void printPrice(String price) {
        System.out.println(addThousandSeparator(price) + MONEY_SYMBOL);
    }

    public void printEvents(String event, String price) {
        if (event.equals(EventMessage.NOT_EXIST)) {
            System.out.println(EventMessage.NOT_EXIST);
            return;
        }
        printEventPrice(price);
    }

    public void printEventPrice(String price){
        if(price.equals("0")){
            System.out.println(EventMessage.NOT_EXIST);
            return;
        }
        System.out.println(BENEFITS_PREFIX + addThousandSeparator(price) + MONEY_SYMBOL);
    }

    public void printGiveaway(String giveaway) {
        if (giveaway == null) {
            System.out.println(EventMessage.NOT_EXIST);
            return;
        }
        System.out.println(giveaway);
    }


    public String addThousandSeparator(String priceNumber) {
        return priceNumber.replaceAll("\\B(?=(\\d{3})+(?!\\d))", THOUSAND_SEPARATOR); //3자릿 수 마다 "," 문자 추가
    }

    public void printNotice(String message) {
        System.out.println(START_SYMBOL + message + END_SYMBOL);
    }
}
