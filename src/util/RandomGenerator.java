package util;

import java.util.Random;

public class RandomGenerator {

  public static int diceRoll() {
    Random random = new Random();
    return random.nextInt(11 - 1) + 1;
  }

  public static int getRandomNumber(int lowerBoundary, int upperBoundary) {
    Random random = new Random();
    return random.nextInt(upperBoundary - lowerBoundary) + lowerBoundary;
  }
}