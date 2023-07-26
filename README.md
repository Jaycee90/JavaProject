# CS3354_Project_Group17
CS3354 Summer class project group 17

Project details: In this project, we will design and implement a simple inventory management system.
The Inventory Management System is a real-time database of inventory that sends products to connecting multiple stores. 
We will use several files to implement the database in this project.

 
In the system, we are implementing the following functionalities:
The System holds all the details (ID, Name, address) of all the stores of this franchise.
It holds the details of all Product Stocks (ID, Name, number of items) held in the inventory of the company.
Users will be able to add new product stocks.
Users will be able to do a few transactions 1. Incoming transactions: 
                                            Add new items to the inventory using either the command line or a file.
                                            (ID, Type, Date) for the transaction (ProductID, Number of Items) for each product of the transaction
                                            2. Outgoing transactions: Send items to the stores through either the command line or a file.
                                            (ID, Type, Date, StoreID) for the transaction
                                            (ProductID, Number of Items) for each product of the transaction
Users will be able to view several reports (we will implement any four):
           1.Items, that are available in the inventory.
           2.Items entered in the inventory.
           3.Items sent to the stores (all or for one store)
           4.All incoming/outgoing transactions (All or for one month)
           5.All incoming/outgoing transactions of a product.
           6.Most number of incoming/outgoing items
