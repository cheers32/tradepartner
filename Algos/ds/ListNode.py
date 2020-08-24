# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def getList(inputArr):
    res = ListNode()
    node = res
    for n in inputArr:
        node.next = ListNode(n)
        node = node.next
    return res.next


def printList(node):
    while node is not None:
        print(node.val)
        node = node.next


if __name__ == "__main__":
    printList(getList([3, 4, 5]))
