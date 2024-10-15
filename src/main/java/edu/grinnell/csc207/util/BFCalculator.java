package edu.grinnell.csc207.util;


/**
 * This is a calculator class which performs calculations over BigFraction types.
 * Mainly for use in our Interactive and Quick Calculators.
 * @author Benjamin Sheeley
 */

public class BFCalculator {
  // Fields

  /**
   * lastVal stores the most recently used value in the calculator.
   */
  private BigFraction lastVal = new BigFraction();

  // No Constructors needed

  // Methods

  /**
   * Gets the last value put into the calculator.
   * @return BigFraction under the field lastVal.
   */
  public BigFraction get() {
    return lastVal;
  } /* get() */

  /**
   * adds two Big Fractions together.
   * @param val
   *  the value to add to lastVal.
   */
  public void add(BigFraction val) {
    this.lastVal = val.add(lastVal);
  } /* add() */

  /**
   * subtracts two BigFractions.
   * @param val
   *  the value to subtract from lastVal.
   */
  public void subtract(BigFraction val) {
    this.lastVal = lastVal.subtract(val);
  } /* subtract() */

  /**
   * multiplies two BigFractions.
   * @param val
   *  the value to multiply lastVal by.
   */
  public void multiply(BigFraction val) {
    this.lastVal = val.multiply(lastVal);
  } /* multiply() */

  /**
   * divides two BigFractions.
   * @param val
   *  the value to divide lastVal by.
   */
  public void divide(BigFraction val) {
    this.lastVal = lastVal.divide(val);
  } /* divide() */

  /**
   * clears lastVal, returning it to its base state of 0.
   */
  public void clear() {
    lastVal = new BigFraction(0, 1);
  } /* clear() */
} /* BFCalculator */
