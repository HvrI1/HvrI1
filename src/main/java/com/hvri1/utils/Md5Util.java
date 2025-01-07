package com.hvri1.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {
    //定义一个字符数组hexDigits，用于存储16进制数字字符。
    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    //定义一个MessageDigest类型的变量messagedigest，用于存储MD5加密算法。
    protected static MessageDigest messagedigest = null;
    //使用static关键字初始化messagedigstm,如果在类外部调用getMD5String方法，会直接使用已初始化的messagedigst。
    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            System.err.println(Md5Util.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            nsaex.printStackTrace();
        }
    }
    //定义一个getMD5String方法，接收一个字符串参数，并将其转换为字节数组，然后调用getMD5String(byte[])方法生成MD5字符串。
    public static String getMD5String(String s) {
        return getMD5String(s.getBytes());
    }
    //定义一个checkPassword方法，接收两个字符串参数，分别是用户输入的密码和数据库中存储的MD5密码字符串。
    public static boolean checkPassword(String password, String md5PwdStr) {
        //调用getMD5String方法生成输入密码的MD5字符串，然后比较生成的字符串和数据库中存储的字符串是否相等。
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }
    //定义一个getMD5String(byte[])方法，接收一个字节数组参数
    public static String getMD5String(byte[] bytes) {
        //调用messagedigest.update(bytes)方法更新加密算法
        messagedigest.update(bytes);
        //调用并返回messagedigest.digest()方法生成MD5哈希值，最后调用bufferToHex方法将哈希值转换为16进制字符串。
        return bufferToHex(messagedigest.digest());
    }
    //定义一个bufferToHex方法，接收两个参数，分别是字节数组和起始索引，用于将字节数组转换为16进制字符串。
    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }
    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }
    //定义一个appendHexPair方法，接收两个参数，分别是字节值和StringBuffer对象
    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        //将字节值转换为16进制字符串并append到StringBuffer对象中。
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }
}
