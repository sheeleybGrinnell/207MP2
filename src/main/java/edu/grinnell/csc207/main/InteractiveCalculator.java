package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;
import edu.grinnell.csc207.util.BFCalculator;
import java.util.Scanner;
import java.io.PrintWriter;


public class InteractiveCalculator {
  public static void main(String args[]) {
    BFRegisterSet Register  = new BFRegisterSet();
    BFCalculator Calc = new BFCalculator();
    Scanner reader = new Scanner(System.in);
    PrintWriter pen = new PrintWriter(System.out, true);
    while (true) {
      String input = reader.nextLine();
      if (input.contains("STORE")) {
        String[] splitInput = input.split(" ");
        char[] keyArr = splitInput[1].toCharArray();
        char key = keyArr[0]; 
        Register.store(key, Calc.lastVal);
      }
      else if (input.contains("QUIT")) {
        reader.close();
        return;
      } else {
        BigFraction result = new BigFraction(0, 1);
        String[] actionBuffer = input.split(" ");
        for (int i = 0; i < actionBuffer.length; i++) {
          BigFraction firstFraction = null;
          BigFraction secondFraction = null;
          if (actionBuffer[i].compareTo("+") == 0) {
            if ((actionBuffer[i - 1].length() == 1) & ((actionBuffer[i - 1].charAt(0) >= 'a') & (actionBuffer[i - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[i - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[i + 1].length() == 1) & ((actionBuffer[i + 1].charAt(0) >= 'a') & (actionBuffer[i + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[i + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
              } else {
                secondFraction = new BigFraction(actionBuffer[i + 1]);
              }
            } else {
            firstFraction = new BigFraction(actionBuffer[i - 1]);
            secondFraction = new BigFraction(actionBuffer[i + 1]);
            }
            BigFraction tempFraction = firstFraction.add(secondFraction);
            result = result.add(tempFraction);
          } 
          if (actionBuffer[i].compareTo("-") == 0) {
            if ((actionBuffer[i - 1].length() == 1) & ((actionBuffer[i - 1].charAt(0) >= 'a') & (actionBuffer[i - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[i - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[i + 1].length() == 1) & ((actionBuffer[i + 1].charAt(0) >= 'a') & (actionBuffer[i + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[i + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
              } else {
                secondFraction = new BigFraction(actionBuffer[i + 1]);
              }
            } else {
            firstFraction = new BigFraction(actionBuffer[i - 1]);
            secondFraction = new BigFraction(actionBuffer[i + 1]);
            }
            BigFraction tempFraction = firstFraction.subtract(secondFraction);
            result = tempFraction.subtract(result);
          } 
          if (actionBuffer[i].compareTo("*") == 0) {
            if ((actionBuffer[i - 1].length() == 1) & ((actionBuffer[i - 1].charAt(0) >= 'a') & (actionBuffer[i - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[i - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[i + 1].length() == 1) & ((actionBuffer[i + 1].charAt(0) >= 'a') & (actionBuffer[i + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[i + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
              } else {
                secondFraction = new BigFraction(actionBuffer[i + 1]);
              }
            } else {
            firstFraction = new BigFraction(actionBuffer[i - 1]);
            secondFraction = new BigFraction(actionBuffer[i + 1]);
            }
            BigFraction tempFraction = firstFraction.multiply(secondFraction);
            result = result.multiply(tempFraction);
          } 
          if (actionBuffer[i].compareTo("/") == 0) {
            if ((actionBuffer[i - 1].length() == 1) & ((actionBuffer[i - 1].charAt(0) >= 'a') & (actionBuffer[i - 1].charAt(0) <= 'z'))) {
              char[] keyToChar = actionBuffer[i - 1].toCharArray();
              char key = keyToChar[0];
              firstFraction = Register.get(key);
              if ((actionBuffer[i + 1].length() == 1) & ((actionBuffer[i + 1].charAt(0) >= 'a') & (actionBuffer[i + 1].charAt(0) <= 'z'))) {
                char[] secondChar = actionBuffer[i + 1].toCharArray();
                char secondKey = secondChar[0]; 
                secondFraction = Register.get(secondKey);
              } else {
                secondFraction = new BigFraction(actionBuffer[i + 1]);
              }
            } else {
            firstFraction = new BigFraction(actionBuffer[i - 1]);
            secondFraction = new BigFraction(actionBuffer[i + 1]);
            }
            BigFraction tempFraction = firstFraction.divide(secondFraction);
            result = tempFraction.divide(result);
          } 
        }
        Calc.lastVal = result;
        String resultString = result.toString();
        pen.println(resultString);
      }
    }
  }
}
