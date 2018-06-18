package com.app.stepDefs.api;

public class testq1 {
	static long ar[] = { 130, 110, 100, 115, 90, 100, 75, 85, 65, 70, 85 };
	public static void main(String[] args) {
		System.out.println(maximum (ar));
	}

	public static long maximum(long[] ar){  
	int j=0;
	    long costPrice=0;
	    long sellingPrice=0;
	    int k=0;
	    long max = maximumKey(j,ar);
	    while(j<ar.length){
	        if(ar[j]<max){
	            costPrice += ar[j];
	            j++;
	        }
	        else if(ar[j]==max){
	            sellingPrice += ((j-k)*ar[j]);
	            j++;
	            k=j;
	            max = maximumKey(j,ar);
	        }            
	    }
	    return sellingPrice-costPrice;
	}
	
	
	
	    public static long maximumKey(int j, long[] ar){
	        long max = 0;
	        for(int i=j;i<ar.length;i++){
	            if(max<ar[i])
	                max = ar[i];
	        }
	            return max;
	    } 
}
