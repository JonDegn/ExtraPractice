package com.practice.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class StringsTest {

    @Test
    public void testTitleCase() {
        String test1 = Strings.titlecase("the quick brown fox jumps over the lazy dog", Arrays.asList("jumps", "the", "over"));
        Assert.assertEquals("The Quick Brown Fox jumps over the Lazy Dog", test1);

        String test2 = Strings.titlecase("THE vitamins ARE IN my fresh CALIFORNIA raisins", Arrays.asList("are", "is", "in", "your", "my"));
        Assert.assertEquals("The Vitamins are in my Fresh California Raisins", test2);
    }

    @Test
    public void testIsOneEditDistance() {
        Assert.assertTrue(Strings.isOneEditDistance("cat", "car"));
        Assert.assertTrue(Strings.isOneEditDistance("cat", "cart"));
        Assert.assertTrue(Strings.isOneEditDistance("car", "cart"));
        Assert.assertFalse(Strings.isOneEditDistance("car", "car"));
    }

    @Test
    public void testShortestDistance() {
        int result = Strings.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
        Assert.assertEquals(3, result);

        result = Strings.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        Assert.assertEquals(1, result);

        result = Strings.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "cow", "coding");
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testShortestDistanceClass() {
        WordDistance wd = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        Assert.assertEquals(3, wd.shortestDistance("coding","practice"));
        Assert.assertEquals(1, wd.shortestDistance("coding","makes"));
        Assert.assertEquals(-1, wd.shortestDistance("asdf","adf"));
    }

    @Test
    public void testCheckPermutation() {
        Assert.assertTrue(Strings.checkPermutation("hello", "olleh"));
        Assert.assertFalse(Strings.checkPermutation("hello", "helo"));
        Assert.assertFalse(Strings.checkPermutation("hello", "hell"));
        Assert.assertFalse(Strings.checkPermutation("hello", "heloo"));
    }
}