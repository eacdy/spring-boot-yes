package com.itmuch.yes.core.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页VO
 *
 * @author itmuch.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageQueryDTO {
    public static final int DEFAULT_PAGE_NO = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;
    /**
     * 页码
     */
    private Integer pageNo;

    /**
     * 一页显示多少条
     */
    private Integer pageSize;

    /**
     * 页码
     *
     * @return 页码
     */
    public Integer getPageNo() {
        if (this.pageNo == null || this.pageNo <= 0) {
            return DEFAULT_PAGE_NO;
        }
        return this.pageNo;
    }

    /**
     * 一页显示多少条
     *
     * @return 一页显示多少条
     */
    public Integer getPageSize() {
        if (this.pageSize == null) {
            return DEFAULT_PAGE_SIZE;
        }
        if (this.pageSize > MAX_PAGE_SIZE) {
            this.pageSize = MAX_PAGE_SIZE;
        } else if (this.pageSize <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
        return this.pageSize;
    }
}
