package sort;

/**
 * 直接选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        selectSort(data);
        print(data);
    }

    /**
     * 直接排序算法
     *
     * @param data
     */
    public static void selectSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            //记录最小值的索引
            int minIndex = i;
            //将该数字和后面的数进行比较，记录下最小值的索引
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex])
                    minIndex = j;
            }
            //如果最小值不是当前的数，则交换最小值到该位置
            if (minIndex != i) {
                swap(data, i, minIndex);
                print(data);
            }
        }
    }

    /**
     * 将数组中的两个数字交换
     *
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[] data, int i, int j) {
        if (i == j)
            return;

        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void print(int[] data) {
        for (int i : data) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
