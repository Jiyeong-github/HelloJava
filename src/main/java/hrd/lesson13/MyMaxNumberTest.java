package hrd.lesson13;

public class MyMaxNumberTest {
    public static void main(String[] args){
        //인터페이스 이름 선언하기
        MyMaxNumber maxNum = (x,y) -> {return (x>=y)?x:y;};
        //반환문이 하나인 경우 return과 {} 생략 가능
        int max = maxNum.getMax(10,20);
        System.out.println(max);
    }
}
