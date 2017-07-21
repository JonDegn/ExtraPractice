package com.practice.strings;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

}
