class Solution {
    public int strStr(String haystack, String needle) {
        int h=haystack.length();
        int n=needle.length();


        if(n == 0)return 0;

        int start=0;
        while(start<=h-n){
            int j=0;
            while(j<n && haystack.charAt(start+j)== needle.charAt(j)){
                j++;
            }
            if(j==n){
                return start;
            }
            start++;
        }
    return -1;
    }
}