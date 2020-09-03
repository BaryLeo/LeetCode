# leetcode刷题笔记

## 刷题路线

### 基础

**要求：想都不用想就能写出来并且百分百无错误**

一维数组：快排，冒泡排序

二维数组：深度优先搜索，广度优先搜索

链表：遍历

二叉树：前序遍历，后序遍历，中序遍历，层序遍历

N叉树：深度优先搜索，广度优先搜索

### 基础刷题顺序

**刷题只是比面基础多了边界问题，但能难倒很多人，刷题按顺序来，建议多刷几遍，直到非常熟悉为止，刷一遍能掌握大部分基础了**

206->链表遍历以及反转

92->子链表反转

20->栈的使用（Java用双端队列作为栈使用效率更高），也可以用哈希解决

232->用队列实现栈

225->十分简单

703->使用优先队列（Java中的PriorityQueue）实现

239->滑动窗口，队列的使用

242->哈希实现，可以使用数组实现特殊的映射表，效率更高

1->经典的两数之和

15->三数之和，可以用哈希，可以用双指针

18->四数之和（可以升级到N数之和），这道题可以先放放，有精力就刷

98->树的中序遍历，加深对二叉搜索树的理解

235->搜索二叉树的后序遍历（不知道搜索二叉树的特点先去搜搜）

236->节点的公共祖先，仅仅是二叉树的后续遍历而已

50->递归遍历，以及溢出的巧妙处理

169->哈希枚举，二分查找，投票选举法

122->贪心算法

102>-树的层序遍历，广度优先搜索，深度优先搜索

104->深度优先搜索

111->深度优先搜索

22->简单剪枝，树的前序遍历

51，52->回溯算法+剪枝+广度优先遍历

36，37->剪枝+广度优先遍历

69->二分法，牛顿迭代法

208->实现一棵字典树

212->字典树+剪枝+回溯+二维数组的广度优先搜索

191->刷题中的位运算

### 进阶刷题顺序

#### 树的套路

要有一个框架的思想，看下面的代码

```java
//除此之外，还有迭代的代码
void traverse(TreeNode root) {
	// 前序遍历
	traverse(root.left)
	// 中序遍历
	traverse(root.right)
	// 后序遍历
}
```

无论是迭代还是递归，所有树的题目都是基于这个框架去写的，不信往下看一道hard题

leetcode124题：

```java
int ans = INT_MIN;
int oneSideMax(TreeNode* root) {
	if (root == nullptr) return 0;
	int left = max(0, oneSideMax(root->left));
	int right = max(0, oneSideMax(root->right));
	ans = max(ans, left + right + root->val);
	return max(left, right) + root->val;
}
```

其实也就是一个后续遍历嘛~再来一题

LeetCode 105 题，难度Medium，了解二叉树的特性，这道题就特容易啦，如果不了解，先掌握前序遍历，中序遍历，后续遍历的特点，核心代码：

```java
//用前序遍历生成二叉树
private TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        //判断数组是否已遍历完成
        if (pre==preorder.length){
            return null;
        }

        //判断是否已完成中序遍历
        if (inorder[in]==stop){
            in++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre++]);
        //完成先序遍历左子树
        root.left = buildTree(preorder,inorder,root.val);
        //中序遍历生成右子树
        root.right = buildTree(preorder,inorder,stop);
        return root;
}
```

其实就是前序+中序的结合体~

so，掌握好树的特点，不同树有不同的特点，然后就是遍历问题而已~~~~

#### 动态规划的套路

#### 回溯的套路

## src--leetcode题

​	92题----链表反转II，链表的遍历

​	206题----链表反转I，链表的遍历

​	130题----二维数组，广度优先搜索

​	133题---图的广度优先搜索，深度优先搜索

## base--基础

​	QuitSort----快排

## 算法

### 二分法

Offer11，Solution153，154

### 动态规划

322