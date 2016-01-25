package lib.unionfind;

/**
 * A union-find data type for quick union.
 * 
 * @author If
 *
 */
public class QuickUnionUF {
  private int[] parent;
  private int count;

  public QuickUnionUF(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    count = n;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    while (p != parent[p]) {
      p = parent[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId == qId) {
      return;
    }
    parent[pId] = qId;
    count--;
  }

  public static void main(String[] args) {
    QuickUnionUF q = new QuickUnionUF(4);
    q.union(0, 1);
    q.union(1, 2);
    System.out.println(q.connected(0, 2));
    System.out.println(q.connected(0, 3));
    System.out.println(q.count());
  }
}
