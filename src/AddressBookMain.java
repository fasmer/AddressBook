import java.util.*;

/**
 * Created by stephen.farmer on 4/12/16.
 *
 */
public class AddressBookMain {
    private static Scanner scanner = new Scanner(System.in);
    public static String firstName;
    public static String lastName;
    public static String phoneNumber;
    public static ContactInformation contact;
    public static ArrayList<ContactInformation> information = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to the address book program!");
        testBook();

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1.) Enter new contact \n2.) Print address book \n3.) Search for contact \n4.) Exit");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    addContact();
                    break;
                case 2:
                    printAddressBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Sorry, invalid option. Please try again.");
            }
        }

    }

    public static void addContact(){
        contact = new ContactInformation(firstName, lastName, phoneNumber);

        System.out.println("Enter first name: ");
        contact.setFirstName(scanner.next());

        System.out.println("Enter last name: ");
        contact.setLastName(scanner.next());

        System.out.println("Enter phone number: ");
        contact.setPhoneNumber(scanner.next());
        information.add(contact);
    }

    public static void printAddressBook(){

        System.out.println("********************");
        System.out.println("*     CONTACTS     *");
        System.out.println("********************");
        for(ContactInformation contacts : information) {
            System.out.println("\nFirst Name: " + contacts.firstName +
                    "\nLast Name: " + contacts.lastName +
                    "\nPhone Number: " + contacts.phoneNumber);
        }
    }

    public static void searchBook(){
        System.out.println("Enter last name of contact:");
        String search = scanner.next();
        int counter = 0;

        for (ContactInformation contact : information) {
            if (contact.lastName.equals(search)) {
                counter++;
            }
        }
        if (counter > 1) {
            System.out.println("More than one contact with the last name " + search + " was found."
                    + "\nPlease specify first name:");
            search = scanner.next();
            for (ContactInformation contact : information) {
                if (contact.firstName.equals(search)) {
                    System.out.println("\nFirst Name: " + contact.firstName +
                            "\nLast Name: " + contact.lastName +
                            "\nPhone Number: " + contact.phoneNumber);
                }
            }
        } else if (counter == 0) {
            System.out.println("Sorry, no results found with last name " + search);
        } else {
            System.out.println("\nFirst Name: " + contact.firstName +
                    "\nLast Name: " + contact.lastName +
                    "\nPhone Number: " + contact.phoneNumber);

        }
    }

    public static void testBook(){
        ContactInformation contactSteve = new ContactInformation(firstName, lastName, phoneNumber);
        contactSteve.setFirstName("Steve");
        contactSteve.setLastName("Farmer");
        contactSteve.setPhoneNumber("214-226-5253");
        information.add(contactSteve);

        ContactInformation contactBen = new ContactInformation(firstName, lastName, phoneNumber);
        contactBen.setFirstName("Ben");
        contactBen.setLastName("Farmer");
        contactBen.setPhoneNumber("214-226-5242");
        information.add(contactBen);
    }


}

