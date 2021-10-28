
/**
 * @author Yinpeng.Lin
 * @see <a href="两数相加">https://leetcode-cn.com/problems/add-two-numbers/</a>
 * @date Created in 2021/10/27 10:13
 */
public class LeetCode2 {

    // public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //     Map<Integer, Boolean> higherAddMap = new HashMap<>(128);
    //     int index = 0;
    //     ListNode headNode = null;
    //     ListNode preNode = null;
    //     // 处理较短链表的长度计算
    //     while (l1 != null || l2 != null) {
    //         // 当前位对应节点求和
    //         int currTotal = 0;
    //         if (l1 != null) {
    //             currTotal += l1.val;
    //
    //             // 后移
    //             l1 = l1.next;
    //         }
    //         if (l2 != null) {
    //             currTotal += l2.val;
    //
    //             // 后移
    //             l2 = l2.next;
    //         }
    //
    //         // 非头结点时，判断上一位是否进1
    //         if (index != 0 && higherAddMap.get(index - 1)) {
    //             currTotal++;
    //         }
    //         // 当前位对应节点val值
    //         ListNode currNode = new ListNode(currTotal % 10);
    //
    //         // 当前位对应节点是否进1标识
    //         higherAddMap.put(index, currTotal >= 10);
    //
    //         // 头结点特殊处理
    //         if (headNode == null) {
    //             headNode = currNode;
    //         } else {
    //             preNode.next = currNode;
    //         }
    //
    //         // 前序节点赋值
    //         preNode = currNode;
    //         index++;
    //     }
    //
    //     // 处理最后一位是否进1
    //     if (preNode != null && higherAddMap.get(index - 1)) {
    //         preNode.next = new ListNode(1);
    //     }
    //
    //     return headNode;
    // }

    /*
     * 使用数组代替HashMap标识进1，省去了HashMap定位时的哈希运算，提升运行效率
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean[] higherAddArray = new boolean[101];
        int index = 0;
        ListNode headNode;
        ListNode currNode = headNode = new ListNode(0);
        // 处理较短链表的长度计算
        while (l1 != null || l2 != null) {
            // 当前位对应节点求和
            int currTotal = 0;
            if (l1 != null) {
                currTotal += l1.val;
                // 后移
                l1 = l1.next;
            }
            if (l2 != null) {
                currTotal += l2.val;
                // 后移
                l2 = l2.next;
            }

            // 非头结点时，判断上一位是否进1
            if (index != 0 && higherAddArray[index - 1]) {
                currTotal++;
            }

            // 当前位对应节点是否进1标识
            higherAddArray[index] = currTotal >= 10;

            // 当前位对应节点val值
            currNode.next = new ListNode(currTotal % 10);
            currNode = currNode.next;
            index++;
        }

        // 处理最后一位是否进1
        if (higherAddArray[index - 1]) {
            currNode.next = new ListNode(1);
        }

        return headNode.next;
    }

    public static void main(String[] args) {
        LeetCode2 leetCode = new LeetCode2();

        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;

        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;
        ListNode result = leetCode.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
