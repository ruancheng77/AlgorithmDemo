package cn.rcddup.algorithm.heapsort;

import cn.rcddup.algorithm.common.ArrayUtils;

/**
 * 堆排序算法:
 * <p>
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（
 * 或者大于）它的父节点。 堆排序的平均时间复杂度为Ο(nlogn) 。
 * </p>
 * <p>
 * 1.创建一个堆H[0..n-1] 
 * </p><p>
 * 2.把堆首（最大值）和堆尾互换
 * </p>
 * <p>
 * 3.把堆的尺寸缩小1，并调用shift_down(0),目的是把新的数组顶端数据调整到相应位置
 * </p>
 * <p>
 * 4. 重复步骤2，直到堆的尺寸为1
 * </p>
 * 
 * @author RuanCheng QQ:410093793
 * @version 创建时间:2016年12月5日下午8:21:10
 */
public class TestDemo {
	public static void main(String[] args) throws Exception {
		int[] arr = ArrayUtils.randomArray(10);
		ArrayUtils.printArray(arr);
		long start = System.currentTimeMillis(); // 计算排序开始时间

		heapsort(arr);

		long end = System.currentTimeMillis(); // 计算排序结束时间
		System.out.println("堆排序法耗时：" + (end - start) + "毫秒"); // 输出排序耗时

		ArrayUtils.printArray(arr);
	}

	/**
	 * 
	 * 堆排序算法的基本操作：
	 * <p>
	 * ① 初始化操作：将R[1..n]构造为初始堆；
	 * </p>
	 * <p>
	 * ② 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换，然后将新的无序区调整为堆(亦称重建堆)。
	 * </p>
	 * <p>
	 * 注意：
	 * </p>
	 * <p>
	 * ①只需做n-1趟排序，选出较大的n-1个关键字即可以使得文件递增有序。
	 * </p>
	 * <p>
	 * ②用小根堆排序与利用大根堆类似，只不过其排序结果是递减有序的。堆排序和直接选择排序相反：在任何时刻堆排序中无序区总是在有序区之前，
	 * 且有序区是在原向量的尾部由后往前逐步扩大至整个向量为止。
	 * </p>
	 */
	private static void heapsort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			createHeapTop(arr, arr.length - 1 - i);
			swap(arr, 0, arr.length - 1 - i);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		if (i == j) {
			return;
		} else {
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - arr[j];
		}
	}

	private static void createHeapTop(int[] arr, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int k = i;
			// 若当前节点的子节点存在
			while (2 * k + 1 <= lastIndex) {
				// biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					// 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
					if (arr[biggerIndex] < arr[biggerIndex + 1]) {
						// 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
						biggerIndex++;
					}
				}
				if (arr[k] < arr[biggerIndex]) {
					// 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
					swap(arr, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
}
