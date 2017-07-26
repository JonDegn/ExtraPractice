package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathondegn on 7/18/17.
 */
public class MyStringBuilder {

    List<Character> chars;
    int length = 0;

    public MyStringBuilder() {
        chars = new ArrayList<>();
    }

    public MyStringBuilder(String str) {
        chars = new ArrayList<>();
        chars.addAll(str.toCharArray());
        length = str.length();
    }

    public MyStringBuilder(int capacity) {
        chars = new ArrayList<>(capacity);
    }

    public MyStringBuilder append(String s) {
        chars.add(s.toCharArray());
        length += s.length();
        return this;
    }

    public char charAt(int idx) {
        int num = 0;
        for (char[] s : chars) {
            if (idx > num && idx < num + s.length){
                return s[idx-num];
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.charAt()
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[0] =
        }
    }
}
