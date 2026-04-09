public class Tester {
    public static void main(String[] args) {
        AnagramList words = new AnagramList();

        words.add(new Word("cinema"));
        words.add(new Word("iceman"));
        words.add(new Word("listen"));
        words.add(new Word("silent"));
        words.add(new Word("enlist"));
        words.add(new Word("hello"));

        String key = "tinsel";

        System.out.println("Key word: " + key);
        System.out.println("Anagrams found: " + words.searchAnagrams(key));
    }
}
