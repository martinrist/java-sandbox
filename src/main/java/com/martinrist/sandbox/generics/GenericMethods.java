package com.martinrist.sandbox.generics;

public class GenericMethods {

    public static void main(String[] args) {

        GenericMethods q = new GenericMethods();

        Derived1 d1 = q.findBaseAsType(1);
        // Prints 'In Derived.derivedMethod()
        d1.derivedMethod();

        // This will work because the compiler knows that findBaseAsType is at
        // least a Base
        // Prints 'In Derived1.baseMethod()
        q.findBaseAsType(1).baseMethod();

        // This won't compile because the compiler can't know that
        // q.findBaseAsType(1) is a Derived1
        // q.findBaseAsType(1).derivedMethod();

        // However, we can give enough information by specifying the
        // type parameter before the method name
        // Prints 'In Derived1.derivedMethod()
        q.<Derived1>findBaseAsType(1).derivedMethod();
    }

    public <T extends Base> T findBaseAsType(int id)
    {
        if (id == 1) {
            return (T) new Derived1();
        } else {
            return (T) new Derived2();
        }
    }

}


class Base {
    public void baseMethod() {
        System.out.println("In Base.baseMethod()");
    }
}

class Derived1 extends Base {
    @Override
    public void baseMethod() {
        System.out.println("In Derived1.baseMethod()");
    }

    public void derivedMethod() {
        System.out.println("In Derived1.derivedMethod()");
    }
}

class Derived2 extends Base {
    @Override
    public void baseMethod() {
        System.out.println("In Derived2.baseMethod()");
    }

    public void derivedMethod() {
        System.out.println("In Derived2.derivedMethod()");
    }
}


