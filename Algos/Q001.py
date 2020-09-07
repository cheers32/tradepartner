from typing import List


def twoSum(nums: List[int], target: int) -> List[int]:
    map = {}  # num->idx
    idx = 0
    for n in nums:
        diff = target-n
        if diff in map:
            return [idx, map[diff]]
        else:
            map[n] = idx
        idx += 1
    return []


print(twoSum([2,7,11,15],9))