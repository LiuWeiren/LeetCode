package com.liuweiren.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * 面试题：40 - 49
 *
 * <br><br>created by <b>LWR</b> on <b>2020/3/20</b>
 * @author LWR
 */
public class SolutionInterview004 {
    /**
     * <a href="https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof">面试题40.</a>
     *
     * 最小的k个数<br>
     *
     * 输入整数数组arr，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        // /*
        //  * 先排序再取前k个数（调用现有API）
        //  */
        // Arrays.sort(arr);
        // return Arrays.copyOf(arr, k);

        /*
         * 利用堆，堆恒定容量为k，每次比较堆顶元素
         *
         * 适用于数据量非常大（内存无法存入），可以一个一个处理数据
         */
        if (arr.length == 0 || k == 0) {
            return new int[] {};
        }
        // 利用队列模拟堆，排序规则保证最大数在堆顶
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
        /*
         * 遍历数组，先将堆填满，再将余下的元素与堆顶元素比较，若小于堆顶的元素，则移除堆顶元素，将该元素添加到堆中
         */
        for (int value : arr) {
            if (queue.size() < k) {
                queue.add(value);
            } else if (value < queue.peek()) {
                queue.poll();
                queue.offer(value);
            }
        }

        int len = queue.size();
        int[] resultArr = new int[len];
        for (int i = 0; i < len; i++) {
            resultArr[i] = queue.poll();
        }

        return resultArr;

        /*
         * 快速选择，基本思想和快速排序一样
         *
         * 效率最高
         */
    }
}
