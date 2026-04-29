class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            sb.append(ch);
            for(int j=0; j<strs.length; j++) {
                if(!strs[j].startsWith(sb.toString())) {
                    sb.deleteCharAt(sb.length()-1);
                    break;
                }
            }    
        }
        return sb.toString();
    }
}