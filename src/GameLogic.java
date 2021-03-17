import java.util.ArrayList;
import java.util.Scanner;

import character.monster.*;
import character.GameCharacter;
import character.hero.Hero;
import map.*;

public class GameLogic {

  private int currentLevel;
  private int currentField;

  public static final double BASE_POTION_AMOUNT = 30.0;

  public GameLogic(int currentLevel, int currentField) {
    this.currentLevel = currentLevel;
    this.currentField = currentField;
  }

  public boolean battle(Hero hero, GameCharacter monster) {
    boolean isHeroAlive = true;

    System.out.println("-----MONSTER FIGHT-----");
    while (hero.getHealthPoint() > 0) {
      hero.fight(monster);
      if (monster.getHealthPoint() > 0) {
        monster.fight(hero);
      } else {
        return isHeroAlive;
      }
    }

    isHeroAlive = false;

    return isHeroAlive;
  }

  public void potionPickUp(Hero hero) {
    System.out.println("-----POTION PICKUP-----");
    double currentHeroHealth = hero.getHealthPoint();
    double newHeroHealth = currentHeroHealth + BASE_POTION_AMOUNT - (currentLevel * 5);
    hero.setHealthPoint(newHeroHealth);
    hero.printGameCharacter();
  }

  public void moveHero(Board board, Hero hero, int step) {
    // CHANGE HERO POSITION
    this.currentField += step;
    hero.step(currentField);

    // SET HERO BACK TO BOSS FIELD
    if (this.currentField >= board.getNumberOfFields() - 1) {
      this.currentField = board.getNumberOfFields() - 1;
      hero.step(currentField);
    }
  }

  public void changeLevel(Board board, Hero hero) {
    if (hero.getPosition().getField() == board.getNumberOfFields() - 1) {
      this.currentLevel += 1;
      this.currentField = GameSetup.START_FIELD;
      board.setCurrentLevel(currentLevel);
      hero.step(currentField);
      hero.changeLevel(currentLevel);
    }
  }

  public void run(Board board, Hero hero, MonsterSwarm monsterSwarm) {
    ArrayList<Level> levels = board.getBoard();

    System.out.println("START");
    Scanner scanner = new Scanner(System.in);

    boolean isHeroAlive = true;
    int numberOfPotionsPicked = 0;
    int numberOfMonstersKilled = 0;

    while (isHeroAlive) {
      System.out.println("\nChoose step:\t 1\t 2\t 3");
      int step = scanner.nextInt();

      // CHANGE LEVEL
      changeLevel(board, hero);

      // MOVING HERO
      moveHero(board, hero, step);

      // BATTLE AND POTION PICK UP
      if (hero.isReadyToFight(levels.get(this.currentLevel).getField(this.currentField))) {
        GameCharacter monster = monsterSwarm.getMonster(this.currentLevel, this.currentField);
        isHeroAlive = battle(hero, monster);
        if (!isHeroAlive) {
          System.out.println("GAME OVER");
          break;
        }
        numberOfMonstersKilled++;
      } else {
        potionPickUp(hero);
        numberOfPotionsPicked++;
      }

      // PRINT LEVEL
      levels.get(this.currentLevel).printLevel(this.currentLevel, hero.getPosition());
    }

    scanner.close();
    System.out.println("TOTAL POTION FOUND: " + numberOfPotionsPicked);
    System.out.println("TOTAL MONSTERS KILLED: " + numberOfMonstersKilled);
  }
}