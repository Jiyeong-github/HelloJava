package hrd.lesson13;

public class TestString {
    public static void main(String[] args){
        StringConcatImpl impl = new StringConcatImpl();

        impl.stringConcat("hello", "java");

        //함수형 인터페이스로 익명 함수를 만들어 메서드를 호출할 수 있음
        StringConcat lambdaImpl = (s1, s2)-> System.out.println(s1+" "+s2);
        lambdaImpl.stringConcat("hello","java");

        StringConcat innerImpl = new StringConcat() {
            @Override
            public void stringConcat(String s1, String s2) {
                System.out.println(s1+" "+s2);
            }
        };
        innerImpl.stringConcat("hello","java");
    }
}
