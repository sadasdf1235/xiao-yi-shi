package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.service.FollowService;

@RestController
@Slf4j
@RequestMapping("/user/follow")
@Api(tags = "关注管理")
public class FollowController {
    @Autowired
    private FollowService followService;
}
