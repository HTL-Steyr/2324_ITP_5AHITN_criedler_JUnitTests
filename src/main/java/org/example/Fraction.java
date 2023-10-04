package org.example;

public class Fraction {

    private int numerator; //zaehler
    private int denominater; //nenner


    public Fraction(int nominator, int denominater) throws DivisionByZeroExeception {
        setNumerator(nominator);
        setDenominater(denominater);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominater() {
        return denominater;
    }

    public void setDenominater(int denominater) throws DivisionByZeroExeception {
        if (denominater == 0) throw new DivisionByZeroExeception();
        this.denominater = denominater;

    }

    public Fraction shorten() {
        int gcd = gcd(getNumerator(), getDenominater());
        try {
            return new Fraction(getNumerator() / gcd, getDenominater() / gcd);
        }catch (DivisionByZeroExeception e){
            throw new RuntimeException();
        }
    }
    public Fraction add(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNumerator() * f.getDenominater() + f.getNumerator() * getDenominater();
        int newDenominator = getDenominater() * f.getDenominater();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction sub(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNumerator() * f.getDenominater() - f.getNumerator() * getDenominater();
        int newDenominator = getDenominater() * f.getDenominater();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction mul(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNumerator() * f.getNumerator();
        int newDenominator = getDenominater() * f.getDenominater();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction div(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNumerator() * f.getDenominater();
        int newDenominator = getDenominater() * f.getNumerator();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction reciprocal(){
        try{
            return new Fraction(getDenominater(), getNumerator()).shorten();
        }catch (DivisionByZeroExeception e){
            throw new RuntimeException(e);
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
