package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BFCalculator {
  //Fields
  public BigFraction lastVal;

  //No Constructors needed

  //Methods
  public void add(BigFraction val) {
    val.add(lastVal);
    this.lastVal = val;
  }

  public void subtract(BigFraction val) {
    val.subtract(lastVal);
    this.lastVal = val;
  }

  public void multiply(BigFraction val) {
    val.multiply(lastVal);
    this.lastVal = val;
  }

  public void divide(BigFraction val) {
    val.divide(lastVal);
    this.lastVal = val;
  }

  public void clear() {
    this.lastVal.num = BigInteger.valueOf(0);
    this.lastVal.denom = BigInteger.valueOf(1);
  }
}
