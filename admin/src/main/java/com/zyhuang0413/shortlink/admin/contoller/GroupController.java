package com.zyhuang0413.shortlink.admin.contoller;

import com.zyhuang0413.shortlink.admin.common.convention.result.Result;
import com.zyhuang0413.shortlink.admin.common.convention.result.Results;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.zyhuang0413.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zyhuang
 * Date: 2023/12/29
 * Time: 15:28
 * Description: 分组控制管理层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    /**
     * 新增短链接分组
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam) {
        groupService.saveGroup(requestParam);
        return Results.success();
    }

}
