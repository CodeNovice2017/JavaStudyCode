package org.codechase.spring_source_code.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-26
 */
@Component
public class UserService {

    @Autowired
    IndexService indexService;

    public void getService(){
        System.out.println(indexService.say());
    }
}
