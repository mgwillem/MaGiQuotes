package org.magi.quotes.core.audit.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author <a href="mailto:mgw@mmx.lu">Marc Gabriel-Willem</a>
 */
public class ProfilerInterceptor
{
    private static final Logger logger = LoggerFactory.getLogger(ProfilerInterceptor.class);

    @Resource(name="PROFILER_ABNORMAL_EXECUTION_TIME")
    private final Long abnormalExecutionTime = 100L;

    @AroundInvoke
    public Object profile(InvocationContext context) throws Exception
    {
        long start = System.currentTimeMillis();
        Object result = context.proceed();

        long executionTime = System.currentTimeMillis() - start;
        if (executionTime > abnormalExecutionTime)
            logger.warn("Following method execution seems to be abnormally long (" + executionTime + " ms.): " + context.getMethod());

        return result;
    }
}
