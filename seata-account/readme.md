## seata(AT)部署步骤
- 1.下载 seata1.5.2
- 2.使用nacos作为配置中心
- 2.1 启动nacos
- 2.2 配置seata的application.yml(主要配置注册中心、配置中心的地址)
- 2.3 我这里用的是nacos需要吧下过来文件种的config.txt上传到nacos
- 2.4 修改config种的配置（主要是存储db的配置，其他暂时不动）
- 2.4.1 如果配置是db的话 需要在数据库种执行sql 其TC的 事务管理器需要连接的数据库表
- 2.4.2 同时本地使用的库种也需要增加rodo表
- 2.5 启动注册中心
- 3.6 启动seata
- 3.7 需要在事务服务的发起者（TM）上加上注解 GlobalTransactional
- 3.8 启动程序 观察事务是否正确 这个方式采用的是AT模式
## seata(TCC)部署步骤
- TCC使用的场景是 1.不支持ACID事务的关系型数据库 