import java.lang.Comparable;

import java.util.*;
import java.util.stream.Collectors;

class WordFreq implements Comparable<WordFreq> {
    public String word;
    public int freq;
    
    public WordFreq(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
    
    public String getWord() {
        return word;
    }
    
    public int compareTo(WordFreq other) {
        if (other.freq != freq) {
            // return freq - other.freq;
            return other.freq - freq; // Reverse order
        }
        
        return word.compareTo(other.word);
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> freq = countWordFrequency(words);
        List<WordFreq> wordFreqList = freq
            .entrySet()
            .stream()
            .map(entry -> new WordFreq(entry.getKey(), entry.getValue().intValue() ))
            .toList();
        
        return wordFreqList
            .stream()
            .sorted()
            .map(WordFreq::getWord)
            .limit(k)
            .toList();
    }
    
    private Map<String, Long> countWordFrequency(String[] words) {
        return Arrays
            .stream(words)
            .collect(
                Collectors.groupingBy(
                    x -> x,
                    Collectors.counting()
                )
            );
    }
}
