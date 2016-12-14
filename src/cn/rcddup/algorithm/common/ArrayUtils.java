package cn.rcddup.algorithm.common;

import java.util.Random;

/**
 * @author RuanCheng QQ:410093793
 * @version 创建时间:2016年12月5日下午6:33:40
 */
public class ArrayUtils {
	public static int[] randomArray(int length) throws Exception {
		if (length < 0)
			throw new Exception("Length is less than zero.");
		int[] arr = new int[length];
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			arr[i] = r.nextInt(length);
		}
		return arr;
	}
	
	public static void printArray(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1)
				System.out.print(arr[i] + "-");
			else
				System.out.print(arr[i]+"\n");
		}
	}
}
