namespace java com.wch.course.domain.thrift

typedef i32 INT
typedef i64 LONG

/**
 * 用户信息
 */
struct UserInfo {

    /**
     * 用户编号
     */
    1: optional INT id,

    /**
     * 用户名
     */
    2: optional string username,

    /**
     * 密码
     */
    3: optional string password,

    /**
     * 真实姓名
     */
    4: optional string realName,

    /**
     * 手机号
     */
    5: optional LONG mobile,

    /**
     * 电子邮箱
     */
    6: optional string email
}