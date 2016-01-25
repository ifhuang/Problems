package lib.unionfind;

/**
 * A union-find data type for quick find.
 * 
 * @author If
 *
 */
public class QuickFindUF {
  private int n;
  private int[] id;
  private int count;

  public QuickFindUF(int n) {
    this.n = n;
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
    count = n;
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pId = id[p];
    int qId = id[q];
    if (pId == qId) {
      return;
    }
    for (int i = 0; i < n; i++) {
      if (id[i] == pId) {
        id[i] = qId;
      }
    }
    count--;
  }

  public static void main(String[] args) {
    QuickFindUF q = new QuickFindUF(4);
    q.union(0, 1);
    q.union(1, 2);
    System.out.println(q.connected(0, 2));
    System.out.println(q.connected(0, 3));
    System.out.println(q.count());
  }
}
