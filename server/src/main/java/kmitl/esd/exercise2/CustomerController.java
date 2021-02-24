
package kmitl.esd.exercise2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kmitl.esd.exercise2.CustomerDTO;


@RestController
@RequestMapping("/customer")

public class CustomerController {

    private final AtomicLong counter = new AtomicLong();
    private static List<CustomerDTO> customers = new ArrayList<>();

    static{
        CustomerDTO customerT = new CustomerDTO(5L,"T");
        customers.add(customerT);
    }

    /**
     *Get all customers info
     */

    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomer() {
        return CustomerService.INSTANCE.getAllCustomer();
    }

    /**
     *create new customer
     */
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer)
    {
        return CustomerService.INSTANCE.createCustomer(customer);
    }
    /**
     *update existing customer
     */

    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {
        return CustomerService.INSTANCE.updateCustomer(customer);
    }

    /**
     * Delete existing customer
     */

    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id")Long customerId){
        return  CustomerService.INSTANCE.deleteCustomer(customerId);
    }
}
