package ListNode;

public class ReverseList {
    /**
     * 方法一：逐个将旧链表的节点插入到新链表
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {
        ListNode new_head = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = new_head;
            new_head = tmp;
        }
        return new_head;
    }

    /**
     * 方法二：使用三指针遍历
     * @param head
     * @return
     */
    public ListNode reverseList02(ListNode head) {
        if (head == null) return head;
        ListNode p0 = null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != null) {
            p1.next = p0;
            p0 = p1;
            p1 = p2;
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        return p0;
    }

    /**
     * 方法三：递归，这个就有点妙了
     * @param head
     * @return
     */
    public ListNode reverseList03(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode p = reverseList03(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
