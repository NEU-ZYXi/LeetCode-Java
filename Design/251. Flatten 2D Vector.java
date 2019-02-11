
/*

Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.

Example:
Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
iterator.next(); // return 1
iterator.next(); // return 2
iterator.next(); // return 3
iterator.hasNext(); // return true
iterator.hasNext(); // return true
iterator.next(); // return 4
iterator.hasNext(); // return false

*/

/*

Solution 1: use two pointers to track the current element
O(1),O(n)

*/

class Vector2D {
    
    private int[][] v;
    private int row, col;

    public Vector2D(int[][] v) {
        this.v = v;
        this.row = 0;
        this.col = 0;
    }
    
    public int next() {
        int ans = v[row][col];
        if (col == v[row].length - 1) {
            row++;
            col = 0;
        } else col++;
        return ans;
    }
    
    public boolean hasNext() {
        while (row < v.length) {
            if (v[row].length == 0) row++;
            else break;
        }
        if (v.length == 0 || row >= v.length) return false;
        return true;
    }
}


/*

Solution 2: use two list iterators to indicate the list and sublist
O(1),O(n)

*/

class Vector2D {
    
    private Iterator<List<Integer>> list;
    private Iterator<Integer> subList;

    public Vector2D(int[][] v) {
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < v.length; ++i) {
            tmp.add(new ArrayList<>());
            for (int j = 0; j < v[i].length; ++j) tmp.get(i).add(v[i][j]);
        }
        this.list = tmp.iterator();
        while (this.list.hasNext()) {
            this.subList = this.list.next().iterator();
            if (this.subList.hasNext()) break;
        }
    }
    
    public int next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        int ans = subList.next();
        if (!subList.hasNext()) {
            while (list.hasNext()) {
                subList = list.next().iterator();
                if (subList.hasNext()) break;
            }
        }
        return ans;
    }
    
    public boolean hasNext() {
        return subList != null && subList.hasNext();
    }
}





