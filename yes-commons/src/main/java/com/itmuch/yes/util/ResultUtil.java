package com.itmuch.yes.util;

import com.itmuch.yes.core.convert.AjaxResult;

/**
 * @author zhouli
 */
public class ResultUtil<T> {

    public static final int OK_STATUS = 200;
    public static final String OK_MSG = "操作成功";

    public static <T> AjaxResult<T> success() {
        AjaxResult<T> result = new AjaxResult<>();
        result.setStatus(OK_STATUS);
        result.setMsg(OK_MSG);

        return result;
    }

    public static <T> AjaxResult<T> success(T data) {
        AjaxResult<T> result = new AjaxResult<>();
        result.setStatus(OK_STATUS);
        result.setMsg(OK_MSG);
        result.setData(data);

        return result;
    }

    public static <T> AjaxResult<T> error(int status, String msg) {
        AjaxResult<T> result = new AjaxResult<>();
        result.setStatus(status);
        result.setMsg(msg);
        return result;
    }
}
