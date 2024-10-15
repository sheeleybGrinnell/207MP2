package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * A class that makes use of BigInteger to build a fraction class with numerator and denominator.
 * @author Benjamin Sheeley
 */

public class BigFraction {

  // Fields

  /**
   * BigInteger Numerator of our Fraction.
   */
  private BigInteger num;


  /**
   * BigInteger Denominator of our Fraction.
   */
  private BigInteger denom;

  // Constructors

  /**
   * Initializes any BigFraction with no parameters to 0.
   */
  public BigFraction() {
    num = BigInteger.valueOf(0);
    denom = BigInteger.valueOf(1);
  } /* BigFraction() */

  /**
   * Constructs a BigFraction with a BigInteger numerator and denominator.
   * @param numerator
   *  the numerator to be used in the fraction.
   * @param denominator
   *  the denominator to be used in the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = numerator.gcd(denominator);
    num = numerator.divide(gcd);
    denom = denominator.divide(gcd);
  } /* BigFraction(numerator, denominator) */

  /**
   * Constructs a BigFraction with an int numerator and denominator.
   * @param numerator
   *  the numerator to be used in the fraction.
   * @param denominator
   *  the denominator to be used in the fraction.
   */
  public BigFraction(int numerator, int denominator) {
    num = BigInteger.valueOf(numerator);
    denom = BigInteger.valueOf(denominator);
    BigInteger gcd = num.gcd(denom);
    num = num.divide(gcd);
    denom = denom.divide(gcd);
  } /* BigFraction(numerator, denominator) */

  /**
   * Constructs a BigFraction using a string input.
   * @param str
   *  The string to be turned into a BigFraction.
   */
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

  // Methods

  /**
   * Turns any BigFraction into a double.
   * @return a fraction represented as a double.
   */
  public double doubleValue() {
    return num.doubleValue() / this.denom.doubleValue();
  } /* double() */

  /**
   * Adds two BigFractions together.
   * @param addend
   *  the BigFraction to be added to the object.
   * @return the combined reduced BigFractions.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(addend.denom);

    resultNum = (this.num.multiply(addend.denom)).add(addend.num.multiply(denom));

    return new BigFraction(resultNum, resultDenom);
  } /* add() */

  /**
   * subtracts one BigFraction from another.
   * @param subend
   *  the BigFraction to subtract from the object.
   * @return the reduced BigFraction.
   */
  public BigFraction subtract(BigFraction subend) {
    BigInteger resultNum;
    BigInteger resultDenom;

    resultDenom = this.denom.multiply(subend.denom);
    resultNum = (this.num.multiply(subend.denom)).subtract(subend.num.multiply(this.denom));

    return new BigFraction(resultNum, resultDenom);
  } /* subtract() */

  /**
   * Multiplies two BigFraction objects.
   * @param x
   *  The BigFraction to multiply by.
   * @return the multiplied reduced BigFraction.
   */
  public BigFraction multiply(BigFraction x) {
    return new BigFraction(num.multiply(x.num), denom.multiply(x.denom));
  } /* multiply() */

  /**
   * Divides two BigFraction objects.
   * @param x
   *  The BigFraction to divide by.
   * @return the divided reduced BigFraction.
   */
  public BigFraction divide(BigFraction x) {
    return new BigFraction(this.num.multiply(x.denom), this.denom.multiply(x.num));
  } /* divide() */

  /**
   * Gets the fractional component of the BigFraction object.
   * @return reduced fraction.
   */
  public BigFraction fractional() {
    return new BigFraction(num.mod(denom), denom);
  } /* fractional() */

  /**
   * Gets the denominator of the BigFraction object.
   * @return the denominator of the BigFraction object.
   */
  public BigInteger denominator() {
    return this.denom;
  } /* denominator() */

  /**
   * Gets the numerator of the BigFraction object.
   * @return the numerator of the BigFraction object.
   */
  public BigInteger numerator() {
    return this.num;
  } /* numerator() */

  /**
   * Converts the BigFraction objects to a String.
   * @return the BigFraction as a String.
   */
  public String toString() {
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } /* do we return zero? */ else if (this.num.mod(this.denom) == BigInteger.ZERO) {
      return this.num.divide(this.denom).toString();
    } /* do we return whole number */ else {
      return this.num + "/" + this.denom;
    } // else block
  } // toString()
} // BigFraction
