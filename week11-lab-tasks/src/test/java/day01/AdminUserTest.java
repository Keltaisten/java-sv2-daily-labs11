package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminUserTest {

    @Test
    void getUserEmail() {
        AdminUser adminUser = new AdminUser("asdm.dsad@sd.hu","dsaijdisa");
        assertEquals("*********", adminUser.getPassword());
    }

    @Test
    void getPassword() {
        AdminUser adminUser = new AdminUser("asdm.dsad@sd.hu","dsaijdisa");
        assertEquals("asdm.dsad@sd.hu", adminUser.getUserEmail());
    }
}