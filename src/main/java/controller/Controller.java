package controller;

import domain.Bill;
import domain.Customer;
import domain.Menu;
import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import domain.event.ChristmasEvent;
import domain.event.DayEvent;
import domain.event.Event;
import domain.event.EventRepository;
import domain.event.GiveawayEvent;
import domain.event.SpecialEvent;
import domain.event.WeekendEvent;
import dto.OrderDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import messages.BillMessage;
import messages.EventMessage;
import messages.InformationMassage;
import utils.Converter;
import utils.Validator;
import view.InputView;
import view.OutputView;

public class Controller {
    private final static int MENU_AND_COUNT = 2;
    private final static String DELIMITER = "-";
    private final static String SEPARATOR = ",";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    private OrderSheet orderSheet;
    private EventRepository eventRepository;
    private Bill bill;

    public void run() {
        Day day = inputDay();
        OrderMenu orderMenu = inputOrderMenu();
        createOrderSheet(day,orderMenu);
        createEventRepository();
        createBill();

    }

    public Day inputDay() {
        while (true) {
            try {
                Day day = getVisitDay();
                return day;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public OrderMenu inputOrderMenu() {

        while (true) {
            try {
                OrderMenu orderMenu = getOrderMenus();
                return orderMenu;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void renderOutputView() {
        renderOrderListView();
        renderPriceBeforeDiscountView();
        renderGiveawayView();
        renderEventBenefitsLog();
        renderBenefitsView();
        renderPriceAfterDiscountView();
        renderEventBadgeView();
    }

    public void createOrderSheet(Day day, OrderMenu orderMenu){
        orderSheet = new OrderSheet(day,orderMenu);
    }
    public void createEventRepository() {
        eventRepository = new EventRepository(orderSheet);
        inputView.printSentence(InformationMassage.EVENT_MESSAGE,orderSheet.getDay());
    }

    public Day getVisitDay() {
        String day = inputView.inputVisitDay();
        Validator.validationDay(day);
        return new Day(Converter.stringToInteger(day));
    }

    public OrderMenu getOrderMenus() {
        String input = inputView.inputMenuAndCount();
        Validator.validationMenus(input, SEPARATOR, DELIMITER,MENU_AND_COUNT );
        String[] menus = Converter.splitByDelimiter(input, SEPARATOR);
        List<OrderDTO> orderDtos = transferDto(menus);
        OrderMenu orderMenu = new OrderMenu(orderDtos);
        return orderMenu;
    }

    public List<OrderDTO> transferDto(String[] input) {
        List<OrderDTO> orderDtos = new ArrayList<>();
        for (String menu : input) {
            orderDtos.add(createDto(menu));
        }
        return orderDtos;
    }

    public OrderDTO createDto(String input) {
        String[] menuAndCount = Converter.splitByDelimiter(input, DELIMITER);
        return new OrderDTO(menuAndCount[0], Converter.stringToInteger(menuAndCount[1]));
    }

    public void createBill() {
        bill = new Bill(orderSheet, eventRepository);
    }

    public void renderOrderListView() {
        HashMap<Menu, Integer> menus = orderSheet.getOrderMenu();
        outputView.printNotice(BillMessage.ORDER_MENU_MESSAGE);
        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            String menu = entry.getKey().getName();
            String count = String.valueOf(entry.getValue());
            outputView.printOrderMenu(menu, count);
        }
    }

    public void renderPriceBeforeDiscountView() {
        outputView.printNotice(BillMessage.BEFORE_DISCOUNT_MESSAGE);
        outputView.printPrice(Converter.IntegerToString(bill.getPriceBeforeDiscount()));
    }

    public void renderGiveawayView() {
        outputView.printNotice(BillMessage.GIVEAWAY_MESSAGE);
        if(bill.getGiveaway()==null){
            outputView.printGiveaway(EventMessage.NOT_EXIST,EventMessage.NOT_EXIST);
            return;
        }
        outputView.printGiveaway(bill.getGiveaway().getMenu(),
                Converter.IntegerToString(bill.getGiveaway().getCount()));
    }

    public void renderEventBenefitsLog() {
        outputView.printNotice(BillMessage.BENEFITS_LIST_MESSAGE);
        HashMap<Event, Integer> eventAndBenefits = bill.getEventAndBenefits();
        if (eventAndBenefits.size() == 0) {
            outputView.printEvents(EventMessage.NOT_EXIST, EventMessage.NOT_EXIST);
        }
        for (Map.Entry<Event, Integer> entry : eventAndBenefits.entrySet()) {
            Event event = entry.getKey();
            int discountPrice = entry.getValue();
            String eventName = branchEvent(event);
            branchEvent(event);
            outputView.printEvents(eventName, Converter.IntegerToString(discountPrice));
        }
    }

    public void renderBenefitsView() {
        outputView.printNotice(BillMessage.TOTAL_BENEFITS_MESSAGE);
        outputView.printEventPrice(String.valueOf(bill.totalBenefits(eventRepository)));

    }


    public void renderPriceAfterDiscountView() {
        outputView.printNotice(BillMessage.AFTER_COUNT_MESSAGE);
        outputView.printPrice(String.valueOf(bill.getPriceAfterDiscount(eventRepository)));
    }

    public void renderEventBadgeView() {
        outputView.printNotice(BillMessage.EVENT_BADGE_MASSAGE);
        Customer customer = new Customer(orderSheet, eventRepository);
        outputView.printBadge(customer.getBadge());

    }

    public String branchEvent(Event event) {
        if (event.getClass() == ChristmasEvent.class) {
            return EventMessage.CHRISTMAS_EVENT_MESSAGE;
        }
        if (event.getClass() == DayEvent.class) {
            return EventMessage.DAY_EVENT_MESSAGE;
        }
        if (event.getClass() == WeekendEvent.class) {
            return EventMessage.WEEKEND_EVENT_MESSAGE;
        }
        if (event.getClass() == SpecialEvent.class) {
            return EventMessage.SPECIAL_EVENT_MESSAGE;
        }
        if (event.getClass() == GiveawayEvent.class) {
            return EventMessage.GIVEAWAY_EVENT_MESSAGE;
        }
        return EventMessage.NOT_EXIST;
    }

}
