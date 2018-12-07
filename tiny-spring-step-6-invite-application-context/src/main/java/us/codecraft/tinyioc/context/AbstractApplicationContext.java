package us.codecraft.tinyioc.context;

import us.codecraft.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @author yihua.huang@dianping.com
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 1.解析xml并保存到Map<String,BeanDefinition> registry中
     * 2.初始化BeanFactory并注册bean
     * @throws Exception
     */
    public void refresh() throws Exception{
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
