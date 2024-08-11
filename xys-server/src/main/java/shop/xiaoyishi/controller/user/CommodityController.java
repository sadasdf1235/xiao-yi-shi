package shop.xiaoyishi.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.xiaoyishi.dto.CommodityDTO;
import shop.xiaoyishi.entity.Commodity;
import shop.xiaoyishi.result.Result;
import shop.xiaoyishi.service.CommodityService;
import shop.xiaoyishi.vo.CommodityVO;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user/commodity")
@Api(tags = "商品管理")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;
    /**
     * 查询用户商品信息
     * @return
     */
    @GetMapping("/commodityInfo")
    @ApiOperation("查询用户商品信息")
    public Result commodityInfo(Long userId){
        log.info("查询用户商品信息 {}",userId);
        List<CommodityVO> commodities = commodityService.getByUserId(userId);
        return Result.success(commodities);
    }

    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/commodities")
    @ApiOperation("查询商品信息")
    public Result commodities(){
        log.info("查询商品信息");
        List<CommodityVO> commodities = commodityService.getList();
        return Result.success(commodities);
    }

    /**
     * 查询商品列表
     * @return
     */
    @PostMapping("/addCommodity")
    @ApiOperation("添加商品")
    public Result addCommodity(@RequestBody CommodityDTO commodityDTO){
        log.info("添加商品{}",commodityDTO);
        commodityService.addCommodity(commodityDTO);
        return Result.success();
    }
}
