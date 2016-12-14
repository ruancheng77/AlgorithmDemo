package cn.rcddup.algorithm.mergesort;

import cn.rcddup.algorithm.common.ArrayUtils;

/**
 * 归并排序：
 * <p>
 * 归并排序（Merge sort，台湾译作：合并排序）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and
 * Conquer）的一个非常典型的应用。
 * </p>
 * <p>
 * 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * </p>
 * <p>
 * 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * </p>
 * <p>
 * 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置 4. 重复步骤3直到某一指针达到序列尾 5.
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 * </p>
 * 
 * @author RuanCheng QQ:410093793
 * @version 创建时间:2016年12月6日上午9:24:40
 */
public class TestDemo {
	public static void main(String[] args) throws Exception {
		int[] arr1 = ArrayUtils.randomArray(5000);
		quicksort(arr1, 0, arr1.length - 1);
		ArrayUtils.printArray(arr1);
		int[] arr2 = ArrayUtils.randomArray(2500);
		quicksort(arr2, 0, arr2.length - 1);
		ArrayUtils.printArray(arr2);

		long start = System.currentTimeMillis();

		int[] arr3 = mergesort(arr1, arr2);

		long end = System.currentTimeMillis();

		System.out.println("归并排序耗时：" + (end - start) + "毫秒");
		ArrayUtils.printArray(arr3);

	}

	private static int[] mergesort(int[] arr1, int[] arr2) {
		// 定义一个新的数组，长度为两数组之和
		int[] arr3 = new int[arr1.length + arr2.length];
		int i; // 作为数组1的指针
		int j; // 作为数组2的指针
		int k; // 作为新数组的指针
		for (i = 0, j = 0, k = 0; (i < arr1.length && j < arr2.length) && k < arr3.length; k++) {
			if (arr1[i] <= arr2[j]) {
				arr3[k] = arr1[i];
				i++;
			} else {
				arr3[k] = arr2[j];
				j++;
			}
		}
		if (i == arr1.length) {
			for (int x = k; x < arr3.length; x++) {
				arr3[x] = arr2[j];
				j = j + 1;
			}
		} else if (j == arr2.length) {
			for (int x = k; x < arr3.length; x++) {
				arr3[x] = arr1[i];
				i = i + 1;
			}
		}
		return arr3;
	}

	private static void quicksort(int[] arr, int left, int right) {
		if (left < right) {
			int pivot = arr[left];
			int low = left;
			int high = right;
			while (low < high) {
				while (low < high && arr[high] > pivot) {
					high--;
				}
				arr[low] = arr[high];
				while (low < high && arr[low] <= pivot) {
					low++;
				}
				arr[high] = arr[low];
			}
			arr[low] = pivot;
			quicksort(arr, left, low - 1);
			quicksort(arr, low + 1, right);
		}
	}
}
