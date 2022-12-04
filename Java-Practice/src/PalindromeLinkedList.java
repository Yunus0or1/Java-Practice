class ListNode {
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

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            if(fast.next == null){
                break;
            }else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }

        ListNode half1 = slow.next;
        ListNode half2 = slow;

        while(half1.next !=null){
            ListNode tmp = half1.next;
            half1.next = half1;
            
        }

        System.out.println(slow.val);
        return false;
    }

    public static void main(String[] args){
        ListNode root = new ListNode(1);
        // root.next = new ListNode(2);
        // root.next.next = new ListNode(3);
        // root.next.next.next = new ListNode(4);
        // root.next.next.next.next = new ListNode(1);

        // ListNode root = new ListNode(1);
        // root.next = new ListNode(2);
        // root.next.next = new ListNode(2);
        // root.next.next.next = new ListNode(1);

        new PalindromeLinkedList().isPalindrome(root);
    }
}