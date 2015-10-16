package op.wjz.leetcode;

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 * @author wenjiezhang
 *
 */
public class ExcelSheetColumnNumber
{
	public static int titleToNumber(String s) 
	{
        if(s == null || s.length() == 0)
        	return 0;
        
        
        char[] chars = s.toCharArray();
        
        int result = 0;
 
        int length = chars.length;
        
        for (int i = 0; i < length; i++)
        {
        	int j = chars[i];
        	
	        if(j < 65 || j > 90)
	        	return 0;

	        result += (j-64) + Math.pow(26 *(j-64), length - i - 1);
	        
        }
        
        
        return length > 1 ? result - 1:result;
    }
	
	
	public static void main(String[] args)
    {
	    System.err.println(titleToNumber(""));
    }
}
