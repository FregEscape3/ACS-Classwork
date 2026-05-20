import java.util.ArrayList;

public class NotesPage {
    // Overall gist: Basically gives you a ranking of which notes page you
    // Requirements: Live demo/tester class, 4 classes (not including tester), 1
    // library, 1 extension class/inherited, array or arraylist in at least 2
    // classes, some sorted data
    private ArrayList<NotesSort> pageNotes = new ArrayList<>();

    public NotesPage(ArrayList<NotesSort> pageNotes) {
        this.pageNotes = pageNotes;
    }

    public static ArrayList<Note> combineNotes(ArrayList<NotesSort> pageNotes) {
        ArrayList<Note> allNotes = new ArrayList<>();
        for (int i = 0; i < pageNotes.size(); i++) {
            ArrayList<Note> notes = pageNotes.get(i).getNotesList();
            for (int j = 0; j < notes.size(); j++) {
                allNotes.add(notes.get(j));
            }
        }
        return allNotes;
    }

    public String printPriority() {
        ArrayList<Note> allNotes = combineNotes(pageNotes);
        NotesSort allNotesSort = new NotesSort(allNotes);
        allNotesSort.sortByPriority();
        String output = "";
        int notesToPrint = 5;
        if (allNotes.size() < notesToPrint) {
            notesToPrint = allNotes.size();
        }
        for (int i = 0; i < notesToPrint; i++) {
            Note note = allNotes.get(allNotes.size() - 1 - i);
            output += (i + 1) + ". " + note.getTitle() + " - " + note.getTopic() + " Unit " + note.getUnit()
                    + " (Priority: " + note.getPriority() + ")\n";
        }
        return output;
    }

    public String printPriority(String notesType) {
        ArrayList<Note> allNotes = combineNotes(pageNotes);
        ArrayList<Note> matchingNotes = new ArrayList<>();
        notesType = notesType.toLowerCase();
        for (int i = 0; i < allNotes.size(); i++) {
            Note note = allNotes.get(i);
            if (notesType.equals("math") && note instanceof MathNote) {
                matchingNotes.add(note);
            } else if (notesType.equals("science") && note instanceof ScienceNote) {
                matchingNotes.add(note);
            }
        }
        NotesSort matchingNotesSort = new NotesSort(matchingNotes);
        matchingNotesSort.sortByPriority();
        String output = "";
        int notesToPrint = 3;
        if (matchingNotes.size() < notesToPrint) {
            notesToPrint = matchingNotes.size();
        }
        for (int i = 0; i < notesToPrint; i++) {
            Note note = matchingNotes.get(matchingNotes.size() - 1 - i);
            output += (i + 1) + ". " + note.getTitle() + " - " + note.getTopic() + " Unit " + note.getUnit()
                    + " (Priority: " + note.getPriority() + ")\n";
        }
        return output;
    }

    public String printDone() {
        ArrayList<Note> allNotes = combineNotes(pageNotes);
        NotesSort allNotesFilterTemp = new NotesSort(allNotes);
        ArrayList<Note> doneNotes = allNotesFilterTemp.filterDone();
        ArrayList<Note> mathNotes = new ArrayList<>();
        ArrayList<Note> scienceNotes = new ArrayList<>();

        for (int i = 0; i < doneNotes.size(); i++) {
            Note note = doneNotes.get(i);
            if (note instanceof MathNote) {
                mathNotes.add(note);
            } else if (note instanceof ScienceNote) {
                scienceNotes.add(note);
            }
        }

        NotesSort mathSort = new NotesSort(mathNotes);
        mathSort.sortByUnit();
        NotesSort scienceSort = new NotesSort(scienceNotes);
        scienceSort.sortByUnit();

        String output = "";
        for (int i = 0; i < mathNotes.size(); i++) {
            Note note = mathNotes.get(i);
            output += note.getTitle() + " - " + note.getTopic() + " Unit " + note.getUnit() + "\n";
        }

        for (int i = 0; i < scienceNotes.size(); i++) {
            Note note = scienceNotes.get(i);
            output += note.getTitle() + " - " + note.getTopic() + " Unit " + note.getUnit() + "\n";
        }

        return output;
    }
}
