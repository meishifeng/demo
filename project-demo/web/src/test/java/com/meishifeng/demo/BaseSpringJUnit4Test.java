package com.meishifeng.demo;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * <ul>
 * <li>测试类父类</li>
 * <li>
     说明：
        使用spring的测试框架需要加入以下依赖包：JUnit 4 （官方下载：http://www.junit.org/）
        Spring Test （Spring框架中的test包）
        Spring 相关其他依赖包（不再赘述了，就是context等包）
 * </li>
 * <li>User:meishifeng Date:2018/06/23 Time:16:02</li>
 * </ul>
 */
@RunWith(SpringJUnit4ClassRunner.class)     //使用junit4进行测试
@WebAppConfiguration    //测试环境使用，用来表示测试环境使用的ApplicationContext将是WebApplicationContext类型的；value指定web应用的根，它的属性指定的是Web资源的位置,默认为 src/main/webapp
@ContextConfiguration(locations = "classpath:spring/spring-context.xml")    //加载配置文件
@Transactional  //这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)    //这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！
public abstract class BaseSpringJUnit4Test extends TestCase {

}
