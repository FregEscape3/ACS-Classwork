public class HubTester {
    public static void main(String[] args) {
        try {
            Student badStudent = new Student(null, "67", "bum@trash.com");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudents = new Student("", "67", "bum@trash.com");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent1 = new Student("bad@ss", "67", "bum@trash.com");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent2 = new Student("bum", null, "bum@trash.com");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent2s = new Student("bum", "", "bum@trash.com");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent3 = new Student("bum", "67", null);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent3s = new Student("bum", "67", "hi@");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent3s = new Student("bum", "67", "hi.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Student badStudent3s = new Student("bum", "67", "hi");
        } catch (Exception e) {
            System.out.println(e);
        }
        Student goodStudent = new Student("Alex", "alexisabum?", "ayang4@hwemail.com");
        Hub bums = new Hub();
        bums.registerStudent("Alexa", "alexisabum?", "ayang4@hwemail.com");
        try {
            goodStudent.changeName("@lex");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            goodStudent.changeName("Alex");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("Alex", "671", "bumsarehere@.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("", "671", "bumsarehere@.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent(null, "671", "bumsarehere@.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("hi@", "671", "bumsarehere@.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("Alexa", "", "bumsarehere@.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("Alexa", null, "bumsarehere@.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("hi", "671", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("hi", "671", "bumsarehere@");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("hi", "671", "bumsarehere.");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("hi", "671", "bumsarehere");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.registerStudent("hi", "671", null);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent("", "671");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent(null, "671");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent("hi", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent("hi", null);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent("asdfasdf", "lol");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent(null, "lol");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.loginStudent("Alexa", "lol");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.doesStudentExist("");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.doesStudentExist(null);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            bums.doesStudentExist("Alexa");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Assignment alright = new Assignment(null, "Bums");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Assignment alright = new Assignment("Alright", null);
        } catch (Exception e) {
            System.out.println(e);
        }
        Assignment alright = new Assignment("Alright", "Bums");
        try {
            alright.setTitle(null);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            alright.setDescription(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
