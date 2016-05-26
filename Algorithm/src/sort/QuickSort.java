package sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        quickSort(data, 0, data.length - 1);
        print(data);
    }

    public static void quickSort(int[] data, int start, int end) {
        if (start >= end)
            return;

        //以起始索引为分界点
        int pivot = data[start];
        int i = start + 1;
        int j = end;

        while (true) {
            while (i <= end && data[i] < pivot)
                i++;
            while (j > start && data[j] > pivot)
                j--;

            if (i < j)
                swap(data, i, j);
            else
                break;
        }
        //交换j和分界点的值
        swap(data, start, j);
        print(data);
        //递归左子树
        quickSort(data, start, j - 1);
        //递归右子树
        quickSort(data, j + 1, end);
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
