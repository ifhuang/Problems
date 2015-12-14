package other;

public class SubTree {
  public int isSubTree(Tree a, Tree b) {
    if (isSameTree(a, b)) {
      return 1;
    } else if (a == null) {
      return -1;
    } else if (isSubTree(a.left, b) == 1 || isSubTree(a.right, b) == 1) {
      return 1;
    } else {
      return -1;
    }
  }

  private boolean isSameTree(Tree a, Tree b) {
    if (a == null && b == null) {
      return true;
    } else if (a == null || b == null) {
      return false;
    } else if (a.val != b.val) {
      return false;
    } else {
      return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
  }
}


class Tree {
  int val;
  Tree left, right;

  Tree(int val, Tree left, Tree right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
