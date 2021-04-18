import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class PrintMaxOccurringWords {
    public static void main(String[] args) {
        String inputFilePath = "B:\\Projects\\crackingTheCodingInterview\\src\\main\\resources\\application.properties";
        File inputFile = new File(inputFilePath);
        Map<String, Integer> wordMap = new HashMap<>();
        Map<String, Integer> sortedWordMap;
        int limit=5;
        String [] words;

        try {
            FileReader reader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String currLine;
            while (Objects.nonNull(currLine = bufferedReader.readLine())){
                words  = currLine.split("\\s");
                getWordsCount(words, wordMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Sort word map by values.
        sortedWordMap = sortMapByValues (wordMap);

        //Print Top 'n' words which have most number of occurrences in the file.
        int counter = 1;
        for (Map.Entry entry: sortedWordMap.entrySet()) {
            if (counter <= limit) {
                log.info("Top \"{}\" word is: \"{}\". It has \"{}\" occurrences.", counter, entry.getKey(), entry.getValue());
                counter ++;
            }
        }
    }

    //Sort a given map by values in descending order.
    private static Map<String, Integer> sortMapByValues(Map<String, Integer> wordMap) {
        return wordMap
                .entrySet()
                .stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    //Add Words into the map with their occurrences count.
    public static void getWordsCount(String[] words, Map<String, Integer> wordMap) {
        Map<String, Integer> wordsCount = new HashMap<>();
        int count = 0;
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                count = wordMap.get(word);
                wordMap.put(word, ++count);
            } else {
                wordMap.put(word, 1);
            }
        }
    }
}