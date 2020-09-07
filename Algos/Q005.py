# 这个题按照我的做法，并没有permformance的问题，我觉得很直观
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        res = ""
        maxRes = ""
        for i in range(len(s)):
            s1 = self.expand(s, i, i)
            s2 = self.expand(s, i, i+1)
            res = s1 if len(s1) > len(s2) else s2
            maxRes = res if len(res) > len(maxRes) else maxRes
        return maxRes

    def expand(self, s, left, right):
        resLeft = -1
        resRight = -1
        while left>=0 and right<len(s) and s[left] == s[right]:
            resLeft = left
            resRight = right
            left -= 1
            right += 1
        if resLeft != -1 and resRight != -1:
            return s[resLeft: resRight+1]
        return ""


print(Solution().longestPalindrome("babad"))
print(Solution().longestPalindrome("cbbd"))


