package us.codecraft.tinyioc.aop;

import org.junit.Assert;
import org.junit.Test;
import us.codecraft.tinyioc.HelloWorldService;
import us.codecraft.tinyioc.HelloWorldServiceImpl;

/**
 * @author yihua.huang@dianping.com
 */
public class AspectJExpressionPointcutTest {
    /**
     * 测试是否能拦截到方法
     * @throws Exception
     */
    @Test
    public void testClassFilter() throws Exception {
        /**
         * 这样写应该就可以了，这是us.codecraft.tinyioc包下所有的类的所有方法。
         * 第一个*代表所有的返回值类型
         * 第二个*代表所有的类
         * 第三个*代表类所有方法
         * 最后一个..代表所有的参数。
         */
        String expression = "execution(* us.codecraft.tinyioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* us.codecraft.tinyioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
