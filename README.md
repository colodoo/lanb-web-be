# lanb-web

> 面向业务的Java框架 && 它基于Spring Boot

## 适用场景

首先要说明的是，该框架不适合大型项目的开发，因为它不具备足够多的功能。  
  
它适合业务少而具有一定复杂性的项目，这得益于Mybatis的灵活性。  

## 特性  
  
### 面向业务  
  
因为开发的初衷是为了解决同一时间开发多个业务，对后端业务中频繁出现的多个公用模块进行生成。  

## 代码生成  

### 前端代码  

该项目是在[lanb-web](https://github.com/lanb-code/lanb-web)抽离出的后端部分，删除了前端页面和前端代码生成部分。  

为的是更好的实现前后端分离。

### 后端代码  

数据库操作部分基于MyBatis Generator生成，对它进行了简单的封装。  
  
如果你对它不满意，想对它进行自定义，大可以学习它[MyBatis Generator](http://www.mybatis.org/generator/index.html) 
  
业务层面基于FreeMarkers生成，如果你有更好的代码规范和封装，那么你可以对它进行自定义。  

### 灵活性  

它具有很高的灵活性，不管是前端还是后端部分，都仅仅是基于模板的生成。  
  
所有模板都可以对其进行自定义和扩展。  

## 文档 
  
- [部署指南](./GET_STARTED.md)  
- [代码生成器](./CODE_CREATER.md)

## 想法
  
本框架还存在很多很多的问题。
  
如果你对该框架有自己的[想法](https://github.com/colodoo/lanb-web-be/issues)，那么可以在这里提出。  
  
## 社区  
  
- [组织](https://github.com/lanb-code)  
- [加入讨论](https://github.com/colodoo/lanb-web-be/issues)  
  
## 许可证书  
  
[MIT](https://github.com/colodoo/lanb-web-be/blob/master/LICENSE)  