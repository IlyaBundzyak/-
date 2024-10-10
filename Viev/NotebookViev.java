package Viev;

import java.time.LocalDateTime;
import java.util.List;

import Note.Note;

public interface NotebookViev {
    void showNotes(List<Note> notes);
    void showMessage(String message);
    LocalDateTime getDateTimeInput();
    String getDescriptionInput();
    String getFileNameInput();

}