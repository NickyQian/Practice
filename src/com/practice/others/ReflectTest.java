package com.practice.others;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    private int data;

    public ReflectTest() {
    }

    public ReflectTest(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void increase() {
        data++;
    }

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IllegalArgumentException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    @SuppressWarnings({ "rawtypes", "unused" })
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalArgumentException, InstantiationException,
            IllegalAccessException, InvocationTargetException,
            SecurityException, NoSuchMethodException {
        // TODO Auto-generated method stub
        Children c = new Children();
        c.setData(10);
        c.decrease();
        System.out.println(c.getData());

        Class<?> s = Class.forName("com.practice.others.Children");
        Constructor[] cons = s.getConstructors();
        Constructor con = s.getConstructor(new Class[] { int.class });
        ReflectTest object = (ReflectTest) con.newInstance(20); // parse to
                                                                // ReflectTest,
                                                                // actually is
                                                                // class
                                                                // Children
        object.setData(10);
        object.increase();
        System.out.println(object.getData());

    }

}

class Children extends ReflectTest {
    public Children() {
    }

    public Children(int data) {
        super(data);
    }

    public void increase() {
        setData(getData() + 2);
    }

    public void decrease() {
        int data = getData();
        setData(--data);
    }
}
