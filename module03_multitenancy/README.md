> ###  任务 3（代码作业）：提升系统扩展性
>
>**任务目标：**
>基于管道 - 过滤器模式实现一个新的过滤器组件，用来屏蔽那些客服名称中包含特定文字的客服数据。



新增一个Filter：

```java
public class CustomerStaffNameFilter extends AbstractCustomerStaffFilter {

    @Override
    public PlatformCustomerStaff execute(PlatformCustomerStaff customerStaff) {
        //简单示例，存放敏感字符串的数组，遍历数组对比，包含这些字符串的则替换为"***"
        List<String> sensitiveWords = new ArrayList<>();
        sensitiveWords.add("tianyalan");

        if (!sensitiveWords.isEmpty()) {
            for (String sensitiveWord : sensitiveWords) {
                if (customerStaff.getStaffName().indexOf(sensitiveWord) == -1) {
                    continue;
                } else {
                    customerStaff.setStaffName("***");
                }
            }
        }

        return customerStaff;
    }
}

```

在Endpoint中构造方法添加该Filter：

```java
public class CustomerStaffEndpointImpl implements CustomerStaffEndpoint {

	public CustomerStaffEndpointImpl() {
        customerStaffFilterChain = new CustomerStaffFilterChain();
        customerStaffFilterChain.addFilter(new CustomerStaffEmptyFilter());
        customerStaffFilterChain.addFilter(new CustomerStaffNameFilter());
    }
    ...omit...
        
}
```

