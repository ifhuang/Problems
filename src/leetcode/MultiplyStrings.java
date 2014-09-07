package leetcode;

public class MultiplyStrings
{
	public String multiply(String num1, String num2)
	{
		java.math.BigDecimal big1 = new java.math.BigDecimal(num1);
		java.math.BigDecimal big2 = new java.math.BigDecimal(num2);
		return big1.multiply(big2).toString();
	}
}
