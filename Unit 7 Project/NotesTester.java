import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class NotesTester {
    // this thing is not very important this is just for me to check if everything
    // runs smoothly. This is AI generated and won't be a part of the actual
    // project.
    private static int testsRun = 0;
    private static int testsPassed = 0;

    public static void main(String[] args) {
        System.out.println("Running Notes project tests...\n");
        testNoteConstructorsAndAccessors();
        testNoteTemplate();
        testMathNoteAccessorsAndProblemGeneration();
        testScienceNoteMessages();
        testNotesSort();
        testNotesPage();
        System.out.println("\nPassed " + testsPassed + " out of " + testsRun + " tests.");
        if (testsPassed == testsRun) {
            System.out.println("All tests passed!");
        } else {
            System.out.println("Some tests failed. Check the messages above.");
        }
    }

    public static void testNoteConstructorsAndAccessors() {
        printSection("Note constructors and accessors");

        Note randomWeightNote = new Note("Derivatives", "Calculus", 4);
        checkEquals("Derivatives", randomWeightNote.getTitle(), "3-argument constructor sets title");
        checkEquals("Calculus", randomWeightNote.getTopic(), "3-argument constructor sets topic");
        checkEquals(4, randomWeightNote.getUnit(), "3-argument constructor sets unit");
        checkFalse(randomWeightNote.isDone(), "new notes start as not done");
        checkTrue(randomWeightNote.getPriority() >= 9 && randomWeightNote.getPriority() <= 480,
                "3-argument constructor generates a priority in the expected range");

        Note weightedNote = new Note("Atomic Structure", "Chemistry", 2, 40);
        checkEquals(392, weightedNote.getPriority(), "4-argument constructor calculates priority from weight and unit");
        checkEquals(392, weightedNote.generatePriority(), "generatePriority returns the calculated priority");

        weightedNote.setTitle("Periodic Trends");
        weightedNote.setTopic("AP Chemistry");
        weightedNote.setUnit(3);
        weightedNote.setDone(true);
        weightedNote.setPriority(900);

        checkEquals("Periodic Trends", weightedNote.getTitle(), "setTitle changes title");
        checkEquals("AP Chemistry", weightedNote.getTopic(), "setTopic changes topic");
        checkEquals(3, weightedNote.getUnit(), "setUnit changes unit");
        checkTrue(weightedNote.isDone(), "setDone changes done status");
        checkEquals(900, weightedNote.getPriority(), "setPriority changes priority");
    }

    public static void testNoteTemplate() {
        printSection("Note template");

        String template = Note.printTemplate();
        checkContains(template, "# Title", "printTemplate includes a title heading");
        checkContains(template, "## Problems", "printTemplate includes a problems section");
        checkContains(template, "## Solutions", "printTemplate includes a solutions section");
        checkContains(template, "theorem-box", "printTemplate includes theorem box markup");
    }

    public static void testMathNoteAccessorsAndProblemGeneration() {
        printSection("MathNote methods");

        MathNote mathNote = new MathNote("Trig Graphs", "Precalculus", 8, 4);
        checkEquals("Trig Graphs", mathNote.getTitle(), "MathNote inherits Note title behavior");
        checkEquals(8, mathNote.getUnit(), "MathNote inherits Note unit behavior");
        checkEquals(460, mathNote.getPriority(), "MathNote constructor uses the expected fixed weight");
        checkEquals(4, mathNote.getDifficulty(), "MathNote constructor sets difficulty");

        mathNote.setDifficulty(2);
        checkEquals(2, mathNote.getDifficulty(), "setDifficulty changes difficulty");

        checkGraphProblem(mathNote, "trig");
        checkGraphProblem(mathNote, "invtrig");
        checkGraphProblem(mathNote, "polynomial");
        checkGraphProblem(mathNote, "rational");
        checkGraphProblem(mathNote, "log");

        checkEquals("Exponential graphing problem coming soon", mathNote.generateGraphingProblem("exponent"),
                "generateGraphingProblem handles exponent");
        checkEquals("Polar graphing problem coming soon", mathNote.generateGraphingProblem("polar"),
                "generateGraphingProblem handles polar");
        checkEquals(
                "That is not a valid option! Please input either trig, invtrig, polynomial, rational, log, exponent, or polar!",
                mathNote.generateGraphingProblem("circle"),
                "generateGraphingProblem handles invalid input");
        checkGraphProblem(mathNote, "TRIG");
    }

    public static void testScienceNoteMessages() {
        printSection("ScienceNote methods");

        ScienceNote scienceNote = new ScienceNote("Equilibrium", "Chemistry", 7);
        checkEquals("Equilibrium", scienceNote.getTitle(), "ScienceNote inherits Note title behavior");
        checkEquals("Chemistry", scienceNote.getTopic(), "ScienceNote inherits Note topic behavior");
        checkEquals(7, scienceNote.getUnit(), "ScienceNote inherits Note unit behavior");

        ScienceNote invalidChemUnit = new ScienceNote("Future Unit", "Chemistry", 10);
        String invalidChemOutput = captureOutput(new Runnable() {
            public void run() {
                invalidChemUnit.generateWebsiteNote("chemistry");
            }
        });
        checkContains(invalidChemOutput, "That is not a valid AP Chemistry unit.",
                "generateWebsiteNote handles invalid chemistry units");

        ScienceNote invalidPhysicsUnit = new ScienceNote("Future Physics", "Physics", 8);
        String physicsOutput = captureOutputWithInput("mech\n", new Runnable() {
            public void run() {
                invalidPhysicsUnit.generateWebsiteNote("physics");
            }
        });
        checkContains(physicsOutput, "That is not a valid AP Physics C Mechanics unit.",
                "generateWebsiteNote handles invalid mechanics units");

        String invalidTypeOutput = captureOutput(new Runnable() {
            public void run() {
                scienceNote.generateWebsiteNote("biology");
            }
        });
        checkContains(invalidTypeOutput, "That is not a supported science note type.",
                "generateWebsiteNote handles unsupported science types");
    }

    public static void testNotesSort() {
        printSection("NotesSort methods");

        Note unit3 = new Note("Unit 3 Note", "General", 3, 10);
        Note unit1 = new Note("Unit 1 Note", "General", 1, 10);
        Note unit2 = new Note("Unit 2 Note", "General", 2, 10);
        ArrayList<Note> unitNotes = new ArrayList<>();
        unitNotes.add(unit3);
        unitNotes.add(unit1);
        unitNotes.add(unit2);

        NotesSort unitSort = new NotesSort(unitNotes);
        checkSame(unitNotes, unitSort.getNotesList(), "getNotesList returns the stored list");
        unitSort.sortByUnit();
        checkEquals("Unit 1 Note, Unit 2 Note, Unit 3 Note", titles(unitNotes),
                "sortByUnit sorts notes from lowest unit to highest unit");

        Note lowPriority = new Note("Low Priority", "General", 9, 10);
        Note highPriority = new Note("High Priority", "General", 1, 50);
        Note middlePriority = new Note("Middle Priority", "General", 5, 20);
        ArrayList<Note> priorityNotes = new ArrayList<>();
        priorityNotes.add(lowPriority);
        priorityNotes.add(highPriority);
        priorityNotes.add(middlePriority);

        NotesSort prioritySort = new NotesSort(priorityNotes);
        prioritySort.sortByPriority();
        checkEquals("Low Priority, Middle Priority, High Priority", titles(priorityNotes),
                "sortByPriority sorts notes from lowest priority to highest priority");

        MathNote hard = new MathNote("Hard Math", "Math", 1, 5);
        MathNote easy = new MathNote("Easy Math", "Math", 1, 1);
        MathNote medium = new MathNote("Medium Math", "Math", 1, 3);
        ArrayList<Note> difficultyNotes = new ArrayList<>();
        difficultyNotes.add(hard);
        difficultyNotes.add(easy);
        difficultyNotes.add(medium);

        NotesSort difficultySort = new NotesSort(difficultyNotes);
        difficultySort.sortByDifficulty();
        checkEquals("Hard Math, Medium Math, Easy Math", titles(difficultyNotes),
                "sortByDifficulty sorts MathNotes from hardest to easiest");

        unit1.setDone(true);
        unit3.setDone(true);
        ArrayList<Note> doneNotes = unitSort.filterDone();
        checkEquals(2, doneNotes.size(), "filterDone returns only completed notes");
        checkTrue(doneNotes.contains(unit1), "filterDone includes a completed note");
        checkFalse(doneNotes.contains(unit2), "filterDone excludes an incomplete note");
    }

    public static void testNotesPage() {
        printSection("NotesPage methods");

        MathNote algebra = new MathNote("Algebra", "Math", 2, 1);
        MathNote calculus = new MathNote("Calculus", "Math", 9, 5);
        ScienceNote chemistry = new ScienceNote("Atomic Structure", "Chemistry", 1);
        ScienceNote biology = new ScienceNote("Cell Structure", "Biology", 4);

        chemistry.setPriority(700);
        biology.setPriority(300);

        algebra.setDone(true);
        chemistry.setDone(true);
        biology.setDone(true);

        ArrayList<Note> mathNotes = new ArrayList<>();
        mathNotes.add(calculus);
        mathNotes.add(algebra);
        ArrayList<Note> scienceNotes = new ArrayList<>();
        scienceNotes.add(biology);
        scienceNotes.add(chemistry);

        ArrayList<NotesSort> pages = new ArrayList<>();
        pages.add(new NotesSort(mathNotes));
        pages.add(new NotesSort(scienceNotes));

        ArrayList<Note> combined = NotesPage.combineNotes(pages);
        checkEquals(4, combined.size(), "combineNotes includes notes from every NotesSort");
        checkTrue(combined.contains(algebra), "combineNotes includes math notes");
        checkTrue(combined.contains(chemistry), "combineNotes includes science notes");

        NotesPage notesPage = new NotesPage(pages);
        String priorityOutput = notesPage.printPriority();
        checkContains(priorityOutput, "1. Atomic Structure - Chemistry Unit 1 (Priority: 700)",
                "printPriority puts the highest priority note first");
        checkContains(priorityOutput, "3. Calculus - Math Unit 9 (Priority: 455)",
                "printPriority includes lower priority notes later");

        String mathPriorityOutput = notesPage.printPriority("math");
        checkContains(mathPriorityOutput, "1. Algebra - Math Unit 2 (Priority: 490)",
                "printPriority(math) includes MathNotes");
        checkFalse(mathPriorityOutput.contains("Atomic Structure"),
                "printPriority(math) excludes ScienceNotes");

        String sciencePriorityOutput = notesPage.printPriority("science");
        checkContains(sciencePriorityOutput, "1. Atomic Structure - Chemistry Unit 1 (Priority: 700)",
                "printPriority(science) includes ScienceNotes");
        checkFalse(sciencePriorityOutput.contains("Algebra"),
                "printPriority(science) excludes MathNotes");

        String doneOutput = notesPage.printDone();
        checkEquals("Algebra - Math Unit 2\nAtomic Structure - Chemistry Unit 1\nCell Structure - Biology Unit 4\n",
                doneOutput, "printDone lists completed math notes, then completed science notes, sorted by unit");
    }

    public static void checkGraphProblem(MathNote note, String type) {
        final String[] problem = new String[1];
        final Exception[] exception = new Exception[1];

        Thread graphThread = new Thread(new Runnable() {
            public void run() {
                try {
                    problem[0] = note.generateGraphingProblem(type);
                } catch (Exception e) {
                    exception[0] = e;
                }
            }
        });
        graphThread.setDaemon(true);
        graphThread.start();

        try {
            graphThread.join(1000);
            if (graphThread.isAlive()) {
                checkTrue(false, "generateGraphingProblem should finish quickly for " + type
                        + " problems, but it timed out");
                return;
            }
            if (exception[0] != null) {
                checkTrue(false, "generateGraphingProblem should not throw an exception for " + type
                        + " problems, but threw " + exception[0].getClass().getSimpleName());
                return;
            }
            checkTrue(problem[0] != null && problem[0].length() > 0,
                    "generateGraphingProblem creates a non-empty " + type + " problem");
        } catch (InterruptedException e) {
            checkTrue(false, "generateGraphingProblem test was interrupted for " + type + " problems");
        }
    }

    public static void printSection(String title) {
        System.out.println("---- " + title + " ----");
    }

    public static void checkTrue(boolean condition, String testName) {
        testsRun++;
        if (condition) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
        }
    }

    public static void checkFalse(boolean condition, String testName) {
        checkTrue(!condition, testName);
    }

    public static void checkEquals(int expected, int actual, String testName) {
        testsRun++;
        if (expected == actual) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName + " | expected: " + expected + ", actual: " + actual);
        }
    }

    public static void checkEquals(String expected, String actual, String testName) {
        testsRun++;
        if (expected.equals(actual)) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName + " | expected: " + expected + ", actual: " + actual);
        }
    }

    public static void checkContains(String text, String expectedText, String testName) {
        testsRun++;
        if (text.contains(expectedText)) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName + " | missing text: " + expectedText);
        }
    }

    public static void checkSame(Object expected, Object actual, String testName) {
        testsRun++;
        if (expected == actual) {
            testsPassed++;
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName + " | objects were not the same reference");
        }
    }

    public static String titles(ArrayList<Note> notes) {
        String output = "";
        for (int i = 0; i < notes.size(); i++) {
            output += notes.get(i).getTitle();
            if (i < notes.size() - 1) {
                output += ", ";
            }
        }
        return output;
    }

    public static String captureOutput(Runnable runnable) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        try {
            runnable.run();
        } finally {
            System.setOut(originalOut);
        }
        return output.toString();
    }

    public static String captureOutputWithInput(String input, Runnable runnable) {
        java.io.InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(output));
        try {
            runnable.run();
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
        return output.toString();
    }
}
