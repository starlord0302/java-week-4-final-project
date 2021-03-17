package character.hero;

import util.*;
import map.*;
import character.GameCharacter;

public class Hero extends GameCharacter {

  private static final char HERO_INITIAL = 'H';
  private static final double BASE_HEALTH = 100.0;
  private static final double INSTANT_KILL = 1000.0;
  private static final double HARD_ATTACK = 10.0;
  private static final double MEDIUM_ATTACK = HARD_ATTACK * (60.0 / 100.0);
  private static final double WEAK_ATTACK = HARD_ATTACK * (30.0 / 100.0);

  public Hero(int level, int field) {
    super(BASE_HEALTH, HARD_ATTACK, new Position(level, field), HERO_INITIAL);
  }

  public void step(int field) {
    super.getPosition().setField(field);
  }

  public void changeLevel(int level) {
    super.getPosition().setLevel(level);
  }

  @Override
  public double attack() {
    int currentDiceRoll = RandomGenerator.diceRoll();

    System.out.println("Dice: " + currentDiceRoll);

    double attackAmount = 0;

    if (currentDiceRoll == 1 || currentDiceRoll == 2) {
      attackAmount = Hero.INSTANT_KILL;
    } else if (currentDiceRoll == 3 || currentDiceRoll == 4) {
      attackAmount = Hero.HARD_ATTACK;
    } else if (currentDiceRoll == 5 || currentDiceRoll == 6) {
      attackAmount = Hero.MEDIUM_ATTACK;
    } else if (currentDiceRoll == 7 || currentDiceRoll == 8) {
      attackAmount = Hero.WEAK_ATTACK;
    }

    return attackAmount;
  }

  public boolean isReadyToFight(Field field) {
    boolean ready = false;

    if (field.getFieldType() == FieldType.MONSTER || field.getFieldType() == FieldType.BOSS) {
      ready = true;
    }

    return ready;
  }
}