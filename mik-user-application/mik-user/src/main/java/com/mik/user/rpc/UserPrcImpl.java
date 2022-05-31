package com.mik.user.rpc;

import com.mik.user.api.UserRpc;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class UserPrcImpl implements UserRpc {
    @Override
    public String getUserByMobile(String mobile) {
        return null;
    }
}
