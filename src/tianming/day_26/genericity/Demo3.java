package tianming.day_26.genericity;

/**
 * @program: Stage1
 * @description: 泛型接口
 * @author: 邓造坚
 * @create: 2021-07-08 16:35
 **/
public class Demo3 {
}
interface F<T>{
    T get();
}

class S implements F{

    //默认Object类型
    @Override
    public Object get() {
        return null;
    }
}
class S2 implements F<String>{

    @Override
    public String get() {
        return null;
    }
}
class S3<T> implements F<T>{

    @Override
    public T get() {
        return null;
    }
}