package com.adolphus.incident.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.adolphus.incident.common.Page;
import com.adolphus.incident.exception.BusinessError;
import com.adolphus.incident.exception.BusinessException;

/**
 * util for pagination
 * 
 * @author Zhang Chi
 * @date 2024-12-27
 */
public class PageUtil {
    private static final Logger logger = LoggerFactory.getLogger(PageUtil.class);

    /**
     * transfer spring page to my Page<T>
     * 
     * @param page
     * @param clazz
     * @return
     */

    public static <S, T> Page<T> toPage(org.springframework.data.domain.Page<S> page, Class<T> clazz) {
        List<T> list = page.getContent().stream().map(s -> {
            T t = null;
            try {
                t = clazz.getConstructor().newInstance();
            } catch (Exception e) {
                logger.error("transfer page elements failed.", e);
                throw BusinessException.build(e, BusinessError.SYSTEM_ERROR);
            }
            BeanUtils.copyProperties(s, t);
            return t;
        }).toList();
        return new Page<>(page.getNumber(), page.getSize(), page.getTotalElements(), list);
    }
}
