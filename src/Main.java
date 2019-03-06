import java.util.Scanner;

public class Main {
    private static String userName;

    public static void userName() {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Enter your name, please: ");
        userName = in.nextLine();
    }

    public static String getUserName() {
        return userName;
    }

    public static void main(String[] args) {
        userName();
        Notebook newNotebook = new Notebook();
        System.out.println("New " + getUserName() + "'s " + "Notebook created");

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println(getUserName() + ", " + "what do you want to do next?\n" +
                    "Enter: add note, delete note, edit note or show all.\n" +
                    "For user name change print: user");
            String nextAct = in.nextLine();
            if (nextAct == null) {
                System.out.println("Try again \n");
            }
            else if ((nextAct.equals("add note")) || (nextAct.equals("add")))  {
                Scanner inName = new Scanner(System.in);
                System.out.println("Enter the name of your note: ");
                String name = inName.nextLine();
                Scanner inContent = new Scanner(System.in);
                System.out.println("Enter your note: ");
                String content = inContent.nextLine();
                NotebookEntry newNote = new NotebookEntry(name,content);
                newNotebook.addNote(newNote);
            }
            else if ((nextAct.equals("delete note")) || (nextAct.equals("delete"))) {
                Scanner inNum = new Scanner(System.in);
                System.out.println("Enter the number of the note you want to delete (from 1): ");
                Integer num = inNum.nextInt();
                newNotebook.deleteNote(num);
            }
            else if ((nextAct.equals("show all")) || (nextAct.equals("show"))) {
                newNotebook.showAll();
            }
            else if ((nextAct.equals("edit note")) || (nextAct.equals("edit"))) {
                Scanner inEdit = new Scanner(System.in);
                System.out.println("Enter the number of the note you want to edit (from 1): ");
                Integer numEdit = inEdit.nextInt();
                if (numEdit > newNotebook.getNoteNum()) {
                    System.out.println("Sorry, this note does note exist");
                }
                else {
                    Scanner inNewName = new Scanner(System.in);
                    System.out.println("Enter new name: ");
                    String newName = inNewName.nextLine();
                    Scanner inNewContent = new Scanner(System.in);
                    System.out.println("Enter new content: ");
                    String newContent = inNewContent.nextLine();
                    NotebookEntry editedNote = new NotebookEntry(newName, newContent);
                    newNotebook.editNote(numEdit, editedNote);
                }
            }
            else if (nextAct.equals("user")) {
                userName();
            }
            else {
                System.out.println("Try again \n");
            }
        }

    }
}
