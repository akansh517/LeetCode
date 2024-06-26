class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // MSB -> 2^(n-1)
        int score = (int) Math.pow(2, n - 1) * m;

        for (int j = 1; j < n; j++) {
            int countSameBits = 0; // count of 1s
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == grid[i][0]) {
                    countSameBits++;
                }
            }

            int countOnes = countSameBits;
            int countZeros = m - countOnes;

            int ones = Math.max(countOnes, countZeros);

            score += (int) Math.pow(2, n - j - 1) * ones;
        }

        return score;
    }
}


// (Without Modifying the input)
//T.C : O(m*n)
//S.C : O(1)

class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Set first column value in each row
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                // Flip that row
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j]; // Flipping
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int countZero = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 0) {
                    countZero++;
                }
            }
            int countOne = m - countZero;
            if (countZero > countOne) {
                // Flipping that column
                for (int i = 0; i < m; i++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }

        int score = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j] * (int) Math.pow(2, n - j - 1);
                score += value;
            }
        }

        return score;
    }
}

//(Modifying the input)
//T.C : O(m*n)
//S.C : O(1)