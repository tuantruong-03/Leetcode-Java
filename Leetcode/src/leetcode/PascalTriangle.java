package src.leetcode;

//	Main point: Write Pascal triangle
//	1 
//	1 1 
//	1 2 1
//	1 3 3 1
//	1 4 6 4 1
//	Check index of previous row if it is out of bounds

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> rowOne = new ArrayList<Integer>();
        rowOne.add(1);
        res.add(rowOne);
        if (numRows == 1) return res;
        for (int i = 1; i< numRows; ++i) {
        	List<Integer> currentRow = new ArrayList<Integer>();
        	List<Integer> rowBefore = res.get(i-1);
        	for (int j = 0; j < i+1; ++j ) {
        		// Check rowBefore[j], rowBefore[j-1] is out of bounds
        		int value1 = j >= 0 && j < i ? rowBefore.get(j) : 0;
        		int value2 = j - 1 >= 0 && j - 1 < i ? rowBefore.get(j-1) : 0;
        		int col = value1 + value2;
        		currentRow.add(col);
        	}
        	res.add(currentRow);
        }
        return res;
    }
}
