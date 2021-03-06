package oj;

/**
 * @author ：Siyuan Gao
 * @date ：Created in 2021/3/3 10:21
 * @description：
 * @modified By：
 * @version: $
 */
//数学公式。输入三个数，实现(A^B)%C  也叫快速幂模算法
public class MathGs {
	//这是快速幂运算，当然可以了用chengfang类中的递归运算解决
	//计算模的公式
	/*
	* (A+B) \mod b = (A \mod b + B \mod b) \mod b
      (A×B) \mod b = ((A \mod b) × (B \mod b)) \mod b
    */
	static int quickPower(int a,int b,int m){
		int ans=1,base=a;

		while(b>0){
			//如果当前b的最后一位是1
			if((b & 1)==1){
				ans*=base;//把ans呈上对应的a^(2^n)
				ans%=m;

			}
			base*=base;
			base%=m;
			b>>=1;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(quickPower(10,9,6));
		System.out.println(myPow(10.0,9,6));
	}
	public static double myPow(double x, int n,int m) {
		if(n==0) return 1;
		if(n == 1) return x;

		if(n == -1) return 1/x;

		double half=myPow(x,n/2,m);
		double mod=myPow(x,n%2,m);
		return ((half%m)*(half%m)*(mod%m))%m;

	}
	//快速幂的非递归过程

	int myPower(int a, int b)//是求a的b次方
	{
		int ans = 1, base = a;//ans为答案，base为a^(2^n)
		while(b > 0)//b是一个变化的二进制数，如果还没有用完
		{  //以3的11次方为例，11对应二进制为1011 相当于3^1*3^2*3^8
			if((b & 1)==1)//&是位运算，b&1表示b在二进制下最后一位是不是1，如果是：
				ans *= base;//把ans乘上对应的a^(2^n)

			base *= base;//base自乘，由a^(2^n)变成a^(2^(n+1))
			b >>= 1;//位运算，b右移一位，如101变成10（把最右边的1移掉了），10010变成1001。现在b在二进制下最后一位是刚刚的倒数第二位。结合上面b & 1食用更佳
		}
		return ans;
	}







}
