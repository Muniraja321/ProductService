package net.javaguides.productservices;


import jakarta.transaction.Transactional;
import net.javaguides.productservices.Repositories.CustomerOrderRepository;
import net.javaguides.productservices.Repositories.CategoryRepository;
import net.javaguides.productservices.Repositories.PriceRepository;
import net.javaguides.productservices.Repositories.ProductRepository;
import net.javaguides.productservices.models.Category;
import net.javaguides.productservices.models.CustomerOrder;
import net.javaguides.productservices.models.Price;
import net.javaguides.productservices.models.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import net.javaguides.productservices.inheritanceexample.singletable.Student;
import net.javaguides.productservices.inheritanceexample.joinedtable.StudentRepository;
import net.javaguides.productservices.inheritanceexample.joinedtable.MentorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootApplication
public class ProductServicesApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private CustomerOrderRepository customerOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServicesApplication.class, args);
    }




    public ProductServicesApplication(MentorRepository mentorRepository,
                                      StudentRepository studentRepository,
                                      CategoryRepository categoryRepository,
                                      ProductRepository productRepository,
                                      PriceRepository priceRepository,
                                      CustomerOrderRepository customerOrderRepository)
    {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.customerOrderRepository = customerOrderRepository;

    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
//
//        Mentor mentor = new Mentor();
//       mentor.setName("Diwakar");
//       mentor.setEmail("D@gmail.com");
//       mentor.setAvgRating(100.0);
//
//       mentorRepository.save(mentor);
//
//       User user = new User();
//       user.setName("Muniraja");
//       user.setEmail("M@gmail.com");
//
//       userRepository.save(user);
//
//        Student student = new Student();
//        student.setName("Balaji");
//        student.setEmail("B@gmail.com");
//        student.setBatch("batch1");
//        student.setPsp(99.0);
//
//        studentRepository.save(student);
//
//       List<User> Users = userRepository.findAll();
//        Users.forEach(user2 ->{
//            System.out.println(user.getName());
//
//        });
//
//        Student student = new Student();
//        student.setName("Harsha");
//        student.setEmail("H@gmail.com");
//        student.setBatch("batch2");
//        student.setPsp(95.0);
//
//        studentRepository.save(student);

//        Category category = new Category();
//        category.setName("ELECTRONICS");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee", 100.0);
//        Price savedPrice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("IPhone16");
//        //product.setPrice(100);
//        product.setImage("Image Url");
//        product.setDescription("Best Phone Ever");
//        product.setCategory(savedCategory);
//        product.setPrice(savedPrice);
//
//        productRepository.save(product);

//        Category category = new Category();
//        category.setName("ELECTRONICS");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("DINAR", 300.0);  // Don't save separately
//
//        Product product = new Product();
//        product.setTitle("IPhone3");
//        product.setImage("Image Url");
//        product.setDescription("Best Phone Ever");
//        product.setCategory(savedCategory);
//        product.setPrice(price);  // Assign price directly
//
//        productRepository.save(product);  // ✅ This will persist both Product & Price

       // List<Product> product1= productRepository.findByTitleAndPrice_currency("IPhone16-3","Rupee");

        //System.out.println(product1);

//
//
//        CustomerOrder customerOrder = new CustomerOrder();
//        customerOrder.setStatus("Pending");
//
//        List<Product> productList = new ArrayList<>();
//        productList.add(savedProduct);
//        customerOrder.setProducts(productList);
//
//        customerOrder.setTotalPrice(savedPrice);
//
//        CustomerOrder savedOrder = customerOrderRepository.save(customerOrder);
//
//        System.out.println("Order placed successfully!");












//      Optional<Category> categoryOptional = categoryRepository.
//				findById(UUID.fromString("16ae4763-f4b7-4853-b3e7-e5d32a5eba26"));
//
//
//		if(!categoryOptional.isEmpty()) {
//			Category category = categoryOptional.get();
//			System.out.println(category.getProduct());
//		}

       //productRepository.deleteById(UUID.fromString("e574bca9-408d-456c-906c-cf8a758e906e"));


//        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString("fb0bdb07-d768-41d4-9845-ce6434ace73e"));
//
//        Category category =categoryOptional.get();
//
//        System.out.println(category);
//
//        List<Product> products = category.getProduct();
//        System.out.println(products);


    }
}
