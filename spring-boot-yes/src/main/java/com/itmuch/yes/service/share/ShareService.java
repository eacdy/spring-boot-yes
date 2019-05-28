package com.itmuch.yes.service.share;

import com.itmuch.yes.domain.entity.share.Share;
import com.itmuch.yes.mapper.share.ShareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ShareService {
    @Autowired
    private ShareMapper shareMapper;

    public Share selectById(@PathVariable Integer id) {
        return this.shareMapper.selectByPrimaryKey(id);
    }

    public void insert(Share share) {
        this.shareMapper.insertSelective(share);
    }
}
