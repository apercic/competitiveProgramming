import java.util.PriorityQueue;

/**
 * Solution to https://leetcode.com/problems/merge-k-sorted-lists/
 * with PriorityQueue
 */
class Solut {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val < b.val ? -1 : 1);

        for (int i = 0; i < lists.length; i++) {
            ListNode arr = lists[i];
            while (arr != null) {
                minHeap.add(arr);
                arr = arr.next;
            }
        }
        ListNode output = new ListNode(0);
        ListNode finalOutput = output;

        while (!minHeap.isEmpty()) {
            output.next = minHeap.poll();
            output = output.next;
        }
        output.next = null;
        return finalOutput.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode b = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode c = new ListNode(2, new ListNode(6, null));

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = a;
        listNodes[1] = b;
        listNodes[2] = c;
        mergeKLists(listNodes);
    }
}