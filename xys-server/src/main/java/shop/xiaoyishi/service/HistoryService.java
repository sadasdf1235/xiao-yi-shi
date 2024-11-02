package shop.xiaoyishi.service;

import org.apache.ibatis.annotations.Mapper;
import shop.xiaoyishi.vo.HistoryVO;

import java.util.List;

public interface HistoryService {
    /**
     * 查询历史数量
     */
    Integer countHistory(Long userId);

    /**
     * 查询历史列表
     */
    List<HistoryVO> historyList(Long userId, Integer type);
}
