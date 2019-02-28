package com.voidx.dao.impl;

import com.voidx.dao.TestDao;
import com.voidx.model.ZzZtestEntity;
import com.voidx.util.HibernateSessionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("testDao")
public class TestDaoImpl implements TestDao {
    private Session session;
    // 初始化
    public void initHibernateResources() {
        session = HibernateSessionUtil.openSession();
        session.beginTransaction();
    }

    // 關閉資源
    public void closeHibernateResources() {
        if(session != null) {
            session.getTransaction().commit();
            session.close();
        }
    }

    // 模板
    public String template() {
        String result = "1";
        try {
            initHibernateResources();

            session.createQuery("");
            session.save("");
            session.update("");
            session.delete("");

            closeHibernateResources();
        } catch (Exception e) {
            e.printStackTrace();
            result = "0";
        }

        return result;
    }

    @Override
    public List<ZzZtestEntity> query(){
        //String result = "1";
        List<ZzZtestEntity> result = null;

        try {
            initHibernateResources();

            result = session.createQuery("from ZzZtestEntity").list();
            //session.save("");
            //session.update("");
            //session.delete("");

            closeHibernateResources();
        } catch (Exception e) {
            e.printStackTrace();
            //result = "0";
        }

        return result;
    }
}
