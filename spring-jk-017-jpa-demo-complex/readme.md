# jpa complex demo

使用公共的实体类BaseEntity，提取出Coffee和CoffeeOrder的公共部分

## 1. 根据方法名定义查询

- com.ws.exp.spring.repository.CoffeeRepository中，根据方法名，定义了查询
  - find…By… / read…By… / query…By… / get…By…
  - count…By…
  - …OrderBy…[Asc / Desc]
  - And / Or / IgnoreCase
  - Top / First / Distinct
- 接口变成了bean，怎么实现的？看源代码。