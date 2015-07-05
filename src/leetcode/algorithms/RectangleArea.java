package leetcode.algorithms;

public class RectangleArea {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int s1 = (C - A) * (D - B);
    int s2 = (G - E) * (H - F);
    int x1 = Math.max(A, E);
    int y1 = Math.max(B, F);
    int x2 = Math.min(C, G);
    int y2 = Math.min(D, H);
    int t = 0;
    if (x2 > x1 && y2 > y1)
      t = (x2 - x1) * (y2 - y1);
    return s1 + s2 - t;
  }
}
