package com.lh.rpc.protocol;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务描述
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {

    //服务类
    private String clazz;
    //此服务的方法
    private String method;
    //返回值的类型
    private String returnType;
    //参数列表
    private String[] parameterTypes;


    private static ServiceDescriptor newInstance(Class<?> clazz, Method method) {
        ServiceDescriptor serviceDescriptor = new ServiceDescriptor();
        serviceDescriptor.setClazz(clazz.getName());
        serviceDescriptor.setMethod(method.getName());
        serviceDescriptor.setReturnType(method.getReturnType().getTypeName());

        String[] paramterTypes = Arrays.stream(method.getParameterTypes()).map(Class::getName).toArray(String[]::new);
        serviceDescriptor.setParameterTypes(paramterTypes);
        return serviceDescriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceDescriptor that = (ServiceDescriptor) o;
        return Objects.equals(clazz, that.clazz) &&
                Objects.equals(method, that.method) &&
                Objects.equals(returnType, that.returnType) &&
                Arrays.equals(parameterTypes, that.parameterTypes);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(clazz, method, returnType);
        result = 31 * result + Arrays.hashCode(parameterTypes);
        return result;
    }

    @Override
    public String toString() {
        return "com.lh.rpc.protocol.ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}