package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WebshopTest {

    Webshop webshop = new Webshop();

    @BeforeEach
    void setUp() {
        webshop.addUser(new User("John Doe", 3000));
        webshop.addPurchasable(new Item("Walkman", 2000));
        webshop.addPurchasable(new Item("Battery", 1000));
        webshop.addPurchasable(new Service("Home delivery", 1000));
    }

    @Test
    void testCreate() {
        assertEquals(1, webshop.getUsers().size());
        assertEquals(3, webshop.getPurchasables().size());
    }

    @Test
    void testPurchase() {
        webshop.purchase("John Doe", "Battery");
        assertEquals(1900, webshop.getUsers().get(0).getBalance());
        assertEquals(1, webshop.getUsers().get(0).getPurchases().size());
        assertEquals(LocalDate.now().plusMonths(36), webshop.getUsers().get(0).getPurchases().get(0).getExpirationDate());
        assertEquals(LocalDate.now().plusMonths(3), webshop.getPurchasables().get(1).getExpirationDate());
    }

    @Test
    void testPurchaseWithIncorrectUserName() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> webshop.purchase("John_Doe", "Walkman"));
        assertEquals("User not found", e.getMessage());
    }

    @Test
    void testPurchaseWithIncorrectPurchasableName() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> webshop.purchase("John Doe", "Milk"));
        assertEquals("Purchasable not found", e.getMessage());
    }
}
