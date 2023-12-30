package com.zyhuang0413.shortlink.admin.contoller;

import com.zyhuang0413.shortlink.admin.common.convention.result.Result;
import com.zyhuang0413.shortlink.admin.common.convention.result.Results;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.zyhuang0413.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.zyhuang0413.shortlink.admin.dto.resp.ShortLinkGroupQueryRespDTO;
import com.zyhuang0413.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 查询短链接分组
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupQueryRespDTO>> listGroup() {
        return Results.success(groupService.listGroup());
    }

    /**
     * 修改短链接分组名称
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> update(@RequestBody ShortLinkGroupUpdateReqDTO requestParam) {
        groupService.updateGroup(requestParam);
        return Results.success();
    }

}
