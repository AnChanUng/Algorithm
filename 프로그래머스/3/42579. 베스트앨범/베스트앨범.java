import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>(); // genres, 플레이횟수 2개까지만 저장
        
        // 1.장르별 총 재생수 집계
        for(int i=0; i<genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                map.put(genres[i], plays[i]);
            } else {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
            }
        }
        
        // 2.장르별 곡 목록 저장
        Map<String, List<int[]>> song = new HashMap<>(); // [재생수, 고유번호]
        for(int i=0; i<genres.length; i++) {
            if(!song.containsKey(genres[i])) {
                song.put(genres[i], new ArrayList<>());
            }
            song.get(genres[i]).add(new int[]{plays[i], i});
        }
        
        // 3.장르를 총 재생수 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(map.keySet());
        sortedGenres.sort((a, b) -> map.get(b)-map.get(a));
        
        // 4.장르에서 재생수 내림차순 2곡 뽑기
        for(String genre : sortedGenres) {
            List<int[]> songs = song.get(genre);
            songs.sort((a, b) -> Integer.compare(b[0], a[0]));
            for(int i=0; i<Math.min(2, songs.size()); i++) {
                answer.add(songs.get(i)[1]);
            }
        }
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}