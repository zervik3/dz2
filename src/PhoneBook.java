import java.util.*;

public class PhoneBook {
    private Map<String, Set<Integer>> contacts;

    public PhoneBook() {

        contacts = new HashMap<>();
    }

    public void addContact(String name, Integer phoneNumber) {
        contacts.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void printPhoneBook() {
        List<Map.Entry<String, Set<Integer>>> sortedContacts = new ArrayList<>(contacts.entrySet());

        // Сортировка по убыванию числа телефонов
        sortedContacts.sort((entry1, entry2) -> {
            int size1 = entry1.getValue().size();
            int size2 = entry2.getValue().size();
            return Integer.compare(size2, size1);
        });

        // Вывод отсортированных контактов
        for (Map.Entry<String, Set<Integer>> entry : sortedContacts) {
            String name = entry.getKey();
            Set<Integer> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Alice", 1234567);
        phoneBook.addContact("Bob", 9876543);
        phoneBook.addContact("Alice", 5556667);
        phoneBook.addContact("Charlie", 1111111);
        phoneBook.addContact("Bob", 9998887);

        phoneBook.printPhoneBook();
    }
}