package com.daniel;

public interface Controls {
	
	/**
	 *  The search algorithm see 'A' and 'a' as two different chars <p>
	 *  Computer != computer
	 */
	public static final int INCLUDE_UPPER_CASES=0;
	/**
	 * The search algorithm see 'A' and 'a' as same chars <p>
	 *  COMPUTER == computer && Computer == computer 
	 */
	public static final int IGNORE_UPPER_CASES=1;
	
	/**
	 *  Algorithm searches from first char if correct checks next, then next... <p> 
	 *  e.g. <p>
	 *  Search: "com" <p>
	 *  	in computer ->found <p>
	 *  	in pccomputer -> not found
	 */
	public static final int SEARCH_FROM_BEGGINING=0;
	/**
	 * 	Algorithm checks if string contains given text
	 *  e.g. <p>
	 *  Search: "com" <p>
	 *  	in computer ->found <p>
	 *  	in pccomputer -> found
	 */
	public static final int SEARCH_WITHIN_FILE=1;
}
