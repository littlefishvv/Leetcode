package Arrays;

public class Problem345 {
    //依旧是使用碰撞指针的思想
    public String reverseVowels(String s) {
        int n=s.length();
        if(n<=1) return s;
        char[] c=s.toCharArray();
        int l=0;
        int r=n-1;
        while(l<r){
//这样写太冗杂了  可以把aeiouAEIOU放到list中用contains来判断
            if((c[l]=='a'||c[l]=='e'||c[l]=='i'||c[l]=='o'||c[l]=='u'||c[l]=='A'||c[l]=='E'||c[l]=='I'||c[l]=='O'||c[l]=='U')&&
                    (c[r]=='a'||c[r]=='e'||c[r]=='i'||c[r]=='o'||c[r]=='u'||c[r]=='A'||c[r]=='E'||c[r]=='I'||c[r]=='O'||c[r]=='U')){
                char temp=c[r];
                c[r]=c[l];
                c[l]=temp;
                l++;
                r--;

            }
            if(!(c[l]=='a'||c[l]=='e'||c[l]=='i'||c[l]=='o'||c[l]=='u'||c[l]=='A'||c[l]=='E'||c[l]=='I'||c[l]=='O'||c[l]=='U')){
                l++;
            }
            if(!(c[r]=='a'||c[r]=='e'||c[r]=='i'||c[r]=='o'||c[r]=='u'||c[r]=='A'||c[r]=='E'||c[r]=='I'||c[r]=='O'||c[r]=='U')){
                r--;
            }

        }
        return String.valueOf(c);
    }
}
