package HomeWorkApp3;

import java.util.*;

public class PhoneList {

    private HashMap<String, List<String>> book;

    public PhoneList() {
        this.book = new HashMap<>();
    }

    public void add(String name, String phone) {
        // check if key already exists
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<>(Arrays.asList(phone)));
        } else /* if key is not exists */{
            List<String> phones = book.get(name);
            // if phone is not exists for this person
            if (!phones.contains(phone)) {
                phones.add(phone);
            }
        }
    }

    public List<String> get(String name) {
        if (book.containsKey(name)) {
            return book.get(name);
        } else {
            return new ArrayList<>();
        }
    }

}
