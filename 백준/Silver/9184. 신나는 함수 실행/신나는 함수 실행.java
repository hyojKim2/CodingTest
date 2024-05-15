import java.util.Scanner;

public class Main {

	
	static int [][][]dp = new int[21][21][21];
	
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        while(true) {

            int a= sc.nextInt();
            int b= sc.nextInt();
            int c= sc.nextInt();
            
        	if(a==-1 && b==-1 && c==-1)
        		break;
        	System.out.printf("w(%d, %d, %d) = %d\n", a, b, c,doW(a,b,c));
        	
        }
        
    }
    

    static int doW(int x, int y, int z) {
    	//x=y=z인경우는, 2의 x제곱이다. 
    	if( checkDomain(x, y, z ) && dp[x][y][z]!=0) {
    		return dp[x][y][z];
    	}
    	
    	if( x<=0 || y<=0 || z<=0) {
    		return 1;
    	}
    	
    	if( x>20 || y>20 || z >20) {
    		return dp[20][20][20]= doW(20, 20, 20);  //doW(20,20,20)함수부터 실행후, dp[20][20][20]에 저장하여,dp[20][20][20]값 리턴 
    	}
    	
    	if( x< y && y< z) { 
    		return dp[x][y][z]= doW(x, y, z-1) + doW(x, y-1, z-1) - doW(x, y-1, z);
    	}
    	
    	return dp[x][y][z]=doW(x-1, y, z) + doW(x-1, y-1, z)+ doW(x-1, y, z-1) - doW(x-1, y-1, z-1) ;
    }
    
    static boolean checkDomain(int a, int b, int c) { //a, b, c 중 하나 이상 음수때 공간할당안하도록
		return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20; 
    }
    
    
}
