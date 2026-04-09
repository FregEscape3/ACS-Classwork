public class Word {
    private String originalWord;
    private String sortedWord;

    public Word(String originalWord) {
        if (!isValidWord(originalWord)) {
            throw new IllegalArgumentException("Word must be one word using letters only.");
        }

        this.originalWord = originalWord;
        this.sortedWord = sortWord();
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public String getSortedWord() {
        return sortedWord;
    }

    public String sortWord() {
        String lowerCaseWord = originalWord.toLowerCase();
        char[] letters = lowerCaseWord.toCharArray();

        for (int i = 0; i < letters.length - 1; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < letters.length; j++) {
                if (letters[j] < letters[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            char temp = letters[i];
            letters[i] = letters[smallestIndex];
            letters[smallestIndex] = temp;
        }

        return new String(letters);
    }

    private boolean isValidWord(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        return originalWord;
    }
}
