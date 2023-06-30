package site.xmy.projects.cs.servicebus.router;

import java.util.List;

public interface OutsourcingSystemRouter<T> {
    List<T> fetchOutsourcingCustomerStaffs(String systemUrl);
}
