package com.dcrtv.dcrtvbackend.common.response;

/**
 * 统一的返回对象
 * <p>
 * 用于封装统一格式的API响应结果，包含状态码、消息和数据三部分。
 * 使用record定义，确保不可变性。
 *
 * @param code    状态码
 * @param message 消息描述
 * @param data    响应数据
 * @param <T>     数据类型泛型
 */
public record R<T>(Integer code, String message, T data) {
    /**
     * 创建一个表示成功的响应对象
     *
     * @param rCodeMsgEnum 响应状态码和消息的枚举对象
     * @param data         响应数据
     * @param <T>          响应数据的类型
     * @return 包含指定状态码、消息和数据的成功响应对象
     */
    public static <T> R<T> success(RCodeMsgEnum rCodeMsgEnum, T data) {
        return new R<>(rCodeMsgEnum.getCode(), rCodeMsgEnum.getMessage(), data);
    }
}
