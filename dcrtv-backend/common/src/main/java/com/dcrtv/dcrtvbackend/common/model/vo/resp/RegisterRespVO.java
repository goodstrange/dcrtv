package com.dcrtv.dcrtvbackend.common.model.vo.resp;

/**
 * 用户注册的响应实体类
 * @author: chz
 * @param user_id: 用户id
 * @param account: 账号（可以是手机号也可以是邮箱）
 * @param account_type: 明确返回的账号类型：mobile/email
 */
public record RegisterRespVO(Integer user_id, String account, String account_type) {

}
