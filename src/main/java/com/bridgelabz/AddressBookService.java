package com.bridgelabz;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookService {
      HashMap<String, AddressBook> addressBookmap = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    public AddressBook findAddressBook(String adBookName) {

        for (Map.Entry<String, AddressBook> itr : addressBookmap.entrySet()) {
            if (itr.getKey().equalsIgnoreCase(adBookName)) {
                return itr.getValue();
            }
        }
        return null;
    }
    public void addAddressBook() {

        System.out.println(" Enter the name of the address book: ");
        String name = scan.next();

        if (addressBookmap.get(name) != null) {

            System.out.println("the Entered address book is already exists");
            return;
        }

        addressBookmap.put(name, new AddressBook());
    }
    public void addContact() {

        System.out.println(" Please enter the name of the address book: ");
        String name = scan.next();

        AddressBook adBook = findAddressBook(name);

        if (adBook == null) {
            System.out.println("Invalid  address book ");
            return;
        }

        adBook.addContact();
    }
    public void displayContacts() {

        System.out.println(" Enter the name of the address book name: ");
        String name = scan.next();

        AddressBook addBook = findAddressBook(name);

        if (addBook == null) {
            System.out.println("Invalid address book , Please Enter the proper Address book name");
            return;
        }
        addBook.displayContacts();
    }
    public void editContact() {

        System.out.println(" Enter the name of the address book name: ");
        String name = scan.next();

        AddressBook addBook = findAddressBook(name);

        if (addBook == null) {
            System.out.println("Invalid address book , Please Enter the proper Address book name");
            return;
        }
        addBook.editContact();
    }
    public void deleteContact() {

        System.out.println(" Enter the name of the address book name: ");
        String name = scan.next();

        AddressBook addBook = findAddressBook(name);

        if (addBook == null) {
            System.out.println("Invalid address book , Please Enter the proper Address book name");
            return;
        }
        addBook.deleteContact();
    }
    public void viewByCityOrState(){
        System.out.print(" Eter to view by city or state(city/state): ");
        String viewChoice = scan.next();

        System.out.print(" Enter the location: ");
        String viewLocation = scan.next();

        viewCityState(viewLocation, viewChoice);
    }
    public void viewCityState(String location, String choice) {
        addressBookmap.values().stream().forEach((adBook) -> {
            adBook.addressBook.stream().filter(contact -> {

                        if (choice.equalsIgnoreCase("city"))
                            return contact.getCity().equalsIgnoreCase(location);
                        else
                            return contact.getState().equalsIgnoreCase(location);
                    })
                    .forEach(contact -> System.out.println(contact));
        });

    }
    public void countByContacts(){
        System.out.print(" Enter to count by city or state(city/state): ");
        String countChoice = scan.next();

        System.out.print(" Enter the location: ");
        String countLocation = scan.next();

        countContact(countLocation, countChoice);
    }
    public void countContact(String location, String choice) {

        int finalCount = 0;

        for (AddressBook addBook : addressBookmap.values()) {

            finalCount += addBook.addressBook.stream()
                    .filter(contact -> {
                        if (choice.equalsIgnoreCase("city"))
                            return contact.getCity().equalsIgnoreCase(location);
                        else
                            return contact.getState().equalsIgnoreCase(location);
                    })
                    .count();
        }

        System.out.println(" Total count: " + finalCount);
    }

    public void sortByContacts(){
        System.out.print(" Enter which address book to sort: ");
        String sortAdBook = scan.next();

        System.out.print(" Enter to sort by name, city, state ");
        String sortChoice = scan.next();
        sortContacts(sortAdBook, sortChoice);
    }
    public void sortContacts(String adBookName, String sortChoice) {
        AddressBook addBook = findAddressBook(adBookName);
        addBook.addressBook.stream().sorted((contact1, contact2) -> {
            if (sortChoice.equalsIgnoreCase("name"))
                return contact1.getFirstName().compareToIgnoreCase(contact2.getFirstName());

            else if (sortChoice.equalsIgnoreCase("city"))
                return contact1.getCity().compareToIgnoreCase(contact2.getCity());
            else
                return contact1.getState().compareToIgnoreCase(contact2.getState());
        }).forEach(contact -> System.out.println(contact));

    }
}
