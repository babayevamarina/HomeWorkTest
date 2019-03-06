import java.util.Scanner;

public class Main {
    private static String nextAct;

    public static void NextUserAct() {

    Scanner in = new Scanner(System.in);
        System.out.println("What you want to do next? Enter: add note, delete note, "+
                "edit note or show all.\nFor user name change print: user");
        nextAct =in.nextLine();
        if (nextAct ==null) {
        System.out.println("Try again later");
        }
        else if ((nextAct.equals("add note")) || (nextAct.equals("add")))  {
        notebookEntry.NewNote();
        }
        else if ((nextAct.equals("delete note")) || (nextAct.equals("delete"))) {
        notebookEntry.DeleteNote();
        }
        else if ((nextAct.equals("show all")) || (nextAct.equals("show"))) {
        notebookEntry.ShowAll();
        }
        else if ((nextAct.equals("edit note")) || (nextAct.equals("edit"))) {
            notebookEntry.EditNote();
        }
        else if (nextAct.equals("user")) {
        Notebook.UserName();
        }
        else {
        System.out.println("Try again \n");
        }

}

    public static void main(String[] args) {
        Notebook.UserName();
        Notebook.MakeNewNotebook();
        while (true) {
            NextUserAct();
        }

    }
}
