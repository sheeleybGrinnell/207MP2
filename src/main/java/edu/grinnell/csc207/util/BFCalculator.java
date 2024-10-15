package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BFCalculator {
  //Fields
  public BigFraction lastVal = new BigFraction();

  //No Constructors needed

  //Methods
  public BigFraction get() {
    return lastVal;
  } /* get() */

  public void add(BigFraction val) {
    this.lastVal = val.add(lastVal);
  } /* add() */

  public void subtract(BigFraction val) {
    this.lastVal = lastVal.subtract(val);
  } /* subtract() */

  public void multiply(BigFraction val) {
    this.lastVal = val.multiply(lastVal);
  } /* multiply() */

  public void divide(BigFraction val) {
    this.lastVal = lastVal.divide(val);
  } /* divide() */

  public void clear() {
    this.lastVal.num = BigInteger.valueOf(0);
    this.lastVal.denom = BigInteger.valueOf(1);
  } /* clear() */
} /* BFCalculator */
