package com.dice;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Dice Game application
 *
 * Created by eric on 28/11/16.
 */
public class DiceGame {

    private static BigDecimal credit = new BigDecimal("0.50");
    //private static BigDecimal totalCredit = new BigDecimal(0);
    private static Random randomGenerator = new Random();

    public static void main(String[] args) {

        BigDecimal totalCredit = new BigDecimal(0);

        for (int i = 0; i <= 1000; i++) {

            int dice1 = randomGenerator.nextInt(6) + 1;
            int dice2 = randomGenerator.nextInt(6) + 1;

            int total = dice1 + dice2;

            System.out.println("Turn : " + i + 1 + " total dice " + total);
            totalCredit = calculateTurnEarnings(total, totalCredit);

        }

        System.out.println("Your final credit is " + totalCredit);
        printFinalResult(totalCredit);

    }

    public static BigDecimal calculateTurnEarnings(int total, BigDecimal totalCredit) {

        if (total == 12) {
            return totalCredit.add(calculateCredit(credit, 3));
        } else if (total == 11) {
            return totalCredit.add(calculateCredit(credit, 2));
        } else if (total == 10) {
            return totalCredit.add(calculateCredit(credit, 1));
        } else if (total < 10 && total > 6) {
            return totalCredit;
        } else {
            return totalCredit.subtract(credit);
        }
    }

    private static void printFinalResult(BigDecimal totalCredit) {

        if (totalCredit.compareTo(credit) > 0) {
            System.out.println("You won!");
        } else if (totalCredit.compareTo(BigDecimal.ZERO) < 1) {
            System.out.println("So sad you loose money!");
        } else {
            System.out.println("No loose, no won, just earn nothing");
        }
    }

    private static BigDecimal calculateCredit(BigDecimal credit, int multiply) {
        return credit.multiply(new BigDecimal(multiply));
    }
}
