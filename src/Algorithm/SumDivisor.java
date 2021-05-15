package Algorithm;

public class SumDivisor {
    // programmers 12928 약수의 합
    public int sumDivisor(int num) {
        int answer = 0;
        for(int i = 1; i<= num ; i++){
            // 나머지 0이면 약수다. 하나씩 더해주기
            if(num % i ==0){
                answer += i;
            }
        }
        return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        SumDivisor c = new SumDivisor();
        System.out.println(c.sumDivisor(12));
    }
}
