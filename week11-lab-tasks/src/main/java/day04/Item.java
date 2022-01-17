package day04;

import java.time.LocalDate;

public class Item implements Purchasable {

    private final String name;
    private final int price;
    private LocalDate expirationDate;
    private static final int WARRANTY_DURATION = 3;
    private static final int EXTENDED_WARRANTY_DURATION = 36;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public LocalDate getExpirationDate() {
        if (expirationDate != null) {
            return expirationDate;
        }
        return LocalDate.now().plusMonths(WARRANTY_DURATION);
    }

    @Override
    public void purchase() {
        expirationDate = LocalDate.now().plusMonths(WARRANTY_DURATION);
    }

    public void purchaseWithExtendedWarranty() {
        expirationDate = LocalDate.now().plusMonths(EXTENDED_WARRANTY_DURATION);
    }

    @Override
    public Item copy() {
        return new Item(name, price);
    }
}
