# DAT152_Globalization
Exercise 2 – Globalization


A small web application that contains some elements similar to a webstore.
The application has three pages, see the examples below for views in different languages:


Home (/home) - index.jsp

![image](https://user-images.githubusercontent.com/42578147/135932268-e6774bb5-9dcc-4b45-9350-d2a93da989f1.png)


Product Page (/store) - store.jsp

![image](https://user-images.githubusercontent.com/42578147/135932374-d80d615e-5778-46ab-9953-847a3c790c89.png)

Cart (/cart) - cart.jsp

![image](https://user-images.githubusercontent.com/42578147/135932454-8aba3519-7f95-4d79-a6c5-9133dfa7a23e.png)

# Data on products conceivably stored in a "database". Relational model for the database:

Product (pno, pName, priceInEuro, imageFile) 

Description (pno, langCode, text), FK pno -> product.pno


# Custom tags:

Copyright-tag - writes the “since year” and the current year in Roman numerals

Short-Tag - limits the length of product description in the carts summary


