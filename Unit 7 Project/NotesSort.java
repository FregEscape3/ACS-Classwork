import java.util.ArrayList;

public class NotesSort {
    // this class will help sort a notespage by unit
    private ArrayList<Note> NotesList;

    // prerequisite: All notes are from the SAME topic!
    public NotesSort(ArrayList<Note> NotesList) {
        this.NotesList = NotesList;
    }

    public ArrayList<Note> getNotesList() {
        return NotesList;
    }

    public void sortByUnit() {
        for (int i = 0; i < NotesList.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < NotesList.size(); j++) {
                if (NotesList.get(j).getUnit() < NotesList.get(minIndex).getUnit()) {
                    minIndex = j;
                }
            }
            Note temp = NotesList.get(i);
            NotesList.set(i, NotesList.get(minIndex));
            NotesList.set(minIndex, temp);
        }
    }

    public void sortByPriority() {
        for (int i = 0; i < NotesList.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < NotesList.size(); j++) {
                if (NotesList.get(j).getPriority() < NotesList.get(minIndex).getPriority()) {
                    minIndex = j;
                }
            }
            Note temp = NotesList.get(i);
            NotesList.set(i, NotesList.get(minIndex));
            NotesList.set(minIndex, temp);
        }
    }

    public void sortByDifficulty() {
        for (int i = 0; i < NotesList.size(); i++) {
            if (NotesList.get(i) instanceof MathNote) {
                int minIndex = i;
                for (int j = i + 1; j < NotesList.size(); j++) {
                    if (NotesList.get(j) instanceof MathNote
                            && ((MathNote) NotesList.get(j)).getDifficulty() < ((MathNote) NotesList.get(minIndex))
                                    .getDifficulty()) {
                        minIndex = j;
                    }
                }

                Note temp = NotesList.get(i);
                NotesList.set(i, NotesList.get(minIndex));
                NotesList.set(minIndex, temp);
            }
        }
    }

    public ArrayList<Note> filterDone() {
        ArrayList<Note> output = new ArrayList<>();
        for (Note note : NotesList) {
            if (note.isDone()) {
                output.add(note);
            }
        }
        return output;
    }
}
