import common.CommonUtil;
import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="删除链表的倒数第 N 个结点">https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/</a>
 * @date Created in 2021/11/5 12:45
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        int offset = 0;
        // 初始位移为 0
        // 仅移动 q 节点，直到 p 节点与 q 节点间隔为 n，然后同步移动
        // 当 q == null 时：
        //      1、offset < n 时，链表长度小于 n，返回异常或null
        //      2、offset == n 时，表示刚好达到临界值，但还未进行同步移动
        //      3、offset > n 时，表示已经进行过至少一次同步移动，此时 p.next 节点就是需要移除的节点
        while (q != null) {
            if (offset <= n) {
                q = q.next;
                offset++;
                continue;
            }
            p = p.next;
            q = q.next;
        }

        // 表示链表长度小于 n，无法删除
        if (head == null || offset < n) {
            throw new IllegalArgumentException("参数不正确");
        }

        // 刚好达到间隔 n，但还未开始同步移动，此时需要移除头结点
        if (offset == n) {
            return p.next;
        }

        // 将 p.next 节点移除（目标节点）
        p.next = p.next.next;
        return head;
    }

    public static void main(String[] args) {
        LeetCode19 leetCode = new LeetCode19();

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode header = new ListNode(1, node2);
        CommonUtil.printListNode(header);
        ListNode listNode = leetCode.removeNthFromEnd(header, 2);
        CommonUtil.printListNode(listNode);

        System.out.println("----------------------");

        ListNode header1 = new ListNode(1);
        CommonUtil.printListNode(header1);
        listNode = leetCode.removeNthFromEnd(header1, 1);
        CommonUtil.printListNode(listNode);

        System.out.println("----------------------");

        ListNode node22 = new ListNode(2);
        ListNode header2 = new ListNode(1, node22);
        CommonUtil.printListNode(header2);
        listNode = leetCode.removeNthFromEnd(header2, 1);
        CommonUtil.printListNode(listNode);

        System.out.println("----------------------");

        ListNode node23 = new ListNode(2);
        ListNode header3 = new ListNode(1, node23);
        CommonUtil.printListNode(header3);
        listNode = leetCode.removeNthFromEnd(header3, 2);
        CommonUtil.printListNode(listNode);

        System.out.println("----------------------");

        ListNode node34 = new ListNode(3);
        ListNode node24 = new ListNode(2, node34);
        ListNode header4 = new ListNode(1, node24);
        CommonUtil.printListNode(header4);
        listNode = leetCode.removeNthFromEnd(header4, 3);
        CommonUtil.printListNode(listNode);
    }

}
