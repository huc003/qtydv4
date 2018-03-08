package com.qtyd.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.spi.NumberFormatProvider;
import java.util.*;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @author Administrator
 */
public final class CommonUtils {

    private static Random rand = null;

    private static SecureRandom secureRand = null;

    private static String localhost = "";

    private static Snowflake snow = new Snowflake(1);

    private static String CARD_ID_KEY = "QTYD@)!%";

    static {
        secureRand = new SecureRandom();
        rand = new Random(secureRand.nextLong());
    }

    public static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement stackTraceElement = (new Throwable()).getStackTrace()[1];
        stringBuffer.append("(");
        stringBuffer.append("className:").append(
                stackTraceElement.getClassName());
        stringBuffer.append(";fieldName:").append(
                stackTraceElement.getFileName());
        stringBuffer.append(";methodName:").append(
                stackTraceElement.getMethodName());
        stringBuffer.append(";lineNumber:").append(
                stackTraceElement.getLineNumber());
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static String getTraceInfo(Throwable e) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        stringBuffer.append("(");
        stringBuffer.append("className:").append(
                stackTraceElement.getClassName());
        stringBuffer.append(";fieldName:").append(
                stackTraceElement.getFileName());
        stringBuffer.append(";methodName:").append(
                stackTraceElement.getMethodName());
        stringBuffer.append(";lineNumber:").append(
                stackTraceElement.getLineNumber());
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /**
     * 获得随机数
     *
     * @param accuracy
     * @return
     */
    public static int getRandom(int accuracy) {
        return (int) (Math.random() * accuracy);
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getRandom() {

        String str = MD5.md5(getUUID() + System.currentTimeMillis()
                + getRandom(999999999) + rand.nextLong() + localhost);
        str = str.toLowerCase();
        /*
         * String date = (new Date()).getTime()+""; String str
         * =TimeUtils.getSysTimeLong
         * ().substring(2)+MD5Utils.md5(""+getRandom(999999999)).substring(8,
         * 16)+date+(new Random()).nextInt(10); if(str.length()>32){ str =
         * str.substring(0,32); }
         */
        return str;
    }

    public static String getRandom(String string) {
        String str = MD5.md5(getUUID() + System.currentTimeMillis()
                + getRandom(999999999) + rand.nextLong() + localhost + string);
        str = str.toLowerCase();
        return str;
    }

    public static String encodeBase64String(String data) {
        return Base64.encode(data.getBytes()).trim();
    }

    public static String hiddenMobile(String mobile) {
        if (ValidatorUtils.isNull(mobile) || mobile.length() < 11) {
            return mobile;
        }
        return mobile.substring(0, 3) + "******" + mobile.substring(9, 11);
    }

    public static String hiddenNickName(String nickName) {
        if (ValidatorUtils.isNull(nickName)) {
            return nickName;
        }
        if (nickName.length() < 7) {
            return nickName.substring(0, 1) + "****";
        }
        return nickName.substring(0, 1) + "****"
                + nickName.substring(nickName.length() - 1, nickName.length());
    }

    /**
     * 用于生成红包编号字符串
     */
    public static final String REWARD_NUMBER_RANDOM = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";

    /**
     * 获取红包编号
     *
     * @return
     */
    public static String getRewardNo() {
        Random random = new Random();
        StringBuffer result = new StringBuffer("QTYD");
        for (int i = 0; i < 10; i++) {
            result.append(REWARD_NUMBER_RANDOM.charAt(random.nextInt(34)));
        }
        return result.toString();
    }

    /**
     * 登录密码处理
     *
     * @param password
     * @return
     */
    public static String loginPwd(String password) {
        return MD5.md5("@)!%" + password + ")!!$");
    }

    /**
     * 支付密码处理
     *
     * @param password
     * @return
     */
    public static String payPwd(String password) {
        return MD5.md5("@)$!" + password + "^&*()");
    }

    /**
     * 短信验证码
     *
     * @return
     */
    public static String smsCode() {
        StringBuffer rand = new StringBuffer("");
        while (rand.toString().length() < 6) {
            rand.append((new Random()).nextInt(10));
        }
        return rand.toString();
    }

    /**
     * 获得新浪用户ID
     *
     * @param uid
     * @return
     */
    public static String sinaUID(Long uid) {
        String rand = "";
        while (rand.length() < 5) {
            rand = rand + (new Random()).nextInt(10);
        }
        int userIdLen = 4;
        String userId = uid + "";
        while (userId.length() < userIdLen) {
            userId = "0" + userId;
        }
        if (userId.length() > userIdLen) {
            userId = userId.substring(0, userIdLen);
        }
        return "QTYD" + TimeUtils.getSysdateInt().substring(2) + rand + userId
                + (new Random()).nextInt(10);
    }

    /**
     * 获得16位的记录编号
     * 年月日，时分秒 12位+毫秒 3位+随机1位
     *
     * @return
     */
    public static String getRecordNo() {
        String date = (new Date()).getTime() + "";
        //毫秒 3位
        date = date.substring(date.length() - 3);
        return TimeUtils.getSysTimeLong().substring(2) + date
                + (new Random()).nextInt(10);
    }

    public static final long getOrderNo() {
        return snow.next();
    }

    public static String getDesKey() {
        String md5 = MD5.md5((new Date()).getTime() + "");
        return md5.substring(8, 16).toUpperCase();
    }

    public static String encodeCardId(String cardId) {
        //qtyd2015
        return DesUtils.encrypt(cardId, CARD_ID_KEY);
    }

    public static String decodeCardId(String cardId) throws Exception {
        return DesUtils.decrypt(cardId, CARD_ID_KEY);
    }

    public static String birthday(String cardId) {
        if (cardId.length() == 18) {
            return cardId.substring(6, 10) + "-" + cardId.substring(10, 12)
                    + "-" + cardId.substring(12, 14);
        }
        return "";
    }

    public static String encodeBankAccount(String bankAccount) {
        return DesUtils.encrypt(bankAccount, "%!*^%#QT");
    }

    public static String decodeBankAccount(String bankAccount) throws Exception {
        return DesUtils.decrypt(bankAccount, "%!*^%#QT");
    }

    public static String encodeUserToken(String redisKey) {
        return DesUtils.encrypt(redisKey, "!@)#!&#&");
    }

    public static String decodeUserToken(String redisKey) throws Exception {
        return DesUtils.decrypt(redisKey, "!@)#!&#&");
    }

    public static String encodeJDBC(String value) {
        return DesUtils.encrypt(value, "wNjQ3ODg");
    }

    public static Map<String, String> pageInfo(int currentPage, int pageSize,
                                               int totalRows) {
        int totalPage = 1;
        if (totalRows > 0) {
            totalPage = (totalRows % pageSize == 0) ? (totalRows / pageSize)
                    : ((totalRows / pageSize) + 1);
        }
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        Map<String, String> result = new LinkedHashMap<String, String>();
        result.put("total_count", totalRows + "");
        result.put("total_page", totalPage + "");
        result.put("page_size", pageSize + "");
        result.put("current_page", currentPage + "");
        return result;
    }

    /**
     * 给集合中间嵌入一层
     *
     * @param dbResult 集合
     * @param key      嵌入名称
     * @return
     */
    public static List<Map<String, Object>> convertDataMapToApiMap(
            List<Map<String, Object>> dbResult, String key) {
        if (dbResult == null) {
            return null;
        }
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        Map<String, Object> obj = null;
        for (Map<String, Object> map : dbResult) {
            obj = new HashMap<String, Object>();
            obj.put(key, map);
            result.add(obj);
        }
        return result;
    }

    /**
     * 给集合移除嵌入的一层
     *
     * @param dbResult 集合
     * @param key      嵌入名称
     * @return
     */
    public static List<Map<String, Object>> removeNesting(
            List<Map<String, Object>> dbResult, String key) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        if (ValidatorUtils.isEmpty(dbResult)) {
            return list;
        }
        for (Map<String, Object> map : dbResult) {
            @SuppressWarnings("unchecked")
            Map<String, Object> result = (Map<String, Object>) map.get(key);
            list.add(result);
        }
        return list;
    }

