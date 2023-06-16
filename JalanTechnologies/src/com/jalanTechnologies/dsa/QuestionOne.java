package com.jalanTechnologies.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuestionOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lenOfArray = sc.nextInt();
		int [] array = new int [lenOfArray];
		for (int i = 0; i < lenOfArray; i++) {
			array[i] = sc.nextInt();
		}
		List<Integer> result = findZeroSumElements(array);

        if (result.isEmpty()) {
            System.out.println("No Elements found");
        } else {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }
    }

    public static List<Integer> findZeroSumElements(int[] arr) {
        int n = arr.length;
        List<Integer> subArray = new ArrayList<>();
        Map<Integer, Integer> tempSum = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                for (int j = 0; j <= i; j++) {
                    subArray.add(arr[j]);
                }
                return subArray;
            }

            if (tempSum.containsKey(sum)) {
                int startIndex = tempSum.get(sum) + 1;
                int endIndex = i;

                for (int j = startIndex; j <= endIndex; j++) {
                    subArray.add(arr[j]);
                }
                return subArray;
            }
            tempSum.put(sum, i);
        }
        return subArray;
    }
}
