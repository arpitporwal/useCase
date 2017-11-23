package practice;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    
    int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    
    String pairs = getPairsOfAtoB_BtoA(input);
    
    power(142, 149);
    System.out.println(0L/0.0);
  }
    
  private static void power(int a, int b)
  {
	  System.out.println(Math.pow(a,b));
	  System.out.println(Math.pow(b,a));
	  System.out.println(Math.pow(a,b) == Math.pow(b,a));
  }
  static String getPairsOfAtoB_BtoA(int[] input){
   
    long temp1 = 0;
    long temp2 = 0;
    StringBuilder result = new StringBuilder();
    for (long i = 0;i<150L;i++){
    
      temp1 = i;
      for(long j=i+1; j<150L;j++){
        
        temp2 = j;
        
        double pow1 = Math.pow(temp1,temp2);
        double pow2 = Math.pow(temp2,temp1);
        
        if(pow1 == pow2){
        	System.out.println("("+temp1+","+temp2+")");
        
        }
      
      }
    
    }
    return result.toString();
  }
  
}