import java.util.Scanner;

public class ConsoleController {

    private Scanner scanner;
    private final String EMPTY_STRING = "";
    //private int nextNum = 0;

    public ConsoleController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String consoleStringInput(String message) {
        String nextLine = EMPTY_STRING;
        while (nextLine.equals(EMPTY_STRING)) {
            System.out.println(message);
            nextLine = scanner.nextLine();
        }
        return nextLine;
    }
    public Integer consoleIntInput(String message) {
        Integer nextNum = null;
        while (nextNum == null) {
            System.out.println(message);
            nextNum = scanner.nextInt();
        }
        return nextNum;
    }


}
