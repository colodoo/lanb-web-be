# 代码生成器

## 启动  

代码生成器为Web应用,所以需要正常启动项目后,才能使用.  

参考[windows部署指南](./WINDOWS_GET_STARTED.md).  

## 配置数据库  

在生成代码之前,你需要对数据库信息进行配置.  

只有正常的配置才能正常生成代码.  

application-dev.yml

```yaml
creater:
  src-path: 项目源代码路径
database:
  name: 数据库名
```

generatorConfig.xml

```xml
<jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://127.0.0.1:3306/数据库名?useUnicode=true&amp;characterEncoding=utf-8&amp;useSSL=false"
                        userId="root"
                        password=""
        >
```

分别为项目源代码路径,和数据库名,这些参数用于解决一些生成的问题.
 
## 设计数据表  

在生成代码之前,需要对数据表进行设计,因为它是基于数据表来生成代码的.  

并且在这之前我们有一些预设的表,它用来提供基础服务;它在.\src\main\resources\sql目录中.

## 生成代码  

因为删除了前端代码部分，所以现在你只能通过调用接口的方式来创建我们的代码。

一般使用Postman等工具来调用我们的代码生成接口。

### 生成Java代码  

***一键生成代码***可以生成相关的Java代码,它包含

> * Action层
> * Service层
> * DAO层

你只需要提供包名和数据表名即可.
如:

```yaml
> 包名: com.colodoo.manager.test  
> 表名: test
```

**Datagrid生成**可以生成相应的前端代码.

它具有最基本的增删改查功能.

你只需要提供功能名,功能标题,表名.

如:

```yaml
> 功能名: testManager  
> 功能标题: 测试设置  
> 表名: test
```

## 最后  

在生成所有代码之后,就可以在菜单**代码生成**中,找到它. 

到此代码生成结束. 