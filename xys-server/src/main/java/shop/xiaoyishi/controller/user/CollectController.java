package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.xiaoyishi.constant.CollectType;
import shop.xiaoyishi.constant.MessageConstant;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.CollectService;
import shop.xiaoyishi.vo.CommodityVO;
import shop.xiaoyishi.vo.PostVO;

import java.util.List;

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
        return Result.success(follow);
    }

    /**
     * 收藏列表
     * @param userId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("收藏列表")
    public Result collectList(Long userId,String type){
        log.info("查询收藏列表 {}",userId);
        // 收藏帖子 收藏商品
        if(type.equals(CollectType.COMMODITY)){
            List<CommodityVO> commodityVOList = collectService.collectCommodity(userId);
            return Result.success(commodityVOList);
        } else if (type.equals(CollectType.POST)) {
            List<PostVO> postVOList = collectService.collectPost(userId);
            return Result.success(postVOList);
        }
        return Result.error(MessageConstant.TYPE_NOT_FOUND);
    }
}
