package com.wjc.demo.common.interceptor;

import com.wjc.demo.common.utils.ServletRequestIPUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName: demo
 * @Package: com.wjc.demo.common.interceptor
 * @ClassName: DingTalkInterceptor
 * @Description: java类作用描述
 * @Author: wangjc
 * @CreateDate: 2020/1/9 0009 14:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/9 0009 14:25
 * @UpdateRemark: 更新内容
 * @Version: 1.0
 */
@Slf4j
public class DingTalkInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        // 从请求头中获取 Gateway Token
        String ipAddr = ServletRequestIPUtil.getIpAddr(request);
        log.info("服务请求ip为: {}", ipAddr);
        return true;
    }
}
