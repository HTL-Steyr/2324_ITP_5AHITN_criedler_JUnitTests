package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    /**
     * Test shorten with given 12_4 expected 3_1
     */
    @Test
    void shorten1() throws DivisionByZeroExeception {
        Fraction f = new Fraction(12, 4);

        Fraction shortened = f.shorten();

        assertEquals(3, shortened.getNumerator());
        assertEquals(1, shortened.getDenominater());
    }


    @Test
    void add() throws DivisionByZeroExeception {
        Fraction fraction = new Fraction(1, 2);

        Fraction newFraction = fraction.add(new Fraction(1, 2));
        newFraction = newFraction.shorten();

        assertEquals(1, newFraction.getNumerator());
        assertEquals(1, newFraction.getDenominater());
    }

    @Test
    void sub() throws DivisionByZeroExeception {
        Fraction fraction = new Fraction(1, 2);
        Fraction newFraction = fraction.sub(new Fraction(1, 2));
        newFraction = newFraction.shorten();

        assertEquals(0, newFraction.getNumerator());
        assertEquals(1, newFraction.getDenominater());
    }

    @Test
    void mul() throws DivisionByZeroExeception {
        Fraction fraction = new Fraction(1, 2);
        Fraction newFraction = fraction.mul(new Fraction(1, 2));
        newFraction = newFraction.shorten();

        assertEquals(1, newFraction.getNumerator());
        assertEquals(4, newFraction.getDenominater());
    }

    @Test
    void div() throws DivisionByZeroExeception {
        Fraction fraction = new Fraction(1, 2);
        Fraction newFraction = fraction.div(new Fraction(1, 2));
        newFraction = newFraction.shorten();

        assertEquals(1, newFraction.getNumerator());
        assertEquals(1, newFraction.getDenominater());
    }

    @Test
     void reciprocal() throws DivisionByZeroExeception {
        Fraction f = new Fraction( 3,4);
        Fraction result = f.reciprocal();

        assertEquals(4,result.getNumerator());
        assertEquals(3,result.getDenominater());
    }
}