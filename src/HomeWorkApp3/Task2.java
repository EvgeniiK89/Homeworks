package HomeWorkApp3;

public class Task2 {

    public static void main(String[] args) {

        PhoneList phoneList = new PhoneList();
        phoneList.add("Petrov", "911");
        phoneList.add("Petrov", "122");
        phoneList.add("Petrov", "112");
        phoneList.add("Petrov", "112");
        phoneList.add("Sidorov", "01");
        phoneList.add("Ivanov", "02");

        System.out.println("Phones for Petrov " + phoneList.get("Petrov"));
        System.out.println("Phones for Sidorov " + phoneList.get("Sidorov"));
        System.out.println("Phones for NoName " + phoneList.get("NoName"));
    }
}
