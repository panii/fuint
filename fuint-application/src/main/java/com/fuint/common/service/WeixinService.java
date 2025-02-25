package com.fuint.common.service;

import com.alibaba.fastjson.JSONObject;
import com.fuint.framework.exception.BusinessCheckException;
import com.fuint.framework.web.ResponseObject;
import com.fuint.repository.model.MtOrder;
import com.fuint.repository.model.MtUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Date;

/**
 * 微信相关业务接口
 *
 * Created by FSQ
 * CopyRight https://www.fuint.cn
 */
public interface WeixinService {

    /**
     * 获取微信登录token
     *
     * @param merchantId 商户ID
     * @param useCache 是否从缓存中读取
     * @return
     * */
    String getAccessToken(Integer merchantId, boolean useCache) throws BusinessCheckException ;

    /**
     * 提交预支付订单
     *
     * @param userInfo 会员信息
     * @param orderInfo 订单信息
     * @param payAmount 支付金额
     * @param authCode 支付二维码
     * @param giveAmount 赠送金额
     * @param ip 支付发起IP
     * @param platform 支付平台
     * @return
     * */
    ResponseObject createPrepayOrder(MtUser userInfo, MtOrder orderInfo, Integer payAmount, String authCode, Integer giveAmount, String ip, String platform) throws BusinessCheckException;

    /**
     * 处理返回的xml数据
     *
     * @param request 请求体
     * @return
     * */
    Map<String,String> processResXml(HttpServletRequest request);

    /**
     * 处理返回的xml数据
     *
     * @param response 返回相应
     * @param flag 标签
     * @return
     * */
    void processRespXml(HttpServletResponse response, boolean flag);

    /**
     * 获取微信个人信息
     *
     * @param merchantId 商户ID
     * @param code 登录编码
     * @return
     * */
    JSONObject getWxProfile(Integer merchantId, String code) throws BusinessCheckException;

    /**
     * 获取微信openId
     *
     * @param merchantId 商户ID
     * @param code 登录编码
     * @return
     * */
    JSONObject getWxOpenId(Integer merchantId, String code) throws BusinessCheckException;

    /**
     * 获取会员微信绑定的手机号
     *
     * @param encryptedData 加密的编码（前端返回）
     * @param sessionKey
     * @param iv
     * @return
     * */
    String getPhoneNumber(String encryptedData, String sessionKey, String iv);

    /**
     * 发送订阅消息
     *
     * @param merchantId 商户ID
     * @param userId 会员ID
     * @param toUserOpenId 会员openID
     * @param key 消息编码
     * @param page 跳转页面
     * @param params 发送参数
     * @param sendTime 发送时间
     * @return
     * */
    Boolean sendSubscribeMessage(Integer merchantId, Integer userId, String toUserOpenId, String key, String page, Map<String,Object> params, Date sendTime) throws BusinessCheckException;

    /**
     * 发送订阅消息
     *
     * @param merchantId 商户ID
     * @param reqDataJsonStr 发送参数
     * @return
     * */
    Boolean doSendSubscribeMessage(Integer merchantId, String reqDataJsonStr);

    /**
     * 查询支付订单
     *
     * @param storeId 店铺ID
     * @param transactionId 交易单号
     * @param orderSn 订单号
     * @return
     * */
    Map<String, String> queryPaidOrder(Integer storeId, String transactionId, String orderSn);

    /**
     * 发起售后
     *
     * @param storeId 店铺ID
     * @param orderSn 订单号
     * @param totalAmount 订单总金额
     * @param refundAmount 售后金额
     * @param platform 平台
     * @return
     * */
    Boolean doRefund(Integer storeId, String orderSn, BigDecimal totalAmount, BigDecimal refundAmount, String platform) throws BusinessCheckException;

    /**
     * 生成店铺二维码
     *
     * @param merchantId 商户ID
     * @param storeId 店铺ID
     * @param width 宽度
     * @return
     * */
    String createStoreQrCode(Integer merchantId, Integer storeId, Integer width);

}