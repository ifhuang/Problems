package leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays
{
	public double findMedianSortedArrays(int A[], int B[])
	{
		if ((A == null || A.length == 0) && (B == null || B.length == 0))
		{
			return Double.NaN;
		}
		if (A == null || A.length == 0)
		{
			return findMedianSortedArray(B);
		}
		else if (B == null || B.length == 0)
		{
			return findMedianSortedArray(A);
		}
		else if (A.length == 1)
		{
			return findMedianSortedArrays1(A, B);
		}
		else if (B.length == 1)
		{
			return findMedianSortedArrays1(B, A);
		}
		else if (A.length == 2)
		{
			return findMedianSortedArrays2(A, B);
		}
		else if (B.length == 2)
		{
			return findMedianSortedArrays2(B, A);
		}
		else
		{
			int m = A.length;
			int n = B.length;
			if (A[m / 2] >= B[n / 2])
			{
				int discard = Math.min(m - 1 - m / 2, n / 2);
				if (n % 2 == 0)
				{
					discard = Math.min(m - 1 - m / 2, n / 2 - 1);
				}
				return findMedianSortedArrays(
						Arrays.copyOfRange(A, 0, m - discard),
						Arrays.copyOfRange(B, discard, n));
			}
			else
			{
				int discard = Math.min(n - 1 - n / 2, m / 2);
				if (m % 2 == 0)
				{
					discard = Math.min(n - 1 - n / 2, m / 2 - 1);
				}
				return findMedianSortedArrays(
						Arrays.copyOfRange(A, discard, m),
						Arrays.copyOfRange(B, 0, n - discard));
			}
		}

	}

	private double findMedianSortedArray(int A[])
	{
		if (A.length % 2 == 0)
		{
			return (A[A.length / 2 - 1] + A[A.length / 2]) / 2.;
		}
		else
		{
			return A[A.length / 2];
		}
	}

	private double findMedianSortedArrays1(int A[], int B[])
	{
		if (B.length == 1)
		{
			return (A[0] + B[0]) / 2.;
		}
		if (B.length % 2 == 0)
		{
			int a = A[0];
			int b1 = B[B.length / 2 - 1];
			int b2 = B[B.length / 2];
			return mid(a, b1, b2);
		}
		else
		{
			int a = A[0];
			int b1 = B[B.length / 2 - 1];
			int b2 = B[B.length / 2 + 1];
			return (B[B.length / 2] + mid(a, b1, b2)) / 2.;
		}
	}

	private double findMedianSortedArrays2(int A[], int B[])
	{
		if (B.length == 2)
		{
			int a1 = A[0];
			int a2 = A[1];
			int b1 = B[0];
			int b2 = B[1];
			if (a1 >= b1 && a2 <= b2)
			{
				return (a1 + a2) / 2.;
			}
			else if (b1 >= a1 && b2 <= a2)
			{
				return (b1 + b2) / 2.;
			}
			else if (a1 >= b1 && a2 >= b2)
			{
				return (a1 + b2) / 2.;
			}
			else
			{
				return (b1 + a2) / 2.;
			}
		}
		if (B.length % 2 == 0)
		{
			int a1 = A[0];
			int a2 = A[1];
			int b1 = B[B.length / 2 - 2];
			int b2 = B[B.length / 2 - 1];
			int b3 = B[B.length / 2];
			int b4 = B[B.length / 2 + 1];
			if (a1 >= b2 && a2 <= b3)
			{
				return (a1 + a2) / 2.;
			}
			else if (a2 <= b1)
			{
				return (b1 + b2) / 2.;
			}
			else if (a1 >= b4)
			{
				return (b3 + b4) / 2.;
			}
			else if (a1 <= b2 && a2 >= b3)
			{
				return (b2 + b3) / 2.;
			}
			else if (a2 <= b3 && a2 >= b1 && b2 >= a1)
			{
				return (a2 + b2) / 2.;
			}
			else
			{
				return (a1 + b3) / 2.;
			}
		}
		else
		{
			int a1 = A[0];
			int a2 = A[1];
			int b1 = B[B.length / 2 - 1];
			int b2 = B[B.length / 2];
			int b3 = B[B.length / 2 + 1];
			if (a1 >= b2 && a1 <= b3)
			{
				return a1;
			}
			else if (a2 >= b1 && a2 <= b2)
			{
				return a2;
			}
			else if (a2 <= b1)
			{
				return b1;
			}
			else if (b2 >= a1 && b2 <= a2)
			{
				return b2;
			}
			else
			{
				return b3;
			}
		}
	}

	private double mid(int a, int b, int c)
	{
		if (a >= b)
		{
			if (b >= c)
			{
				return b;
			}
			else
			{
				if (a >= c)
				{
					return c;
				}
				else
				{
					return a;
				}
			}
		}
		else
		{
			if (a >= c)
			{
				return a;
			}
			else
			{
				if (b >= c)
				{
					return c;
				}
				else
				{
					return b;
				}
			}
		}
	}
}
