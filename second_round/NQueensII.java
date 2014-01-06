package second_round;

public class NQueensII {
	public static void main(String[] args) {		
		System.out.println(totalNQueens(12));
	}

    public static int totalNQueens(int n){
        int[] map = new int[n];
        return nQueensIIHelper(map, n, 0);
    }

    public static int nQueensIIHelper(int[] map, int n, int row){
        if(row >= n || n == 1)
            return 1;

        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            boolean valid = true;
            for(int j = 0; j < row; j++)
            {
                if(i == map[j] || Math.abs(i - map[j]) == row - j)
                {
                    valid = false;
                    break;
                }
            }
            if(valid)
            {
                map[row] = i;
                sum += nQueensIIHelper(map, n, row + 1);
            }
        }
        return sum;
    }
}
