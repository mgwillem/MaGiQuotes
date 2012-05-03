package org.magi.quotes.core.audit.control;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;

/**
 * @author MGW
 */
public class ProfilerInterceptor
{
    @Resource(name="PROFILER_ABNORMAL_EXECUTION_TIME")
    private final Long abnormalExecutionTime = 100L;

    @Inject @Slf4j
    private Logger logger;

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
