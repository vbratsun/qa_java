package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    private Cat cat;

    @Before
    public void setup(){
        this.cat = new Cat(this.feline);
    }

    @Test
    public void testGetCatSound() {
        String expectedSound = "Мяу";
        Assert.assertEquals(expectedSound, this.cat.getSound());
    }

    @Test
    public void testGetPredatorFood() throws Exception {
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(this.feline.eatMeat()).thenReturn(expectedFoodList);
        Assert.assertEquals(expectedFoodList, this.cat.getFood());
        Mockito.verify(this.feline, Mockito.times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Mockito.when(this.feline.eatMeat()).thenThrow(new Exception());
        this.cat.getFood();
    }
}