/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MProxy
 * Author:   mzh
 * Date:     2019/5/6 23:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic.mdynamicproxy;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用来生成代码〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MProxy {
    private static String eol = "\r\n";

    /**
     * 功能描述: <br>
     * 〈〉
     *  1. 动态生成源代码，根据传入的 interfaces的方法数重写方法
     *  2. 输出源代码到磁盘
     *  3. 动态编译
     *  4. 加载类 MClassLoader

     * @return:
     * @since: 1.0.0
     * @Author:mzh
     * @Date: 2019/5/6 23:39
     */
    public static Object newProxyInstance(MClassLoader loader,
                                          Class<?>[] interfaces,
                                          MInvocationHandler h) throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
        // 1.动态生成源代码
        String srcCode = getSrcCode(interfaces);

        // 2.java文件输出
        String filePath = MProxy.class.getResource("").getPath();
        File f = new File(filePath + "$Proxy0.java");
        FileWriter writer = new FileWriter(f);
        writer.write(srcCode);
        writer.flush();
        writer.close();

        // 3.生成的.java文件编译成.class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = manager.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
        task.call();
        manager.close();

        // 4.编译生成的.class我那件加载到JVM
        Class proxyClass = loader.findClass("$Proxy0");
        Constructor constructor = proxyClass.getConstructor(MInvocationHandler.class);
        f.delete();

        // 5.返回字节码重组的新代理对象
        return constructor.newInstance(h);
    }

    private static String getSrcCode(Class<?>[] interfaces) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package dojo.pattern.proxy.dynamic.mdynamicproxy;" + eol);
        stringBuffer.append("import dojo.pattern.proxy.IPerson;" + eol);
        stringBuffer.append("import java.lang.reflect.*;" + eol);
        stringBuffer.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + eol);
            stringBuffer.append("MInvocationHandler h;" + eol);

            stringBuffer.append("public $Proxy0 (MInvocationHandler h) {" + eol);
                stringBuffer.append("this.h = h;" + eol);
            stringBuffer.append("}" + eol);

            for (Method method:interfaces[0].getMethods()) {
                Class<?>[] params = method.getParameterTypes();
                StringBuffer paramNames = new StringBuffer();
                StringBuffer paramValues = new StringBuffer();
                StringBuffer paramClasses = new StringBuffer();

                int paramLen = params.length;
                for (int i = 0; i < paramLen; i++) {
                    Class clazz = params[i];
                    String typeName = clazz.getName();
                    String paramName = toLowerFirstCase(clazz.getSimpleName());
                    paramNames.append(typeName + " " + paramName);
                    paramValues.append(paramName);
                    paramClasses.append(clazz.getName() + ".class");
                    if (i > 0 && i < paramLen - 1) {
                        paramNames.append(",");
                        paramValues.append(",");
                        paramClasses.append(",");
                    }
                }

                stringBuffer.append("public " + method.getReturnType().getName() + " " + method.getName() + "(" + paramNames.toString() + ")" + eol);
                stringBuffer.append("{" + eol);
                    stringBuffer.append("try {" + eol);
                        stringBuffer.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + method.getName() + "\", new Class[]{" + paramClasses.toString() + "});" + eol);
                        stringBuffer.append((hasReturnValue(method.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})",method.getReturnType()) + ";" + eol);
                    stringBuffer.append("} catch (Throwable e) {" + eol);
                        stringBuffer.append("throw new UndeclaredThrowableException(e);" + eol);
                    stringBuffer.append("}" + eol);
                    stringBuffer.append(getReturnEmptyCode(method.getReturnType()));
                stringBuffer.append("}" + eol);
            }
        stringBuffer.append("}" + eol);
        return stringBuffer.toString();
    }

    private static Map<Class,Class> mappings = new HashMap<>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }


    private static String getCaseCode(String code,Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() +  ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> clazz){
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
