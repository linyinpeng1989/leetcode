import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="反转链表">https://leetcode-cn.com/problems/reverse-linked-list/</a>
 * @date Created in 2021/11/5 11:08
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null) {
            // 临时节点，指向下一个节点
            ListNode tempNode = currNode.next;

            // 就地反转
            currNode.next = preNode;
            preNode = currNode;

            // 将临时节点的引用赋值给 currNode
            currNode = tempNode;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode header = new ListNode(1, node2);

        LeetCode206 leetCode206 = new LeetCode206();
        System.out.println(leetCode206.reverseList(header));
    }

}
