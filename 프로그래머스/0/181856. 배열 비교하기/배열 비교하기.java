class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        int sumArr1 = 0;
        int sumArr2 = 0;
        if(arr1.length > arr2.length) {
            return 1;
        } else if (arr1.length < arr2.length) {
            return -1;
        } else {
            for(int i=0; i<arr1.length; i++) {
                sumArr1 += arr1[i];
                sumArr2 += arr2[i];
                System.out.println("sumArr1: " + sumArr1);
                System.out.println("sumArr2: " + sumArr2);
            }
            if(sumArr1 > sumArr2) {
                return 1;
            } else if (sumArr1 < sumArr2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}