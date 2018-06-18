package com.app.stepDefs.api;

public class Test1 {

	static int prices[] = { 130, 110, 100, 115, 90, 100, 75, 85, 65, 70, 85 };
//	static int profit=0;
//	-15-10-5

	// int currentPrice
	public static void main(String[]args) {
		 int profit=0;
		for(int i=0;i<prices.length;i++) {
			
			int currentPrice=prices[i];
			for(int p=i+1;p<prices.length;p++) {
				if(prices[i]>prices[p]) {
					continue;
				}
				if(prices[i]<prices[p]) {
					profit+=prices[p]-currentPrice;
					break;
				}else {
						
					continue;
					
						}
					
				
				}
				
			
		}
		System.out.println(profit);
	}

}
