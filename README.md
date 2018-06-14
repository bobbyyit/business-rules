#Business Rules#

Start web application:
1. Run BusinessRules.main()
2. Navigate to http://localhost:9999/ to verify if service is running
3. Create payment: http://localhost:9999/order/create/:name/:product
3.1 name: Name of customer
3.2 product: Product type: PHYSICAL, BOOK, NEW_MEMBERSHIP, UPGRADE_MEMBERSHIP, VIDEO 
    No validator on product name, if value not in the list above. It will throw a 500 Internal Server Error
