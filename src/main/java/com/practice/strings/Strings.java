package com.practice.strings;


import java.util.*;

public class Strings {

    //    https://www.reddit.com/r/dailyprogrammer/comments/wjzly/7132012_challenge_76_easy_title_case/
    //    Write a function that transforms a string into title case. This mostly means: capitalizing only every first letter
    //    of every word in the string. However, there are some non-obvious exceptions to title case which can't easily be
    //    hard-coded. Your function must accept, as a second argument, a set or list of words that should not be capitalized.
    //    Furthermore, the first word of every title should always have a capital letter. For example:
    //    exceptions = ['jumps', 'the', 'over']
    //    titlecase('the quick brown fox jumps over the lazy dog', exceptions)
    //    This should return:
    //    The Quick Brown Fox jumps over the Lazy Dog
    //    An example from the Wikipedia page:
    //    exceptions = ['are', 'is', 'in', 'your', 'my']
    //    titlecase('THE vitamins ARE IN my fresh CALIFORNIA raisins', exceptions)
    //    Returns:
    //    The Vitamins are in my Fresh California Raisins
    public static String titlecase(String title, List<String> exceptions) {
        String[] words = title.split(" ");
        StringBuilder newTitle = new StringBuilder();
        String space = "";
        for (String word : words) {
            String newWord = word.toLowerCase();

            if (exceptions.contains(newWord) && newTitle.length() > 0) {
                newTitle.append(space).append(newWord);
            } else {
                newTitle.append(space).append(newWord.substring(0, 1).toUpperCase()).append(newWord.substring(1));
            }
            space = " ";
        }
        return newTitle.toString();
    }

    //    Given two strings S and T, determine if they are both one edit distance apart.
    public static boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                if (count > 1) return false;

                if (s.length() > t.length()) {
                    i++;
                } else if (s.length() < t.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }

