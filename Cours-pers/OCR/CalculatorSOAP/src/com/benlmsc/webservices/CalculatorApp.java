package com.benlmsc.webservices;

public class CalculatorApp {
    private Double number1;
    private Double number2;

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public Double add() {
        return Double.sum(getNumber1(), getNumber2());
    }

    public double div() {
        return getNumber1() / getNumber2();
    }

    private boolean exist() {
        return (getNumber1() != null && getNumber2() != null);
    }
}
