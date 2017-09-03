package com.zkx.bbs.controller;

import com.zkx.bbs.entity.Result;
import com.zkx.bbs.exception.BBSErrorNo;
import com.zkx.bbs.exception.ErrorNoException;
import com.zkx.bbs.service.ZoneService;
import com.zkx.bbs.util.CommonUtils;
import com.zkx.bbs.util.LogHome;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 版块controller
 */
@Controller
@RequestMapping("v1/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @RequestMapping("list")
    @ResponseBody
    public Result queryZoneList(Long userId) {
        Result result = CommonUtils.generateSuccessResult();
        // TODO: 2017/9/3
        result.setData(zoneService.queryZoneList(userId));
        return result;
    }

    @RequestMapping("new")
    @ResponseBody
    public Result saveZone(Long userId, String zoneName, Integer parentId) {
        if (CommonUtils.isIdNull(userId) || StringUtils.isBlank(zoneName)) {
            LogHome.getLog().error("保存版块，参数缺失，userId:" + userId + ", zoneName:" + zoneName + ", parentId:" + parentId);
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        result.setData(zoneService.saveZone(userId, zoneName, parentId));
        return result;
    }
}
