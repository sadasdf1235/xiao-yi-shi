package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.CollectService;

@RestController
@Slf4j
@RequestMapping("/user/collect")
@Api(tags = "收藏管理")
public class CollectController {
    @Autowired
    private CollectService collectService;

    /**
     * 查询收藏数量
     * @return
     */
    @GetMapping("/count")
    @ApiOperation("收藏数量")
    public Result count(Long userId){
        log.info("查询收藏数量 {}",userId);

        Integer follow = collectService.countCollect(userId);
        return Result.success();
    }

    /**
     * 收藏列表
     * @param userId
     * @return
     */
    @GetMapping("/countList")
    @ApiOperation("收藏列表")
    public Result collectList(Long userId){
        log.info("查询收藏列表 {}",userId);

        return null;
    }
}