    public static int howOld(String cardId) {
        if (cardId == null || "".equals(cardId)) {
            return 0;
        }
        int len = cardId.length();
        if (len == 18) {
            cardId = cardId.substring(6, 14);
        } else if (len == 15) {
            cardId = "19" + cardId.substring(6, 12);
        }
        String oldYear = cardId.substring(0, 4);
        String md = cardId.substring(4, 8);
        String now = TimeUtils.getSysdateInt();
        String nowYear = now.substring(0, 4);
        String nmd = now.substring(4, 8);
        int age = Integer.parseInt(nowYear) - Integer.parseInt(oldYear);
        if (md.compareTo(nmd) > 0) {
            age = age - 1;
        }
        return age;
    }

    public static String round(String value, int digits) {
        return round(Double.valueOf(value), digits);
    }

    public static String round(double value, int digits) {
        return String.format("%." + digits + "f", value);
        /*
         * BigDecimal bg = new BigDecimal(value); double result =
         * bg.setScale(digits, BigDecimal.ROUND_HALF_UP).doubleValue();
         * java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
         * nf.setGroupingUsed(false); nf.setMinimumFractionDigits(digits);
         * return nf.format(result);
         */
    }

    public static String roundDown(double value, int digits) {
        BigDecimal bg = new BigDecimal(value);
        double result = bg.setScale(digits, BigDecimal.ROUND_DOWN)
                .doubleValue();
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMinimumFractionDigits(digits);
        return nf.format(result);
    }

