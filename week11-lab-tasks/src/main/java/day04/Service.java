package day04;

import java.time.LocalDate;

public class Service implements Purchasable {

    private final String name;
    private final int price;
    private LocalDate expirationDate;
    private static final int WARRANTY_DURATION = 12;

    public Service(String name, int price) {
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

    @Override
    public Service copy() {
        return new Service(name, price);
    }
}
