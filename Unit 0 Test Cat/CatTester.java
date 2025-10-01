public class CatTester {
    public static void main(String[] args) {
        Cat myCat = new Cat("Betsy", "Tabby");
        Cat otherCat = new Cat("Tiger Beast", "Tabby");
        //added "new" to the constructors
        System.out.println(myCat.toString()
         + "My Cat's Name: " + myCat.getName());
        //fixed the syntax error (the ;)
        System.out.println("Are the cat's equal?" + myCat.equals(otherCat));
        //print instead of return 
        System.out.println("Is my cat hungry? " + myCat.getIsHungry());
        String firstName = "Tiger";
        String lastName = "Beast";
        String name = firstName + " " + lastName;
        System.out.println("Changing the cat's name...");
        myCat.setName(name);
        System.out.println("The two cat's are the same now: " + myCat.equals(otherCat));

    }

}
