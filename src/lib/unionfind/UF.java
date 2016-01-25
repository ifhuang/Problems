package lib.unionfind;

/**
 * A union-find data type for weighted quick union with path compression.
 * 
 * @author If
 *
 */
public class UF {
  private int[] parent;
  private byte[] rank;
  private int count;

  public UF(int n) {
    parent = new int[n];
    rank = new byte[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
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
      parent[p] = parent[parent[p]];
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
    if (rank[pId] > rank[qId]) {
      parent[qId] = pId;
    } else if (rank[pId] < rank[qId]) {
      parent[pId] = qId;
    } else {
      parent[qId] = pId;
      rank[pId]++;
    }
    count--;
  }

  public static void main(String[] args) {
    UF q = new UF(4);
    q.union(0, 1);
    q.union(1, 2);
    System.out.println(q.connected(0, 2));
    System.out.println(q.connected(0, 3));
    System.out.println(q.count());
  }
}
