import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="合并两个有序链表">https://leetcode-cn.com/problems/merge-two-sorted-lists/</a>
 * @date Created in 2021/11/5 12:45
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 定义一个哨兵节点，减少边界特殊处理逻辑
        ListNode sortListNode = new ListNode(-1);
        ListNode nextNode = sortListNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                nextNode.next = l1;
                l1 = l1.next;
            } else {
                nextNode.next = l2;
                l2 = l2.next;
            }
            nextNode = nextNode.next;
        }
        // 剩余列表节点处理
        if (l1 != null) {
            nextNode.next = l1;
        } else if (l2 != null) {
            nextNode.next = l2;
        }
        // 跳过哨兵节点
        return sortListNode.next;
    }

}
