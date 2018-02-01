# mycloud
spring cloud some test

翟永超 Spring Cloud微服务实战
#2018-1-30  p71
1、Eureka Server的高可用实际上是将自己作为服务向其他服务注册中心注册自己，这样可以形成一组相互注册的服务注册中心，
    以实现服务清单的互相同步
2、在 C:\Windows\System32\drivers\etc\host (linux /etc/hosts ) 中 增加 127.0.0.1 peer1 127.0.0.1 peer2
3、eureka.instance.prefer-ip-address=true 表示当前服务以IP形式注册到Eureka
4、服务注册中心、服务提供者、服务消费者
4、Eureka中有Region和Zone的概念，一个Region中可以包含多个Zone，每个服务客户端需要被注册到一个Zone中，
    所以一个客户端对应一个Region和Zone。在进行服务调用的时候，优先访问同处一个Zone中的服务提供方，若访问不到，就访问其他Zone
5、页面出现红色的警告，触发了EurekaServer的自我保护机制


#2018-2-1  p159
1、@Path 标注资源类或者方法的相对路径
2、@GET @PUT @POST @DELETE  http的请求类型
3、@Produces 返回的MIME媒体类型
4、@Consumes 可接收请求的MIME媒体类型
5、@PathParam (URL的路径) @QueryParam (URL的查询参数)
    @HeaderParam (http请求的头信息) @CookieParam (http请求的头信息)
    @MatrixParam (用来绑定包含多个property(属性)=value(值)方法参数表达式)
    @FormParam   (http form表单)
    分别表示参数来自Http请求的不同位置
