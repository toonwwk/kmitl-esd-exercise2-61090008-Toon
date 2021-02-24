package kmitl.esd.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public static CustomerService INSTANCE = new CustomerService();
    private static List<CustomerDTO> customers = new ArrayList<>();

    static {
        CustomerDTO customerA = new CustomerDTO(0L,"Tom");
        CustomerDTO customerB = new CustomerDTO(1L,"Te");

        customers.add(customerA);
        customers.add(customerB);
    }

    private CustomerService() {}

    /**
     * get list of all customers
     */
    public List<CustomerDTO> getAllCustomer() {
        return customers;
    }

    /**
     * create new customer
     */
    public CustomerDTO createCustomer(CustomerDTO customer) {
        customers.add(customer);
        return customer;
    }

    /**
     * update existing customer
     */
    public CustomerDTO updateCustomer(CustomerDTO customer) {
        try {
            CustomerDTO customerTobeUpdated = customers.stream().findFirst().get();
            customers.remove(customerTobeUpdated);
            customers.add(customer);
        } catch (Exception e) {
            customers.add(customer);
        }

        return customer;
    }

    /**
     * delete existing customer
     */
    public boolean deleteCustomer(Long customerId) {
        try {
            CustomerDTO customerTobeDeleted = customers.stream().findFirst().get();
            customers.remove(customerTobeDeleted);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
