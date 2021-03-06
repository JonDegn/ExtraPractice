package com.practice.algorithms;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by jonathondegn on 6/29/17.
 */
public class Algorithms {

    // Two Sum
    //
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    // Two Sum II - Input array is sorted
    //
    // Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
    // specific target number.
    // The function twoSum should return indices of the two numbers such that they add up to the target, where index1
    // must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
    // You may assume that each input would have exactly one solution and you may not use the same element twice.    //
    public static int[] twoSumII(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        do {
            if (i >= j) {
                return null;
            }
            if (nums[i] + nums[j] < target) {
                i++;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            }
        } while (nums[i] + nums[j] != target);
        return new int[]{i + 1, j + 1};
    }

    // Two Sum III - Data structure design
    //
    // Design and implement a TwoSum class. It should support the following operations:
    // add and find.
    // add - Add the number to an internal data structure. find - Find if there exists any
    // pair of numbers which sum is equal to the value.
    public class TwoSum {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        public void add(int num) {
            if (numbers.containsKey(num)) {
                numbers.put(num, numbers.get(num) + 1);
            } else {
                numbers.put(num, 1);
            }
        }

        public boolean find(int num) {
            for (int i : numbers.keySet()) {
                int target = num - i;
                if (numbers.containsKey(target)) {
                    if (i == target && numbers.get(target) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    // Three Sum
    //
    // Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    // Find all unique triplets in the array which gives the sum of zero.
    // Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a  b  c)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;

                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
    // O(n^2)

    //    Given an array S of n integers, find three integers in S such that the sum is closest to a
    //    given number, target. Return the sum of the three integers. You may assume that each
    //    input would have exactly one solution.
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(curr - target);

                if (diff == 0) return curr;

                if (diff < min) {
                    min = diff;
                    result = curr;
                }

                if (curr < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
    // O(n^2)

    //    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c
    //    + d = target? Find all unique quadruplets in the array which gives the sum of target.
    //    Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤
    //    b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; // skip duplicate numbers

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicate numbers
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
                        k++;
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
                        l--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) l--; // skip duplicate numbers
                        while (k < l && nums[k] == nums[k - 1]) k++; // skip duplicate numbers
                    }
                }
            }
        }
        return result;
    }

