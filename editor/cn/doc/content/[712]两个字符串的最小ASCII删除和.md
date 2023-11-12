<p>给定两个字符串<code>s1</code>&nbsp;和&nbsp;<code>s2</code>，返回 <em>使两个字符串相等所需删除字符的&nbsp;<strong>ASCII&nbsp;</strong>值的最小和&nbsp;</em>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> s1 = "sea", s2 = "eat"
<strong>输出:</strong> 231
<strong>解释:</strong> 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> s1 = "delete", s2 = "leet"
<strong>输出:</strong> 403
<strong>解释:</strong> 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>0 &lt;= s1.length, s2.length &lt;= 1000</code></li> 
 <li><code>s1</code>&nbsp;和&nbsp;<code>s2</code>&nbsp;由小写英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字符串 | 动态规划</details><br>

<div>👍 358, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=minimum-ascii-delete-sum-for-two-strings" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这题本质上是考察最长公共子序列问题的解法，把 [1143. 最长公共子序列问题](/problems/longest-common-subsequence) 的解法代码稍微改一下就 OK 了。

**详细题解：[经典动态规划：最长公共子序列](https://labuladong.github.io/article/fname.html?fname=LCS)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    // 备忘录
    int memo[1001][1001];

    /* 主函数 */
    int minimumDeleteSum(string s1, string s2) {
        int m = s1.size(), n = s2.size();
        // 备忘录值为 -1 代表未曾计算
        memset(memo, -1, sizeof(memo));
        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(string s1, int i, string s2, int j) {
        int res = 0;
        // base case
        if (i == s1.size()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.size(); j++)
                res += s2[j];
            return res;
        }
        if (j == s2.size()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.size(); i++)
                res += s1[i];
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1[i] == s2[j]) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = min(
                    s1[i] + dp(s1, i + 1, s2, j),
                    s2[j] + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        m, n = len(s1), len(s2)
        # 备忘录值为 -1 代表未曾计算
        memo = [[-1] * n for _ in range(m)]

        def dp(i: int, j: int) -> int:
            res = 0
            # base case
            if i == m:
                # 如果 s1 到头了，那么 s2 剩下的都得删除
                for k in range(j, n):
                    res += ord(s2[k])
                return res
            if j == n:
                # 如果 s2 到头了，那么 s1 剩下的都得删除
                for k in range(i, m):
                    res += ord(s1[k])
                return res

            if memo[i][j] != -1:
                return memo[i][j]

            if s1[i] == s2[j]:
                # s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
                memo[i][j] = dp(i + 1, j + 1)
            else:
                # s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
                memo[i][j] = min(
                    ord(s1[i]) + dp(i + 1, j),
                    ord(s2[j]) + dp(i, j + 1)
                )
            return memo[i][j]

        return dp(0, 0)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {

    // 备忘录
    int memo[][];

    /* 主函数 */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    int dp(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func minimumDeleteSum(s1 string, s2 string) int {
    m, n := len(s1), len(s2)
    // 备忘录值为 -1 代表未曾计算
    memo := make([][]int, m)
    for i := range memo {
        memo[i] = make([]int, n)
        for j := range memo[i] {
            memo[i][j] = -1
        }
    }

    var dp func(s1 string, i int, s2 string, j int) int
    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    dp = func(s1 string, i int, s2 string, j int) int {
        res := 0
        // base case
        if i == len(s1) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for ; j < len(s2); j++ {
                res += int(s2[j])
            }
            return res
        }
        if j == len(s2) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for ; i < len(s1); i++ {
                res += int(s1[i])
            }
            return res
        }

        if memo[i][j] != -1 {
            return memo[i][j]
        }

        if s1[i] == s2[j] {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1)
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = min(
                int(s1[i]) + dp(s1, i + 1, s2, j),
                int(s2[j]) + dp(s1, i, s2, j + 1),
            )
        }
        return memo[i][j]
    }

    return dp(s1, 0, s2, 0)
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var minimumDeleteSum = function(s1, s2) {
    var m = s1.length, n = s2.length;
    // memo[i][j] 存储将s1[i...]和s2[j...]删除成相同字符串的最小ASCII码之和
    var memo = new Array(m);
    for(var i=0; i<memo.length; i++) memo[i] = new Array(n).fill(-1);

    // dp函数定义，计算删除成相同字符所需的最小ASCII码之和
    function dp(i, j) {
        var res = 0;
        // 如果 s1 到头了，那么 s2 剩下的都得删除
        if (i == s1.length) {
            for (; j < s2.length; j++)
                res += s2.charCodeAt(j);
            return res;
        }
        // 如果 s2 到头了，那么 s1 剩下的都得删除
        if (j == s2.length) {
            for (; i < s1.length; i++)
                res += s1.charCodeAt(i);
            return res;
        }

        // 如果memo数组已有记录则直接返回
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 如果s1[i]和s2[j]都在LCS中，则不需要删除
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(i + 1, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，需要删掉一个
            memo[i][j] = Math.min(
                    s1.charCodeAt(i) + dp(i + 1, j),
                    s2.charCodeAt(j) + dp(i, j + 1)
            );
        }
        return memo[i][j];
    }

    // 返回将s1和s2删除成相同字符串的最小ASCII码之和
    return dp(0, 0);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_minimum-ascii-delete-sum-for-two-strings" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-ascii-delete-sum-for-two-strings"></div></div>
</details><hr /><br />

**类似题目**：
  - [1143. 最长公共子序列 🟠](/problems/longest-common-subsequence)
  - [583. 两个字符串的删除操作 🟠](/problems/delete-operation-for-two-strings)
  - [剑指 Offer II 095. 最长公共子序列 🟠](/problems/qJnOS7)

</details>
</div>

