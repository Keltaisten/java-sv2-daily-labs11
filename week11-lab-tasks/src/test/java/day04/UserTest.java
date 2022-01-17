package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User("John Doe", 3000);
    Purchasable p1 = new Item("Walkman", 2000);
    Purchasable p2 = new Item("Battery", 1000);
    Purchasable p3 = new Service("Home delivery", 1000);

    @Test
    void testCreate() {
        assertEquals("John Doe", user.getName());
        assertEquals(0, user.getPurchases().size());
        assertEquals(3000, user.getBalance());
    }

    @Test
    void testPurchaseItem() {
        user.purchase(p1);
        assertEquals(1, user.getPurchases().size());
        assertEquals(1000, user.getBalance());
        assertEquals(LocalDate.now().plusMonths(3), p1.getExpirationDate());
    }

    @Test
    void testPurchaseItemWithExtendedWarranty() {
        user.purchase(p2);
        assertEquals(1, user.getPurchases().size());
        assertEquals(1900, user.getBalance());
        assertEquals(LocalDate.now().plusMonths(36), p2.getExpirationDate());
    }

    @Test
    void testPurchaseService() {
        user.purchase(p3);
        assertEquals(1, user.getPurchases().size());
        assertEquals(2000, user.getBalance());
        assertEquals(LocalDate.now().plusMonths(12), p3.getExpirationDate());
    }

    @Test
    void testPurchaseBalanceTooLow() {
        user.purchase(p2);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> user.purchase(p1));
        assertEquals("Balance too low", e.getMessage());
    }
}
