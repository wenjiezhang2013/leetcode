package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/count-and-say/
 * @author wenjiezhang
 *
 */

public class CountAndSay
{

	public static String countAndSay(int n)
	{

		String result = "";

		for (int index = 1; index <= n; index++)
		{
			if (index == 1)
				result = "1";
			else
			{
				char[] nChar = result.toCharArray();
				result = "";
				int number = 0;
				Character preItem = null;
				for (Character item : nChar)
				{
					if (preItem == null || preItem == item)
					{
						number++;
						preItem = item;
						continue;

					} 
					else if (preItem != item)
					{
						result += number + preItem.toString();
						number = 1;
					}
					preItem = item;
				}

				result += number + preItem.toString();
			}
		}

		return result;

	}
	
	public static void main(String[] args)
    {
	    System.out.println(countAndSay(4));
    }
}
