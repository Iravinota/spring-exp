# simple reactor

响应式编程

## 1. pom.xml

- io.projectreactor:reactor-core: 响应式编程需要的jar包. Project Reactor项目。其它reactor工具还有RxJava等

## 2. Project Reactor函数说明

- Operators - Publisher / Subscriber
  - Nothing Happens Until You subscribe()
  - Flux [ 0..N ] - onNext()、 onComplete()、 onError()
  - Mono [ 0..1 ] - onNext()、 onComplete()、 onError()
- Backpressure
  - Subscription
  - onRequest()、 onCancel()、 onDispose()
- 线程调度 Schedulers
  - immediate() / single() / newSingle()
  - elastic() / parallel() / newParallel()
- 错误处理理
  - onError / onErrorReturn / onErrorResume
  - doOnError / doFinally