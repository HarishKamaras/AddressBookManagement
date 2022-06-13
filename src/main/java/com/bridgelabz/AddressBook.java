package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AddressBook {
    public HashSet<Contact> addressBook = new HashSet<Contact>();
    Scanner scan = new Scanner(System.in);

    public Contact insertDetails() {

        System.out.print(" Enter the first name: ");
        String firstName = scan.next();

        System.out.print(" Enter the last name: ");
        String lastName = scan.next();

        System.out.print(" Enter the address: ");
        String address = scan.next();

        System.out.print(" Enter the city: ");
        String city = scan.next();

        System.out.print(" Enter the state: ");
        String state = scan.next();

        System.out.print(" Enter the zip: ");
        int zip = scan.nextInt();

        System.out.print(" Enter the phone number: ");
        long phone = scan.nextLong();

        System.out.print(" Enter the email: ");
        String email = scan.next();

        // Creating a new object of the contact class with the parameter values filled by user
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

        return contact;

    }


    public void addContact() {

        System.out.print(" Please enter how many contacts you want to add: ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {

            Contact newContact = insertDetails();
            addressBook.add(newContact);

        }
        System.out.println();
    }
    public void displayContacts() {

        for (Contact contact : addressBook) {
            System.out.println(contact);
        }
    }
    public Contact findContact() {

        System.out.print(" Please enter the first name: ");
        String firstName = scan.next();

        for (Contact contact : addressBook) {
            if (firstName.compareToIgnoreCase(contact.getFirstName()) == 0) {
                return contact;
            }
        }
        return null;
    }
    public void deleteContact() {
        Contact contact = findContact();
        if (contact == null) {
            System.out.println(" Invalid contact");
            return;
        }
        addressBook.remove(contact);
        System.out.println(" Contact deleted successfully");
    }
    public void editContact() {
        Contact contact = findContact();
        if (contact == null) {
            System.out.println(" Invalid contact");
            return;
        }
        System.out.println(" Contact found Enter new details of the contact");
        addressBook.remove(contact);
        addressBook.add(insertDetails());
    }
}
