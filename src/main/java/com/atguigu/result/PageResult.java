package com.atguigu.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 包名:com.atguigu.result
 *
 * @author Leevi
 * 日期2023-09-10  14:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private List<T> data;
    private Integer pageSize;
    private Long total;
    private Integer currentPage;
}
