
def twoSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    map = {}
    idx = 0
    for n in nums:
        if target-n in map:
            return [idx, map[target-n]]
        map[target-n] = idx
    return []

