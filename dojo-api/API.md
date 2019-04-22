简单步骤
1. 新建springboot项目Dojo，使用gradle做构建工具
2. 项目内新建模块dojo-api，dojo-core，选择 gradle -> java 
3. 删除原项目下的src目录
4. 修改根目录settings.gradle， bulid.gradle
5. 修改dojo-api，dojo-core下dojo-api.gradle，dojo-core.gradle
6. dojo-core新建hello包，新建HelloService，编写getName方法
7. dojo-api新建HelloController,编写testControllerValidation接口，调用getName服务
8. dojo-api新建启动类Application，启动工程，浏览器访问 http://localhost:8080/hello/test 显示"Hi, I'm xiaoma"
9. ok，多模块工程成功