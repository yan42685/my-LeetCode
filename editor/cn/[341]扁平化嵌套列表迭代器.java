
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> deque;

    public NestedIterator(List<NestedInteger> list) {
        deque = new LinkedList<>(list);
    }

    @Override
    public boolean hasNext() {
        NestedInteger first = deque.peekFirst();
        if (first == null) {
            return false;
        } else if (first.isInteger()) {
            return true;
        } else {
            deque.pollFirst();
            for (int i = first.getList().size() - 1; i >= 0; i--) {
                deque.offerFirst(first.getList().get(i));
            }
            return hasNext();
        }
    }

    @Override
    public Integer next() {
        return deque.pollFirst().getInteger();
    }

}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
