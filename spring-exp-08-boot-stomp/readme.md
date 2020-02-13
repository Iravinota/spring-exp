# stomp

STOMP是websocket之上的一层协议，相当于tcp之上的http。Spring实战502页。

## 1. 说明

- pom.xml:
  - spring-boot-starter-websocket: websocket
- WebSocketConfiguration.java: 配置STOMP端点，配置处理哪些消息
  - @EnableWebSocketMessageBroker: 表明这个配置类不仅配置了websocket，还支持基于代理的STOMP消息
  - 继承`WebSocketMessageBrokerConfigurer` ，支持stomp
  - `registerStompEndpoints()` 函数注册一个stomp端点，向这个端点发送的消息会被stomp解析
  - `enableSimpleBroker()` 启动一个内存消息代理（类似ActiveMQ），处理`/topic`等为前缀的消息
  - `setApplicationDestinationPrefixes("/app")` 指明以/app开头的消息由@MessageMapping指定的函数处理
- MarcoController.java:
  - @MessageMapping: 指定处理的消息类型。隐含`setApplicationDestinationPrefixes("/app")`中指定的/app路径
  - 函数中直接return可以返回信息。不return不返回信息。
  - 可以使用`SimpMessagingTemplate`在任何位置返回STOMP信息
  - @SendTo: 处理函数返回时，STOMP信息发送到哪个主题
- index.html:
  - spring boot默认加载。进入http://localhost:8080就会显示
  - 使用chrome中的console查看交互
  - `stomp.subscribe`: 订阅主题

## 2. 操作

- 运行Application.java
- chrome中打开http://localhost:8080
- 打开console，点击按钮，查看信息交互
- 打开多个chrome标签，点击按钮，多个标签都可收到消息