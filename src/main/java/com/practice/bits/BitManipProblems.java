package com.practice.bits;

/**
 * Created by jonathondegn on 8/5/17.
 */
public class BitManipProblems {
    //    https://leetcode.com/problems/hamming-distance/description/
    //    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
    //    Given two integers x and y, calculate the Hamming distance.
    static int hammingDistance(int x, int y) {
        if (x < 0 || y < 0) return -1;
        int total = 0;
        for (x ^= y; x != 0; x = x >> 1) {
            total += (x & 1);
        }
        return total;
    }
}
