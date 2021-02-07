public class DynamicProgramming {
    static int max(int a, int b){
        return ( a > b ) ? a : b;
    }
    static int Knapsack(int W, int wt[], int val[], int n) {
        int i, w;
        int[] K[] = new int[n + 1][W + 1];
        
        for(i = 0; i <= n; i++){
            for(w = 0; w <= W; w++) {
                if (i ==0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else 
                    K[i][w] = K[i -1][w];
            }                
        }
        return K[n][W];
    }
    public static void main(String[] args) {
        int val[] = new int[] {28, 16, 14, 7};
        int wt[] = new int [] {5, 3, 2 ,1};
        int W = 5;
        int n = val.length;
        System.out.println("Keuntungan Terbesar Menjadi : " +Knapsack(W, wt, val, n));
    }    
}
