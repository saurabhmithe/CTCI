package LinkedLists;

public class SumLists {

    public LinkedList sumLists(LinkedList.Node head1, LinkedList.Node head2) {
        LinkedList sumList = new LinkedList();
        LinkedList.Node runner1 = head1;
        LinkedList.Node runner2 = head2;

        int carry = 0;
        while (runner1 != null && runner2 != null) {
            int sum = runner1.data + runner2.data + carry;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else carry = 0;
            sumList.append(sum);
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        if (runner1 == null && runner2 == null) {
            if (carry == 1) sumList.append(carry);
        } else {
            if (runner1 != null) {
                sumMethod(sumList, runner1, carry);
            } else {
                sumMethod(sumList, runner2, carry);
            }
        }
        return sumList;
    }

    private void sumMethod(LinkedList sumList, LinkedList.Node runner, int carry) {
        while (runner != null) {
            int remSum = 0;
            remSum = runner.data + carry;
            if (remSum >= 10) {
                remSum = remSum % 10;
                carry = 1;
            } else carry = 0;
            sumList.append(remSum);
            runner = runner.next;
        }
        if (carry == 1) sumList.append(carry);
    }

    public static void main(String[] args) {
        LinkedList num1 = new LinkedList();
        num1.append(7);
        num1.append(1);
        num1.append(6);
        LinkedList num2 = new LinkedList();
        num2.append(5);
        num2.append(9);
        num2.append(7);
        num2.append(3);
        num2.append(8);

        SumLists sumLists = new SumLists();
        LinkedList.Node node = sumLists.sumLists(num1.getHead(), num2.getHead()).getHead();

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
