package com.practice.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


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
        Assert.assertEquals(3, wd.shortestDistance("coding", "practice"));
        Assert.assertEquals(1, wd.shortestDistance("coding", "makes"));
        Assert.assertEquals(-1, wd.shortestDistance("asdf", "adf"));
    }

    @Test
    public void testCheckPermutation() {
        Assert.assertTrue(Strings.checkPermutation("hello", "olleh"));
        Assert.assertFalse(Strings.checkPermutation("hello", "helo"));
        Assert.assertFalse(Strings.checkPermutation("hello", "hell"));
        Assert.assertFalse(Strings.checkPermutation("hello", "heloo"));
    }

    @Test
    public void testURLify() {
        char[] chars = "Mr John Smith    ".toCharArray();
        Strings.URLify(chars, 13);
        Assert.assertEquals("Mr%20John%20Smith", new String(chars));
    }

    @Test
    public void testPalindromePermutation() {
        Assert.assertTrue(Strings.palindromePermutation("TacT Coa"));   //taco cat
    }

    @Test
    public void testCompressString() {
        Assert.assertEquals("hi", Strings.compressString("hi"));
        Assert.assertEquals("hello", Strings.compressString("hello"));
        Assert.assertEquals("aaabbbccaaba", Strings.compressString("aaabbbccaaba"));
        Assert.assertEquals("a3b3c2a2b3a1", Strings.compressString("aaabbbccaabbba"));
        Assert.assertEquals("aabbcc", Strings.compressString("aabbcc"));
        Assert.assertEquals("a4b1", Strings.compressString("aaaab"));
        Assert.assertEquals("b1a4", Strings.compressString("baaaa"));
    }

    @Test
    public void testIsRotation() {
        Assert.assertTrue(Strings.isRotation("hello", "lohel"));
        Assert.assertFalse(Strings.isRotation("hello", "lohle"));
    }

    @Test
    public void testRövarspråketDecode() {
        Assert.assertEquals("Jag talar Rövarspråket!", Strings.rövarspråketDecode("Jojagog totalolaror Rorövovarorsospoproråkoketot!"));
        Assert.assertEquals("I'm speaking Robber's language!", Strings.rövarspråketDecode("I'mom sospopeakokinongog Rorobobboberor'sos lolanongoguagoge!"));
        Assert.assertEquals("Tre Kronor är världens bästa ishockeylag.", Strings.rövarspråketDecode("Totrore Kokrorononoror äror vovärorloldodenonsos bobäsostota isoshohocockokeylolagog."));
        Assert.assertEquals("Vår kung är coolare än er kung.", Strings.rövarspråketDecode("Vovåror kokunongog äror cocoololarore änon eror kokunongog."));
    }

    @Test
    public void testRövarspråketEncode() {
        Assert.assertEquals("Jojagog totalolaror Rorövovarorsospoproråkoketot!", Strings.rövarspråketEncode("Jag talar Rövarspråket!"));
        Assert.assertEquals("I'mom sospopeakokinongog Rorobobboberor'sos lolanongoguagoge!", Strings.rövarspråketEncode("I'm speaking Robber's language!"));
        Assert.assertEquals("Totrore Kokrorononoror äror vovärorloldodenonsos bobäsostota isoshohocockokeylolagog.", Strings.rövarspråketEncode("Tre Kronor är världens bästa ishockeylag."));
        Assert.assertEquals("Vovåror kokunongog äror cocoololarore änon eror kokunongog.", Strings.rövarspråketEncode("Vår kung är coolare än er kung."));
    }

    @Test
    public void testIsValidISBN(){
        Assert.assertTrue(Strings.isValidISBN("0-7475-3269-9"));
        Assert.assertTrue(Strings.isValidISBN("156881111X"));
    }

    @Test
    public void testLetterByLetter(){
        Strings.letterByLetter("floor", "brake");
        Strings.letterByLetter("wood", "book");
        Strings.letterByLetter("a fall to the floor", "braking the door in");
    }
}