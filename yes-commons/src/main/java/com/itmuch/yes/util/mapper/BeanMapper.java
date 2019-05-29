package com.itmuch.yes.util.mapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;

import java.util.List;

/**
 * 简单封装orika, 实现深度的 BeanOfClassA - BeanOfClassB 复制
 * 不要是用Apache Common BeanUtils进行类复制，每次就行反射查询对象的属性列表, 非常缓慢.
 * 注意：需要参考本模块的POM文件，显式引用orika.
 * 参考：http://yuncode.net/code/c_53a3a3146869e59
 * 参考：SpringSide
 *
 * @author itmuch.com
 */
@SuppressWarnings("ALL")
public class BeanMapper {
    private static MapperFacade mapper;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory
                .Builder()
                .mapNulls(false)
                .build();
        mapper = mapperFactory.getMapperFacade();
    }

    /**
     * 简单的复制出新类型对象.
     * 通过source.getClass() 获得源Class
     *
     * @param source           源
     * @param destinationClass 目标类
     * @param <S>              源类型
     * @param <D>              目标类型
     * @return 目标对象
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }


    /**
     * 简单的复制出新类型对象.
     * 通过source.getClass() 获得源Class
     *
     * @param source 源
     * @param d      目标对象
     * @param <S>    源类型
     * @param <D>    目标类型
     */
    public static <S, D> void map(S source, D d) {
        mapper.map(source, d);
    }


    /**
     * 极致性能的复制出新类型对象.
     * 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入
     *
     * @param source          源
     * @param sourceType      源类型
     * @param destinationType 目标类型
     * @param <S>             源
     * @param <D>             目标
     * @return 目标对象
     */
    public static <S, D> D map(S source, Type<S> sourceType, Type<D> destinationType) {
        return mapper.map(source, sourceType, destinationType);
    }

    /**
     * 简单的复制出新对象列表到ArrayList
     * 不建议使用 ma.glasnost.orika.MapperFacade#mapAsList(java.lang.Iterable, java.lang.Class) 接口, sourceClass需要反射，实在有点慢
     *
     * @param sourceList       源list
     * @param sourceClass      源类型
     * @param destinationClass 目标类型
     * @param <S>              源
     * @param <D>              目标
     * @return 目标list
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<S> sourceClass, Class<D> destinationClass) {
        return mapper.mapAsList(sourceList, TypeFactory.valueOf(sourceClass), TypeFactory.valueOf(destinationClass));
    }

    /**
     * 极致性能的复制出新类型对象到ArrayList.
     * 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入
     *
     * @param sourceList      源list
     * @param sourceType      源类型
     * @param destinationType 目标类型
     * @param <S>             源
     * @param <D>             目标
     * @return 目标list
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Type<S> sourceType, Type<D> destinationType) {
        return mapper.mapAsList(sourceList, sourceType, destinationType);
    }

    /**
     * 简单复制出新对象列表到数组
     * 通过source.getComponentType() 获得源Class
     *
     * @param destination      目标
     * @param source           源
     * @param destinationClass 目标类型
     * @param <S>              源
     * @param <D>              目标
     * @return 目标数组
     */
    public static <S, D> D[] mapArray(final D[] destination, final S[] source, final Class<D> destinationClass) {
        return mapper.mapAsArray(destination, source, destinationClass);
    }

    /**
     * 极致性能的复制出新类型对象到数组
     * 预先通过BeanMapper.getType() 静态获取并缓存Type类型，在此处传入
     *
     * @param destination     目标
     * @param source          源
     * @param sourceType      源类型
     * @param destinationType 目标类型
     * @param <S>             源
     * @param <D>             目标
     * @return 目标数组
     */
    public static <S, D> D[] mapArray(D[] destination, S[] source, Type<S> sourceType, Type<D> destinationType) {
        return mapper.mapAsArray(destination, source, sourceType, destinationType);
    }

    /**
     * 预先获取orika转换所需要的Type，避免每次转换.
     *
     * @param rawType rawType
     * @param <E>     E
     * @return E
     */
    public static <E> Type<E> getType(final Class<E> rawType) {
        return TypeFactory.valueOf(rawType);
    }

}