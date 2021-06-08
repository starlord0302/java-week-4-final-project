package character;

import util.Position;
import util.TestArray;

public abstract class GameCharacter {
  private double healthPoint;
  private double attackPoint;
  private Position position;
  private char initial;

  public GameCharacter(double healthPoint, double attackPoint, Position position, char initial) {
    this.healthPoint = healthPoint;
    this.attackPoint = attackPoint;
    this.position = position;
    this.initial = initial;
  }

  public double getHealthPoint() {
    return this.healthPoint;
  }

  public void setHealthPoint(double healthPoint) {
    this.healthPoint = healthPoint;
  }

  public double getattackPoint() {
    return this.attackPoint;
  }

  public Position getPosition() {
    return this.position;
  }

  public char getInitial() {
    return this.initial;
  }

  public void printGameCharacter() {
    if(this.healthPoint < 0) {
      System.out.println(this.initial + " = " + "{ a: " + this.attackPoint + ", h: 0"  + ", p: "
        + this.position.positionString() + " }");
    } else {
      System.out.println(this.initial + " = " + "{ a: " + this.attackPoint + ", h: " + this.healthPoint + ", p: "
        + this.position.positionString() + " }");
    }
  }

  public void fight(GameCharacter GameCharacter) {
    try {
      Thread.sleep(1000); // 1000 milliseconds is one second.
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
    double damage = this.attack();
    TestArray.counter = 0;
    System.out.println(this.initial + " attack:  " + damage);
    double newHeroHealth = GameCharacter.getHealthPoint() - damage;
    GameCharacter.setHealthPoint(newHeroHealth);
    GameCharacter.printGameCharacter();
    if (GameCharacter.getHealthPoint() <= 0) {
      System.out.println("-----" + GameCharacter.getInitial() + " DEAD-----");
    }
  }

  public abstract double attack();
}
