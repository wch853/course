namespace java com.wch.course.thrift.service

include 'user_model.thrift'

typedef i32 INT
typedef user_model.UserInfo UserInfo

/**
 * 用户信息服务
 */
service IUserService {

    /**
     * 通过用户编号查询用户信息
     */
    UserInfo queryUserById(1: INT id);

    /**
     * 通过用户名查询用户信息
     */
    UserInfo queryUserByName(1: string username);

    /**
     * 新增用户
     */
    void addUser(1: UserInfo userInfo);
}