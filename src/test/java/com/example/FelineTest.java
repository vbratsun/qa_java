package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        this.feline = new Feline();
    }

    @Test
    public void testGetFelineFamily() {
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, this.feline.getFamily());
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFoodList, feline.eatMeat());
    }

    @Test
    public void testFelineGetSingleKitten() {
        int expectedNumberOfKittens = 1;
        Assert.assertEquals(expectedNumberOfKittens, this.feline.getKittens());
    }

    @Test
    public void testFelineGetMoreThenOneKitten() {
        int expectedNumberOfKittens = 5;
        Assert.assertEquals(expectedNumberOfKittens, this.feline.getKittens(expectedNumberOfKittens));
    }
}