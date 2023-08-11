package algorithm;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Yuri
 * @see <a href="https://www.cnblogs.com/AkimotoAkira/p/14023436.html">十大基础排序</a>
 * @since 2021/8/27 14:59
 */
class Sort {
    private static Vector<Integer> v = new Vector<>();
    private static int len;

    //冒泡排序
    public void bubbleSort() {
        len = v.size();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                int a = v.get(j), b = v.get(j + 1);
                if (a > b) swap(j, j + 1);
            }
        }
    }

    //选择排序
    public void selectionSort() {
        int minNum;
        len = v.size();
        for (int i = 0; i < len - 1; i++) {
            minNum = i;
            for (int j = i + 1; j < len; j++) {
                int a = v.get(minNum), b = v.get(j);
                if (a > b) {
                    minNum = j;
                }
            }
            swap(i, minNum);
        }
    }

    //插入排序
    public void insertionSort() {
        int index, currentNum;
        len = v.size();
        for (int i = 1; i < len; i++) {
            index = i;
            currentNum = v.get(i);
            while (index - 1 >= 0 && v.get(index - 1) > currentNum) {
                v.set(index, v.get(index - 1));
                index--;
            }
            v.set(index, currentNum);
        }
    }

    //希尔排序
    public void shellSort() {
        int index, currentNum;
        len = v.size();
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                index = i;
                currentNum = v.get(i);
                while (index - gap >= 0 && v.get(index - gap) > currentNum) {
                    v.set(index, v.get(index - gap));
                    index -= gap;
                }
                v.set(index, currentNum);
            }
        }
    }

    //归并排序
    public Vector<Integer> merge(Vector<Integer> left, Vector<Integer> right) {
        Vector<Integer> result = new Vector<>();
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.remove(0));
            } else {
                result.add(right.remove(0));
            }
        }
        while (left.size() > 0) result.add(left.remove(0));
        while (right.size() > 0) result.add(right.remove(0));
        return result;
    }

    public Vector<Integer> mergeSort(Vector<Integer> ary) {
        /*System.out.printf("%d:%s\n", testTime++, ary);*/
        int mergeLen = ary.size();
        if (mergeLen < 2) return ary;
        int mid = mergeLen / 2;
        Vector<Integer> left = new Vector<>();
        Vector<Integer> right = new Vector<>();
        int i = 0;
        while (i < mid) {
            left.add(ary.get(i++));
        }
        while (i < mergeLen) {
            right.add(ary.get(i++));
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    public void doMergeSort() { //mergeSort启动函数
        len = v.size();
        v = mergeSort(v);
    }

    //快速排序
    public void quickSort(int left, int right) {
        if (left >= right) return;
        int i = left, j = right, base = v.get(left);
        while (i < j) {
            while (v.get(j) >= base && i < j) j--;
            while (v.get(i) <= base && i < j) i++;
            if (i < j) swap(i, j);
        }
        v.set(left, v.get(i));
        v.set(i, base);
        quickSort(left, i - 1);
        quickSort(i + 1, right);
    }

    public void doQuickSort() {
        len = v.size();
        quickSort(0, len - 1);
    }

    //堆排序
    public void adjustHeap(int i) {
        int left = 2 * i + 1, right = 2 * i + 2; //二叉树子节点公式
        int maxPoint = i;
        if (left < len && v.get(left) > v.get(maxPoint)) maxPoint = left;
        if (right < len && v.get(right) > v.get(maxPoint)) maxPoint = right;
        if (maxPoint != i) {
            swap(i, maxPoint);
            adjustHeap(maxPoint);
        }
    }

    public void buildMaxHeap() {
        len = v.size();
        for (int i = len / 2; i >= 0; i--) adjustHeap(i); //二叉树根节点 <= 叶子节点
    }

    public void heapSort() {
        buildMaxHeap();
        for (int i = v.size() - 1; i > 0; i--) {
            swap(0, i);
            len--;
            adjustHeap(0);
        }
        len = v.size();
    }

    //计数排序
    public void countingSort() {
        int maxNum = Collections.max(v), minNum = Collections.min(v);
        len = v.size();
        Vector<Integer> result = new Vector<Integer>();
        result.setSize(len);

        int countSize = maxNum - minNum + 1;
        int count[] = new int[countSize];
        Arrays.fill(count, 0);
        for (int i = 0; i < len; i++) {
            count[v.get(i) - minNum]++;
        }
        for (int i = 1; i < countSize; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < len; i++) {
            result.set(count[v.get(i) - minNum] - 1, v.get(i));
            count[v.get(i) - minNum]--;
        }
        v = result;
    }

    //桶排序
    public void bucketSort() {
        int i, j, maxNum = Collections.max(v), minNum = Collections.min(v);
        int bucketSize = 5; //桶容量
        int bucketCount = ((maxNum - minNum) / bucketSize) + 1;
        Vector<Integer> result = new Vector<>();
        Vector<Vector<Integer>> buckets = new Vector<Vector<Integer>>();
        for (i = 0; i < bucketCount; i++) {
            buckets.add(new Vector<>());
        }
        for (i = 0; i < v.size(); i++) {
            buckets.get((v.get(i) - minNum) / bucketSize).add(v.get(i));
        }
        for (i = 0; i < bucketCount; i++) {
            v = buckets.get(i);
            insertionSort();
            for (j = 0; j < v.size(); j++) {
                result.add(v.get(j));
            }
        }
        v = result;
        len = v.size();
    }

    //基数排序
    public void radixSort() {
        int mod = 10, dev = 1, bitNum, maxDigit;
        int i, j;
        Vector<Vector<Integer>> buckets;
        maxDigit = String.valueOf(Collections.max(v)).length(); //获取数组v最最大数的位数
        for (i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            buckets = new Vector<Vector<Integer>>();
            buckets.setSize(10);
            for (j = 0; j < v.size(); j++) {
                bitNum = v.get(j) % mod / dev;
                if (buckets.get(bitNum) == null) {
                    buckets.set(bitNum, new Vector<>());
                }
                buckets.get(bitNum).add(v.get(j));
            }
            v.clear();
            for (j = 0; j < buckets.size(); j++) {
                if (buckets.get(j) != null) {
                    while (buckets.get(j).size() != 0) {
                        v.add(buckets.get(j).firstElement());
                        buckets.get(j).remove(0);
                    }
                }
            }
        }
        len = v.size();
    }


    public void putIn() {
        Scanner in = new Scanner(System.in);
        v.clear();
        System.out.println("\n请输入待排序数组以空格隔开，Ctrl+D结束：");
        //输入任意数量的整数，Ctrl+D表示Eof
        while (in.hasNext()) {
            int num = in.nextInt();
            v.add(num);
        }
    }

    public void putOut() {
        for (int i = 0; i < len - 1; i++) {
            System.out.printf("%d ", v.get(i));
        }
        System.out.printf("%d\n", v.get(len - 1));
    }

    public void swap(int x, int y) {
        int temp;
        temp = v.get(x);
        v.set(x, v.get(y));
        v.set(y, temp);
    }
}

public class BasicSorts {
    private static int sortIndex;
    //算法名容器
    private static Vector<String> sortName = new Vector<>();
    //算法函数选择容器
    private static Vector<String> vFunc = new Vector<>();
    private static Scanner in = new Scanner(System.in);
    private static Sort st = new Sort();

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        sortNameList();
        selectSort();
        st.putIn();
        doSort();
        st.putOut();
    }

    private static void sortNameList() {
        sortName.add("Bubble Sort");
        sortName.add("Selection Sort");
        sortName.add("Insertion Sort");
        sortName.add("Shell Sort");
        sortName.add("Merge Sort");
        sortName.add("Quick Sort");
        sortName.add("Heap Sort");
        sortName.add("Counting Sort");
        sortName.add("Bucket Sort");
        sortName.add("Radix Sort");
        vFunc.add("bubbleSort");
        vFunc.add("selectionSort");
        vFunc.add("insertionSort");
        vFunc.add("shellSort");
        vFunc.add("doMergeSort");
        vFunc.add("doQuickSort");
        vFunc.add("heapSort");
        vFunc.add("countingSort");
        vFunc.add("bucketSort");
        vFunc.add("radixSort");
    }

    private static void selectSort() {
        int i = 0;
        for (String s : sortName) {
            System.out.printf("%d.%s.\n", ++i, s);
        }
        System.out.printf("请输入数字选择排序算法：\n");
        sortIndex = in.nextInt() - 1;
    }

    private static void doSort() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = st.getClass().getMethod(vFunc.get(sortIndex), new Class[0]);
        method.invoke(st, new Object[0]);
    }
}


