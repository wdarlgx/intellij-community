import java.util.ArrayList;
import java.util.List;

class Test {
  List<String> queue = new ArrayList<>();
}

class DD {
    P1<P<String>> l = new L<String>() {
        @Override
        void f() {
        }
    };

    P1<P<String>> l1 = new L<>();

    P1<P<String>> foo() {
        return new L<>();
    }

    String s = "";
}

class L<K> extends P1<P<K>> {
    void f() {
    }
}

class P1<P1T> extends P<P1T> {
}

class P<PT> {
}


class Test1 {
  void bar() {
    foo<error descr="'foo(F<F<java.lang.String>>)' in 'Test1' cannot be applied to '(FF<java.lang.Object>)'">(new FF<>())</error>;
  }

  void foo(F<F<String>> p) {}
}

class FF<X> extends F<X>{}
class F<T> {}

class MyTest {
     static class Foo<X> {
        Foo(X x) {}
     }

     static interface Base<Y> {}
     static class A extends Exception implements Base<String> {}
     static class B extends Exception implements Base<Integer> {}

     void m() throws B {
         try {
             if (true) {
                 throw new A();
             }
             else {
                 throw new B();
             }
         } catch (A ex) {
             Foo<? extends Base<String>> foo1 = new Foo<>(ex);  // ok
             <error descr="Incompatible types. Found: 'MyTest.Foo<MyTest.A>', required: 'MyTest.Foo<MyTest.Base<java.lang.String>>'">Foo<Base<String>> foo2 = new Foo<>(ex);</error>  // should be error
         }
     }
}
