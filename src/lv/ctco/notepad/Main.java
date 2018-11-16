package lv.ctco.notepad;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
	  for(;;){
          System.out.println("cmd: ");
          String cmd = scanner.next();
          switch (cmd){
              case "create":
                  createPerson();
                  break;
              case "List":
                  showList();
                  break;    
              case "help":
                  showHelp();
                  break;
              case "exit":
                  return;
              default:
                  System.out.println("Wrong command. Try help!");
          }
      }
    }

    private static void showHelp() {
    }

    private static void showList() {
    }

    private static void createPerson() {
    }
}
