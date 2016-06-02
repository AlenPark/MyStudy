package sort;

/**
 * 并归排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        mergeSort(data, 0, data.length - 1);
        print(data);
    }

    public static void mergeSort(int[] data, int left, int right) {
        if (left >= right)
            return;

        //找出中间索引
        int center = (left + right) / 2;
        //对左边数组进行递归
        mergeSort(data, left, center);
        //对右边数组进行递归
        mergeSort(data, center + 1, right);
        //合并
        merge(data, left, center, right);

        print(data);
    }

    public static void merge(int[] data, int left, int center, int right) {
        //临时数组
        int[] tmpArr = new int[data.length];
        //右边数组第一个元素的索引
        int mid = center + 1;
        //记录临时数组的索引
        int third = left;
        //缓存作品数组第一个元素的索引
        int tmp = left;

        while (left <= center && mid <= right) {
            //从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid])
                tmpArr[third++] = data[left++];
            else
                tmpArr[third++] = data[mid++];
        }
        //将剩余部分依次放入数组
        while (mid <= right)
            tmpArr[third++] = data[mid++];
        while (left <= center)
            tmpArr[third++] = data[left++];

        //将临时数组中的内容拷贝至原数组中
        while (tmp <= right)
            data[tmp] = tmpArr[tmp++];
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
