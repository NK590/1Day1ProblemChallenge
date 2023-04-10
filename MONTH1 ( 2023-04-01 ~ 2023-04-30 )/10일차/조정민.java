// 프로그래머스 - 스킬트리

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Loop1 : for(String skill_name : skill_trees) {
            int result = 0;
            
            for(int i = 0; i < skill.length(); i++) {
                int n = skill_name.indexOf(skill.substring(i, i + 1));
                
                if(n != -1) {
                    if(result == -1 || result > n) {
                        continue Loop1;
                    }
                }
                
                result = n;
            }
            
            answer++;
        }
        
        return answer;
    }
}
