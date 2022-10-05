import java.util.HashMap;

class BoyerMooreMatcher{
    static HashMap<Character, Integer> createShift(String p){
        HashMap<Character, Integer> shift = new HashMap<Character, Integer>();
        for(int i = 0; i < p.length() - 2; i++)
            shift.put(p.charAt(i), p.length() - i -1);
        return shift;
    }

    static int match(String t, String p){
        int i = 0;
        int j = p.length() - 1;
        HashMap<Character, Integer> shift = createShift(p);
        while(i < t.length()){
            if (p.charAt(j) == t.charAt(i + j)){
                if (j == 0)
                    return i;
                j--;
            }else{
                j = p.length() - 1;
                if (shift.get(t.charAt(i + j)) == null){
                    i += p.length() - 1;
                }else
                    i += shift.get(t.charAt(i + j));
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String testString = "BMmatcher_shift_character_example";
        String testPattern = "example";
        System.out.println(match(testString, testPattern));
    }
}

