package com.app.tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Baha {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		int d = 3;
		 System.out.println(Arrays.toString(solve(a, d)));
		Map map = new HashMap();
		map.put(null, null);
		map.put(null, "good");
		map.put(1, null);
		Set set = new HashSet();
		set.add("Temirlan");
		set.add("Temirlan");
//		System.out.println(set.size());
//		System.out.println(map.get(null) + " " + map.size());

	}

	// 1,2,3,4,5 -> 3,4,5,1,2 / 2
	static int[] solve(int[] a, int k) {
		int n = a.length;
		Map map = new HashMap();
		map.put(null, null);
		map.put(null, "good");
		System.out.println(map.get(null));
		
		int[] temp = new int[a.length];

		int[] copy = new int[n];
		System.arraycopy(a, k, copy, 0, (n - k));
		System.arraycopy(a, 0, copy, (n - k), (n - (n - k)));
		System.out.println();
		return copy;

		// int j = 0;
		// if(d>a.length) {
		// System.exit(0);
		// }
		// else if (d == 0) {
		//
		// System.out.println(Arrays.toString(a));
		// return a;
		// }
		//
		// for (int i = d; i < a.length; i++) {
		//
		// temp[j] = a[i];
		//
		// System.out.println(temp[j]);
		//
		// j++;
		// }
		//
		// int t = temp.length-d;
		//
		// for (int k = 0; k < a.length - t; k++) {
		// int r=temp.length-d;
		// temp[r] = a[k];
		// System.out.println(temp[r]+" secodn");
		// r++;
		// }
		//
		// return temp;
	}

}
