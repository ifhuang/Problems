package lib.unionfind;

// Given a social network containing N members and a log file containing M timestamps at which times
// pairs of members formed friendships, design an algorithm to determine the earliest time at which
// all members are connected (i.e., every member is a friend of a friend of a friend ... of a
// friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence
// relation. The running time of your algorithm should be MlogN or better and use extra space
// proportional to N.
public class Socialnetworkconnectivity {

  public int solve(int N, int M, int[][] log) {
    if (N == 1) {
      return 0;
    }
    UF uf = new UF(N);
    for (int i = 0; i < M; i++) {
      uf.union(log[i][0], log[i][1]);
      if (uf.count() == 1) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Socialnetworkconnectivity s = new Socialnetworkconnectivity();
    System.out.println(s.solve(1, 0, null));
    int[][] log1 = {{0, 1}};
    System.out.println(s.solve(2, 1, log1));
    int[][] log2 = { {0, 1}, {1, 2}, {2, 3}};
    System.out.println(s.solve(4, 3, log2));
    int[][] log3 = { {0, 1}, {1, 2}};
    System.out.println(s.solve(4, 2, log3));
  }

}
