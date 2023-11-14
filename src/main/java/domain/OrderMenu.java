package domain;

import dto.OrderDTO;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import messages.ErrorMessages;

public class OrderMenu {
    private HashMap<Menu, Integer> menus = new LinkedHashMap();
    private final static int MAX_COUNT = 20;

    public OrderMenu(List<OrderDTO> orderDtos) {
        transfer(orderDtos);
    }

    public HashMap getOrderMenu(){
        return menus;
    }

    public void transfer(List<OrderDTO> orderDtos) {
        for (OrderDTO dto : orderDtos) {
            Menu menu = Menu.of(dto.getMenuName());
            int count = dto.getCount();
            notExistMenu(menu);
            invalidCount(count);
            duplicationManu(menu);

            putMenu(menu,count);
        }
        overMaxCount();
        validationImpossibleOrder();
    }

    public void putMenu(Menu menu, int count){
        menus.put(menu, count);
    }

    public boolean contains(Menu menu) {
        return menus.containsKey(menu);
    }


    public int calculateTotalPrice() {
        int totalPrice = 0;

        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            Menu menu = entry.getKey();
            Integer value = entry.getValue();
            totalPrice = totalPrice + menu.getPrice() * value;
        }
        return totalPrice;
    }
    public void validationImpossibleOrder(){
        if(onlyDrinks()){
            throw new IllegalArgumentException(ErrorMessages.IMPOSSIBLE_ORDER_ERROR);
        }
    }
    public boolean onlyDrinks(){

        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            Menu menu = entry.getKey();
            if(Category.of(menu)!=Category.DRINK){
                return false;
            }
        }
        return true;
    }

    public void overMaxCount(){
        if(totalCount()>MAX_COUNT){
            throw  new IllegalArgumentException(ErrorMessages.OVER_MAX_COUNT);
        }
    }
    public int totalCount(){
        return menus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    private static void invalidCount(int count) {
        if (count> MAX_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.OVER_MAX_COUNT);
        }
    }

    private static void notExistMenu(Menu menu) {
        if (menu == Menu.NOT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR);
        }
    }

    public void duplicationManu(Menu menu) {
        if (contains(menu)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_ORDER_ERROR);
        }

    }

}
