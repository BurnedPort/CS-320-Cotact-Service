
package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "Chris", "Smith", "2155551234", "123 Main Street");
        service.addContact(c);

        assertNotNull(service.getContact("1"));
        assertEquals("Chris", service.getContact("1").getFirstName());
    }

    @Test
    void testAddContactDuplicateIdFails() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(new Contact("1", "C", "D", "0987654321", "Addr2")));
    }

    @Test
    void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));

        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    void testDeleteContactMissingIdFails() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("nope"));
    }

    @Test
    void testUpdateFieldsSuccess() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));

        service.updateFirstName("1", "Chris");
        service.updateLastName("1", "Smith");
        service.updatePhone("1", "2155551234");
        service.updateAddress("1", "123 Main Street");

        Contact updated = service.getContact("1");
        assertEquals("Chris", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("2155551234", updated.getPhone());
        assertEquals("123 Main Street", updated.getAddress());
    }

    @Test
    void testUpdateMissingIdFails() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("404", "X"));
    }

    @Test
    void testUpdateValidationFails() {
        ContactService service = new ContactService();
        service.addContact(new Contact("1", "A", "B", "1234567890", "Addr"));

        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "bad"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("1",
                "1234567890123456789012345678901"));
    }
}