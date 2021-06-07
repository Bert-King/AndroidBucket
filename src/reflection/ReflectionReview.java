package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author bertking
 * @Package reflection
 * @Description: AndroidBucket
 * @date 2021/6/7-11:58 下午
 * @problem
 * @level 通过反射「Reflection」获取 Maybach 类的一些信息(属性，构造函数，方法)
 */
public class ReflectionReview {

    public static void main(String[] args) {
        // 构造函数私有化，导致无法创建对象
//        Maybach maybach = new Maybach();

        boolean b = getInstance() == getInstance2();
        System.out.println(b);


    }


    /**
     * 反射创建对象
     */
    public static Maybach getInstance() {
        try {
            /**
             *  通过Class.newInstance()创建对象。 另外newInstance()调用的是无参构造函数。（在java 9被废弃）
             */
            Maybach maybach = Maybach.class.newInstance();
            return maybach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    static Maybach getInstance2() {
        /**
         * getDeclaredConstructor() 从所有的构造函数中去匹配
         * getConstructor() 只会从public的构造函数中去匹配
         *
         * 注意这里用的是double.class，而不是Double.class
         */
        try {
            Constructor<Maybach> constructor = Maybach.class.getDeclaredConstructor(double.class);
            // 设置访问权限
            constructor.setAccessible(true);
            // 通过构造函数的newInstance()去获取对象
            Maybach maybach = constructor.newInstance(99999999.9);
            return maybach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过反射获取方法
     * @param maybach
     */
    static void getMethod(Maybach maybach){
        try {
            Method driveMethod = Maybach.class.getDeclaredMethod("drive");
            driveMethod.setAccessible(true);
            driveMethod.invoke(maybach);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void getFiled(Maybach maybach){
        try {
            Field branchField = Maybach.class.getDeclaredField("branch");
            branchField.setAccessible(true);
            String  branch = (String) branchField.get(maybach);
            System.out.println("品牌:"+branch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