    public static double add(double v1, double v2) {
        String tp = round(v1, 2);
        String tp2 = round(v2, 2);
        double result = Double.valueOf(tp) + Double.valueOf(tp2);
        return Double.valueOf(CommonUtils.round(result, 2));
    }

    public static double add(double v1, double v2, double v3) {
        double result = v1 + v2 + v3;
        return Double.valueOf(CommonUtils.round(result, 2));
    }

    public static double add(String v1, String v2) {
        double result = Double.valueOf(v1) + Double.valueOf(v2);
        return Double.valueOf(CommonUtils.round(result, 2));
    }

    public static double sub(double v1, double v2) {
        String tp = round(v1, 2);
        String tp2 = round(v2, 2);
        double result = Double.valueOf(tp) - Double.valueOf(tp2);
        return Double.valueOf(CommonUtils.round(result, 2));
    }

    public static double sub(String v1, String v2) {
        double result = Double.valueOf(v1) - Double.valueOf(v2);
        return Double.valueOf(CommonUtils.round(result, 2));
    }

    public static int getWordLength(String str) {
        str = StringUtils.nullToStrTrim(str);
        return str.replaceAll("[^\\x00-\\xff]", "**").length();
    }

    public static int getRealLength(String str) {

        return getRealLength(str, "UTF-8");
    }

    /**
     * 获得标的期数
     *
     * @param borrowName  标全名
     * @param bracketsFlg 新的标题是否需要携带左右括弧
     */
    public static String getBorrowTitle(String borrowName, boolean bracketsFlg) {
        if (borrowName.indexOf("【") > 0) {
            int end = borrowName.length();
            if (borrowName.indexOf("】") > 0) {
                end = borrowName.indexOf("】");
            }
            borrowName = borrowName.substring(borrowName.indexOf("【") + 1, end);
        }
        if (bracketsFlg) {
            borrowName = "【" + borrowName + "】";
        }
        return borrowName;
    }

    public static int getRealLength(String str, String charsetName) {
        str = StringUtils.nullToStrTrim(str);
        if (ValidatorUtils.isNull(str)) {
            return 0;
        }
        try {
            return str.getBytes(charsetName).length;
        } catch (UnsupportedEncodingException e) {
            return 0;
        }
    }
    
    /**
     * 隐藏字符
     * @param str 字符串
     * @param start 前面显示几位
     * @param end 后面显示几位
     * @return
     */
    public static String hiddenStr(String str,int start,int end) {
        if (ValidatorUtils.isNull(str)) {
            return str;
        }
        return str.substring(0,start)+"******"+str.substring(str.length()-end, str.length());
    }
    
    public static void main(String[] args) throws Exception {
//        String cardId = "5d1af519e8c9fb7dc4269c0a2002496bb337063281e2daf5";
//        System.out.println(decodeCardId(cardId));
        
//        System.out.println(hiddenStr("杭州祺天优贷互联网金融服务有限公司",2,2));
    }
}