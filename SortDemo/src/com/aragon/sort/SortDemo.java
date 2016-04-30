package com.aragon.sort;

/**
 * Created by aragon on 16/4/17.
 */
public class SortDemo {
    public static void main(String args[]) {

        testBubbleSort();

//        testChoseSort();
//        quickTest();
//        quick();
//        insertSortTest();
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @return
     */
    public static int[] bubbleSort(int[] a) {

        int size = a.length;

        for (int j = 0; j < size - 1; j++) {
            for (int i = 0; i < size - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }


        return a;
    }

    /**
     * 选择排序
     *
     * @param intArr
     * @return
     */
    public static int[] choseSort(int[] intArr) {
        int len = intArr.length;

        for (int i = 0; i < len; i++) {
            int lowIndex = i;

            for (int j = i + 1; j < len; j++) {
                if (intArr[j] < intArr[lowIndex]) {
                    lowIndex = j;
                }
            }

            //将当前第一个元素与它后面序列中的最小的一个 元素交换，也就是将最小的元素放在最前端
            int temp = intArr[i];
            intArr[i] = intArr[lowIndex];
            intArr[lowIndex] = temp;
        }

        return intArr;
    }


    public static void testBubbleSort() {
        int[] arr = {3, 1, 8, 2, 10, 4};
        int[] result = bubbleSort(arr);
        sop(result);
    }

    public static void testChoseSort() {
        int[] arr = {3, 1, 8, 2, 10, 4};
        int[] result = choseSort(arr);
        sop(result);
    }

    public static void sop(int[] res) {
        int size = res.length;
        for (int i = 0; i < size; i++) {
            System.out.println(res[i]);
        }
    }

    public static void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] >= tmp) {

                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端

            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    public static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            _quickSort(list, low, middle - 1);
            _quickSort(list, middle + 1, high);
        }
    }

    public static void quick() {
        int[] a2 = {4, 2, 1, 6, 8};
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
        sop(a2);
    }

    public static void insertSortTest() {
        int[] a = {19, 2, 0, 8, 5, 8, 21};
        int temp = 0;
        int len = a.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            temp = a[i];
            for (; j >= 0 && temp < a[j]; j--) {
                a[j + 1] = a[j];                       //将大于temp的值整体后移一个单位
            }
            a[j + 1] = temp;
        }
        sop(a);
    }


}
