package com.cms.project.controller;

import com.cms.project.entity.OrderDetail;
import com.cms.project.entity.OrderInput;
import com.cms.project.entity.TransactionDetails;
import com.cms.project.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping({"/placeOrder/{isSingleProductCheckout}"})
    public void placeOrder(
            @PathVariable(name = "isSingleProductCheckout") boolean isSingleProductCheckout ,
            @RequestBody OrderInput orderInput) {
        orderDetailService.placeOrder(orderInput,isSingleProductCheckout);
    }
    //API to return orderdetails to user
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getOrderDetails"})
    public List<OrderDetail> getOrderDetails() {

        return orderDetailService.getOrderDetails();
    }
    //API for returning orderdetails to admin
    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/getAllOrderDetails/{status}"})
    public List<OrderDetail> getAllOrderDetails(@PathVariable(name = "status") String status) {
        return orderDetailService.getAllOrderDetails(status);
    }
//API for orderdelivered
    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/markOrderAsDelivered/{orderId}"})
    public void markOrderAsDelivered(@PathVariable(name = "orderId") Integer orderId) {
        orderDetailService.markOrderAsDelivered(orderId);
    }


    //API for payment
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/createTransaction/{amount}"})
    public TransactionDetails createTransaction(@PathVariable(name = "amount") Double amount) {
        return orderDetailService.createTransaction(amount);
    }
}