    //    Probability Graph
    //    https://www.reddit.com/r/dailyprogrammer/comments/wk066/7132012_challenge_76_intermediate_probability/
    //    Write a function graph(f, low, high, tests) that outputs a probability graph of the function f from range low
    //    to high (inclusive) over tests tests (i.e., counting the frequencies of f() outputs). f takes no arguments and
    //    returns an integer, low, high and tests are all integer values. For example, a function f that simulates
    //    two-dice rolls:
    //    def two_dice():
    //            return random.randint(1, 6) + random.randint(1, 6)
    //    Then graph(f, 2, 12, 10000) should output something roughly like:
    //            2: ##
    //            3: #####
    //            4: #######
    //            5: ###########
    //            6: #############
    //            7: #################
    //            8: #############
    //            9: ###########
    //           10: ########
    //           11: #####
    //           12: ##
    //    For bonus points, output the graph with the numbers on the bottom and the bars drawn vertically.
    public static void graph(Supplier<Integer> f, int low, int high, int tests) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < tests; i++) {

            Integer k = f.get();
            if (frequencies.containsKey(k)) {
                frequencies.put(k, frequencies.get(k) + 1);
            } else {
                frequencies.put(k, 1);
            }
        }

        int highestFreq = 0;
        for (int i = low; i <= high; i++) {
            if (frequencies.containsKey(i)) {
                if (highestFreq < frequencies.get(i)) {
                    highestFreq = frequencies.get(i);
                }
            } else {
                frequencies.put(i, 0);
            }
        }
        for (int i = low; i <= high; i++) {
            System.out.printf("%4d: ", i);

            for (int j = 0; j < ((double) frequencies.get(i) / tests) * 100; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    //    Enumerating Morse code sequences
    //    https://www.reddit.com/r/dailyprogrammer/comments/wn3ld/7162012_challenge_77_easy_enumerating_morse_code/
    //    Morse code, as we are all aware, consists of dots and dashes. Lets define a "Morse code sequence" as simply a
    //    series of dots and dashes (and nothing else). So ".--.-.--" would be a morse code sequence, for instance.
    //    Dashes obviously take longer to transmit, that's what makes them dashes. Lets say that a dot takes 1 unit of time
    //    to transmit, and a dash takes 2 units of time. Then we can say that the "size" of a certain morse code sequence is
    //    the sum of the time it takes to transmit the dots and dashes. So, for instance "..-." would have a size of 5
    //    (since there's three dots taking three units of time and one dash taking two units of time, for a total of 5). The
    //    sequence "-.-" would also have a size of 5.
    //    In fact, if you list all the the possible Morse code sequences of size 5, you get:
    //            .....  ...-  ..-.  .-..  -...  .--  -.-  --.
    //    A total of 8 different sequences.
    //    Your task is to write a function called Morse(X) which generates all morse code sequences of size X and returns
    //    them as an array of strings (so Morse(5) should return the 8 strings I just mentioned, in some order).
    //    Use your function to generate and print out all sequences of size 10.
    public static List<String> morse(int num, String curr) {
        if (num == 0) {
            return Collections.singletonList(curr);
        } else if (num < 0) {
            return new ArrayList<>();
        }
        List<String> results = new ArrayList<>();
        results.addAll(morse(num - 1, curr + "."));
        results.addAll(morse(num - 2, curr + "-"));

        return results;
    }

    //    Given an array of n positive integers and a positive integer s, find the minimal length
    //    of a subarray of which the sum ≥ s. If there isn’t one, return 0 instead.
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums.length;
        int start = 0, onePastEnd = 0, sum = 0;
        boolean exists = false;

        while (onePastEnd <= nums.length) {
            if (sum >= s) {
                exists = true;
                if (start == onePastEnd - 1) return 1;

                result = Math.min(result, onePastEnd - start);
                sum = sum - nums[start];
                start++;
            } else {
                if (onePastEnd == nums.length) break;

                sum = sum + nums[onePastEnd];
                onePastEnd++;
            }
        }

        return exists ? result : 0;
    }

    //remove duplicates from a sorted array
    // can't resize array, so returning new one
    public static int[] removeDuplicates(int[] a) {
        if (a == null || a.length < 2) {
            return a;
        }

        int i = 0, j = 1;

        while (j < a.length) {
            if (a[i] == a[j]) {
                j++;
            } else {
                i++;
                a[i] = a[j];
                j++;
            }
        }

        return Arrays.copyOf(a, i + 1);
    }

    // remove duplicates that occur more than twice from a sorted array
    // can't resize array, so returning new one
    public static int[] removeDuplicatesII(int[] a) {
        if (a == null || a.length < 3) {
            return a;
        }

        int previous = a[0];
        boolean seenTwo = false;
        int count = 0;

        int idxToUpdate = 1;

        for (int i = 1; i < a.length; i++) {
            int curr = a[i];

            if (curr == previous) {
                if (!seenTwo) {
                    seenTwo = true;
                    a[idxToUpdate++] = curr;
                    continue;
                } else {
                    count++;
                }
            } else {
                previous = curr;
                a[idxToUpdate++] = curr;
                seenTwo = false;
            }
        }

        return Arrays.copyOf(a, a.length - count);
    }

    //    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate
    //    (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai)
    //    and (i, 0). Find two lines, which together with x-axis forms a container, such that the
    //    container contains the most water.
    public static int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    //    There are N children standing in a line. Each child is assigned a rating value. You are
    //    giving candies to these children subjected to the following requirements:
    //      1. Each child must have at least one candy.
    //      2. Children with a higher rating get more candies than their neighbors.
    //    What is the minimum candies you must give?
    public static int candy(int[] ratings) {
        if (ratings == null | ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int totalCandy = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            int newGuess = 1;
            if (ratings[i] > ratings[i + 1]) {
                newGuess = candies[i + 1] + 1;
            }
            candies[i] = Math.max(candies[i], newGuess);
            totalCandy += candies[i];
        }
        return totalCandy;
    }

    //    Given n non-negative integers representing an elevation map where the width of each
    //    bar is 1, compute how much water it is able to trap after raining.
    public static int trap(int[] heights) {
        int result = 0;
        if (heights == null | heights.length < 3) {
            return result;
        }


        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        int max = heights[0];
        left[0] = heights[0];

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < max) {
                left[i] = max;
            } else {
                left[i] = heights[i];
                max = heights[i];
            }
        }

        max = heights[heights.length - 1];
        right[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] < max) {
                right[i] = max;
            } else {
                right[i] = heights[i];
                max = heights[i];
            }
        }

        for (int i = 0; i < heights.length; i++) {
            result += Math.min(left[i], right[i]) - heights[i];
        }

        return result;
    }

    //    Find the largest palindrome made from the product of two n-digit numbers.
    //    Since the result could be very large, you should return the largest palindrome mod 1337
    static public int largestPalindrome(int n) {
        int max = Integer.MIN_VALUE;
        int num1, num2;
        if (n < 1 || n > 8) return -1;
        num1 = (int) Math.pow(10, n) - 1;
        while (num1 >= Math.pow(10, n - 1)) {
            num2 = num1;
            while (num2 >= Math.pow(10, n - 1)) {
                if (isPalindrome(num1 * num2)) {
                    max = Math.max(num1 * num2, max);
                }
                num2--;
            }
            num1--;
        }
        return max % 1337;
    }

    static private boolean isPalindrome(long num) {
        long forward = num;
        long reverse = 0;
        while (num > 0) {
            long digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        return forward == reverse;
    }

    //    https://www.reddit.com/r/dailyprogrammer/comments/3r7wxz/20151102_challenge_239_easy_a_game_of_threes/
    //    Repeatedly do the following:
    //    If the number is divisible by 3, divide it by 3.
    //    If it's not, either add 1 or subtract 1 (to make it divisible by 3), then divide it by 3.
    //    The game stops when you reach "1".
    static void threesGame(int num) {
        System.out.print(num);
        if (num == 1) return;

        if (num % 3 == 0) {
            System.out.println(" 0");
            threesGame(num / 3);
        } else if ((num + 1) % 3 == 0) {
            System.out.println(" 1");
            threesGame((num + 1) / 3);
        } else {
            System.out.println(" -1");
            threesGame((num - 1) / 3);
        }
    }

    //    https://leetcode.com/problems/distribute-candies/description/
    //    Given an integer array with even length, where different numbers in this array represent different kinds of
    //    candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally
    //    in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.
    static int distributeCandies(int[] candies) {
        Set<Integer> candySet = Arrays.stream(candies).boxed().collect(Collectors.toSet());
        return Math.min(candySet.size(), candies.length / 2);
    }

    //    https://leetcode.com/problems/nim-game/description/
    //    You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one
    //    of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will
    //    take the first turn to remove the stones.
    //    Both of you are very clever and have optimal strategies for the game. Write a function to determine whether
    //    you can win the game given the number of stones in the heap.
    static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    //    https://leetcode.com/problems/add-digits/description/
    //    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
    static int addDigits(int num) {
//        while (num > 9) {
//            int total = 0;
//            while (num != 0) {
//                total += num % 10;
//                num /= 10;
//            }
//            num = total;
//        }
//        return num;
        // O(1)
        return 1 + (num - 1) % 9;
    }

    //    https://leetcode.com/problems/construct-the-rectangle/description/
    //    1. The area of the rectangular web page you designed must equal to the given target area.
    //    2. The width W should not be larger than the length L, which means L >= W.
    //    3. The difference between length L and width W should be as small as possible.
    static int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        int l = (int) Math.ceil(sqrt);
        int w = (int) Math.floor(sqrt);
        while (l * w != area) {
            if (l * w > area)
                w--;
            else
                l++;
            if (l * w == 0) return new int[0];
        }
        return new int[]{l, w};

//        int w = (int) Math.sqrt(area);
//        while (area % w != 0) w--;
//        return new int[]{area / w, w};
    }

    //    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    //    Say you have an array for which the ith element is the price of a given stock on day i.
    //    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    static int maxProfit(int[] prices) {
        // brute force
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
//            }
//        }
//        return maxProfit;
        //
//        int maxCur = 0, maxSoFar = 0;
//        for (int i = 1; i < prices.length; i++) {
//            maxCur += prices[i] - prices[i - 1];
//            maxCur = Math.max(0, maxCur);
//            maxSoFar = Math.max(maxCur, maxSoFar);
//        }
//        return maxSoFar;
        if (prices == null || prices.length < 2) return 0;
        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            } else {
                minPrice = Math.min(minPrice, prices[i]);
            }
        }
        return maxProfit;
    }

    static int[] cache = new int[100];

    //    https://leetcode.com/problems/climbing-stairs/description/
    //    You are climbing a stair case. It takes n steps to reach to the top.
    //    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    static int climbStairs(int n) {
//        cache[0] = 1;
//        cache[1] = 2;
//        if (cache[n-1] == 0) {
//            cache[n-1] = climbStairs(n-1) + climbStairs(n-2);
//        }
//        return cache[n-1];
        // no extra space
        if (n==1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

}
