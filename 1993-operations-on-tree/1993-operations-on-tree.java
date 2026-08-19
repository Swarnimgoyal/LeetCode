class LockingTree {

    int[] parent;
    int[] lockedby;
    List<Integer>[] child;

    public LockingTree(int[] parent) {

        this.parent = parent;

        int n = parent.length;

        lockedby = new int[n];

        child = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }

        // Start from 1 because parent[0] = -1
        for (int i = 1; i < n; i++) {
            child[parent[i]].add(i);
        }
    }

    public boolean lock(int num, int user) {

        if (lockedby[num] != 0) {
            return false;
        }

        lockedby[num] = user;

        return true;
    }

    public boolean unlock(int num, int user) {

        if (lockedby[num] != user) {
            return false;
        }

        lockedby[num] = 0;

        return true;
    }

    public boolean upgrade(int num, int user) {

        // 1. Node itself must be unlocked
        if (lockedby[num] != 0) {
            return false;
        }

        // 2. No locked ancestor
        int a = parent[num];

        while (a != -1) {

            if (lockedby[a] != 0) {
                return false;
            }

            a = parent[a];
        }

        // 3. Find and unlock locked descendants
        boolean f = unlockDescendants(num);

        // No locked descendant
        if (!f) {
            return false;
        }

        // Lock current node
        lockedby[num] = user;

        return true;
    }

    private boolean unlockDescendants(int num) {

        boolean found = false;

        for (int childs : child[num]) {

            if (lockedby[childs] != 0) {
                lockedby[childs] = 0;
                found = true;
            }

            if (unlockDescendants(childs)) {
                found = true;
            }
        }

        return found;
    }
}