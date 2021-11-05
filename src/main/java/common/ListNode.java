package common;

/**
 * @author Yinpeng.Lin
 * @desc 单链表（为了在引用时可以直接获取属性，而不用通过 getXxx() 获取，故属性设置为 public）
 * @date Created in 2021/11/5 17:20
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
