package hrd.lesson13;

class OutClass{
private InClass inClass;
private int num = 100;
private static int snum = 300;
    //내부클래스는 외부클래스의 레퍼런스를 가짐
    public OutClass(){
        inClass = new InClass();
        //외부 클래스의 생성자에서 주로 생성되는 내부 클래스
    }

    class InClass{//Instance Inner Class(인스턴스 내부 클래스)
        int inNum = 200;

        void inTest(){
            System.out.println(num);
            System.out.println(inNum);
            System.out.println(snum);
        }
    }
    //인스턴스 내부클래스는 주로 외부클래스가 생성될 때 함께 생성됨
    //내부클래스는 외부클래스의 모든 변수 사용 가능

    public void usingInMethod(){//호출하기
          inClass.inTest();
    }
}

public class InnerClassTest {
    public static void main(String[] args){
        OutClass outer = new OutClass();
        outer.usingInMethod();

        OutClass.InClass inClass = outer.new InClass();
        inClass.inTest();
        //클래스 내부에서만 사용하려는 클래스지만 외부에서도 생성은 가능
        //outer.new Inclass();로 외부클래스에서 내부클래스 생성 가능
        //private 클래스를 통해 외부클래스에서 내부클래스 생성 방지 가능
    }
}
