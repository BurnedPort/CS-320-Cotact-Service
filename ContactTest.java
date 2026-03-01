package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContactConstructs() {
        Contact c = new Contact("1", "Chris", "Smith", "2155551234", "123 Main Street");
        assertEquals("1", c.getContactId());
        assertEquals("Chris", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("2155551234", c.getPhone());
        assertEquals("123 Main Street", c.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "A", "B", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "A", "B", "1234567890", "Addr"));
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "B", "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "ABCDEFGHIJK", "B", "1234567890", "Addr"));
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", null, "1234567890", "Addr"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", "ABCDEFGHIJK", "1234567890", "Addr"));
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", "B", null, "Addr"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", "B", "123", "Addr"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", "B", "123456789A", "Addr"));
    }

    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", "B", "1234567890", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "A", "B", "1234567890",
                        "1234567890123456789012345678901")); // 31 chars
    }

    @Test
    void testSettersValidate() {
        Contact c = new Contact("1", "A", "B", "1234567890", "Addr");

        c.setFirstName("NewName");
        assertEquals("NewName", c.getFirstName());

        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ABCDEFGHIJK"));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("111"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress("1234567890123456789012345678901"));
    }
}