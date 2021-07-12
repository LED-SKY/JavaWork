package mystudydemo.day_23.Demo;

import mystudydemo.day_23.anno.DBconfig;

import java.sql.Connection;

/**
 * @program: Stage1
 * @description:
 * @author: 邓造坚
 * @create: 2021-07-05 14:35
 **/
public class DButil {
    //获取数据库连接
    @DBconfig(host = "localhost", user = "root", password = "123456", dbName = "test")
    public static Connection getConnection(){
        return null;
    }
}
