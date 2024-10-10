package Main;

import java.util.Scanner;

import Note.Notebook;
import Presenter.NotebookPresenter;
import Viev.NotebookViev;

public class Main {

    public static void main(String[] args) {

        Notebook model = new Notebook();
        NotebookViev viev = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(model, viev);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Add Note");
                System.out.println("2. Show notes for day");
                System.out.println("3. Show notes for week");
                System.out.println("4. Save notes");
                System.out.println("5. Load notes");
                System.out.println("6. Exit");

                int choise = scanner.nextInt();
                scanner.nextLine();

                switch (choise) {
                    case 1:
                        presenter.addNote();
                        break;
                    case 2:
                        presenter.showNotesForDay();
                        break;
                    case 3:
                        presenter.showNotesForWeek();
                        break;
                    case 4:
                        presenter.saveNotes();
                        break;
                    case 5:
                        presenter.loadNotes();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }

            }
        }
    }
}