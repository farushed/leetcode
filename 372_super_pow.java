// https://leetcode.com/problems/super-pow/
// Runtime: 5 ms, faster than 86.84%
// Memory Usage: 42.2 MB, less than 91.45%

class Solution {
    public int superPow(int a, int[] b) {
        int mod = 1337;
        
        int[] powers = new int[10];
        for (int i=0; i<=9; i++)
            powers[i] = modPow(a, i, mod);
        
        int result = powers[b[0]];
        for (int i=1; i<b.length; i++) {
            result = modPow(result, 10, mod);
            result *= powers[b[i]];
        }
        
        return result % mod;
    }
    
    public int modPow(int a, int b, int m) {
        if (b == 0)
            return 1;
        a %= m;
        if ((b & 1) == 1)
            return (a * modPow(a, b-1, m)) % m;
        return (modPow(a * a, b/2, m)) % m;
    }
}
