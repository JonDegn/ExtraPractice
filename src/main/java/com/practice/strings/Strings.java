package com.practice.strings;


import java.util.List;

public class Strings {

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

}
