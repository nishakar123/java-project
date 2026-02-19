Steps to follow to build the project in local system:
1. Project is built on Maven archetype so maven should be installed in your system to build the project locally.
2. After extracting zip file, go to root directory of the project, ex: java-project
3. Run **mvn clean install** to build the project locally.
4. Once build is successful, you can run the unit test case with **mvn test**.

Project Tree:
├───src
   ├───main
   │   ├───java
   │      └───shopping
   │          └───cart
   │              ├───enums
   │              │       ProductPrice.java
   │              │       
   │              ├───model
   │              │       Product.java
   │              │       ShoppingCart.java
   │              │       
   │              ├───records
   │              │       ShoppingCartDetails.java
   │              │       
   │              ├───service
   │              │   │   ProductsService.java
   │              │   │   ShoppingCartProductsService.java
   │              │   │   ShoppingCartService.java
   │              │   │   
   │              │   └───impl
   │              │           ProductServiceImpl.java
   │              │           ShoppingCartProductsServiceImpl.java
   │              │           ShoppingCartServiceImpl.java
   │              │           
   │              └───utils
   │                      Constants.java
   │                      RoundDoubleValueToTwoDecimalPoint.java
   │           
   └───test
       └───java
           └───shopping
               └───cart
                       ProductServiceImplTest.java
                       ShoppingCartProductsServiceImplTest.java
                       ShoppingCartServiceImplTest.java

shopping.cart
│
├── enums        → Product pricing definitions
├── model        → Core domain models
├── service      → Business logic (interfaces + implementations)
├── records      → Immutable cart summary projection
├── utils        → Utility/helper classes
└── test         → Unit test cases

├── ShoppingCartServiceImpl
    ├── addProduct - this method will accept the Product object and add to shopping cart
    ├── getSubTotalAmountWithoutTax - this method will calculate total amount of all product without tax added in the shopping cart
    ├── getTotalTaxOnCartProducts - this method will calculate the total tax amount added in the shopping cart
    ├── getTotalSumAmountWithTaxOnCartProducts - this method will calculate the total amount with tax added in the shopping cart
    ├── getShoppingCart - this method will return the shopping cart instance with added products

├── ProductServiceImpl
    ├── getAllProductsFromShoppingCart - this method will return list of products added in the shopping cart
    ├── getProductsWithCount - this method will return the map object of cart products with product name and count of that product

├── ShoppingCartProductsServiceImpl
    ├── getShoppingCartDetails - this method will return the record object which contains map of product name and its count, subtotal amount without tax, total tax amount and total amount with tax

Help Taken From Internet:
1. I was aware but not remembered the exact stream api method name.
2. Converting the double value to 2 decimal points.
3. In test case, @BeforeEach to setup the basic so test case runs after that.
4. Created the tree graph to represent package and class information.
