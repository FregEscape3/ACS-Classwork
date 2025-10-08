public class DogTester {
    public static void main(String[] args) {
        //Day 1
        Dog dog1 = new Dog("Alex", "Bob", 41, 234);
        Dog dog2 = new Dog("Michael", "Bob", 67, 123);
        Dog dog3 = new Dog();
        System.out.println(dog1.getName() + " Should: Alex");
        System.out.println(dog2.getName() + " Should: Michael");
        System.out.println(dog3.getName() + " Should: Lulu");
        dog1.setName("Xela");
        System.out.println(dog1.getName() + " Should: Xela");
        System.out.println(dog1.getOwnerName() + " Should: Bob");
        dog1.setOwnerName("Alex");
        System.out.println(dog1.getOwnerName() + " Should: Alex");
        System.out.println(dog1.getDogId() + " Should: 234");
        System.out.println(dog2.getDogChar() + " Should: L");
        System.out.println(dog2.getDogTag() + " Should: 123L");
        System.out.println(dog2.getStillInFacility() + " Should: true");
        System.out.println(PawesomeUtils.generateDogTag(234, 'O') + " Should: 234O");
        System.out.println(PawesomeUtils.generateDogTag(123, 'L') + " Should: 123L");
        System.out.println(dog2.equals(dog3) + " Should: false");
        Dog dog4 = new Dog();
        System.out.println(dog3.equals(dog4) + " Should: true");
        dog4.setStillInFacility(false);
        dog4.toString();

        //Day 2
        System.out.println(PawesomeUtils.generateDogChar(123) + " Should: L");
        System.out.println(PawesomeUtils.generateDogChar(456) + " Should: K");
        System.out.println(PawesomeUtils.generateDogChar(789) + " Should: J");
        Dog myDog = new Dog("Mr. Yang", "Maria", 12, 109);
        System.out.println(myDog.pickup(myDog, "Maria"));
        System.out.println(myDog.pickup(myDog, "John"));
        Dog myDog1 = new Dog("Mochi", "Alex", 2, 674);
        myDog1.setStillInFacility(false);
        myDog1.checkIn(myDog1, "Michael");
        System.out.println(myDog1.getStillInFacility() + " Should: true");
        System.out.println(myDog1.getOwnerName() + " Should: Michael");

        //Day 3
        System.out.println(PawesomeUtils.validateDogId(671) + " Should: 671");
        System.out.println(PawesomeUtils.validateDogId(41) + " Should: 3 dig #");
        System.out.println(PawesomeUtils.validateDogId(4167) + " Should: 3 dig #");
        System.out.println(PawesomeUtils.validateDogTag(dog1) + " Should: true");
        System.out.println(PawesomeUtils.validateDogTag(dog2) + " Should: true");
        dog3.setDogId(10030);
        System.out.println(PawesomeUtils.validateDogTag(dog3) + " Should: false");



    }
}
