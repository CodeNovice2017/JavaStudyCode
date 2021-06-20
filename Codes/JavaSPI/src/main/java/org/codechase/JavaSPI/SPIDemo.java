package org.codechase.JavaSPI;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-20
 */
public class SPIDemo {

    public static void main(String[] args) {
        ServiceLoader<CodeChaseInterface> serviceLoader = ServiceLoader.load(CodeChaseInterface.class);
        Iterator<CodeChaseInterface> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            CodeChaseInterface codeChaseInterface = iterator.next();
            codeChaseInterface.say();
        }
    }
}
