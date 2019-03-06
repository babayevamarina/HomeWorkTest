import java.util.Arrays;
import java.util.Scanner;

public class notebookEntry {

    public String noteName;
    public String noteContent;

    notebookEntry(String name, String content) {
        noteName = name;
        noteContent = content;
    }

    public static void NewNote() {
        Scanner inName = new Scanner(System.in);
        System.out.println("Enter the name of your note: ");
        String name = inName.nextLine();
        Scanner inContent = new Scanner(System.in);
        System.out.println("Enter your note: ");
        String content = inContent.nextLine();
        notebookEntry newNote = new notebookEntry(name,content);

        Notebook.notes[Notebook.noteNum] = newNote;
        Notebook.noteNum = Notebook.noteNum + 1;

        if (Notebook.noteNum == Notebook.initialSize) {
            Notebook.initialSize = Notebook.initialSize * 2;
            Notebook.notes = Arrays.copyOf(Notebook.notes, Notebook.initialSize);
        }

        System.out.println("Done");

    }

    public static void DeleteNote() {
        Scanner inNum = new Scanner(System.in);
        System.out.println("Enter the number of the note you want to delete (from 1): ");
        Integer num = inNum.nextInt();
        if (num-1 > Notebook.noteNum) {
            System.out.println("Sorry, this note does note exist");
        }
        else {
            for (int i = num - 1; i < Notebook.initialSize - 1; i++) {
                Notebook.notes[i] = Notebook.notes[i + 1];
                Notebook.notes[Notebook.noteNum] = null;
            }
            if (Notebook.noteNum <= Notebook.initialSize/2) {
                Notebook.initialSize = Notebook.initialSize / 2;
                Notebook.notes = Arrays.copyOf(Notebook.notes, Notebook.initialSize);
            }
            Notebook.noteNum = Notebook.noteNum - 1;
            System.out.println("Done");
        }

    }

    public static void EditNote() {
        Scanner inEdit = new Scanner(System.in);
        System.out.println("Enter the number of the note you want to edit (from 1): ");
        Integer numEdit = inEdit.nextInt();
        if (numEdit-1 > Notebook.noteNum) {
            System.out.println("Sorry, this note does note exist");
        }
        else {
            Scanner inNewName = new Scanner(System.in);
            System.out.println("Enter new name: ");
            String newName = inNewName.nextLine();
            Scanner inNewContent = new Scanner(System.in);
            System.out.println("Enter new content: ");
            String newContent = inNewContent.nextLine();
            Notebook.notes[numEdit - 1] = new notebookEntry(newName, newContent);
            System.out.println("Done");
        }
    }

    public static void ShowAll() {
        if (Notebook.noteNum <= 0) {
            System.out.println("Sorry, there are no any notes in Notebook");
        }
        else {
            for (int i = 0; i <= Notebook.noteNum - 1; i++) {
                System.out.println((i+1) + " " + Notebook.notes[i]);
            }
            System.out.println("That's all");
        }

    }


}








