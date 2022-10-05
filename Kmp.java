class KmpStringMatcher{
    static int[] createNext(String p){
        int i = 2;
        int j = 0;
        int[] next = new int[p.length()];
        next[0] = 0;
        next[1] = 0;
        while(i < p.length()){
            if(p.charAt(j) == p.charAt(i-1)){
                next[i++] = ++j;
            }else{
                if (j > 0)
                    j = next[j-1];
                else
                    next[++i] = i;
            }
        }
        return next;
    }


    static int match(String t, String p){
        int i = 0;
        int j = 0;
        int[] next = createNext(p);
        while(i < t.length()){
            if(t.charAt(i) == p.charAt(j)){
                if(j == p.length() - 1)
                    return i - p.length() + 1;
                i++; j++;
            }else{
                j = next[j];
                if (j == 0 && t.charAt(i) != p.charAt(0))
                    i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String testString = "0010010020001002012200";
        String testPattern = "00100201";
        System.out.println(match(testString, testPattern));
    }
}

