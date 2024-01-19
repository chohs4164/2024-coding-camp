//10개의 도시와 인구수를 입력받고 찾고자 하는 도시를 입력하면 그 인구수가 출력되는 코드
import java.util.*;
public class seven {
    public static void main(String[] args){
        HashMap<String,Integer> CityMap = new HashMap<String,Integer>();

        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<10;i++){
            String city=scanner.next();
            scanner.nextLine();
            int population=scanner.nextInt();
            CityMap.put(city,population); //도시와 인구 입력받기
        }
        System.out.print("찾고 싶은 도시는?");
        String city1=scanner.next();
        int answer_population=CityMap.get(city1);
        System.out.println("인구수: "+answer_population);
    }
}
