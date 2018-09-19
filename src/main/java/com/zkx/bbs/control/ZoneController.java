package com.zkx.bbs.control;

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
 * 版块
 */
@Controller
@RequestMapping("v1/zone")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @RequestMapping("list")
    @ResponseBody
    public Result queryAllZoneList(Long userId) {
        if (CommonUtils.isIdNull(userId)) {
            throw new ErrorNoException(BBSErrorNo.PARAM_ERROR);
        }
        Result result = CommonUtils.generateSuccessResult();
        result.setData(zoneService.queryAllZoneList(userId));
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
        zoneService.saveZone(userId, zoneName, parentId);
        return result;
    }
}
