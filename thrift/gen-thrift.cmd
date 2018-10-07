thrift.exe --gen go --out ../course-message/src message_service.thrift

thrift.exe --gen java --out ../course-interface/src/main/java message_service.thrift

thrift.exe --gen java --out ../course-interface/src/main/java user_model.thrift

thrift.exe --gen java --out ../course-interface/src/main/java user_service.thrift