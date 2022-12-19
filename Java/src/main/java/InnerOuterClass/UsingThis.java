package InnerOuterClass;

import lombok.ToString;

@ToString
public class UsingThis {

    public int outerField = 10;

    void instanceMethod() {

        String name = "mokk";

        class LocalClass{
            ;;
        }

    } // instanceMethod()


    // 클래스 블록 내부에서 선언된 클래스를 "중첩클래스"라고 하며
    // 이 중첩클래스는 두가지 종류로 구분됩니다.
    // 1. 멤버 클래스(Inner Class) : 바깥쪽 클래스의 클래스블록내에서 선언된 클래스
    // 2. 로컬 클래스(Local Class) : 바깥쪽 메소드의 블록내에서 선언된 클래스
    @ToString
    class Inner {
        int innerField = 20;

        void method() { // 매개변수로 사용할 시 (final String name)

            // 메소드의 매개변수, 지역변수 모두 메소드의 실행이 끝나면, 그 즉시 파괴됨
            // 모든 지역변수, 매개변수는 JVM Stack Area 영역에 보관
            // 다른메모리 영역으로 옮겨 "익명구현객체"의 생명주기보다 더 오래 살아남도록 하자 -> final 을 써서
            // 바로 final 키워드를 람다식이 사용하는 지역변수(매개변수)들에만 붙이자
            // -> JVM Method Area (Clazz 객체가 보관되는) 상수풀(Constant pool)에 보관
            // so, JVM 의 생명주기와 같게 만들어 버린다.
            // 컴파일러가 알아서 final 을 붙여준다.
            int age = 23; // 지역변수


            // 람다식이 생성한 "익명구현객체" 역시 Heap area 에 생성되는 객체임
            // 이 객체의 생명주기 : GC 될 때 파괴됨
            MyFunctionalInterface fi = () -> {

                System.out.println("2. This 는 자기를 가르키지 못하고 자기를 선언한 클래스의 주소 : " + this);
                System.out.println("\t + type : " + this.getClass().getName());

                // 가장 바깥쪽 클래스에 선언된 필드를 이름으로 직접 사용
                System.out.println("outerField" + outerField);
//                System.out.println("outerField" + UsingThis.this.outerField + "\n");
//
                // 멤버클래스에 선언된 필드를 이름으로 직접 사용
                System.out.println("innerField" + innerField);
//                System.out.println("innerField" + this.innerField + "\n");

                // 메소드 블록내에서 정의된 지역변수의 사용 -> 이것이 Closure 문제 발생시킴
                System.out.println("age : " + age);
                // 생명주기가 서로 다르기 떄문에 문제가 생긴다 = Closure
                // 해결방법 : age 의 생명주기를 같이 늘려버리자 ! 어떻게? final int age = 23;
                // final 는 메모리 영역에 있지 않고

            };// 람다식을 이용한 "익명구현객체"생성(타겟타입에 대한)

            System.out.println("1. fi에 들어있는 익명구현객체의 주소 : " + fi.getClass().getName());
            fi.method();

//            ---------------------------------------------------

            fi = new MyFunctionalInterface() {
                @Override
                public void method() {
                    System.out.println("3. this 는 자기자신을 가르킨다. : " + this);
                    // 일반적으로 알고있는 this 람다와는 다르다.
                }
            }; // 익명구현객체코딩기법을 이용한 "익명구현객체" 생성
            fi.method();


        }// method

    } // end class : Inner

} // end class : UsingThis
