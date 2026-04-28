class Solution {
    public boolean isAnagram(String s, String t) {
        // s와 t를 비교합니다.
        char[] arr = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        char[] res = new char[t.length()];
        for(int i=0; i<t.length(); i++) {
            res[i] = t.charAt(i);
        }

        Arrays.sort(arr);
        Arrays.sort(res);

        if(arr.length == res.length) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i] != res[i]) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
