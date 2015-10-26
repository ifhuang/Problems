package leetcode.algorithms;

import leetcode.util.Reader4;

// https://leetcode.com/problems/read-n-characters-given-read4/
// The API: int read4(char *buf) reads 4 characters at a time from a file.
// The return value is the actual number of characters read. For example, it returns 3 if there is
// only 3 characters left in the file.
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters
// from the file.
// Note:
// The read function will only be called once for each test case.
public class ReadNCharactersGivenRead4 extends Reader4 {

  public int read(char[] buf, int n) {
    int i = 0;
    char[] c = new char[4];
    int len = 0;
    int j = 0;
    while (i < n) {
      if (i % 4 == 0) {
        len = read4(c);
      }
      j = i % 4;
      if (j >= len) {
        break;
      }
      buf[i] = c[j];
      i++;
    }
    return i;
  }

}
