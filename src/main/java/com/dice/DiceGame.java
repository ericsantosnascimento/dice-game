package com.dice;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by eric on 28/11/16.
 */
public class DiceGame {

    private static BigDecimal credit = new BigDecimal("0.50");
    private static BigDecimal totalCredit = new BigDecimal(0);
    private static Random randomGenerator = new Random();


    public static void main(String[] args) {

        for (int i = 0; i <= 1000; i++) {

            int dice1 = randomGenerator.nextInt(7);
            int dice2 = randomGenerator.nextInt(7);
            int total = dice1 + dice2;
            System.out.println("Turn : " + i + " total dice " + total);
            calculateTurnEarnings(total);

        }

        System.out.println("Your final credit is " + totalCredit);
        printFinalResult();

    }

    private static void calculateTurnEarnings(int total) {

        if (total == 12) {
            totalCredit = totalCredit.add(calculateCredit(credit, 4));
            System.out.println(totalCredit);
        } else if (total == 11) {
            totalCredit = totalCredit.add(calculateCredit(credit, 3));
            System.out.println(totalCredit);
        } else if (total == 10) {
            totalCredit = totalCredit.add(calculateCredit(credit, 2));
            System.out.println(totalCredit);
        } else if (total < 10 && total > 6) {
            System.out.println(totalCredit);
        } else {
            totalCredit = totalCredit.subtract(credit);
            System.out.println(totalCredit);
        }
    }

    private static void printFinalResult() {

        if (totalCredit.compareTo(credit) > 1) {
            System.out.println("You won!");
        } else if (totalCredit.compareTo(BigDecimal.ZERO) < 1) {
            System.out.println("So sad you loose money!");
        } else {
            System.out.println("No loose no won, just earn nothing");
        }
    }

    private static BigDecimal calculateCredit(BigDecimal credit, int multiply) {
        return credit.multiply(new BigDecimal(multiply));
    }
}
