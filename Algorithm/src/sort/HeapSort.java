package sort;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        heapSort(data);
        print(data);
    }

    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createMaxHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }

    public static void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            //保存当前正在判断的节点
            int k = i;
            //若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                //biggerIndex记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    //若右子节点存在,否则此时biggerIndex的值应该等于lastIndex的值
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        //若右子节点值比左节点的值大,则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }

                if (data[k] < data[biggerIndex]) {
                    //若当前节点的值比子节点最大值小,则交换二者的值,交换后将biggerIndex的值赋给K
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else
                    break;
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
