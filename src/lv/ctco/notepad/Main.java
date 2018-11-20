package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static List<Person> records  = new ArrayList<>();

    public static void main(String[] args) {
	  for(;;){
          System.out.println("Please enter command: ");
          String cmd = scanner.next();
          switch (cmd){
              case "create":
                  createPerson();
                  break;
              case "list":
                  showList();
                  break;    
              case "help":
                  showHelp();
                  break;
              case "delete":
                  deleteId();
                  break;
              case "exit":
                  return;
              default:
                  System.out.println("Wrong command. Try help!");
          }
      }
    }

    private static void deleteId() {
        deleteId();
    }

    private static void showHelp() {
    }

    private static void showList() {
        records.forEach(r -> System.out.println(r));
    }

    private static void createPerson() {

        Person p = new Person();
        String in;

        System.out.println("First name:");
        String name = askString("First name:");
        p.setFirstName(name);

        System.out.println("Last name:");
        String lastName = askString("Last name:");
        p.setLastName(lastName);

        System.out.println("e-mail:");
        p.setEmail(scanner.next());

        System.out.println("Phone:");
        p.setPhone(scanner.next());

        records.add(p);
    }

    public static String askString(String msg) {
        String ret = "";
        String n;
        //System.out.println(msg);

        if (msg.equals("First name:") || msg.equals("Last name:")) {
            n = scanner.next();
            if (n.startsWith("\"")) {
                ret = ret + n;
                while (!(n.endsWith("\""))) {
                    n = scanner.next();
                    ret = ret + " " + n;
                }
            } else {
                ret = scanner.next();
            }

            return ret;


        }
    }
}
