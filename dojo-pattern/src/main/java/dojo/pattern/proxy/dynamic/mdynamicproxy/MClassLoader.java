/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: MClassLoader
 * Author:   mzh
 * Date:     2019/5/6 23:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package dojo.pattern.proxy.dynamic.mdynamicproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈类加载〉
 *
 * @author mzh
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MClassLoader extends ClassLoader {
    private File file;

    public MClassLoader() {
        String classPath = MClassLoader.class.getResource("").getPath();
        this.file = new File(classPath);
    }

    /**
     * 功能描述: 类加载，字节码转类<br>
     * 〈〉
     *

     * @return:
     * @since: 1.0.0
     * @Author:mzh
     * @Date: 2019/5/7 0:11
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MClassLoader.class.getPackage().getName() + "." + name;
        if(file  != null){
            File classFile = new File(file,name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte [] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
