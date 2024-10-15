package edu.grinnell.csc207.util;

/**
 * A set that helps keep track of fractions to make multiple calculations over.
 * @author Benjamin Sheeley
 */

public class BFRegisterSet {
  // Fields

  /**
   * stores our fractions to be looked at by Calculators.
   */
  private BigFraction[] fractionStorage = new BigFraction[26];

  // Constructors
  /**
   * Populates our array so it isn't a null array.
   */
  public BFRegisterSet() {
    for (int i = 0; i <= 25; i++) {
      fractionStorage[i] = new BigFraction(0, 1);
    } /* for block */
  } /* BFRegisterSet() */

  // Methods
  /**
   * Stores given value in the array to be looked up later.
   * @param register
   *  the key to be paired to the value.
   * @param val
   *  the value to be paired to the key.
   */
  public void store(char register, BigFraction val) {
    for (int i = 0; i <= 25; i++) {
      if (((int) register - 97) == i) {
        fractionStorage[i] = new BigFraction(val.numerator(), val.denominator());
        return;
      } /* check if register is in valid range */
    } /* for block */
    System.err.println("The provided register is out of the valid range. Use a lowercase letter");
  } /* store(register, val) */

  /**
   * gets the value based on the register given.
   * @param register
   *  the key used to find the value paired to the key.
   * @return A BigFraction paired the Register.
   */
  public BigFraction get(char register) {
    for (int i = 0; i <= 25; i++) {
      if (((int) register - 97) == i) {
        return fractionStorage[i];
      } /* check for lowercase letter */
    } /* for block */
    System.err.println("The provided register is out of the valid range. Use a lowercase letter");
    return null;
  } /* get(Register) */
} /* BFRegisterSet */
