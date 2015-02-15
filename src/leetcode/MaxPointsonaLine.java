package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.util.Point;

// https://oj.leetcode.com/problems/max-points-on-a-line/
public class MaxPointsonaLine {
  public int maxPoints(Point[] points) {
    int n = points.length;
    int ans = n < 2 ? n : 2;
    for (int i = 0; i < n - 1; i++) {
      Map<List<Integer>, Integer> map = new HashMap<>();
      int t = 0;
      int max = 0;
      for (int j = i + 1; j < n; j++) {
        int x = points[i].x - points[j].x;
        int y = points[i].y - points[j].y;
        if (x == 0 && y == 0) {
          t++;
          continue;
        }
        int g = gcd(x, y);
        List<Integer> pair = new ArrayList<>();
        pair.add(x / g);
        pair.add(y / g);
        if (map.containsKey(pair))
          map.put(pair, map.get(pair) + 1);
        else
          map.put(pair, 1);
        max = Math.max(max, map.get(pair));
      }
      ans = Math.max(ans, max + t + 1);
    }
    return ans;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
