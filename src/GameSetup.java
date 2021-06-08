import character.hero.Hero;
import character.monster.MonsterSwarm;
import map.Board;

public class GameSetup {

  private Board board;
  private Hero hero;
  private MonsterSwarm monsterSwarm;
  private GameLogic gameLogic;

  public static final int START_LEVEL = 0;
  public static final int START_FIELD = -1;

  public GameSetup(int numberOfLevels, int numberOfFields) {
    this.board = new Board(numberOfLevels, numberOfFields);
    this.monsterSwarm = new MonsterSwarm(board);
    this.hero = new Hero(START_LEVEL, START_FIELD);
    this.gameLogic = new GameLogic(START_LEVEL, START_FIELD);
    board.printBoard();
  }

  public GameSetup(char[][] boardSetup) {
    this.board = new Board(boardSetup);
    this.monsterSwarm = new MonsterSwarm(board);
    this.hero = new Hero(START_LEVEL, START_FIELD);
    this.gameLogic = new GameLogic(START_LEVEL, START_FIELD);
    board.printBoard();
  }

  public void start() {
    this.gameLogic.run(this.board, this.hero, this.monsterSwarm);
  }

}