class App {
  private static final int LEVELS = 5;
  private static final int FIELDS = 10;
  private static final char[][] BOARD = {
    {'M', 'M', 'P', 'P', 'M', 'P', 'M', 'P', 'P', 'B'},
    {'P', 'M', 'P', 'M', 'M', 'P', 'P', 'M', 'P', 'B'},
    {'M', 'P', 'P', 'M', 'M', 'M', 'P', 'P', 'P', 'B'}
  };

  public static void main(String[] args) {
    //new GameSetup(LEVELS, FIELDS).start();
    new GameSetup(BOARD).start();
  }
}