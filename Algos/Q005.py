# 这个题按照我的做法，并没有performance的问题，我觉得很直观
# 如果需要改进，那就返回两个index及len，而不是substring
class Solution:  # N^2，没有更快时间
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
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


# 这个改进版本使用index, 时间没有明显区别
class Solution2:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        maxLen = 0
        left = 0
        right = 0
        for i in range(len(s)):
            len1, l1, r1 = self.expand(s, i, i)
            len2, l2, r2 = self.expand(s, i, i+1)
            if len1 > maxLen:
                maxLen = len1
                left = l1
                right = r1
            if len2 > maxLen:
                maxLen = len2
                left = l2
                right = r2
        return s[left: right+1]

    def expand(self, s, left, right):
        resLeft = -1
        resRight = -1
        while left>=0 and right<len(s) and s[left] == s[right]:
            resLeft = left
            resRight = right
            left -= 1
            right += 1
        if resLeft == -1 and resRight == -1:
            return 0, resLeft, resRight
        else:
            return resRight-resLeft+1, resLeft, resRight


print(Solution2().longestPalindrome("babad"))
print(Solution2().longestPalindrome("cbbd"))


