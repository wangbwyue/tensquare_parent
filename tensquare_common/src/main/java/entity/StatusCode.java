package entity;

/**
 * @描述 常量类（用于定以返回状态码）
 *  在java代码中，对常量的描述，通常有以下几种方式：（1男2女）
 *  1、常量类：
 *  2、枚举类：可以用来描述一组常量：比如星期
 *  3、数据字典：用数据库存储这些常量，适用于大型项目，一般会初始化的缓存中，使用时从缓存读取
 * @创建人 wangyue
 * @创建时间2019/6/129:26
 */

public class StatusCode {

    public static final int OK=20000;//成功
    public static final int ERROR =20001;//失败
    public static final int LOGINERROR =20002;//用户名或密码错误
    public static final int ACCESSERROR =20003;//权限不足
    public static final int REMOTEERROR =20004;//远程调用失败
    public static final int REPERROR =20005;//重复操作
}
