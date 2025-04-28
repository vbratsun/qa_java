package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void testLionThrowsExceptionOnInvalidSex() throws Exception {
        new Lion(this.feline, "Неизвестный пол");
    }

    @Test
    public void testLionGetSingleKitten() throws Exception {
        int expectedNumberOfKittens = 1;
        Lion lion = new Lion(this.feline, "Самец");
        Mockito.when(this.feline.getKittens()).thenReturn(expectedNumberOfKittens);
        Assert.assertEquals(expectedNumberOfKittens, lion.getKittens());
    }

    @Test
    public void testLionGetPredatorFood() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        String animalKind = "Хищник";
        Mockito.when(this.feline.getFood(animalKind)).thenReturn(expectedFoodList);
        Lion lion = new Lion(this.feline, "Самец");
        Assert.assertEquals(expectedFoodList, lion.getFood());
        Mockito.verify(this.feline, Mockito.times(1)).getFood(animalKind);
    }
}