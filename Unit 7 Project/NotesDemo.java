import java.util.ArrayList;
import java.util.Scanner;

public class NotesDemo {
    public static void main(String[] args) {
        Scanner thing = new Scanner(System.in);
        int option = thing.nextInt();
        thing.nextLine();
        thing.close();
        if (option == 1) {
            System.out.println("Welcome to my Notes Project demo!\n");
            // setting up notes and stuff
            MathNote trigNote = new MathNote("Trig Graphs", "Precalculus", 8, 4);
            MathNote derivativeNote = new MathNote("Derivatives", "Calculus", 5, 5);
            MathNote polynomialNote = new MathNote("Polynomial Functions", "Algebra 2", 3, 2);
            MathNote logarithmNote = new MathNote("Logarithm Transformations", "Precalculus", 5, 3);
            MathNote seriesNote = new MathNote("Infinite Series", "Calculus BC", 10, 5);
            MathNote conicNote = new MathNote("Conic Sections", "Precalculus", 12, 3);
            ScienceNote atomicNote = new ScienceNote("Atomic Structure", "Chemistry", 1);
            ScienceNote equilibriumNote = new ScienceNote("Equilibrium", "Chemistry", 7);
            ScienceNote forcesNote = new ScienceNote("Forces", "Physics", 2);
            ScienceNote circuitsNote = new ScienceNote("Circuits", "Physics E&M", 4);
            ScienceNote kineticsNote = new ScienceNote("Kinetics", "Chemistry", 5);
            ScienceNote oscillationsNote = new ScienceNote("Oscillations", "Physics Mechanics", 7);
            atomicNote.setPriority(700);
            equilibriumNote.setPriority(430);
            forcesNote.setPriority(250);
            circuitsNote.setPriority(520);
            kineticsNote.setPriority(610);
            oscillationsNote.setPriority(340);
            trigNote.setDone(true);
            polynomialNote.setDone(true);
            logarithmNote.setDone(true);
            atomicNote.setDone(true);
            forcesNote.setDone(true);
            circuitsNote.setDone(false);
            // printing out stuff
            System.out.println("1. Creating individual notes\n");
            System.out.println(trigNote.getTitle() + " is a " + trigNote.getTopic()
                    + " note from Unit " + trigNote.getUnit()
                    + " with difficulty " + trigNote.getDifficulty() + ".");
            System.out.println(atomicNote.getTitle() + " is a " + atomicNote.getTopic()
                    + " note from Unit " + atomicNote.getUnit() + ".");
            System.out.println(circuitsNote.getTitle() + " is a " + circuitsNote.getTopic()
                    + " note from Unit " + circuitsNote.getUnit() + ".");
            System.out.println();
            // testing problem generatino (mathNotes)
            System.out.println("2. Generating a random math graphing problem\n");
            System.out.println(
                    "Precondition: Type is always trig, invtrig, polynomial, log, rational, exponential, or polar.");
            System.out.println("Trig problem: " + trigNote.generateGraphingProblem("trig"));
            System.out.println("Inverse trig problem: " + trigNote.generateGraphingProblem("invtrig"));
            System.out.println("Polynomial problem: " + polynomialNote.generateGraphingProblem("polynomial"));
            System.out.println("Log problem: " + logarithmNote.generateGraphingProblem("log"));
            System.out.println();
            // setting up stuff
            ArrayList<Note> mathNotes = new ArrayList<>();
            mathNotes.add(trigNote);
            mathNotes.add(derivativeNote);
            mathNotes.add(polynomialNote);
            mathNotes.add(logarithmNote);
            mathNotes.add(seriesNote);
            mathNotes.add(conicNote);
            ArrayList<Note> scienceNotes = new ArrayList<>();
            scienceNotes.add(atomicNote);
            scienceNotes.add(equilibriumNote);
            scienceNotes.add(forcesNote);
            scienceNotes.add(circuitsNote);
            scienceNotes.add(kineticsNote);
            scienceNotes.add(oscillationsNote);
            NotesSort mathSorter = new NotesSort(mathNotes);
            NotesSort scienceSorter = new NotesSort(scienceNotes);
            // Sorting
            System.out.println("3. Sorting math notes by difficulty\n");
            mathSorter.sortByDifficulty();
            for (Note note : mathNotes) {
                MathNote mathNote = (MathNote) note;
                System.out.println(mathNote.getTitle() + " - difficulty " + mathNote.getDifficulty());
            }
            System.out.println();
            System.out.println("4. Sorting science notes by unit\n");
            scienceSorter.sortByUnit();
            for (Note note : scienceNotes) {
                System.out.println(note.getTitle() + " - Unit " + note.getUnit());
            }
            System.out.println();
            ArrayList<NotesSort> allSubjects = new ArrayList<>();
            allSubjects.add(mathSorter);
            allSubjects.add(scienceSorter);
            NotesPage notesPage = new NotesPage(allSubjects);
            // testing ranking systems
            System.out.println("5. Top priority notes across all subjects\n");
            System.out.print(notesPage.printPriority());
            System.out.println("\n6. Top priority math notes only\n");
            System.out.print(notesPage.printPriority("math"));
            System.out.println("\n7. Notes I have already finished\n");
            System.out.print(notesPage.printDone());
            // template testing
            System.out.println("\n8. Example note template\n");
            System.out.println(Note.printTemplate());
            // website testing
            System.out.println("9. Demoing website note generation\n");
            Scanner bums = new Scanner(System.in);
            System.out.println("Note: I have preset units to open, you can change it if you want.");
            System.out.print("Choose a topic (chemistry or physics): ");
            String topic = bums.nextLine().toLowerCase();
            if (topic.equals("chemistry")) {
                System.out.println("Opening the website for a Chemistry note:");
                atomicNote.generateWebsiteNote("chemistry");
            } else if (topic.equals("physics")) {
                System.out.println("Opening the website for a Physics note:");
                System.out.println("For this demo, type mech to open the Mechanics Unit 2 page.");
                forcesNote.generateWebsiteNote("physics");
            }
            System.out.println();
            System.out.println("Thank you for watching!");
            bums.close();
        } else {
            System.out.println("Live Demo!\n");
        }
    }
}
