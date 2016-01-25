package lib.unionfind;

/**
 * A union-find data type for weighted quick union.
 * 
 * @author If
 *
 */
public class WeightedQuickUnionUF {
  private int[] parent;
  private int[] size;
  private int count;

  public WeightedQuickUnionUF(int n) {
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
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
    if (size[pId] > size[qId]) {
      parent[qId] = pId;
      size[pId] += size[qId];
    } else {
      parent[pId] = qId;
      size[qId] += size[pId];
    }
    count--;
  }

  public static void main(String[] args) {
    WeightedQuickUnionUF q = new WeightedQuickUnionUF(4);
    q.union(0, 1);
    q.union(1, 2);
    System.out.println(q.connected(0, 2));
    System.out.println(q.connected(0, 3));
    System.out.println(q.count());
  }
}
