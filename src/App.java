class App {
  private static final int LEVELS = 5;
  private static final int FIELDS = 10;

  public static void main(String[] args) {
    new GameSetup(LEVELS, FIELDS).start();
  }
}