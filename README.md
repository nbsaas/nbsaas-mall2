## 去好店
[![maven](https://img.shields.io/maven-central/v/com.nbsaas.boot/nbsaas-boot.svg)](http://mvnrepository.com/artifact/com.nbsaas.boot/nbsaas-boot)
[![QQ](https://img.shields.io/badge/chat-on%20QQ-ff69b4.svg?style=flat-square)](//shang.qq.com/wpa/qunwpa?idkey=d1a308945e4b2ff8aeb1711c2c7914342dae15e9ce7041e94756ab355430dc78)
[![使用IntelliJ IDEA开发维护](https://img.shields.io/badge/IntelliJ%20IDEA-提供支持-blue.svg)](https://www.jetbrains.com/idea/)
[![GitHub forks](https://img.shields.io/github/stars/nbsaas/nbsaas-boot.svg?style=social&logo=github&label=Stars)](https://github.com/nbsaas/nbsaas-boot)

> 去好店，让你快速的找到喜欢的店铺。
## 最近项目正在进行重构，spring boot+nuxt3+vue3，前后端分离，请大家耐心等待
![输入图片说明](documents/images/banner.png)
### 技术选型：

#### 服务端
* Spring、SpringMVC、spring data jpa
* Spring boot,Spring cloud,Spring alibaba
* 安全权限 Shiro
* 缓存 Ehcache
* 代码生成模板 freemarker
* 其它 Jsoup、gson
* 核心采用Request-Response模式，Chain模型。
* [nbsaas-boot](https://gitee.com/cng1985/nbsaas-boot)

#### [pc端](https://gitee.com/cng1985/nbsaas-life-nuxt3)
* nuxt3
* element-plus


#### 后台管理端

* vue3
* element-plus
* axios
* [nuxt3前端](https://gitee.com/cng1985/nbsaas-life-nuxt3)
* [vue3管理端](https://gitee.com/cng1985/nbsaas-life-admin)


## 搭建步骤

1. 创建数据库。如使用MySQL，字符集选择为`utf8`或者`utf8mb4`（支持更多特殊字符，推荐）。
2. 在idea中导入maven项目。点击idea菜单`File` - `open`，选择 `项目所在磁盘位置`。创建好maven项目后，会开始从maven服务器下载第三方jar包（如spring等），需要一定时间，请耐心等待。
3. 创建mysql数据库，导入`/documents/sql/nbsaas_life.sql`
4. 修改数据库连接。打开`/gates/admin/main/resources/application.yml`文件，根据实际情况修改`jdbc.url`、`jdbc.username`、`jdbc.password`的值。
5. 运行程序AdminApplication(后台)，FrontApplication(前台)
6. 访问系统。前台接口地址：[http://localhost:8081](http://localhost:8081/)，后台接口地址：[http://127.0.0.1:8082/](http://127.0.0.1:8082/)；用户名：ada，密码：123456。

