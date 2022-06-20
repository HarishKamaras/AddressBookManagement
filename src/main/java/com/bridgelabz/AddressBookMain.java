package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println(" Welcome to the Address Book Program");
        Scanner scan = new Scanner(System.in);
        AddressBookService addressBookServiceBook = new AddressBookService();
        String character;
        boolean loop =true;

        while (loop) {
            System.out.println(" ################################### MENU ###############################################");
            System.out.println(" 1.) Add contacts\n 2.) Display contacts\n 3.) Edit contacts\n 4.) Delete contact\n"
                    + " 5.) Add address book\n 6.) View contacts by city or state\n"
                    + " 7.) Count contacts by city or state\n 8.) Sort contacts by city/state\n 9.) File\n 10.)Exit");
            System.out.println(" ########################################################################################");
            System.out.print("\n Please enter your choice: ");

            character = scan.next();

            switch (character) {
                case "1":
                    addressBookServiceBook.addContact();
                    break;
                case "2":
                    addressBookServiceBook.displayContacts();
                    break;
                case "3":
                    addressBookServiceBook.editContact();
                    break;
                case "4":
                    addressBookServiceBook.deleteContact();
                    break;
                case "5":
                    addressBookServiceBook.addAddressBook();
                    break;
                case "6":
                    addressBookServiceBook.viewByCityOrState();
                    break;
                case "7":
                    addressBookServiceBook.countByContacts();
                    break;

                case "8":
                    addressBookServiceBook.sortByContacts();
                    break;
                case "9":
                    FileHandler file = new FileHandler();

                    System.out.print(" Please enter to perform read or write: ");
                    String fileOption = scan.next();

                    if (fileOption.equals("read"))
                        file.readFromFile();
                    else {
                        System.out.print(" Please enter which address book to write: ");
                        String adBookFile = scan.next();

                        file.writeIntoFile(adBookFile, addressBookServiceBook);
                    }
                    break;
                case "10":
                    System.out.println(" EXIT ");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice, please enter the valid choice");
            }
        }
    }
}
