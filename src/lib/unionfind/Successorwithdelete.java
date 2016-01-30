package lib.unionfind;

// Given a set of N integers S={0,1,...,N-1} and a sequence of requests of the following form:
// Remove x from S
// Find the successor of x: the smallest y in S such that y¡Ýx.
// design a data type so that all operations (except construction) should take logarithmic time or
// better.
public class Successorwithdelete {

  private UF uf;
  private int N;

  public Successorwithdelete(int N) {
    uf = new UF(N + 1);
    uf.union(N, N - 1);
    this.N = N;
  }

  public void remove(int x) {
    uf.union(x + 1, x);
  }

  public int successor(int x) {
    int ans = uf.find(x + 1);
    return ans == N ? -1 : ans;
  }

  public static void main(String[] args) {
    Successorwithdelete s = new Successorwithdelete(4);
    System.out.println(s.successor(1));
    s.remove(1);
    System.out.println(s.successor(0));
    System.out.println(s.successor(1));
    System.out.println(s.successor(3));
    s.remove(2);
    s.remove(3);
    System.out.println(s.successor(0));
    System.out.println(s.successor(1));
    System.out.println(s.successor(3));
  }

}
