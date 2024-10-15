package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;
import java.io.PrintWriter;

/**
 * A calculator that makes use of single-line commands and returns a calculated result at the end.
 * @author Benjamin Sheeley
 */

public class QuickCalculator {
  /**
   * Main method that takes in arguments and gives a calculated result using lastVal.
   * @param args
   *  valid BigFraction inputs.
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BFRegisterSet register = new BFRegisterSet();
    BFCalculator calc = new BFCalculator();
    for (int i = 0; i < args.length; i++) {
      if (args[i].contains("STORE")) {
        String[] splitInput = args[i].split(" ");
        char[] keyArr = splitInput[1].toCharArray();
        char key = keyArr[0];
        register.store(key, calc.get());
      } /* if block, check for store */ else {
        BigFraction result = new BigFraction(0, 1);
        String[] actionBuffer = args[i].split(" ");
        for (int j = 0; j < actionBuffer.length; j++) {
          BigFraction firstFraction = null;
          BigFraction secondFraction = null;
          if (actionBuffer[j].compareTo("+") == 0) {
            if ((actionBuffer[j - 1].length() == 1)
                & ((actionBuffer[j - 1].charAt(0) >= 'a')
                 & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = register.get(key);
              if ((actionBuffer[j + 1].length() == 1)
                  & ((actionBuffer[j + 1].charAt(0) >= 'a')
                   & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0];
                secondFraction = register.get(secondKey);
              } /* if block */ else {
                secondFraction = new BigFraction(actionBuffer[j + 1]);
              } /* else block */
            } /* if block */ else {
              firstFraction = new BigFraction(actionBuffer[j - 1]);
              secondFraction = new BigFraction(actionBuffer[j + 1]);
            } /* else block */
            BigFraction tempFraction = firstFraction.add(secondFraction);
            result = result.add(tempFraction);
          } /* if block, addition */
          if (actionBuffer[j].compareTo("-") == 0) {
            if ((actionBuffer[j - 1].length() == 1)
                & ((actionBuffer[j - 1].charAt(0) >= 'a')
                 & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = register.get(key);
              if ((actionBuffer[j + 1].length() == 1)
                  & ((actionBuffer[j + 1].charAt(0) >= 'a')
                   & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0];
                secondFraction = register.get(secondKey);
              } /* if block */ else {
                secondFraction = new BigFraction(actionBuffer[j + 1]);
              } /* else block */
            } /* if block */ else {
              firstFraction = new BigFraction(actionBuffer[j - 1]);
              secondFraction = new BigFraction(actionBuffer[j + 1]);
            } /* else block */
            BigFraction tempFraction = firstFraction.subtract(secondFraction);
            result = result.subtract(tempFraction);
          } /* if block, subtraction */
          if (actionBuffer[j].compareTo("*") == 0) {
            if ((actionBuffer[j - 1].length() == 1)
                & ((actionBuffer[j - 1].charAt(0) >= 'a')
                 & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = register.get(key);
              if ((actionBuffer[j + 1].length() == 1)
                  & ((actionBuffer[j + 1].charAt(0) >= 'a')
                   & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0];
                secondFraction = register.get(secondKey);
              } /* if block */ else {
                secondFraction = new BigFraction(actionBuffer[j + 1]);
              } /* else block */
            } /* if block */ else {
              firstFraction = new BigFraction(actionBuffer[j - 1]);
              secondFraction = new BigFraction(actionBuffer[j + 1]);
            } /* else block */
            BigFraction tempFraction = firstFraction.multiply(secondFraction);
            result = result.multiply(tempFraction);
          } /* if block, multiplication */
          if (actionBuffer[j].compareTo("/") == 0) {
            if ((actionBuffer[j - 1].length() == 1)
                & ((actionBuffer[j - 1].charAt(0) >= 'a')
                 & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = register.get(key);
              if ((actionBuffer[j + 1].length() == 1)
                  & ((actionBuffer[j + 1].charAt(0) >= 'a')
                   & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0];
                secondFraction = register.get(secondKey);
              } /* if block */ else {
                secondFraction = new BigFraction(actionBuffer[j + 1]);
              } /* else block */
            } /* if block */ else {
              firstFraction = new BigFraction(actionBuffer[j - 1]);
              secondFraction = new BigFraction(actionBuffer[j + 1]);
            } /* else block */
            BigFraction tempFraction = firstFraction.divide(secondFraction);
            result = result.divide(tempFraction);
          } /* if block, division */
        } /* for block */
        String resultString = result.toString();
        pen.println(resultString);
      } /* else block, evaluation */
    } /* for block over each argument */
  } /* main(args) */
} /* QuickCalculator */
