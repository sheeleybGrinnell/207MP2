package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BigFraction {
  
//Fields

  public BigInteger num;

  public BigInteger denom;

//Constructors

  public BigFraction(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);
    num = numerator.divide(gcd);
    denom = denominator.divide(gcd);
  }

  public BigFraction(int numerator, int denominator) {
    num = BigInteger.valueOf(numerator);
    denom = BigInteger.valueOf(denominator);
    BigInteger gcd = num.gcd(denom);
    num = num.divide(gcd);
    denom = denom.divide(gcd);
  }

  public BigFraction(String str) {
    String[] numDenomArr = str.split("/", 0);
    num = new BigInteger(numDenomArr[0]);
    denom = new BigInteger(numDenomArr[1]);
    BigInteger gcd = num.gcd(denom);
    denom = denom.divide(gcd);
  }

//Methods

  public double doubleValue() {
    return num.doubleValue() / this.denom.doubleValue();
  }

  public BigFraction add(BigFraction addend) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(addend.denom);

    resultNum = (this.num.multiply(addend.denom)).add(addend.num.multiply(denom));

    return new BigFraction(resultNum, resultDenom);
  }

  public BigFraction subtract(BigFraction subend) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = denom.multiply(subend.denom);
    resultNum = (num.multiply(subend.denom)).subtract(subend.num.multiply(denom));

    return new BigFraction(resultNum, resultDenom);
  }

  public BigFraction multiply(BigFraction x) {
    return new BigFraction(num.multiply(x.num), denom.multiply(x.num));
  }

  public BigFraction divide(BigFraction x) {
    return new BigFraction(num.multiply(x.denom), denom.multiply(x.num));
  }

  public BigFraction fractional() {
    return new BigFraction(num.mod(denom), denom);
  }

  public BigInteger denominator() {
    return this.denom;
  }

  public BigInteger numerator() {
    return this.num;
  }

  public String toString() {
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    }
    return this.num + "/" + this.denom;
  }
}
