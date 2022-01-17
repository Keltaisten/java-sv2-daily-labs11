package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item item = new Item("Walkman", 2000);

    @Test
    void testCreate() {
        assertEquals("Walkman", item.getName());
        assertEquals(2000, item.getPrice());
        assertEquals(LocalDate.now().plusMonths(3), item.getExpirationDate());
    }

    @Test
    void testPurchase() {
        item.purchase();
        assertEquals(LocalDate.now().plusMonths(3), item.getExpirationDate());
    }

    @Test
    void testPurchaseWithExtendedWarranty() {
        item.purchaseWithExtendedWarranty();
        assertEquals(LocalDate.now().plusMonths(36), item.getExpirationDate());
    }

    @Test
    void testCopy() {
        Item item2 = item.copy();
        assertNotSame(item, item2);
        assertEquals("Walkman", item2.getName());
        assertEquals(2000, item2.getPrice());
        assertEquals(LocalDate.now().plusMonths(3), item2.getExpirationDate());
    }
}
