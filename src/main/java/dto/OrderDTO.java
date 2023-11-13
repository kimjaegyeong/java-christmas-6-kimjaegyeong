package dto;

import org.mockito.internal.matchers.Or;

public class OrderDTO {
    String menuName;
    int count;

    public OrderDTO(String menuName, int count) {
        this.menuName = menuName;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getMenuName() {
        return menuName;
    }

    @Override
    public boolean equals(Object obj) {
        OrderDTO other = (OrderDTO) obj;
        return this.menuName == other.getMenuName();
    }
}
