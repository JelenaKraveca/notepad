package lv.ctco.notepad;

import javax.swing.table.DefaultTableCellRenderer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.*;

public class Main {

    public static final String DATE_PATTERN = "dd/MM/uuuu";
    public static final DateTimeFormatter DATE_FORMATTER =  ofPattern(DATE_PATTERN);

    public static final String TIME_PATTERN = "HH:mm";
    public static final DateTimeFormatter TIME_FORMATTER =  ofPattern(TIME_PATTERN);

    static Scanner scanner = new Scanner(System.in);
    private static List<Record> records  = new ArrayList<>();

    public static void main(String[] args) {
	  for(;;){
          System.out.println("Please enter command: ");
          String cmd = scanner.next();
          switch (cmd){
              case "search":
                  search();
                  break;
              case "cp":
              case "createPerson":
                  createRecord(new Person());
                  break;
              case "cn":
              case "createStickyNote":
                  createRecord(new StikyNote());
                  break;
              case "ca":
              case "createAlarm":
                  createRecord(new Alarm());
                  break;
              case "cr":
              case "createReminder":
                  createRecord(new Reminder());
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

    private static void createRecord(Record record){
        record.askData();
        records.add(record);
        System.out.println(record);
    }

 /*   private static void createPerson() {
        Person p = new Person();
        p.askData();
        records.add(p);
    }
    private static void createStickyNote() {
        StikyNote n = new StikyNote();
        n.askData();
        records.add(n);
    }
*/
    private static void search() {
        String ss = askString("What do you want to find?");
        records.stream()
                .filter(r -> r.contains(ss))
               // .forEach(r -> System.out.println(r));
                .forEach(System.out::println);


    /*    for (Record r : records){
            if (r.contains(ss)){
                System.out.println(r);
            }
        }*/
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

    public static LocalDate askDate( String msg){
        String strDate = askString(msg);
        return LocalDate.parse(strDate, DATE_FORMATTER);
    }

    public static LocalTime askTime(String msg){
        String strTime = askString(msg);
        return LocalTime.parse(strTime, TIME_FORMATTER);
    }
}