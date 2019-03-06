import java.util.Scanner;

public class Main {
    private static String userName;
    private static String nextActQuestion = ", what do you want to do next?\nEnter: add, delete, edit or show all.\nFor user name change print: user";

    public static String getUserName() {
        return userName;
    }

    public static void edit(ConsoleController console, Notebook newNotebook) {
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
    }

    public static void add(ConsoleController console, Notebook newNotebook) {
        String name = console.consoleStringInput("Enter the name of your note: ");
        String content = console.consoleStringInput("Enter your note: ");
        NotebookEntry newNote = new NotebookEntry(name,content);
        newNotebook.addNote(newNote);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleController console = new ConsoleController(scanner);
        userName = console.consoleStringInput("Hello! Enter your name, please: ");
        Notebook newNotebook = new Notebook();

        while (true) {
            String nextAct = console.consoleStringInput(userName + nextActQuestion);
            switch (nextAct) {
                case "add" : {
                    add(console,newNotebook);
                    break;
                }
                case "delete": {
                    Integer num = console.consoleIntInput("Enter the number of the note you want to delete (starting from 1): ");
                    newNotebook.deleteNote(num);
                    break;
                }
                case "edit": {
                    edit(console,newNotebook);
                    break;
                }
                case "show all": {
                    newNotebook.showAll();
                    break;
                }
                case "user": {
                    userName = console.consoleStringInput("Hello! Enter your name, please: ");
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
