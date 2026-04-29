class Solution {
    public String longestCommonPrefix(String[] strs) {
        String word = "";
        for(int i=0; i<strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            word += ch;
            for(int j=0; j<strs.length; j++) {
                if(strs[j].startsWith(word)) {
                    
                } else {
                    word = word.substring(0, word.length()-1);
                    break;
                }
            }    
        }
        return word;
    }
}