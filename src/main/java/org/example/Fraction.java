package org.example;

public class Fraction {

    private int nominator; //zaehler
    private int denominater; //nenner


    public Fraction(int nominator, int denominater) throws DivisionByZeroExeception {
        setNominator(nominator);
        setDenominater(denominater);
    }

    public int getNominator() {
        return nominator;
    }

    public void setNominator(int nominator) {
        this.nominator = nominator;
    }

    public int getDenominater() {
        return denominater;
    }

    public void setDenominater(int denominater) throws DivisionByZeroExeception {
        if (denominater == 0) throw new DivisionByZeroExeception();
        this.denominater = denominater;

    }

    public Fraction shorten() {
        int gcd = gcd(getNominator(), getDenominater());
        try {
            return new Fraction(getNominator() / gcd, getDenominater() / gcd);
        }catch (DivisionByZeroExeception e){
            throw new RuntimeException();
        }
    }
    public Fraction add(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNominator() * f.getDenominater() + f.getNominator() * getDenominater();
        int newDenominator = getDenominater() * f.getDenominater();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction sub(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNominator() * f.getDenominater() - f.getNominator() * getDenominater();
        int newDenominator = getDenominater() * f.getDenominater();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction mul(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNominator() * f.getNominator();
        int newDenominator = getDenominater() * f.getDenominater();
        return new Fraction(newNominator, newDenominator);
    }

    public Fraction div(Fraction f) throws DivisionByZeroExeception {
        int newNominator = getNominator() * f.getDenominater();
        int newDenominator = getDenominater() * f.getNominator();
        return new Fraction(newNominator, newDenominator);
    }

    private int gcd(int a, int b) {
        if (b == 0)        return gcd(b, a % b);
        return a;
    }
}
