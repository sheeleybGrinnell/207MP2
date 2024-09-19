package edu.grinnell.csc207.util;

import java.math.BigInteger;

public class BFRegisterSet {
 //Fields

  public BigFraction[] fractionStorage = new BigFraction[26];

//Constructors
  public BFRegisterSet() {
    for (int i = 0; i <= 25; i++) {
      fractionStorage[i].num = null;
      fractionStorage[i].denom = BigInteger.valueOf(1); 
    }
  }


//Methods
  public void store(char register, BigFraction val){
    for (int i = 0; i <= 25; i++) {
      if (((int) register - 97) == i) {
        fractionStorage[i].num = val.num;
        fractionStorage[i].denom = val.denom;
        return;
      }
    }
    System.err.println("The provided register is out of the valid range. Please use a lowercase letter");
  }

  public BigFraction get(char Register) {
    for (int i = 0; i <= 25; i++) {
      if (((int) Register - 97) == i) {
        return fractionStorage[i];
      }
    }
    System.err.println("The provided register is out of the valid range. Please use a lowercase letter");
    return null;
  }
}
