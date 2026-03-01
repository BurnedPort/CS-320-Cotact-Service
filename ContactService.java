package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact cannot be null");
        }
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("contactId must be unique");
        }
        contacts.put(id, contact);
    }

    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("contactId does not exist");
        }
        contacts.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        getExisting(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getExisting(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getExisting(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getExisting(contactId).setAddress(address);
    }

    // Helpful for tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    private Contact getExisting(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        Contact c = contacts.get(contactId);
        if (c == null) {
            throw new IllegalArgumentException("contactId does not exist");
        }
        return c;
    }

}