
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean equationsPossible(String[] equations) {
        Unionfind uf = new Unionfind(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                uf.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (uf.isConnected(eq.charAt(0) - 'a', eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;

    }

    private class Unionfind {
        private int[] parent;

        public Unionfind(int size) {
            parent = new int[size];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            parent[findRoot(a)] = findRoot(b);
        }

        public int findRoot(int a) {
            if (parent[a] != a) {
                parent[a] = findRoot(parent[a]);
            }
            return parent[a];
        }

        public boolean isConnected(int a, int b) {
            return findRoot(a) == findRoot(b);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
