package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author wenjiezhang
 *
 */
public class BestTimeToBuyAndSellStockII
{

	public static int maxProfit(int[] prices)
	{
		boolean hasShare = false;
		int costBase = 0;
		int profit = 0;
		for (int i = 0; i < prices.length; i++)
        {
			if(!hasShare)
			{
				if((i+1) < prices.length && prices[i] < prices[i+1])
				{
					costBase = prices[i];
					hasShare = true;
					continue;
				}
			}
			else if(hasShare == true && costBase < prices[i] && (((i+1) == prices.length) || (prices[i] > prices[i+1])))
	        {
	        	hasShare = false;
	        	profit += (prices[i] - costBase);
	        	costBase = 0;
	        }
        }
		return profit;
	}
	
	
	public static void main(String[] args)
    {
	    int [] input = {2, 1, 2, 0, 1};
	    
	    System.err.println(maxProfit(input));
	    
    }
}
