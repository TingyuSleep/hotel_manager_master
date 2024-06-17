# 基于Spring Boot的酒店管理系统设计与实现
> 学习过程中，遇到问题可以咨询作者：wzl_9597（微信）

### 功能介绍

平台采用B/S结构，后端采用主流的Springboot框架进行开发，前端采用主流的Vue.js进行开发。

- 功能包括：订单管理、房间管理、房型统计、住户管理、会员办理、销售统计、管理员管理。

### 适合人群

大学生、系统设计人员、课程作业、毕业设计

![输入图片说明](assets/%E5%8A%9F%E8%83%BD%E9%9C%80%E6%B1%82.jpg)

### 代码结构

- server目录是后端代码
- web目录是前端代码

### 部署运行

#### 后端运行步骤

(1) 下载代码后，使用IntelliJ IDEA打开server目录

(2) 配置application.yml文件，配置数据库和upload根目录

(3) 安装mysql 5.7数据库，并创建数据库，创建SQL如下：
```
CREATE DATABASE IF NOT EXISTS xxx DEFAULT CHARSET utf8 COLLATE utf8_general_ci
```
(4) 恢复sql数据。在mysql下依次执行如下命令：

```
mysql> use xxx;
mysql> source D:/xxx/xxx/xxx.sql;
```

(5) 启动后端服务：点击IDEA顶部run按钮


#### 前端运行步骤

(1) 安装node 16.14

(2) cmd进入web目录下，安装依赖，执行:
```
npm install 
```
(3) 运行项目
```
npm run dev
```


### 界面预览

![输入图片说明](assets/%E7%AE%A1%E7%90%86%E5%91%98%E7%AE%A1%E7%90%86.png)
![输入图片说明](assets/%E8%AE%A2%E5%8D%95%E7%AE%A1%E7%90%86.png)



### 问题以及定制咨询

微信：wzl_9597

