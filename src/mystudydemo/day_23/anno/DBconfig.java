package mystudydemo.day_23.anno;

public @interface DBconfig {
    //定义数据库的配置属性
    int port() default 3306;
    String host();
    String user();
    String password();
    String dbName();
}
