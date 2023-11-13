package domain;

import dto.OrderDTO;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
            overMaxCount();

            putMenu(menu,count);
        }
    }

    public void putMenu(Menu menu, int count){
        menus.put(menu, count);
    }

    public void overMaxCount(){
        if(totalCount()>MAX_COUNT){
            throw  new IllegalArgumentException();
        }
    }
    public int totalCount(){
        return menus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    private static void invalidCount(int count) {
        if (count> MAX_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void notExistMenu(Menu menu) {
        if (menu == Menu.NOT) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicationManu(Menu menu) {
        if (contains(menu)) {
            throw new IllegalArgumentException();
        }

    }

    public boolean contains(Menu menu) {
        return menus.containsKey(menu);
    }
}
