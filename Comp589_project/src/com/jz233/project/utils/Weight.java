package com.jz233.project.utils;


public class Weight {

	public static int calcWeightTwo(int grade){
		return grade>0 ? 1 : 0;
	}
	
	public static int calcWeightFive(int grade, int count){
		
		int a = -2*count;
		int b = -1*count;
		int c = 0;
		int d = 1*count;
		int e = 2*count;
		
		int[] arr = {a,b,c,d,e};
		int minDiff = Math.abs(grade -arr[0]);;
		int minDiffIdx = 0;
		
		for (int j = 1; j < arr.length; j++) {
			int compDiff;
			if((compDiff = Math.abs(grade - arr[j]))<minDiff){
				minDiff = compDiff;
				minDiffIdx = j;
			}
		}
		return minDiffIdx;
	}
}
