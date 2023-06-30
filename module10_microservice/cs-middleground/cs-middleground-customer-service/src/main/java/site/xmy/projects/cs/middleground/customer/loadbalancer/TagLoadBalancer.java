package site.xmy.projects.cs.middleground.customer.loadbalancer;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.cloud.nacos.balancer.NacosBalancer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;
import site.xmy.projects.cs.infrastructure.tag.TagUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TagLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    @Value("${tag}")
    private String tagValue;

    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    public TagLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierObjectProvider) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierObjectProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {
        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider
                .getIfAvailable(NoopServiceInstanceListSupplier::new);

        return supplier.get().next().map(list -> getInstanceResponse(list,tagValue));
    }

    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances,String tagValue){
        System.out.println("custom define tag loadbalancer algorithm");
        if (instances.isEmpty())
            return new EmptyResponse();

        List<ServiceInstance> chooseInstances = filterList(instances, instance -> tagValue.equals(TagUtils.getTag(instance)));
        if (CollUtil.isEmpty(chooseInstances)) {
            System.out.println("no instance match tag, use default instances");
            chooseInstances = instances;
        }
        // Nacos provided random+weight Algorithm.
        return new DefaultResponse(NacosBalancer.getHostByRandomWeight3(chooseInstances));
    }

    public static <T> List<T> filterList(Collection<T> from, Predicate<T> predicate) {
        if (CollUtil.isEmpty(from)) {
            return new ArrayList<>();
        }

        return from.stream().filter(predicate).collect(Collectors.toList());
    }
}
