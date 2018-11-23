package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static List<Record> records  = new ArrayList<>();

    public static void main(String[] args) {
	  for(;;){
          System.out.println("Please enter command: ");
          String cmd = scanner.next();
          switch (cmd){
              case "cp":
              case "createPerson":
                  createPerson();
                  break;
              case "cn":
              case "createStickyNote":
                  createStickyNote();
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

        private static void deleteRecordById() {
            int id = askInt("ID to delete");
            for (int i = 0; i < records.size(); i++) {
                Record p = records.get(i);
                if (p.getId() == id) {
                    records.remove(i);
                    break;
                }
            }
            showList();
        }


    private static void createPerson() {

        Person p = new Person();
        String in;

        String firstName = askString("First Name");
        p.setFirstName(firstName);

        String lastName = askString("Last Name");
        p.setLastName(lastName);

        String email = askString("Email");
        p.setEmail(email);

        String phone = askPhone("Phone");
        p.setPhone(phone);

        records.add(p);
    }

    private static void createStickyNote() {

        StikyNote n = new StikyNote();
        String in;

        String note = askString("Text");
        n.setText(note);

        records.add(n);
    }


    public static String askString(String msg) {
        for (;;) {
            System.out.print(msg + ": ");
            String val = scanner.next();
            if (!val.startsWith("\"")) {
                return val;
            }
            List<String> words = new ArrayList<>();
            words.add(val);
            while (!val.endsWith("\"")) {
                val = scanner.next();
                words.add(val);
            }
            String result = String.join(" ", words);
            result = result.substring(1, result.length() - 1);
            if (result.length() < 1) {
                System.out.println("at least one character, please");
                continue;
            }
            return result;
        }
    }

    public static int askInt(String msg) {
        System.out.print(msg + ": ");
        return scanner.nextInt();
    }

    public static String askPhone(String msg) {
        for (; ; ) {
            String result = askString(msg);
            boolean hasWrongChars = result.codePoints()
                    .anyMatch(c -> !(Character.isDigit(c) || Character.isSpaceChar(c) || c == '-' || c == '+'));
            if (hasWrongChars) {
                System.out.println("Only numbers, spaces dashes and pluses are allowed");
                continue;
            }

            long digitCount = result.codePoints()
                    .filter(Character::isDigit)
                    .count();
            if (digitCount < 5) {
                System.out.println("Should be 5 or more digits");
                continue;
            }

            return result;
        }
    }
}