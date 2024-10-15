package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BigFraction {
  
//Fields

  public BigInteger num;

  public BigInteger denom;

//Constructors

  public BigFraction() {
    num = BigInteger.valueOf(0);
    denom = BigInteger.valueOf(1);
  } /* BigFraction() */

  public BigFraction(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);
    num = numerator.divide(gcd);
    denom = denominator.divide(gcd);
  } /* BigFraction(numerator, denominator) */

  public BigFraction(int numerator, int denominator) {
    num = BigInteger.valueOf(numerator);
    denom = BigInteger.valueOf(denominator);
    BigInteger gcd = num.gcd(denom);
    num = num.divide(gcd);
    denom = denom.divide(gcd);
  } /* BigFraction(numerator, denominator) */

  public BigFraction(String str) {
    if (str.contains("/")) {
      String[] numDenomArr = str.split("/", 0);
      num = new BigInteger(numDenomArr[0]);
      denom = new BigInteger(numDenomArr[1]);
      BigInteger gcd = num.gcd(denom);
      num = num.divide(gcd);
      denom = denom.divide(gcd);
    } /* if our fraction contains a denominator split and set it to denominator */ else {
      num = new BigInteger(str);
      denom = BigInteger.valueOf(1);
    } /* else block */
  } /* BigFraction(String) */

//Methods

  public double doubleValue() {
    return num.doubleValue() / this.denom.doubleValue();
  } /* double() */

  public BigFraction add(BigFraction addend) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(addend.denom);

    resultNum = (this.num.multiply(addend.denom)).add(addend.num.multiply(denom));

    return new BigFraction(resultNum, resultDenom);
  } /* add() */

  public BigFraction subtract(BigFraction subend) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(subend.denom);
    resultNum = (this.num.multiply(subend.denom)).subtract(subend.num.multiply(this.denom));

    return new BigFraction(resultNum, resultDenom);
  } /* subtract() */

  public BigFraction multiply(BigFraction x) {
    return new BigFraction(num.multiply(x.num), denom.multiply(x.denom));
  } /* multiply() */

  public BigFraction divide(BigFraction x) {
    return new BigFraction(this.num.multiply(x.denom), this.denom.multiply(x.num));
  } /* divide() */

  public BigFraction fractional() {
    return new BigFraction(num.mod(denom), denom);
  } /* fractional() */

  public BigInteger denominator() {
    return this.denom;
  } /* denominator() */

  public BigInteger numerator() {
    return this.num;
  } /* numerator() */

  public String toString() {
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } /* do we return zero? */ else if (this.num.mod(this.denom) == BigInteger.ZERO) {
      return this.num.divide(this.denom).toString();
    } /* do we return whole number */ else {
    return this.num + "/" + this.denom;
    } // else block
  } //toString()
} //BigFraction
