package com.dcrtv.dcrtvbackend.service;

import com.dcrtv.dcrtvbackend.common.model.vo.req.RegisterReqVO;
import com.dcrtv.dcrtvbackend.common.model.vo.resp.RegisterRespVO;

public interface RegisterService {
    /**
     * 用户注册接口
     * @param registerReqVO
     * @return
     */
    RegisterRespVO register(RegisterReqVO registerReqVO);
}
