package com.itmuch.yes.controller.share;

import com.itmuch.yes.core.convert.AjaxResult;
import com.itmuch.yes.domain.entity.share.Share;
import com.itmuch.yes.service.share.ShareService;
import com.itmuch.yes.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author itmuch.com
 */
@RequestMapping("/shares")
@RestController
public class ShareController {
    @Autowired
    private ShareService shareService;

    @GetMapping("/{id}")
    public AjaxResult<Share> selectById(@PathVariable Integer id) {
        return ResultUtil.success(
            this.shareService.selectById(id)
        );
    }

    @PostMapping("")
    public AjaxResult insert(@RequestBody Share share) {
        this.shareService.insert(share);
        return ResultUtil.success();
    }
}
