def lengthOfLongestSubstring(s: str) -> int:
    map = {}  # char -> idx
    idx = 0
    start = 0
    maxLen = 0
    for c in s:
        if c not in map:
            map[c] = idx
        else:
            start = max(start, map[c]+1)  # this is important step, abba example, the start cannot be less than current start
            map[c] = idx
        len = idx-start+1
        maxLen = max(len, maxLen)
        idx += 1
    return maxLen


#print(lengthOfLongestSubstring("abcbef"))
#print(lengthOfLongestSubstring("abcabcbb"))
print(lengthOfLongestSubstring("abba"))

# another way is 26n, was my original, use a map to count, when c in set, remove from start, until no dup then to expand, not very efficient
