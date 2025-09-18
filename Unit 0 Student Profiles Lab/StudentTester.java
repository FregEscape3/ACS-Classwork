public class StudentTester {
    public static void main(String[] args) {
        Student joshua = new Student("Joshua", 10);
        System.out.println(joshua.toString());
        joshua.setGrade(11);
        Student michael = new Student("Michael", 10);
        System.out.println(michael.toString());
        michael.setGrade(9);
        Student kai = new Student("Kai");
        System.out.println(kai.toString());
        kai.setGrade(12);
        Student alex = new Student("Alex");
        System.out.println(alex.toString());
        alex.setGrade(12);
        System.out.println(joshua.equals(michael));
        System.out.println(alex.equals(kai));
        Student p1 = new Student("p1", 11);
        p1.setLatestOpp("Dr. Murphy");
        Student p2 = new Student("p2", 12);
        p2.setLatestOpp("Dr. Murphy");
        System.out.println(p1.vibeCheck(p2));
        //The students should all be different, with 
        //Joshua and Michael becoming 11th and 9th graders,respectively,
        //while Kai and Alex becoming 12th grades.
    }
}
