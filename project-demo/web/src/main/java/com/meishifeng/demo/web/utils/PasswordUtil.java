package com.meishifeng.demo.web.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.util.Scanner;

/**
 * <ul>
 * <li>阿里Druid连接池数据库密码加解密工具</li>
 * <li>User:meishifeng Date:2017/1/5 Time:17:32</li>
 * </ul>
 */
public class PasswordUtil {

    public static void main(String[] args) throws Exception {
        //密码明文
        System.out.println("请输入需要加密的密码：");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        System.out.println("密码[ "+password+" ]的加密信息如下：\n");
//        String [] keyPair = ConfigTools.genKeyPair(512);
        //私钥
//        String privateKey = keyPair[0];
        //公钥
//        String publicKey = keyPair[1];
        //用私钥加密后的密文
//        password = ConfigTools.encrypt(privateKey, password);
//        System.out.println("privateKey:"+privateKey);
//        System.out.println("publicKey:"+publicKey);
        password = ConfigTools.encrypt(password);
        System.out.println("password:"+password);
//        String decryptPassword = ConfigTools.decrypt(publicKey, password);
//        System.out.println("decryptPassword：" + decryptPassword);
    }

}
