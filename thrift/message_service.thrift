namespace java com.wch.course.thrift.service
namespace go course.rpc.service

/**
 * 消息服务
 */
service IMessageService {

    /**
     * 发送短信
     */
    bool sendSMSMessage(1: string mobile, 2: string message);

    /**
     * 发送邮件
     */
    bool sendEmailMessage(1: string email, 2: string message);
}