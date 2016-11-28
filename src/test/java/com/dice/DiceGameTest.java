package com.dice;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 *
 * Created by eric on 28/11/16.
 */
public class DiceGameTest {

    @Test
    public void calculateTurnTotal12EarningsWithSuccess() {
        BigDecimal total = DiceGame.calculateTurnEarnings(12, BigDecimal.valueOf(0.50));
        Assert.assertThat(total, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("2.00"))));
    }

    @Test
    public void calculateTurnTotal11EarningsWithSuccess() {
        BigDecimal total = DiceGame.calculateTurnEarnings(11, BigDecimal.valueOf(0.50));
        Assert.assertThat(total, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("1.50"))));
    }

    @Test
    public void calculateTurnTotal10EarningsWithSuccess() {
        BigDecimal total = DiceGame.calculateTurnEarnings(10, BigDecimal.valueOf(0.50));
        Assert.assertThat(total, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("1.00"))));
    }

    @Test
    public void calculateTurnTotal10To7EarningsWithSuccess() {
        BigDecimal total = DiceGame.calculateTurnEarnings(7, BigDecimal.valueOf(0.50));
        Assert.assertThat(total, CoreMatchers.is(CoreMatchers.equalTo(new BigDecimal("0.5"))));
    }

    @Test
    public void calculateTurnTotal6to1To2EarningsWithSuccess() {
        BigDecimal total = DiceGame.calculateTurnEarnings(2, BigDecimal.valueOf(0.50));
        Assert.assertThat(total, CoreMatchers.is(CoreMatchers.equalTo(new  BigDecimal("0.00"))));
    }
}