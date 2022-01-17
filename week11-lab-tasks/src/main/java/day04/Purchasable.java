package day04;

import java.time.LocalDate;

public interface Purchasable {

    String getName();
    int getPrice();
    LocalDate getExpirationDate();
    void purchase();
    Purchasable copy();
}
