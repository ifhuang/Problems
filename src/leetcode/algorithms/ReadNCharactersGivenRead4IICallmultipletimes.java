package leetcode.algorithms;

import leetcode.util.Reader4;

// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
// The API: int read4(char *buf) reads 4 characters at a time from a file.
// The return value is the actual number of characters read. For example, it returns 3 if there is
// only 3 characters left in the file.
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters
// from the file.
// Note:
// The read function may be called multiple times.
public class ReadNCharactersGivenRead4IICallmultipletimes extends Reader4 {
  private char[] c;
  private int len;
  private int j;

  public ReadNCharactersGivenRead4IICallmultipletimes() {
    c = new char[4];
    len = 4;
    j = 4;
  }

  public int read(char[] buf, int n) {
    int i = 0;
    while (i < n) {
      if (len == j) {
        len = read4(c);
        j = 0;
      }
      if (len == j) {
        break;
      }
      buf[i++] = c[j++];
    }
    return i;
  }
}
