package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalUserTest {

    @Test
    void getUserEmail() {
        NormalUser normalUser = new NormalUser("asdm.dsad@sd.hu","dsaijdisa");
        assertEquals("dsaijdisa", normalUser.getPassword());
    }

    @Test
    void getPassword() {
        NormalUser normalUser = new NormalUser("asdm.dsad@sd.hu","dsaijdisa");
        assertEquals("asdm.dsad@sd.hu", normalUser.getUserEmail());
    }
}