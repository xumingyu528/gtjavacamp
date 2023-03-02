



## 作业

**任务 2（代码作业）**：实现自定义 Actuator

**任务目标：**实现一个定制化的 Acturator 端点，用来实现对客服人员新增次数的监控。

Endpoint：

```java
@Configuration
@Endpoint(id = "customerStaffCount",enableByDefault = true)
public class CustomerStaffCountEndpoint {

    @Autowired
    private CustomerStaffMapper customerStaffMapper;

    @ReadOperation
    public Map<String,Object> countCustomerStaffs(){
        Map<String,Object> result = new HashMap<>();
        result.put("count: ",customerStaffMapper.countCustomerStaffs());
        return result;
    }
}

```

Mapper：

```java
public interface CustomerStaffMapper extends BaseMapper<CustomerStaff> {
    default Long countCustomerStaffs(){
        LambdaQueryWrapper<CustomerStaff> queryWrapper = new LambdaQueryWrapper<>();
        return this.selectCount(queryWrapper);
    }

    ...omit...

}
```

Test：

```sh
###
GET localhost:8080/actuator/customerStaffCount
Content-Type: application/json
###

Response:
GET http://localhost:8080/actuator/customerStaffCount

HTTP/1.1 200 
Content-Type: application/vnd.spring-boot.actuator.v3+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Thu, 02 Mar 2023 07:45:14 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "count: ": 6
}

Response code: 200; Time: 21ms; Content length: 13 bytes


```

