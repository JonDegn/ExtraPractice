package com.practice.strings;

import java.util.*;

//  Design a class which receives a list of words in the constructor, and implements
//  a method that takes two words word1 and word2 and return the shortest distance
//  between these two words in the list.
public class WordDistance {
    Map<String, List<Integer>> wordPositions;

    public WordDistance(String[] words) {
        this.wordPositions = new HashMap<>();
        for (int i = 0; i < words.length; i++) {

            if (this.wordPositions.containsKey(words[i])) {
                List<Integer> positions = wordPositions.get(words[i]);
                positions.add(i);
                wordPositions.put(words[i], positions);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                wordPositions.put(words[i], l);
            }
        }
    }

    public int shortestDistance(String w1, String w2) {
        if (!wordPositions.containsKey(w1) || !wordPositions.containsKey(w2)) return -1;

        List<Integer> w1positions = wordPositions.get(w1);
        List<Integer> w2Positions = wordPositions.get(w2);

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while (i < w1positions.size() && j < w2Positions.size()) {
            min = Math.min(min, Math.abs(w1positions.get(i) - w2Positions.get(j)));
            if (w1positions.get(i) < w2Positions.get(j)) {
                i++;
            } else {
                j++;
            }
        }

//        for (int i : w1positions) {
//            for (int j : w2Positions) {
//                min = Math.min(min, Math.abs(i - j));
//            }
//        }
        return min;
    }

}
