public class CustomerMain {

    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.getCustomer(105);
    }
}