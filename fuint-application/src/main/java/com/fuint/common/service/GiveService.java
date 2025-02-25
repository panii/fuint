package com.fuint.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fuint.common.dto.GiveDto;
import com.fuint.common.param.GiveParam;
import com.fuint.framework.exception.BusinessCheckException;
import com.fuint.framework.pagination.PaginationRequest;
import com.fuint.framework.pagination.PaginationResponse;
import com.fuint.framework.web.ResponseObject;
import com.fuint.repository.model.MtGive;
import com.fuint.repository.model.MtGiveItem;

import java.util.List;
import java.util.Map;

/**
 * 转赠业务接口
 *
 * Created by FSQ
 * CopyRight https://www.fuint.cn
 */
public interface GiveService extends IService<MtGive> {

    /**
     * 分页查询列表
     *
     * @param paginationRequest
     * @return
     */
    PaginationResponse<GiveDto> queryGiveListByPagination(PaginationRequest paginationRequest) throws BusinessCheckException;

    /**
     * 转赠卡券
     *
     * @param giveParam
     * @throws BusinessCheckException
     * @return
     */
    ResponseObject addGive(GiveParam giveParam) throws BusinessCheckException;

    /**
     * 根据组ID获取信息
     *
     * @param id ID
     * @throws BusinessCheckException
     * @return
     */
    MtGive queryGiveById(Long id) throws BusinessCheckException;

    /**
     * 根据条件搜索详情
     *
     * @param params
     * @throws BusinessCheckException
     * @return
     * */
    List<MtGiveItem> queryItemByParams(Map<String, Object> params) throws BusinessCheckException;
}
