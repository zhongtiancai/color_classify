package com.zhongtiancai.classify;

import java.util.*;

class RandomArray {
	// 从 m个整数中随机抽取 n个整数，条件: m > n
	public static List<Integer> genRandomArray(int m, int n) {

		List<Integer> array = new ArrayList<>();
		int intRd = 0; // 存放随机数
		int count = 0; // 记录生成的随机数个数
		while (count < n) {
			Random rdm = new Random(System.currentTimeMillis());
			intRd = Math.abs(rdm.nextInt()) % m;
			if (!array.contains(intRd)) {
				array.add(intRd);
				count++;
			}
		}
		return array;
	}
	public static void main(String args[]) {
		System.out.println(genRandomArray(10,5));
	}

}