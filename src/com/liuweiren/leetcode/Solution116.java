package com.liuweiren.leetcode;

/**
 *
 * 1160 - 1169
 *
 * <br><br>Created by <b>LWR</b> on <b>2020/3/18</b>
 * @author LWR
 */
public class Solution116 {
    /**
     * 1160.Find Words That Can Be Formed by Characters (单词拼写)
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        // int wordLength = 0;
        //
        // Map<Character, Integer> charMap = new HashMap<>(chars.length(), 1);
        // for (char c : chars.toCharArray()) {
        //     charMap.put(c,(charMap.containsKey(c) ? charMap.get(c) + 1 : 1));
        // }
        //
        // for (String word : words) {
        //     Map<Character, Integer> charTemp = new HashMap<>(charMap);
        //
        //     boolean isComplete = true;
        //     for (int i = 0, wordL = word.length(); i < wordL; i++) {
        //         char wordChar = word.charAt(i);
        //
        //         if (charTemp.containsKey(wordChar) && charTemp.get(wordChar) > 0) {
        //             charTemp.put(wordChar, charTemp.get(wordChar) - 1);
        //             continue;
        //         }
        //
        //         isComplete = false;
        //         break;
        //     }
        //
        //     if (isComplete) {
        //         wordLength += word.length();
        //     }
        // }

        // int wordLength = 0;
        //
        // Map<Character, Integer> charMap = new HashMap<>(chars.length(), 1);
        // for (char c : chars.toCharArray()) {
        //     charMap.put(c,(charMap.containsKey(c) ? charMap.get(c) + 1 : 1));
        // }
        //
        // for (String word : words) {
        //     Map<Character, Integer> wordMap = new HashMap<>(word.length(), 1);
        //     for (char c : word.toCharArray()) {
        //         wordMap.put(c,(wordMap.containsKey(c) ? wordMap.get(c) + 1 : 1));
        //     }
        //
        //     boolean isComplete = true;
        //     for (char c : word.toCharArray()) {
        //         if (charMap.get(c) == null || wordMap.get(c) > charMap.get(c)) {
        //             isComplete = false;
        //             break;
        //         }
        //     }
        //
        //     if (isComplete) {
        //         wordLength += word.length();
        //     }
        // }

        int wordsLength = 0;

        int[] charsArr =  new int[26];
        for (int i = 0, charLen = chars.length(); i < charLen; i++) {
            charsArr[chars.charAt(i) - 'a']++;
        }

        for (String word : words) {
            int[] wordArr = new int[26];
            for (int i = 0, wordLen = word.length(); i < wordLen; i++) {
                wordArr[word.charAt(i) - 'a']++;
            }

            boolean isComplete = true;
            for (int i = 0, arrLen = wordArr.length; i < arrLen; i++) {
                if (wordArr[i] > charsArr[i]) {
                    isComplete = false;
                    break;
                }
            }

            if (isComplete) {
                wordsLength += word.length();
            }
        }

        return wordsLength;
    }
}
