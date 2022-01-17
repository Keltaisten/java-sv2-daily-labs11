package day04;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private final List<Purchasable> purchases = new ArrayList<>();
    private int balance;
    private static final int EXTENDED_WARRANTY_BALANCE_THRESHOLD_PRICE_FACTOR = 3;
    private static final double EXTENDED_WARRANTY_PRICE_FACTOR = 1.1;

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public List<Purchasable> getPurchases() {
        return purchases;
    }

    public int getBalance() {
        return balance;
    }

    public void purchase(Purchasable purchasable) {
        validatePurchase(purchasable);
        if (getPurchaseWithExtendedWarranty(purchasable)) {
            ((Item) purchasable).purchaseWithExtendedWarranty();
            balance -= (int) (purchasable.getPrice() * EXTENDED_WARRANTY_PRICE_FACTOR);
        } else {
            purchasable.purchase();
            balance -= purchasable.getPrice();
        }
        purchases.add(purchasable);
    }

    private void validatePurchase(Purchasable purchasable) {
        if (balance < purchasable.getPrice()) {
            throw new IllegalArgumentException("Balance too low");
        }
    }

    private boolean getPurchaseWithExtendedWarranty(Purchasable purchasable) {
        return purchasable instanceof Item && balance >= purchasable.getPrice() * EXTENDED_WARRANTY_BALANCE_THRESHOLD_PRICE_FACTOR;
    }
}
