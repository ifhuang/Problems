package bop;

public class Game2_ChineseChess {
  public void printKings() {
    for (int i = 1; i <= 81; i++)
      if (i / 9 % 3 != i % 9 % 3)
        System.out.printf("A = %d, B = %d\n", i / 9 + 1, i % 9 + 1);
  }

  public static void main(String[] args) {
    Game2_ChineseChess game2 = new Game2_ChineseChess();
    game2.printKings();
  }
}
