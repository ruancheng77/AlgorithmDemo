package cn.rcddup.algorithm.quicksort;

import cn.rcddup.algorithm.common.ArrayUtils;

/**
 * 快速排序：
 * <p>
 * 在平均状况下，排序 n 个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比 较，但这种状况并不常见。
 * </p>
 * <p>
 * 1：从数列中挑出一个元素，称为 “基准”（pivot），
 * </p>
 * <p>
 * 2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，
 * 该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * </p>
 * <p>
 * 3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * </p>
 * 
 * @author RuanCheng QQ:410093793
 * @version 创建时间:2016年12月5日下午5:43:21
 */
public class TestDemo {
	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.randomArray(10); // 产生指定长度的数组
		ArrayUtils.printArray(arr); // 打印数组
		long start = System.currentTimeMillis(); // 计算排序开始时间

		quicksort(arr, 0, arr.length - 1); // 开始排序

		long end = System.currentTimeMillis(); // 计算排序结束时间
		System.out.println("快速排序法耗时：" + (end - start) + "毫秒"); // 输出排序耗时
		ArrayUtils.printArray(arr); // 打印排序后的数组
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
