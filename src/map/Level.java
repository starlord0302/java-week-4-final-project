package map;

import util.Position;
import util.RandomGenerator;

public class Level {
  private int numberOfFields;
  private int numberOfPotions;
  private int numberOfMonsters;
  private Field[] fields;

  Level(int numberOfFields) {
    this.numberOfFields = numberOfFields;
    this.numberOfPotions = numberOfFields / 2;
    this.numberOfMonsters = this.numberOfPotions - 1;
    this.fields = this.createLevel();
  }

  public int getNumberOfFields() {
    return this.numberOfFields;
  }

  public Field getField(int fieldNumber) {
    return this.fields[fieldNumber];
  }

  public Field[] getFields() {
    return this.fields;
  }

  private void addRandomFields(Field[] fields, int fieldCount, FieldType fieldType) {
    for (int i = 0; i < fieldCount; ++i) {
      boolean isFieldPlaced = false;
      while (!isFieldPlaced) {
        int randomNumber = RandomGenerator.getRandomNumber(0, this.numberOfFields - 1);
        if (fields[randomNumber] == null) {
          fields[randomNumber] = new Field(fieldType);
          isFieldPlaced = true;
        }
      }
    }
  }

  public Field[] createLevel() {
    Field[] fields = new Field[this.numberOfFields];

    fields[this.numberOfFields - 1] = new Field(FieldType.BOSS);

    addRandomFields(fields, this.numberOfPotions, FieldType.POTION);
    addRandomFields(fields, this.numberOfMonsters, FieldType.MONSTER);

    return fields;
  }

  public void printLevel(int level, Position heroPosition) {
    System.out.print(level + ". szint ");
    for (int i = 0; i < this.numberOfFields; i++) {
      if (heroPosition.getField() == i) {
        System.out.print("[H]");
      } else {
        fields[i].printField(true);
      }
    }
    System.out.println();
  }
}