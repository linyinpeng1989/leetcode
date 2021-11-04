/**
 * @author Yinpeng.Lin
 * @see <a href="链表中环的入口节点">https://leetcode-cn.com/problems/c32eOV/</a>
 * @date Created in 2021/11/4 15:06
 */
public class LeetCode_Sword_Offer_22 {

    /**
     * 1、使用快、慢两个指针遍历，直到两个指针相遇
     * 2、将满指针重新指回头结点，然后与快速指针（相遇点）一起同速前进
     * 3、当两个指针再次相遇时，该节点即是环的入口节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        boolean hasCycle = false;
        ListNode slowNode = head;
        ListNode fastNode = head;
        // 快速节点为空，或快速节点的下一个节点为空时，则链表遍历结束
        // 如果存在环，则在遍历完成之前，两个指针必然会相遇
        while (fastNode != null && fastNode.next != null) {
            // 先各自移位(初始节点一致，若不先移位，将会直接判定为相遇节点)
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            // 判断是否相遇
            if (slowNode == fastNode) {
                hasCycle = true;
                break;
            }
        }

        // 异常情况处理
        if (!hasCycle) {
            return null;
        }

        // 将慢节点重新指向 head，然后与快速节点同速前进
        slowNode = head;
        while (true) {
            if (slowNode == fastNode) {
                return slowNode;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

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

    public static void main(String[] args) {
        LeetCode_Sword_Offer_22 leetCode = new LeetCode_Sword_Offer_22();

        ListNode head = new ListNode(1);
        System.out.println(leetCode.detectCycle(head));
    }

}
