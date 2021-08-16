package com.sharding.life.dto.request;

import java.util.Objects;

import lombok.Data;

/**
 * @author huapeng.huang
 * @version V1.0
 * @since 2021-08-14 13:46
 */
@Data
public class PageReq {

    private Integer pageNumber;

    private Integer pageSize;

    public Integer getPageNumber() {
        return Objects.nonNull(pageNumber) ? pageNumber : 1;
    }

    public Integer getPageSize() {
        return Objects.nonNull(pageSize) ? pageSize : 10;
    }
}
