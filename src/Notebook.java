import java.util.Scanner;

public class Notebook {
    public static int initialSize = 50;
    public static String userName;
    public static int noteNum;
    public static notebookEntry[] notes;

    public static void UserName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Enter your name, please: ");
        userName = in.nextLine();
    }

    public static void MakeNewNotebook() {
        notes = new notebookEntry[initialSize];
        System.out.println("New Notebook created");
    }


}
