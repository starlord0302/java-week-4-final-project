package character.monster;

import util.*;
import character.GameCharacter;

public class Monster extends GameCharacter {
  public static final double BASE_MONSTER_ATTACK = 5.0;
  public static final double BASE_MONSTER_HEALTH = 10.0;
  public static final double BASE_BOSS_ATTACK = 10.0;
  public static final double BASE_BOSS_HEALTH = 20.0;

  public Monster(double healthPoint, double attackPoint, Position position, char initial) {
    super(healthPoint, attackPoint, position, initial);
  }

  public double getHardAttack() {
    return super.getattackPoint();
  }

  public double getMediumAttack() {
    return getHardAttack() * (60.0 / 100.0);
  }

  public double getWeakAttack() {
    return getHardAttack() * (30.0 / 100.0);
  }

  @Override
  public double attack() {
    //int currentDiceRoll = RandomGenerator.diceRoll();
    int currentDiceRoll = TestArray.getDiceRoll();
    System.out.println("Dice: " + currentDiceRoll);

    double attackAmount = 0;

    if (currentDiceRoll == 1 || currentDiceRoll == 2) {
      attackAmount = this.getHardAttack();
    } else if (currentDiceRoll == 3 || currentDiceRoll == 4 || currentDiceRoll == 5) {
      attackAmount = this.getMediumAttack();
    } else if (currentDiceRoll == 6 || currentDiceRoll == 7 || currentDiceRoll == 8) {
      attackAmount = this.getWeakAttack();
    }

    return attackAmount;
  }
}