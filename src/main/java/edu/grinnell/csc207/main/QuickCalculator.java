package edu.grinnell.csc207.main;

import java.lang.String;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;
import java.io.PrintWriter;

public class QuickCalculator {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    BFRegisterSet Register = new BFRegisterSet();
    BFCalculator Calc = new BFCalculator();
    for (int i = 0; i < args.length; i++) {
      if (args[i].contains("STORE")) {
        String[] splitInput = args[i].split(" ");
        char[] keyArr = splitInput[1].toCharArray();
        char key = keyArr[0]; 
        Register.store(key, Calc.lastVal);
      } /* if block, check for store */ else {
        BigFraction result = new BigFraction(0, 1);
        String[] actionBuffer = args[i].split(" ");
        for (int j = 0; j < actionBuffer.length; j++) {
          BigFraction firstFraction = null;
          BigFraction secondFraction = null;
          if (actionBuffer[j].compareTo("+") == 0) {
            if ((actionBuffer[j - 1].length() == 1) & ((actionBuffer[j - 1].charAt(0) >= 'a') & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[j + 1].length() == 1) & ((actionBuffer[j + 1].charAt(0) >= 'a') & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
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
            if ((actionBuffer[j - 1].length() == 1) & ((actionBuffer[j - 1].charAt(0) >= 'a') & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[j + 1].length() == 1) & ((actionBuffer[j + 1].charAt(0) >= 'a') & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
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
            if ((actionBuffer[j - 1].length() == 1) & ((actionBuffer[j - 1].charAt(0) >= 'a') & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[j + 1].length() == 1) & ((actionBuffer[j + 1].charAt(0) >= 'a') & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
              } /* if block */else {
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
            if ((actionBuffer[j - 1].length() == 1) & ((actionBuffer[j - 1].charAt(0) >= 'a') & (actionBuffer[j - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[j - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[j + 1].length() == 1) & ((actionBuffer[j + 1].charAt(0) >= 'a') & (actionBuffer[j + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[j + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
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
        Calc.lastVal = result;
        String resultString = result.toString();
        pen.println(resultString);
      } /* else block, evaluation */
    } /* for block over each argument */
  } /* main(args) */
} /* QuickCalculator */
