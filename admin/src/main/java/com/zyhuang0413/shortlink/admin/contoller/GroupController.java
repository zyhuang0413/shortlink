package com.zyhuang0413.shortlink.admin.contoller;

import com.zyhuang0413.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
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

}
