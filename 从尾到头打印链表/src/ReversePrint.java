import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */

public class ReversePrint {

    /**
     * 栈的特点是后进先出，即最后压入栈的元素最先弹出。
     * 考虑到栈的这一特点，使用栈将链表元素顺序倒置。
     * 从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。
     *
     * @param head
     * @return int[]
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head ;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0;i<size ;i++){
            print[i] = stack.pop().val;
        }
        return print;
    }

    /**
     * 自己重写了一遍
     * @param head
     * @return
     */

    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for(int i = 0;i < size ;i++){

            print[i] = stack.pop().val;
        }
        return print;
    }

    /**
     *
     */
    public int[] reversePrint3(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int[] print = new int[count];
        temp = head;
        for(int i = count-1 ;i >= 0 ; i--){
            print[i] = temp.val;
            temp = temp.next;
        }
        return  print ;


    }
}
