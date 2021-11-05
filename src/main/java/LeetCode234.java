import common.ListNode;

/**
 * @author Yinpeng.Lin
 * @see <a href="回文链表">https://leetcode-cn.com/problems/palindrome-linked-list/</a>
 * @date Created in 2021/11/3 17:03
 */
public class LeetCode234 {

    /**
     * 判断是否为回文链表（单链表）
     *
     * @param head 链表头结点
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        /*
         * 利用快慢指针定位中间节点，并将前半部分链表反转
         */
        ListNode slowNode = head;
        ListNode quickNode = head;
        ListNode preNode = null;

        // 判断循环结束条件：
        //      1、奇数节点时 quickNode != null && quickNode.next == null 表示 quickNode 是尾结点
        //      2、偶数节点时 quickNode == null，即 quickNode 的上一个节点是尾结点
        while (quickNode != null && quickNode.next != null) {
            // 临时变量
            ListNode tempNode = slowNode.next;
            // 快指针后移，若quick.next.next == null，则下轮即会结束
            quickNode = quickNode.next.next;

            // 前半部分链表反转
            slowNode.next = preNode;
            preNode = slowNode;

            // 慢节点后移
            slowNode = tempNode;
        }

        // 奇数节点，跳过一个
        if (quickNode != null) {
            slowNode = slowNode.next;
        }

        /*
         * 遍历 preNode - head 与 slowNode - 末尾，判断是否回文
         */
        while (preNode != null && slowNode != null) {
            if (preNode.val != slowNode.val) {
                return false;
            }
            preNode = preNode.next;
            slowNode = slowNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode234 leetCode = new LeetCode234();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(2, node2);
        ListNode headNode = new ListNode(1, node3);
        System.out.println(leetCode.isPalindrome(headNode));
    }

}
