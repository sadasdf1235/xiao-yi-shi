package shop.xiaoyishi.service;

import org.apache.ibatis.annotations.Mapper;

public interface HistoryService {
    /**
     * 查询历史数量
     */
    Integer countHistory(Long userId);
}
