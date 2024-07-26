import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 정보를 저장할 해시맵
        HashMap<String, GenreInfo> genreMap = new HashMap<>();
        
        // 장르별 곡 정보를 업데이트
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];
            
            genreMap.putIfAbsent(genre, new GenreInfo());
            GenreInfo info = genreMap.get(genre);
            
            info.totalPlayCount += playCount;
            info.addSong(playCount, i);
        }
        
        // 장르별 총 재생수에 따라 내림차순 정렬
        List<Map.Entry<String, GenreInfo>> genreList = new ArrayList<>(genreMap.entrySet());
        genreList.sort((e1, e2) -> Integer.compare(e2.getValue().totalPlayCount, e1.getValue().totalPlayCount));
        
        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        
        for (Map.Entry<String, GenreInfo> entry : genreList) {
            GenreInfo info = entry.getValue();
            result.addAll(info.getTopTwoSongs());
        }
        
        // 결과 리스트를 배열로 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 장르 정보를 저장할 클래스
    private static class GenreInfo {
        int totalPlayCount = 0;
        int[] songPlayCounts = new int[2];
        int[] songIndices = new int[2];
        
        void addSong(int playCount, int index) {
            if (songPlayCounts[0] < playCount) {
                songPlayCounts[1] = songPlayCounts[0];
                songIndices[1] = songIndices[0];
                songPlayCounts[0] = playCount;
                songIndices[0] = index;
            } else if (songPlayCounts[1] < playCount) {
                songPlayCounts[1] = playCount;
                songIndices[1] = index;
            }
        }
        
        List<Integer> getTopTwoSongs() {
            List<Integer> topSongs = new ArrayList<>();
            if (songPlayCounts[0] > 0) topSongs.add(songIndices[0]);
            if (songPlayCounts[1] > 0) topSongs.add(songIndices[1]);
            return topSongs;
        }
    }
}
