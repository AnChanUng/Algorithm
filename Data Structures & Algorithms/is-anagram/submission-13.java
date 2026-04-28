class Solution {
    public boolean isAnagram(String s, String t) {
        // s와 t를 비교합니다.
        char[] arr = s.toCharArray();
        char[] res = t.toCharArray();

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
