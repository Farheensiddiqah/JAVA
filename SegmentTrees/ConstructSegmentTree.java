package SegmentTrees;
/*
 * Constructing Segment Tree
 * ==========================
 *--> As we know that we take normal size of segment tree = 4*n
 *--> It is also similar to heaps concept only
 *--> Here also we will 1D array and assume logic using trees 
 * -->Create size of = 4*n
 * 
 * 
 *                   36(0,7)
                     /   \
                    /     \
             10(0,3)        26(4,7)
                /  \        /      \
         (0,,1)3  7(2,3)   11(4,5)  15(6,7)
           /  \    / \      / \       / \
         0     1   2  3     4  5      6  7
 * 
 *   1D array  will be
 *  36  10  26  3  7  11  15  1  2  3  4  5  6  7  8  
 *  0   1   2   3  4  5  6    7  8  9  10 11 12 13 14....32
 * 
 * tree[] = 4*n
 * buildBst(arr,i,start,end)
 *    mid = (st+end)/2
 *    buildBst(arr,2*i+1,st,mid)
 *    buildBst(arr,2*i+2,mid+1,end)
 * 
 *          ith index
 *           /    \
 *  left index    right index
 *  (2*i+1)        (2*i+2)
 * 
 * 
 * Query on Segment Tree
 * =======================
 * Sum of numbers in a range
 * 
 * --> Given from above segment tree arr
 *   1 2   3  4  5  6  7  8
 *       i=2       j=5
 *        |---------|   
 *            |
 *            v
 *           sum? = 18
 * 
 * ==> From the segment tree also to find 
 * eg: 26 (from i = 4 to j=7)
 * and given to find sum from i=2 to j=5
 * 
 * ==>These includes 3 cases
 * CASE = 1
 * --------
 * (Non overlapping)
 * (qj <= si) or (qi>=sj) 
 * just not include
 * return 0
 * 
 * CASE 2
 * -------
 * Complete Overlapping
 * (si >= qi  &&  sj <= qj)
 * include tree[i] 
 * 
 * case 3 : partial overlaping
 * ----------------------
 * divide it by mid
 * mid = (si+sj)/2
 * 
 * UPDATE ON Segment Trees
 * ========================
 * Update at an index idx
 * 
 * ==>EG=
 *  1 2   3  4 5 6 7 8 
 *       i=2
 * 
 * idx = 2
 *    newVal=2
 *    oldVal=3
 *    diff = newVal-OldVal
 *    diff = 2-3 =-1
 *   -->Update in all the overlapping indexes
 * 

 * 
 */
public class ConstructSegmentTree {
    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    //TC === O(n)
    public static int buildST(int arr[],int i,int start,int end){ 
        //Base case
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        buildST(arr, 2*i+1, start, mid); //left subtree - 2*i+1
        buildST(arr, 2*i+2, mid+1, end); //right subtree - 2*i+2
        tree[i] = tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }

    //Query on ST ---Tc==O(logn)
    public static int getSumQueryUtil(int i,int si,int sj,int qi,int qj){
        if(qj <= si || qi >= sj){  //non overlapping
            return 0;
        }else if(si >= qi && sj <= qj){ //complete overlapping
            return tree[i];
        } else {
            //partial overlapping
            int mid = (si+sj)/2;
            int left = getSumQueryUtil(2*i+1, si, mid, qi, qj);
            int right = getSumQueryUtil(2*i+2, mid+1, sj, qi, qj);
            return left+right;
        }
    }
    public static int getSumQuery(int arr[],int qi,int qj){
        int n =arr.length;
        return getSumQueryUtil(0, 0, n-1, qi, qj);
    }


    //Update
    //Upadate at an index idx --O(logn)
    public static void updateUtil(int i,int si,int sj,int idx,int diff){
        if(idx > sj || idx < si){
            return;
        }
        tree[i] += diff;
        if(si != sj){ //non-leaf
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff); //left
            updateUtil(2*i+2, mid+1, sj, idx, diff); //right
        }
    }
    public static void update(int arr[],int idx,int newVal){
        int n =arr.length;
        //Update the oldVal
        int diff = newVal - arr[idx];
        arr[idx] = newVal;

        updateUtil(0, 0, n-1, idx, diff); //segment Tree updation
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buildST(arr, 0, 0, n-1);

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
        System.out.println("Query on ST");
        System.out.println(getSumQuery(arr,2,5));
        System.out.println("Update");
        update(arr,2,2);
        System.out.println(getSumQuery(arr, 2, 5));
    }
}
