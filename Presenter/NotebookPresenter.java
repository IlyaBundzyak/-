package Presenter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import Note.Note;
import Note.Notebook;
import Viev.NotebookViev;

public class NotebookPresenter {
    private Notebook model;
    private NotebookViev viev;

    public NotebookPresenter(Notebook model, NotebookViev viev){
        this.model = model;
        this.viev = viev;
    }
    public void addNote(){
        LocalDateTime dateTime = viev.getDateTimeInput();
        String description = viev.getDescriptionInput();
        model.add(new Note(dateTime, description));
        viev.showMessage("Note added.");
    }
    public void showNotesForDay(){
        LocalDateTime dateTime = viev.getDateTimeInput();
        List<Note> notes = model.getNotesForDay(dateTime);
        viev.showNotes(notes);
    }
    public void showNotesForWeek(){
        LocalDateTime startOfWeek = viev.getDateTimeInput();
        List<Note> notes = model.getNotesForWeek(startOfWeek);
        viev.showNotes(notes);
    }
    public void saveNotes(){
        String fileName = viev.getFileNameInput();
        try{
            model.saveToFile(fileName);
            viev.showMessage(("Notes saved to " + fileName));
        } catch (IOException e){
            viev.showMessage("Failed to save notes: " + e.getMessage());
        }
    }
    public void loadNotes(){
        String fileName = viev.getFileNameInput();
        try {
            model.loadFromFile(fileName);
            viev.showMessage("Notes loaded from" + fileName);
        } catch(IOException e){
            viev.showMessage("Failed to load notes: " + e.getMessage());
        }
    }

}
