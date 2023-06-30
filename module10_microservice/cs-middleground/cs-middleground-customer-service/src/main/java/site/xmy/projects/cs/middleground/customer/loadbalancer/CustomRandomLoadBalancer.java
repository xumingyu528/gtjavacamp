package site.xmy.projects.cs.middleground.customer.loadbalancer;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.DefaultResponse;
import org.springframework.cloud.client.loadbalancer.EmptyResponse;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.NoopServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

public class CustomRandomLoadBalancer implements ReactorServiceInstanceLoadBalancer {
    private ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierProvider;

    public CustomRandomLoadBalancer(ObjectProvider<ServiceInstanceListSupplier> serviceInstanceListSupplierObjectProvider) {
        this.serviceInstanceListSupplierProvider = serviceInstanceListSupplierObjectProvider;
    }

    @Override
    public Mono<Response<ServiceInstance>> choose(Request request) {

        ServiceInstanceListSupplier supplier = serviceInstanceListSupplierProvider
                .getIfAvailable(NoopServiceInstanceListSupplier::new);
        return supplier.get().next().map(this::getInstanceResponse);
    }

    private Response<ServiceInstance> getInstanceResponse(List<ServiceInstance> instances){
        System.out.println("custom define loadbalancer algorithm");
        if (instances.isEmpty())
            return new EmptyResponse();

        int size = instances.size();
        Random random = new Random();
        ServiceInstance instance = instances.get(random.nextInt(size));
        return new DefaultResponse(instance);
    }
}
