package com.voidx.service.impl;

import com.voidx.dao.TestDao;
import com.voidx.model.ZzZtestEntity;
import com.voidx.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;

    @Override
    public String query(){
        String result = "";

        List<ZzZtestEntity> list = testDao.query();

        for (ZzZtestEntity entity: list) {
            result += " " + entity.getAccountName() + " : \t" + entity.getPersonName() + "\n";
        }

        return result;
    }

}
