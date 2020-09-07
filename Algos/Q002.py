from Algos.ds.ListNode import ListNode, getList, printList


def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    res = ListNode()
    node = res
    carry = 0
    while l1 is not None or l2 is not None:  #这个题我最开始是and的逻辑，结果最后的carry走不通，要注意
        n1 = l1.val if l1 is not None else 0
        n2 = l2.val if l2 is not None else 0
        sum = n1 + n2 + carry
        node.next = ListNode(sum % 10)
        carry = sum // 10
        if l1 is not None:
            l1 = l1.next
        if l2 is not None:
            l2 = l2.next
        node = node.next
    if carry == 1:
        node.next = ListNode(1)
    return res.next


def test1():
    l1 = getList([3,9,5,2])
    l2 = getList([1,1,1])
    printList(addTwoNumbers(l1, l2))


def test2():
    l1 = getList([5])
    l2 = getList([5])
    printList(addTwoNumbers(l1, l2))

def test3():
    l1 = getList([9,8])
    l2 = getList([1])
    printList(addTwoNumbers(l1, l2))

test3()