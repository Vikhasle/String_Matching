class KarpRabin{
    // number of chars
    static int k = 256;

    static int match(String t, String p, int q){
        int m = p.length();
        int c = (int)Math.pow(k, m - 1) % q;
        int pq = 0;
        int tq = 0;
        for(int i = 0; i < m; i++){
            pq = (k*pq + p.charAt(i)) % q;
            tq = (k*tq + t.charAt(i)) % q;
        }
        for(int i = 0; i <= t.length() - m; i++){
            if (tq == pq && t.substring(i, i + m).equals(p))
                return i;
            if (i < t.length() - m){
                tq = (k*(tq - t.charAt(i) * c) + t.charAt(i + m)) % q;
                if (tq < 0)
                    tq += q;

            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String testPattern = "TEST";
        String testString = "1234TEST1234";
        System.out.println(match(testString, testPattern, 101));
    }
}

