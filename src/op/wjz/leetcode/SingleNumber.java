package op.wjz.leetcode;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/single-number/
 * 
 * @author wenjiezhang
 *
 */
public class SingleNumber
{

	public int singleNumber(int[] A)
	{
		if (A.length % 2 != 0)
		{
			Arrays.sort(A);
			int result = A[0];
			for (int i = 0; i < A.length; i++)
			{
				result = A[i];
				if (i % 2 == 0 && (i + 1) < A.length)
				{
					if (result != A[i + 1])
					{
						return result;
					}
				} else
				{
					continue;
				}

			}

			return result;
		} else
		{
			throw new IllegalArgumentException();
		}
	}
}
