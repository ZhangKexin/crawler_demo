package com.zkx.bbs.aspect;

import com.zkx.bbs.common.BBSConstant;
import com.zkx.bbs.entity.Result;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.exception.UserException;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.LogHome;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {

    @Pointcut("execution(* com.aladdin..control.*.*(..))")
    public void logAll() {
    }

    /**
     * 切接口，当hxh.control中所有类的所有方法被执行时
     *
     * @param joinpoint
     */
    @Around("logAll()")
    public Object printLogAndAuthority(ProceedingJoinPoint joinpoint) {
        visitLog(joinpoint);
        return callAndLogDuration(joinpoint);
    }

    private void visitLog(ProceedingJoinPoint joinpoint) {
        StringBuilder sb = new StringBuilder();
        try {
            Signature signature = joinpoint.getSignature();
            signature.getDeclaringType();
            sb.append("接口访问[" + signature.getDeclaringTypeName() + "." + signature.getName() + "],参数[");
            for (Object ele : joinpoint.getArgs()) {
                sb.append(ele + ",");
            }
            if (joinpoint.getArgs().length > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("]");
            LogHome.getLog().info(sb.toString());
        } catch (Throwable t) {
            LogHome.getLog().error("切面调用出错", t);
        }
    }

    private Object callAndLogDuration(ProceedingJoinPoint joinpoint) {
        Signature signature = joinpoint.getSignature();
        try {
            long start = System.currentTimeMillis();
            Object obj = joinpoint.proceed();
            long end = System.currentTimeMillis();
            LogHome.getLog().info("接口访问[" + signature.getDeclaringTypeName() + "." + signature.getName() + "]结束,执行耗时["
                    + (end - start) + "]毫秒");
            return obj;
        } catch (UserException e) {
            LogHome.getLog().error("接口访问报错[" + signature.getDeclaringTypeName() + "." + signature.getName() + "]", e);
            Result result = CommonUtils.generateErrorResult(e.getMessage());
            return result;
        } catch (ErrorNoException e) {
            LogHome.getLog().error("接口访问报错[" + signature.getDeclaringTypeName() + "." + signature.getName() + "]", e);
            int errorNo = e.getErrorNo();
            Result result = CommonUtils.generateErrorResult(errorNo, BBSConstant.BBS_ERROR_NO.getName(errorNo));
            return result;
        } catch (Throwable t) {
            LogHome.getLog().error("接口访问报错[" + signature.getDeclaringTypeName() + "." + signature.getName() + "]", t);
            int errorNo = BBSErrorNo.SERVER_INTERNAL_ERROR;
            Result result = CommonUtils.generateErrorResult(errorNo, BBSConstant.BBS_ERROR_NO.getName(errorNo));
            return result;
        }
    }
}
