
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 *
 * 모의고사
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 *
 * */

public class sangwoo {

    public static void main(String[] args) {


        int[] answers = {1,3,2,4,2};
        System.out.println(solution(answers));

    }

    public static int[] solution(int[] answers){
        int[] oneAnswers = {1, 2, 3, 4, 5};
        int[] twoAnswers = {2,1,2,3,2,4,2,5};
        int[] threeAnswers = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] result = {};


        int[] cnt = new int[3];

        Node oneNode = setList(oneAnswers);
        Node twoNode = setList(twoAnswers);
        Node threeNode = setList(threeAnswers);

        for(int answer : answers){

            if(oneNode.getN() == answer) cnt[0]++;
            if(twoNode.getN() == answer)  cnt[1]++;
            if(threeNode.getN() == answer) cnt[2]++;

            oneNode = oneNode.next();
            twoNode = twoNode.next();
            threeNode = threeNode.next();
        }

        int max = Math.max(cnt[0], cnt[1]);
        int max2 = Math.max(max,cnt[2]);


        List<Integer> resultList = new ArrayList<Integer>();
        for(int i = 0; i < cnt.length; i++){
            if(max2 == cnt[i]){
                resultList.add(i+1);
            }
        }
        result = resultList.stream().mapToInt(i -> i).toArray();


        return result;


    }

    public static Node setList(int[] arr){

        Node firstNode = null;

        Node thisNode = null;
        Node preNode = null;

        for(int i = 0; i < arr.length;i++){

            thisNode = new Node(arr[i]);

            if(i == 0){
                firstNode = thisNode;
            }

            if(preNode != null){
                preNode.setNetx(thisNode);
            }
            preNode = thisNode;

        }

        thisNode.setNetx(firstNode);

        return firstNode;
    }


    static class Node{

        private int n;

        private Node next;

        public Node(int n){
            this.n = n;
            this.next = null;
        }

        public void setNetx(Node node){
            this.next = node;
        }

        public Node next(){
            return this.next;
        }

        public int getN(){
            return this.n;
        }

    }

}
