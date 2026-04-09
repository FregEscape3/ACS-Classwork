import java.util.AbstractList;
import java.util.ArrayList;

public class AnagramList extends AbstractList<Word> {
    private ArrayList<Word> wordList;

    public AnagramList() {
        wordList = new ArrayList<Word>();
    }

    public boolean add(Word word) {
        wordList.add(word);
        return true;
    }

    public boolean checkAnagram(Word word1, Word word2) {
        if (word1 == null || word2 == null) {
            return false;
        }

        return !word1.getOriginalWord().equalsIgnoreCase(word2.getOriginalWord())
                && word1.getSortedWord().equals(word2.getSortedWord());
    }

    public ArrayList<Word> searchAnagrams(String key) {
        ArrayList<Word> anagrams = new ArrayList<Word>();
        Word keyWord = new Word(key);

        for (Word currentWord : wordList) {
            if (checkAnagram(keyWord, currentWord)) {
                anagrams.add(currentWord);
            }
        }

        return anagrams;
    }

    public Word get(int index) {
        return wordList.get(index);
    }

    public int size() {
        return wordList.size();
    }
}
