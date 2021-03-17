package map;

import java.util.ArrayList;
import util.Position;

public class Board {
  private int numberOfLevels;
  private int numberOfFields;
  private ArrayList<Level> board;
  private int currentLevel;

  public Board(int numberOfLevels, int numberOfFields) {
    this.numberOfLevels = numberOfLevels;
    this.numberOfFields = numberOfFields;
    this.currentLevel = 0;
    this.board = createBoard();
  }

  public int getNumberOfLevels() {
    return this.numberOfLevels;
  }

  public int getNumberOfFields() {
    return this.numberOfFields;
  }

  public int getCurrentLevel() {
    return this.currentLevel;
  }

  public void setCurrentLevel(int level) {
    this.currentLevel = level;
  }

  public ArrayList<Level> getBoard() {
    return this.board;
  }

  public ArrayList<Level> createBoard() {
    ArrayList<Level> levels = new ArrayList<>();

    for (int i = 0; i < this.numberOfLevels; i++) {
      levels.add(new Level(this.numberOfFields));
    }

    return levels;
  }

  public void printBoard() {
    for (int i = 0; i < numberOfLevels; i++) {
      this.board.get(i).printLevel(i + 1, new Position(-1, -1));
    }
  }
}