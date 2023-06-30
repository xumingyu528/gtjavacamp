package site.xmy.projects.cs.search.service;

import site.xmy.projects.cs.infrastructure.page.PageObject;
import site.xmy.projects.cs.infrastructure.vo.Result;
import site.xmy.projects.cs.search.controller.vo.SearchParamReq;
import site.xmy.projects.cs.search.entity.CustomerAutoReply;

import java.io.IOException;

public interface CustomerAutoReplySearchService {
    Result<PageObject<CustomerAutoReply>> searchCustomerAutoReplies(SearchParamReq searchParamReq) throws IOException;
}
