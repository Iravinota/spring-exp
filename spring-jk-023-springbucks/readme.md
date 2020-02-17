# springbucks

一个虚拟项目

## 1. 说明

- T_COFFEE: 咖啡表，咖啡的name
  - Coffee.java: POJO
  - CoffeeRepository.jave: 使用JPA执行数据库操作
  - CoffeeService.java: repository之上的一层封装，数据库操作
- T_ORDER:  用户的订单表，customer
  - CoffeeOrder.java: POJO
  - CoffeeOrderRepository.java: 使用JPA进行数据库操作
  - CoffeeOrderService.java: repository之上的一层封装，数据库操作
- T_ORDER_COFFEE: 订单中有哪些咖啡，表
  - CoffeeOrder.java中，使用JPA注解@JoinTable引出的关联表
  - 使用CoffeeOrder的操作对其进行操作
