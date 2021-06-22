public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(2);
        head.next = list2;
        list2.next = list3;

        ReversePrint reversePrint = new ReversePrint();
        int[] print;
        print = reversePrint.reversePrint3(head);
        for(int i =0;i<print.length;i++){
            System.out.println(print[i]);
        }
    }
}
