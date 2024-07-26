import java.util.*;

class Solution {
    /*
    해시맵생성,
    장르명: int[5] 배열
    [0]: 장르의 총 재생수
    [1]: 수록곡1의 플레이수
    [2]: 수록곡1의 고유번호
    [3]: 수록곡2의 플레이수
    [4]: 수록곡2의 고유번호
    반복문에서, 곡을 해당 장르의 수록곡1, 2와 재생횟수를 비교하여 배열 갱신

    반복문종료: 최다재생수에 따라 고유번호 return


    */
    public int[] solution(String[] genres, int[] plays) {
        int[] answer ;

        HashMap<String, Integer[]> map =new HashMap<>();

        for(int i=0;i< genres.length; i++){

            if(!map.containsKey(genres[i])){//맵에 장르가 없으면 추가해줌
                Integer[] initialArray = new Integer[5];
                Arrays.fill(initialArray, 0); // 배열을 0으로 초기화
                map.put(genres[i], initialArray);

                map.get(genres[i])[1]=plays[i]; //플레이수
                map.get(genres[i])[2]=i; // 고유번호
            }

            //맵에 장르가 있고, 2번째 삽입인 경우
            else if(map.get(genres[i])[3]==null){

                map.get(genres[i])[3]=plays[i]; //플레이수
                map.get(genres[i])[4]=i; // 고유번호
            }

            //맵에 장르가 있고, 3번째 이상 비교
            else{
                int minPlay=0; //두 곡 중 더 작은 플레이수와 인덱스를 저장
                int minIdx=0;
                if(map.get(genres[i])[1]>map.get(genres[i])[3]){
                    minPlay=map.get(genres[i])[3];
                    minIdx=3;
                }
                else{
                    minPlay=map.get(genres[i])[1];
                    minIdx=1;
                }

                if(plays[i]> minPlay){ //현재 플레이수와 비교해서, 현재 플레이수가 더 크다면 갱신
                    map.get(genres[i])[minIdx]=plays[i];
                    map.get(genres[i])[minIdx+1]=i;
                }

            }

            map.get(genres[i])[0]+=plays[i]; //총 재생수 더해줌


        }

        List<Map.Entry<String, Integer[]>> list = new ArrayList<>(map.entrySet()); //키들을 리스트로 가져옴

        
          list.sort(new Comparator<Map.Entry<String, Integer[]>>() {
            @Override
            public int compare(Map.Entry<String, Integer[]> entry1, Map.Entry<String, Integer[]> entry2) {
                // 내림차순 정렬을 위해 비교 결과를 반전
                return entry2.getValue()[0].compareTo(entry1.getValue()[0]);
            }
        });
        
        
        ArrayList<Integer> arrayList =new ArrayList<>();
        
        for (Map.Entry<String, Integer[]> entry : list) {
            Integer[] array= entry.getValue();
            int min=4;
            int max=2; //먼저 출력할 인덱스 
            
            if(array[3]==0 ){ //하나의 곡만 들어있을 때
                arrayList.add(array[max]);
                continue;
            }
            
            if(array[1].equals(array[3])){ //플레이회수같다면 
                if(array[2]>array[4]){
                    min=2; max=4;
                }
            }
            else if(array[1]<array[3]){ // arary3이 더 크면
                min=2; max=4;
            }
            arrayList.add(array[max]);
            arrayList.add(array[min]);
        }
        
        answer=new int[arrayList.size()];
        int size=0;
        for(int temp:arrayList){
            answer[size++]=temp;
        }
        
        
        return answer;
    }

}