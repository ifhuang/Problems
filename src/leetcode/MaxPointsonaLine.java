package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.util.Point;

public class MaxPointsonaLine
{
	class MyPoint
	{
		int x;
		int y;

		public MyPoint(Point p)
		{
			x = p.x;
			y = p.y;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyPoint other = (MyPoint) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		private MaxPointsonaLine getOuterType()
		{
			return MaxPointsonaLine.this;
		}

		@Override
		public String toString()
		{
			return "MyPoint [x=" + x + ", y=" + y + "]";
		}

	}

	class Line
	{
		double k;
		double b;

		public Line(double k1, double b1)
		{
			k = k1;
			b = b1;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			long temp;
			temp = Double.doubleToLongBits(b);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(k);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Line other = (Line) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
				return false;
			if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
				return false;
			return true;
		}

		private MaxPointsonaLine getOuterType()
		{
			return MaxPointsonaLine.this;
		}

	}

	public int maxPoints(Point[] points)
	{
		if (points == null)
			return 0;
		if (points.length < 3)
			return points.length;
		MyPoint myPoints[] = new MyPoint[points.length];
		for (int i = 0; i < points.length; i++)
			myPoints[i] = new MyPoint(points[i]);

		Map<MyPoint, Integer> map = new HashMap<>();
		for (int i = 0; i < myPoints.length; i++)
			if (map.containsKey(myPoints[i]))
				map.put(myPoints[i], map.get(myPoints[i]) + 1);
			else
				map.put(myPoints[i], 1);
		MyPoint[] disPoints = map.keySet().toArray(new MyPoint[0]);
		if (disPoints.length == 1)
			return myPoints.length;
		Map<Line, Set<MyPoint>> lineMap = new HashMap<>();
		for (int i = 0; i < disPoints.length - 1; i++)
			for (int j = i + 1; j < disPoints.length; j++)
			{
				int yDiff = disPoints[i].y - disPoints[j].y;
				int xDiff = disPoints[i].x - disPoints[j].x;
				double k = 0;
				double b = 0;
				if (yDiff == 0 && xDiff == 0)
					;
				else if (yDiff == 0)
				{
					k = 0;
					b = disPoints[i].y;
				}
				else if (xDiff == 0)
				{
					k = Double.NaN;
					b = disPoints[i].x;
				}
				else
				{
					k = (double) (disPoints[i].y - disPoints[j].y)
							/ (double) (disPoints[i].x - disPoints[j].x);
					b = (double) (disPoints[i].x * disPoints[j].y - disPoints[j].x
							* disPoints[i].y)
							/ (double) (disPoints[i].x - disPoints[j].x);
				}
				Line line = new Line(k, b);
				if (lineMap.containsKey(line))
				{
					Set<MyPoint> set = lineMap.get(line);
					set.add(disPoints[i]);
					set.add(disPoints[j]);
					lineMap.put(line, set);
				}
				else
				{
					Set<MyPoint> set = new HashSet<>();
					set.add(disPoints[i]);
					set.add(disPoints[j]);
					lineMap.put(line, set);
				}
			}
		int max = 0;
		for (Line line : lineMap.keySet())
		{
			int count = 0;
			Set<MyPoint> set = lineMap.get(line);
			for (MyPoint point : set)
				count += map.get(point);
			max = max > count ? max : count;
		}
		return max;
	}

	public static void main(String[] args)
	{
		MaxPointsonaLine solution = new MaxPointsonaLine();
		Point[] points = new Point[3];
		points[0] = new Point(1, 1);
		points[1] = new Point(1, 1);
		points[2] = new Point(1, 1);
		System.out.println("" + solution.maxPoints(points));
	}
}