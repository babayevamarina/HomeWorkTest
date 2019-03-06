import java.util.Scanner;

public class Main {
    private static String userName;



    public static void initUserName(ConsoleController console) {
        userName = console.consoleStringInput("Hello! Enter your name, please: ");
    }
    public static String getUserName() {
        return userName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleController console = new ConsoleController(scanner);
        initUserName(console);
        Notebook newNotebook = new Notebook();

        while (true) {
            String nextAct = console.consoleStringInput(getUserName() + ", " + "what do you want to do next?\n" +
                    "Enter: add, delete, edit or show all.\n" +
                    "For user name change print: user");
            switch (nextAct) {
                case "add" : {
                    String name = console.consoleStringInput("Enter the name of your note: ");
                    String content = console.consoleStringInput("Enter your note: ");
                    NotebookEntry newNote = new NotebookEntry(name,content);
                    newNotebook.addNote(newNote);
                    break;
                }
                case "delete": {
                    Integer num = console.consoleIntInput("Enter the number of the note you want to delete " +
                            "(starting from 1): ");
                    newNotebook.deleteNote(num);
                    break;
                }
                case "edit": {
                    Integer num = console.consoleIntInput("Enter the number of the note you want to edit (from 1): ");
                    if (num > newNotebook.getNoteNum()) {
                        System.out.println("Sorry, this note does note exist");
                    }
                    else {
                        String newName = console.consoleStringInput("Enter new name: ");
                        String newContent = console.consoleStringInput("Enter new content: ");
                        NotebookEntry editedNote = new NotebookEntry(newName, newContent);
                        newNotebook.editNote(num, editedNote);
                    }
                    break;
                }
                case "show all": {
                    newNotebook.showAll();
                    break;
                }
                case "user": {
                    initUserName(console);
                    break;
                }
                default: {
                    System.out.println("Try again");
                    break;
                }
            }
        }
    }
}
