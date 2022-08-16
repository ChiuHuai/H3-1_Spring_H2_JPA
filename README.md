<a name="huai's readme-top"></a>
# H3-1_Spring_H2_JPA_邱懷_Huai Chiu

<!-- ABOUT THE PROJECT -->
## About The Project
8/12(Fri.) 的[回家作業](https://hackmd.io/@kazzy/BJLsMrzC5)，
將 8/5 的課堂作業（點餐）改寫成 H2 Database + Spring Data JPA :arrow_down:

建立 RESTful Web Service 專案，在 pom.xml 加入 H2 Database 和 Spring Data JPA 的 dependency。

使用 Spring Boot RestController 及多種 Annotation，再到Postman操作專案，並連線至H2查看資料。

<!-- GETTING STARTED -->
## Getting Started

1.將此專案下載或clone後，在 IDE 打開 pom.xml。

2.開啟 Postman，import HW3-1_H2_JPA.postman_collection.json

3.回到 IDE ，執行src/main/java/com.example.HW3_1 內的 Hw31Application

4.至 Postman 操作此專案

Meal

* 取得所有meal清單 http://localhost:8080/meal
* 根據ID取得meal資料 http://localhost:8080/meal/:id
* 新增meal至清單 http://localhost:8080/meal
* 修改meal資料 http://localhost:8080/meal/:id
* 刪除meal資料 http://localhost:8080/meal/:id

Order

* 取得所有order清單 http://localhost:8080/order
* :round_pushpin:取得特定id的Order，並加入特定id的Meal: 
    http://localhost:8080/order/:orderId/meal/:mealId
    
  :round_pushpin:內建假資料order內的為空，要用此連結新增meal
* 根據ID取得order資料 http://localhost:8080/order/:id
* 新增order至清單 http://localhost:8080/order
* 修改order資料 http://localhost:8080/order/:id
* 刪除order資料 http://localhost:8080/order/:id

5.連線至H2查看資料

* 連線H2: http://localhost:8080/h2-console
* Driver Class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:HW3_1
* User Name: user
* Password: pass




<p align="right">(<a href="#huai's readme-top">back to top</a>)</p>

<!-- Improvements -->
## 之後可能改善的
1. 有看到 github 上很多 project 內的 primary key 以 LONG 宣告，可以增加往後資料量</br>https://stackoverflow.com/questions/24857449/should-i-use-an-int-or-a-long-for-the-primary-key-in-an-entity-framework-model
2. 以下連結建議用 Set 而不是 List </br> https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/
3. 將 Meal 加入 Order 內的 mealList後，再直接刪除該meal，會產生Exception，待解決 </br>
JdbcSQLIntegrityConstraintViolationException: Referential integrity constraint violation

<p align="right">(<a href="#huai's readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Huai Chiu - huaichiu@systex.com

<p align="right">(<a href="#huai's readme-top">back to top</a>)</p>
