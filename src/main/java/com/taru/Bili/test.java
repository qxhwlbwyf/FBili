package com.taru.Bili;

import com.taru.Bili.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        String resources="mybatis-config.xml";
        //读取配置文件
        InputStream is = Resources.getResourceAsStream(resources);
        //初始化mybatis，创建SqlSessionFactory类实例
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建Session实例
        SqlSession session = sqlSessionFactory.openSession();

        List<User> list=session.selectList("com.taru.Bili.dao.IUserDao.selectUser","zxc");
        System.out.println(list);

        //提交事务
//        session.commit();
        //关闭Session
        session.close();
    }
}
