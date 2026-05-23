import java.util.ArrayList;
import java.util.Scanner;

public class NotesDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to my Notes Project demo!");
        System.out.println("1. Prepared demo");
        System.out.println("2. Live demo");
        System.out.print("Choose a demo option: ");
        int option = scan.nextInt();
        scan.nextLine();
        System.out.println();
        // boring stuff
        ArrayList<Note> mathNotes = new ArrayList<>();
        MathNote trigNote = new MathNote("Trig Graphs", "Precalculus", 8, 4);
        MathNote derivativeNote = new MathNote("Derivatives", "Calculus", 5, 5);
        MathNote polynomialNote = new MathNote("Polynomial Functions", "Algebra 2", 3, 2);
        MathNote logarithmNote = new MathNote("Logarithm Transformations", "Precalculus", 5, 3);
        MathNote seriesNote = new MathNote("Infinite Series", "Calculus BC", 10, 5);
        MathNote conicNote = new MathNote("Conic Sections", "Precalculus", 12, 3);
        trigNote.setDone(true);
        polynomialNote.setDone(true);
        logarithmNote.setDone(true);
        mathNotes.add(trigNote);
        mathNotes.add(derivativeNote);
        mathNotes.add(polynomialNote);
        mathNotes.add(logarithmNote);
        mathNotes.add(seriesNote);
        mathNotes.add(conicNote);
        ArrayList<Note> scienceNotes = new ArrayList<>();
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
        atomicNote.setDone(true);
        forcesNote.setDone(true);
        circuitsNote.setDone(false);
        scienceNotes.add(atomicNote);
        scienceNotes.add(equilibriumNote);
        scienceNotes.add(forcesNote);
        scienceNotes.add(circuitsNote);
        scienceNotes.add(kineticsNote);
        scienceNotes.add(oscillationsNote);
        // working demo
        if (option == 1) {
            System.out.println("Working Demo!\n");
            System.out.println("1. Creating individual notes\n");
            System.out.println(trigNote.getTitle() + " is a " + trigNote.getTopic()
                    + " note from Unit " + trigNote.getUnit()
                    + " with difficulty " + trigNote.getDifficulty() + ".");
            System.out.println(atomicNote.getTitle() + " is a " + atomicNote.getTopic()
                    + " note from Unit " + atomicNote.getUnit() + ".");
            System.out.println(circuitsNote.getTitle() + " is a " + circuitsNote.getTopic()
                    + " note from Unit " + circuitsNote.getUnit() + ".");
            System.out.println();
            System.out.println("2. Generating random math graphing problems\n");
            System.out.println(
                    "Precondition: Type is always trig, invtrig, polynomial, log, rational, exponential, or polar.");
            System.out.println("Trig problem: " + trigNote.generateGraphingProblem("trig"));
            System.out.println("Inverse trig problem: " + trigNote.generateGraphingProblem("invtrig"));
            System.out.println("Polynomial problem: " + polynomialNote.generateGraphingProblem("polynomial"));
            System.out.println("Log problem: " + logarithmNote.generateGraphingProblem("log"));
            System.out.println();
            NotesSort mathSorter = new NotesSort(mathNotes);
            NotesSort scienceSorter = new NotesSort(scienceNotes);
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
            System.out.println("5. Top priority notes across all subjects\n");
            System.out.print(notesPage.printPriority());
            System.out.println("\n6. Top priority math notes only\n");
            System.out.print(notesPage.printPriority("math"));
            System.out.println("\n7. Notes I have already finished\n");
            System.out.print(notesPage.printDone());
            System.out.println("\n8. Example note template\n");
            System.out.println(Note.printTemplate());
            System.out.println("9. Demoing website note generation\n");
            System.out.println("Note: I have preset units to open, you can change it if you want.");
            System.out.print("Choose a topic (chemistry or physics): ");
            String topic = scan.nextLine().toLowerCase();
            if (topic.equals("chemistry")) {
                System.out.println("Opening the website for a Chemistry note:");
                atomicNote.generateWebsiteNote("chemistry");
            } else if (topic.equals("physics")) {
                System.out.println("Opening the website for a Physics note:");
                System.out.println("For this demo, type mech to open the Mechanics Unit 2 page.");
                forcesNote.generateWebsiteNote("physics");
            } else {
                System.out.println("Skipping website demo because that topic is not supported.");
            }

            System.out.println("\nThank you for watching!");
        } else {
            System.out.println("Live Demo!\n");
            System.out.print("How many notes do you want to create? ");
            int noteCount = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < noteCount; i++) {
                System.out.println("\nCreating note " + (i + 1));
                System.out.print("Is this note math or science? ");
                String noteType = scan.nextLine().toLowerCase();
                System.out.print("Title: ");
                String title = scan.nextLine();
                System.out.print("Topic: ");
                String topic = scan.nextLine();
                System.out.print("Unit number: ");
                int unit = scan.nextInt();
                scan.nextLine();
                Note newNote;
                if (noteType.equals("math")) {
                    System.out.print("Difficulty from 1 to 5: ");
                    int difficulty = scan.nextInt();
                    scan.nextLine();
                    newNote = new MathNote(title, topic, unit, difficulty);
                    mathNotes.add(newNote);
                } else {
                    newNote = new ScienceNote(title, topic, unit);
                    scienceNotes.add(newNote);
                }
                System.out.print("Is this note already done? (yes/no): ");
                String doneAnswer = scan.nextLine().toLowerCase();
                if (doneAnswer.equals("yes") || doneAnswer.equals("y")) {
                    newNote.setDone(true);
                }
                System.out.print("Do you want to set a custom priority? (yes/no): ");
                String priorityAnswer = scan.nextLine().toLowerCase();
                if (priorityAnswer.equals("yes") || priorityAnswer.equals("y")) {
                    System.out.print("Priority: ");
                    int priority = scan.nextInt();
                    scan.nextLine();
                    newNote.setPriority(priority);
                }
                System.out.println("Added: " + newNote.getTitle() + " - " + newNote.getTopic()
                        + " Unit " + newNote.getUnit());
            }
            System.out.println("\nNow your notes are added to the working demo data.\n");
            NotesSort mathSorter = new NotesSort(mathNotes);
            NotesSort scienceSorter = new NotesSort(scienceNotes);
            System.out.println("1. Sorting math notes by difficulty\n");
            mathSorter.sortByDifficulty();
            for (Note note : mathNotes) {
                MathNote mathNote = (MathNote) note;
                System.out.println(mathNote.getTitle() + " - difficulty " + mathNote.getDifficulty());
            }
            System.out.println();
            System.out.println("2. Sorting science notes by unit\n");
            scienceSorter.sortByUnit();
            for (Note note : scienceNotes) {
                System.out.println(note.getTitle() + " - Unit " + note.getUnit());
            }
            System.out.println();
            ArrayList<NotesSort> allSubjects = new ArrayList<>();
            allSubjects.add(mathSorter);
            allSubjects.add(scienceSorter);
            NotesPage notesPage = new NotesPage(allSubjects);
            System.out.println("3. Top priority notes across all subjects\n");
            System.out.print(notesPage.printPriority());
            System.out.println("\n4. Top priority math notes only\n");
            System.out.print(notesPage.printPriority("math"));
            System.out.println("\n5. Notes I have already finished\n");
            System.out.print(notesPage.printDone());
            System.out.print("\nDo you want to generate a website note for one of your science notes? (yes/no) (if you only created math notes just type in no): ");
            String websiteAnswer = scan.nextLine().toLowerCase();
            if (websiteAnswer.equals("yes") || websiteAnswer.equals("y")) {
                System.out.print("Website note title: ");
                String websiteTitle = scan.nextLine();
                System.out.print("Website note topic, chemistry or physics: ");
                String websiteTopic = scan.nextLine();
                System.out.print("Website note unit: ");
                int websiteUnit = scan.nextInt();
                scan.nextLine();
                ScienceNote websiteNote = new ScienceNote(websiteTitle, websiteTopic, websiteUnit);
                websiteNote.generateWebsiteNote(websiteNote.getTopic());
            }
            System.out.println("\nLive demo complete!");
        }
    }
}
