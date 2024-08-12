package Graphs;
//733 -- Leetcode problem
/*
 * Flood Fill Algorithm
 * ==========================

 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of 
the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), 
and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

 

Example 1:


Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n


Approach
=========
   Base case
   ---------
   1. sr,sc -- invalid boundary (>0) or (<0)
   2. vis[sc,sr] == 1
   3.image[sr][sc] != orginal colour

   and then fill colour by

   1.left(sr,sc-1)
   2.right(sr,sc+1)
   3.up(sr-1,sc)
   4.down(sr+1,sc)
 * 
 */

 import java.util.*;
public class FloodFillAlgorithm {

    //O(m*n)
    public static void helper(int[][] image,int sr,int sc,int colour,boolean vis[][],int orgCol){
        if(sr < 0 || sc>0 || sr >= image.length || sc >= image[0].length 
        || vis[sr][sc] || image[sr][sc] != orgCol){
            return;
        }
        image[sr][sc] = colour;
        //left
        helper(image, sr, sc-1, colour, vis, orgCol);
        //right
        helper(image, sr, sc+1, colour, vis, orgCol);
        //up
        helper(image, sr-1, sc, colour, vis, orgCol);
        //down
        helper(image, sr+1, sc, colour, vis, orgCol);
    }
    public static int[][] floodfill(int[][] image,int sr,int sc,int colour){
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,colour,vis,image[sr][sc]);
        return image;
    }
    public static void main(String[] args) {
        int image[][] = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1,sc = 1,colour =2;
        System.out.println(floodfill(image, sr, sc, colour));
    }
}
