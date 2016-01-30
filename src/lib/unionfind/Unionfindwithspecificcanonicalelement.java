package lib.unionfind;

// Add a method find() to the union-find data type so that find(i) returns the largest element in
// the connected component containing i. The operations, union(), connected(), and find() should all
// take logarithmic time or better.
// For example, if one of the connected components is {1,2,6,9}, then the find() method should
// return 9 for each of the four elements in the connected components because 9 is larger 1, 2, and
// 6.
public class Unionfindwithspecificcanonicalelement {
  private int[] parent;
  private byte[] rank;
  private int[] max;
  private int count;

  public Unionfindwithspecificcanonicalelement(int n) {
    parent = new int[n];
    rank = new byte[n];
    max = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
      max[i] = i;
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

  public int findMax(int i) {
    return max[find(i)];
  }

  public void union(int p, int q) {
    int pId = find(p);
    int qId = find(q);
    if (pId == qId) {
      return;
    }
    if (rank[pId] > rank[qId]) {
      parent[qId] = pId;
      max[pId] = Math.max(max[pId], max[qId]);
    } else if (rank[pId] < rank[qId]) {
      parent[pId] = qId;
      max[qId] = Math.max(max[qId], max[pId]);
    } else {
      parent[qId] = pId;
      rank[pId]++;
      max[pId] = Math.max(max[pId], max[qId]);
    }
    count--;
  }

  public static void main(String[] args) {
    Unionfindwithspecificcanonicalelement q = new Unionfindwithspecificcanonicalelement(4);
    System.out.println(q.findMax(0));
    q.union(0, 1);
    System.out.println(q.findMax(0));
    q.union(1, 2);
    System.out.println(q.findMax(0));
  }
}