        if (i < s.length() || j < t.length()) count++;
        if (count == 1) return true;
        return false;
    }

    //    Given a list of words and two words word1 and word2, return the shortest distance
    //    between these two words in the list.
    public static int shortestDistance(String[] words, String w1, String w2) {
        int w1pos = -1, w2pos = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(w1)) {
                w1pos = i;
                if (w2pos != -1) {
                    min = Math.min(min, w1pos - w2pos);
                }
            } else if (word.equals(w2)) {
                w2pos = i;
                if (w1pos != -1) {
                    min = Math.min(min, w2pos - w1pos);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min; // return -1 if either word is not found
    }

    //   Check if one string is a permutation of another
    public static boolean checkPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        // O(n) Using HashMap
//        Map<Character, Integer> chars = new HashMap<>(s1.length());
//        for (char c : s1.toCharArray()) {
//            if (chars.containsKey(c)) {
//                chars.put(c, chars.get(c) + 1);
//            } else {
//                chars.put(c, 1);
//            }
//        }
//        for (char c : s2.toCharArray()) {
//            if (chars.containsKey(c) && chars.get(c) > 0) {
//                chars.put(c, chars.get(c) - 1);
//            } else {
//                return false;
//            }
//        }
//        for (char c : chars.keySet()) {
//            if (chars.get(c) > 0) {
//                return false;
//            }
//        }
//        return true;

        //O(n log n) sorting and comparing
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    // Replace spaces with %20
    public static void URLify(char[] s, int len) {
        int numOfSpaces = 0;

        for (int i = 0; i < len; i++) {
            if (s[i] == ' ') {
                numOfSpaces++;
            }
        }

        int insertionPoint = len - 1 + (numOfSpaces * 2);

        for (int i = len - 1; i >= 0; i--) {
            if (s[i] == ' ') {
                s[insertionPoint--] = '0';
                s[insertionPoint--] = '2';
                s[insertionPoint--] = '%';
            } else {
                s[insertionPoint--] = s[i];
            }
        }
    }

    //   Given a string, check if it is a permutation of a palindrome
    public static boolean palindromePermutation(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (c == ' ') continue;
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }
        boolean foundOdd = false;
        for (char c : chars.keySet()) {
            if (chars.get(c) % 2 == 1) {
                if (!foundOdd) {
                    foundOdd = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //   compress a string. aaabb -> a3b2
    public static String compressString(String s) {
        if (s == null || s.length() <= 2) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int run = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                sb.append(run);
                sb.append(s.charAt(i));
                run = 1;
            } else {
                run++;
            }
        }
        sb.append(run);

        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static boolean isRotation(String s1, String s2) {
        return (s1 + s1).contains(s2);
    }

    //    https://www.reddit.com/r/dailyprogrammer/comments/341c03/20150427_challenge_212_easy_r%C3%B6varspr%C3%A5ket/
    //    Take an ordinary word and replace the consonants with the consonant doubled and with an "o" in between.
    //    So the consonant "b" is replaced by "bob", "r" is replaced with "ror", "s" is replaced with "sos", and so on.
    //    Vowels are left intact.
    static String rövarspråketEncode(String str) {
        String vowels = "AEIOUYÅÄÖ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (vowels.indexOf(Character.toUpperCase(c)) == -1 && (c + "").matches("(?U)[\\p{Alpha}]")) {  //consonant
                sb.append(c).append("o").append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String rövarspråketDecode(String str) {
        String vowels = "AEIOUYÅÄÖ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (vowels.indexOf(Character.toUpperCase(c)) == -1 && (c + "").matches("(?U)[\\p{Alpha}]")) {  //consonant
                i += 2;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    //    obtain the sum of 10 times the first digit, 9 times the second digit, 8 times the third digit... all the way
    //    till you add 1 times the last digit. If the sum leaves no remainder when divided by 11 the code is a valid ISBN.
    //    For the cases where the last digit has to equal to ten, the last digit is written as X.
    static boolean isValidISBN(String isbn) {
        String cleaned = isbn.replaceAll("-", "");
        if (cleaned.length() != 10) return false;

        int total = 0;
        try {
            for (int i = 0, mult = 10; i < 10; i++, mult--) {
                total += mult * ((i == 9 && cleaned.charAt(i) == 'X') ? 10 : Integer.parseInt(cleaned.charAt(i) + ""));
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return total % 11 == 0;
    }

    //    https://www.reddit.com/r/dailyprogrammer/comments/5hy8sm/20161212_challenge_295_easy_letter_by_letter
    //    Change a sentence to another sentence, letter by letter.
    //    The sentences will always have the same length.
    static void letterByLetter(String w1, String w2) {
        if (w1.length() != w2.length()) return;

        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                System.out.println(w2.substring(0, i) + w1.substring(i));
            }
        }
        System.out.println(w2);
    }

    static Map<Character, Integer> keysToRow;

    static {
        keysToRow = new HashMap<>(26);
        keysToRow.put('q', 1);
        keysToRow.put('w', 1);
        keysToRow.put('e', 1);
        keysToRow.put('r', 1);
        keysToRow.put('t', 1);
        keysToRow.put('y', 1);
        keysToRow.put('u', 1);
        keysToRow.put('i', 1);
        keysToRow.put('o', 1);
        keysToRow.put('p', 1);

        keysToRow.put('a', 2);
        keysToRow.put('s', 2);
        keysToRow.put('d', 2);
        keysToRow.put('f', 2);
        keysToRow.put('g', 2);
        keysToRow.put('h', 2);
        keysToRow.put('j', 2);
        keysToRow.put('k', 2);
        keysToRow.put('l', 2);

        keysToRow.put('z', 3);
        keysToRow.put('x', 3);
        keysToRow.put('c', 3);
        keysToRow.put('v', 3);
        keysToRow.put('b', 3);
        keysToRow.put('n', 3);
        keysToRow.put('m', 3);
    }

    //    https://leetcode.com/problems/keyboard-row/description/
    //    Given a List of words, return the words that can be typed using letters of alphabet on only one row's of
    //    American keyboard.
    static String[] findWords(String[] words) {
        List<String> oneRowWords = new ArrayList<>();
        outer:
        for (String w : words) {
            int row = keysToRow.get(Character.toLowerCase(w.charAt(0)));
            for (int i = 1; i < w.length(); i++) {
                if (keysToRow.get(Character.toLowerCase(w.charAt(i))) != row) continue outer;
            }
            oneRowWords.add(w);
        }
        return oneRowWords.toArray(new String[oneRowWords.size()]);
    }

    //    https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
    //    Given a string, you need to reverse the order of characters in each word within a sentence while still
    //    preserving whitespace and initial word order.
    static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(new StringBuilder(words[0]).reverse());
        for (int i = 1; i < words.length; i++) {
            sb.append(" ");
            sb.append(new StringBuilder(words[i]).reverse());
        }
        return sb.toString();
    }

    //    https://leetcode.com/problems/detect-capital/description/
    //    Given a word, you need to judge whether the usage of capitals in it is right or not.
    //    We define the usage of capitals in a word to be right when one of the following cases holds:
    //    All letters in this word are capitals, like "USA".
    //    All letters in this word are not capitals, like "leetcode".
    //    Only the first letter in this word is capital if it has more than one letter, like "Google".
    //    Otherwise, we define that this word doesn't use capitals in a right way.
    static boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;

        boolean cap = Character.isUpperCase(word.charAt(1));

        for (int i = 1; i < word.length(); i++) {
            if (cap ^ Character.isUpperCase(word.charAt(i))) return false;
        }
        return Character.isUpperCase(word.charAt(0)) || !cap;
    }

    //    https://leetcode.com/problems/ransom-note/description/
    //    Given an arbitrary ransom note string and another string containing letters from all the magazines, write a
    //    function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
    //    Each letter in the magazine string can only be used once in your ransom note.
    static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (charMap.containsKey(c) && charMap.get(c) > 0) {
                charMap.put(c, charMap.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    //    https://leetcode.com/problems/find-the-difference/description/
    //    Given two strings s and t which consist of only lowercase letters.
    //    String t is generated by random shuffling string s and then add one more letter at a random position.
    //    Find the letter that was added in t.
    static char findTheDifference(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        Arrays.sort(sChars);
//        Arrays.sort(tChars);
//        for (int i = 0; i < s.length(); i++) {
//            if (sChars[i] != tChars[i]) return tChars[i];
//        }
//        return tChars[tChars.length - 1];
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
