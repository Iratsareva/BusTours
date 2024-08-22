package org.example.controller;

import org.example.dto.PaymentDTO;
import org.example.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public PaymentDTO addPayment (@RequestBody PaymentDTO paymentDTO){
        return paymentService.addPayment(paymentDTO);
    }

    @GetMapping("/{id}")
    public PaymentDTO getPaymentById(@PathVariable int id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/all")
    Iterable<PaymentDTO> getAll() {
        return paymentService.findAll();
    }


    @GetMapping("/pay/{idTicket}")
    public PaymentDTO paymentTicket (@PathVariable int idTicket){
        return paymentService.paymentTicket(idTicket);
    }

}
