package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    Service service = new Service("Delivery", 1000);

    @Test
    void testCreate() {
        assertEquals("Delivery", service.getName());
        assertEquals(1000, service.getPrice());
        assertEquals(LocalDate.now().plusMonths(12), service.getExpirationDate());
    }

    @Test
    void testPurchase() {
        service.purchase();
        assertEquals(LocalDate.now().plusMonths(12), service.getExpirationDate());
    }

    @Test
    void testCopy() {
        Service service2 = service.copy();
        assertNotSame(service, service2);
        assertEquals("Delivery", service2.getName());
        assertEquals(1000, service2.getPrice());
        assertEquals(LocalDate.now().plusMonths(12), service2.getExpirationDate());
    }
}
