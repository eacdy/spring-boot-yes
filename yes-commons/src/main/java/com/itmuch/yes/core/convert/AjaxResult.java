package com.itmuch.yes.core.convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * AJax返回消息体
 *
 * @param <T> T
 * @author itmuch.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class AjaxResult<T> {
    /**
     * 状态码
     */
    private long status;

    /**
     * 错误提示
     */
    private String msg;

    /**
     * payload
     */
    @Builder.Default
    private T data = null;
}