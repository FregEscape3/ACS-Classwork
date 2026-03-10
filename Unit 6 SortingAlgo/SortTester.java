public class SortTester {

    public static void main(String[] args) {
        BubbleSort test = new BubbleSort(67);
        test.fillArr(test.nums);
        test.sort(test.nums);
        System.out.println(test.toString());
        StalinSort test2 = new StalinSort(67);
        test2.fillArr(test2.nums);
        test2.sort(test2.nums);
        System.out.println(test2.toString());
    }
}
