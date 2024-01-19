//1번:난수 10개를 생성하여 출력하고 그 평균을 구하여 출력하는 코드
public class GetAverage {
   public static void main(String[] args){
      int rand[]=new int[10];
      int sum=0;
      for(int k=0;k<10;k++){
         rand[k]=(int)(Math.random()*100+100);
      }
      for(int a=0;a<10;a++){ //랜덤 수 출력
         System.out.print(rand[a]+" ");
      }
      System.out.println();
      for(int i=0;i<10;i++){
         sum+=rand[i];
      }
      int average=sum/rand.length;
      System.out.println(average);
   }
}

