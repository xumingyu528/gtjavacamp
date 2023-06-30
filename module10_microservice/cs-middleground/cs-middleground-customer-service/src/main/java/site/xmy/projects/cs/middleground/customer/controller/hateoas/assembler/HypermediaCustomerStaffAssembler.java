package site.xmy.projects.cs.middleground.customer.controller.hateoas.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;
import site.xmy.projects.cs.middleground.customer.controller.hateoas.HypermediaCustomerStaffController;
import site.xmy.projects.cs.middleground.customer.entity.staff.CustomerStaff;

@Component
public class HypermediaCustomerStaffAssembler implements SimpleRepresentationModelAssembler<CustomerStaff> {
    @Override
    public void addLinks(EntityModel<CustomerStaff> resource) {
        Long id = resource.getContent().getId();

        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HypermediaCustomerStaffController.class).single(id)).withSelfRel();
        resource.add(selfLink);
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HypermediaCustomerStaffController.class).all()).withRel("allCustomerStaffs"));
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<CustomerStaff>> resources) {
        resources.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HypermediaCustomerStaffController.class).all()).withSelfRel());

    }
}
