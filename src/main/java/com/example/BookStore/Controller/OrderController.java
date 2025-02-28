package com.example.BookStore.Controller;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Model.Order;
import com.example.BookStore.Model.OrderItem;
import com.example.BookStore.Repository.OrderRepository;
import com.example.BookStore.Services.BookServices;
import com.example.BookStore.Services.CustomerService;
import com.example.BookStore.Services.OrderServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderServices orderServices;
    private final CustomerService customerService;
    private final BookServices bookServices;

    public OrderController(final OrderServices orderServices, final CustomerService customerService, final BookServices bookServices) {
        this.orderServices = orderServices;
        this.customerService = customerService;
        this.bookServices = bookServices;
    }


    @PostMapping("/add")
    public ResponseEntity<Order> checkckout(@Valid @RequestBody OrderRequest  orderRequest){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Optional<Customer> customerOpt = customerService.getByEmail(email);

        if (customerOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Customer customer = customerOpt.get();
        Order order = orderRequest.getOrder();
        order.setCustomer(customer);

        Order savedOrder = orderServices.create(order);

        // Process books and quantities
        List<Long> bookIds = orderRequest.getBookIds();
        List<Integer> quantities = orderRequest.getQuantities();

        for (int i = 0; i < bookIds.size(); i++) {
            Long bookId = bookIds.get(i);
            int qty = quantities.get(i);

            Optional<Book> bookOpt = bookServices.get(bookId);
            if (bookOpt.isPresent()) {
                Book book = bookOpt.get();
                System.out.println(bookOpt.get().getBook_id());
                orderServices.createOrderItem(savedOrder, book, qty);
            }
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedOrder.getId())
                .body(savedOrder);
    }

    //Find cart items by customer_id
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderServices.getOrdersByCustomerId(customerId));
    }
}
