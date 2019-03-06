import java.util.Arrays;

public class Notebook {
    private final static int initialSize = 50;
    private int noteNum = 0;
    private NotebookEntry[] notes = new NotebookEntry[initialSize];

    public Notebook() {
        System.out.println("New " + Main.getUserName() + "'s " + "Notebook created");
    }

    public int getNoteNum() {
        return noteNum;
    }

    public void addNote(NotebookEntry newNote) {
        arrSizeCheck();
        notes[noteNum] = newNote;
        noteNum++;
        System.out.println("Done");
    }

    public void deleteNote(Integer numDelete) {
        if (numDelete > noteNum) {
            System.out.println("Sorry, this note does note exist");
        } else {
            for (int i = numDelete - 1; i < noteNum; i++) {
                notes[i] = notes[i + 1];
                notes[noteNum] = null;
            }
            noteNum = noteNum - 1;
            arrSizeCheck();
            System.out.println("Done");
        }
    }

    public void editNote(Integer numEdit, NotebookEntry editedNote) {
        notes[numEdit - 1] = editedNote;
            System.out.println("Done");
        }


    public void showAll() {
        if (noteNum <= 0) {
            System.out.println("Sorry, there are no any notes in Notebook");
        } else {
            for (int i = 0; i <= noteNum - 1; i++) {
                System.out.println(noteNum + " " + notes[i].getNoteName() + ": " + notes[i].getNoteContent());
            }
            System.out.println("That's all");
        }
    }

    private void arrSizeCheck() {
        if (noteNum >= notes.length) {
            notes = Arrays.copyOf(notes, notes.length * 2);
        }
        if (noteNum < initialSize / 2) {
            notes = Arrays.copyOf(notes, initialSize);
        }
    }

}
