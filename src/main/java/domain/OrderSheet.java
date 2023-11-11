package domain;

public class OrderSheet {
    private final Menu menu;
    // menu와 category를 한꺼번에 관리하는 클래스 1개 생성 , 그 클래스와 갯수를 hashmap 으로 관리
    public OrderSheet(Menu menu) {
        this.menu = menu;

    }
}
