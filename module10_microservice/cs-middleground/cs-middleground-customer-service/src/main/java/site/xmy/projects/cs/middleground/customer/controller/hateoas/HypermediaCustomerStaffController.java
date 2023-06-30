package site.xmy.projects.cs.middleground.customer.controller.hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;
import site.xmy.projects.cs.middleground.customer.controller.hateoas.assembler.HypermediaCustomerStaffAssembler;
import site.xmy.projects.cs.middleground.customer.entity.staff.CustomerStaff;
import site.xmy.projects.cs.middleground.customer.service.ICustomerStaffService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/hypermedia/customerStaffs")
public class HypermediaCustomerStaffController {
    @Autowired
    ICustomerStaffService customerStaffService;

    @Autowired
    HypermediaCustomerStaffAssembler assembler;

    @GetMapping(value = "/{staffId}",produces = "application/json; charset=utf-8")
    public EntityModel<CustomerStaff> single(@PathVariable("staffId") Long staffId) {

        CustomerStaff customerStaff = customerStaffService.findCustomerStaffById(staffId);
//        Link selfLink = linkTo(methodOn(HypermediaCustomerStaffController.class).single(staffId)).withSelfRel();
//        Link rootLink = linkTo(methodOn(HypermediaCustomerStaffController.class).all()).withRel("allStaffs");

//        return EntityModel.of(customerStaff,selfLink,rootLink);
        return assembler.toModel(customerStaff);
    }

    @GetMapping(value = "/",produces = "application/json; charset=utf-8")
    public CollectionModel<EntityModel<CustomerStaff>> all() {
        List<CustomerStaff> customerStaffs = customerStaffService.findCustomerStaffs();

        return assembler.toCollectionModel(customerStaffs);
    }
}
