package com.mediLaboSolutions.authenticationservice.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserCredentialTest {

    @Test
    void testConstructorsAndGettersSetters() {
        Integer id = 1;
        String name = "testUser";
        String email = "test@example.com";
        String password = "testPassword";
        Integer id2 = 10;
        String name2 = "testUserTest";
        String email2 = "test@Test.com";
        String password2 = "testPasswordTest";


        UserCredential userCredential = new UserCredential();
        assertThat(userCredential).isNotNull();


        userCredential = new UserCredential(id, name, email, password);

        assertEquals(id, userCredential.getId());
        assertEquals(name, userCredential.getName());
        assertEquals(email, userCredential.getEmail());
        assertEquals(password, userCredential.getPassword());


        userCredential.setId(id2);
        userCredential.setName(name2);
        userCredential.setEmail(email2);
        userCredential.setPassword(password2);

        assertEquals(id2, userCredential.getId());
        assertEquals(name2, userCredential.getName());
        assertEquals(email2, userCredential.getEmail());
        assertEquals(password2, userCredential.getPassword());
    }
}