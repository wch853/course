package impl

import (
	"fmt"
	"context"
)

type MessageServiceImpl struct {
}

func (c *MessageServiceImpl) SendSMSMessage(ctx context.Context, mobile string, message string) (r bool, err error) {
	fmt.Printf("send to %s, message: %s\n", mobile, message)
	return true, nil
}

func (c *MessageServiceImpl) SendEmailMessage(ctx context.Context, email string, message string) (r bool, err error) {
	fmt.Printf("send to %s, message: %s\n", email, message)
	return true, nil
}
