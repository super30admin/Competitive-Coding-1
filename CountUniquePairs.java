

import java.util.*;
//Time Complexity: O(n)

//Space Complexity: O(n)

public class CountUniquePairs {

    public static void main(String[] args) {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(7, 7, 7, 3, 6, 13, 2, 3),
                Arrays.asList(-1, -3, 4, 1, 5),
        );

        int targetDiff = -2;

        for (List<Integer> inputList : testCases) {
            int uniquePairCount = countUniquePairs(inputList, targetDiff);
            System.out.println("Input: " + inputList);
            System.out.println("Target Difference: " + targetDiff);
            System.out.println("Unique Pair Count: " + uniquePairCount);
            System.out.println("--------------");
        }
    }

    public static int countUniquePairs(List<Integer> inputList, int targetDiff) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number : inputList) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int uniquePairCount = 0;

        // Traverse each unique number in the map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int currentNum = entry.getKey();
            int freq = entry.getValue();

            if (targetDiff != 0) {
                // 🔑 Ensure unique pairs by checking only currentNum once
                // If currentNum + targetDiff exists, we count (currentNum, currentNum + targetDiff) as one unique pair
                if (frequencyMap.containsKey(currentNum + targetDiff)) {
                    uniquePairCount++;
                }
            } else {
                // For k = 0, we only count numbers with duplicates (to form a pair of same numbers)
                if (freq > 1) {
                    uniquePairCount++;
                }
            }
        }

        return uniquePairCount;
    }
}

