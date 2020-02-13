# Spring-boot实现websocket

参看<https://www.devglan.com/spring-boot/spring-websocket-integration-example-without-stomp>

## 操作方式

- 运行Application.java。这会启动localhost:8080端口
- 在浏览器中，输入http://localhost:8080
- 在Chrome浏览器中打开开发者工具，点击Sources，点击Snippets，新建一个snippet。在输入框中输入test/resources/client.js的
内容，Ctrl+s保存，点击输入框右下角的三角符号运行
- 关闭服务器停止运行
- 刷新浏览器，重新运行js，开始新的运行

运行结果

```text
Opening
Sending message: Marco!
Received message:  Polo!
Sending message: Marco!
Received message:  Polo!
Sending message: Marco!
Closing
```