package site.xmy.projects.cs.search.service.impl;

import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.infrastructure.vo.Result;
import site.xmy.projects.cs.search.controller.vo.SearchParamReq;
import site.xmy.projects.cs.search.entity.CustomerAutoReply;
import site.xmy.projects.cs.search.service.CustomerAutoReplySearchService;

import java.io.IOException;

public class CustomerAutoReplySearchServiceImpl implements CustomerAutoReplySearchService {
    @Override
    public Result<PageObject<CustomerAutoReply>> searchCustomerAutoReplies(SearchParamReq searchParamReq) throws IOException {
        return null;
    }
}
