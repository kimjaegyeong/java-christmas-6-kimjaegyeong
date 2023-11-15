package controller;

import domain.Bill;
import domain.Customer;
import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import domain.event.Event;
import domain.event.EventRepository;
import dto.OrderDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        createOrderSheet();
        createEventRepository();
        createBill();

    }

    public void renderOutputView(){
        renderOrderListView();
        renderPriceBeforeDiscountView();
        renderGiveawayView();
        renderEventBenefitsLog();
        renderBenefitsView();
        renderPriceAfterDiscountView();
        renderEventBadgeView();
    }

    public void createEventRepository() {
        eventRepository = new EventRepository(orderSheet);
    }

    public void createOrderSheet() {
        Day day = getVisitDay();
        OrderMenu orderMenu = getOrderMenus();
        orderSheet = new OrderSheet(day, orderMenu);
    }

    public Day getVisitDay() {
        String day = inputView.inputVisitDay();
        Validator.validationDay(inputView.inputVisitDay());
        return new Day(Converter.stringToInteger(day));
    }

    public OrderMenu getOrderMenus() {
        String input = inputView.inputMenuAndCount();
        Validator.validationMenus(input, SEPARATOR, MENU_AND_COUNT);

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
        orderSheet.getOrderMenu();
        //...
    }

    public void renderGiveawayView() {
        bill.getGiveaway();
        //view.. giveaway 객체를 보내서 있고 없고에 따른 처리는 view가 담당하도록
    }

    public void renderEventBenefitsLog() {
        HashMap<Event, Integer> eventAndBenefits = bill.getEventAndBenefits();
        for (Map.Entry<Event, Integer> entry : eventAndBenefits.entrySet()) {
            Event event = entry.getKey();
            int discountPrice = entry.getValue();
        }
    }

    public void renderBenefitsView() {

        bill.totalBenefits(eventRepository);
        //view.. 값이 0일 때, 값이 1 이상일 때 따른 처리는 view 담당
    }

    public void renderPriceBeforeDiscountView() {
        bill.getPriceBeforeDiscount();
        //view..
    }

    public void renderPriceAfterDiscountView() {
        bill.getPriceAfterDiscount(eventRepository);
    }

    public void renderEventBadgeView(){
        Customer customer = new Customer(orderSheet);
        customer.getBadge(eventRepository);

    }

}
