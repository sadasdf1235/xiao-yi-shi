package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.vo.CollectVO;
import shop.xiaoyishi.service.HistoryService;
import shop.xiaoyishi.vo.HistoryVO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user/history")
@Api(tags = "历史管理")
public class HistoryController {
    private HistoryService historyService;

    /**
     * 历史列表
     * @param userId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("历史列表")
    public Result collectList(Long userId, Integer type) {
        log.info("查询历史列表 {}", userId);
        log.info("收藏类型 {}", type);
        List<HistoryVO> historyVOS = historyService.historyList(userId, type);
        log.info("收藏类型 {}", historyVOS);
        return Result.success(historyVOS);

    }
}
