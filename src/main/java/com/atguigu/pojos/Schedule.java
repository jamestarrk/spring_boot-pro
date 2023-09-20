package com.atguigu.pojos;

import com.atguigu.groups.AddGroup;
import com.atguigu.groups.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * 包名:com.atguigu.pojos
 *
 * @author Leevi
 * 日期2023-09-11  09:32
 */
@Data
public class Schedule {
    @NotNull(message = "id不能为空",groups = {UpdateGroup.class})
    @Null(message = "id必须为空",groups = {AddGroup.class})
    private Integer id;

    @NotBlank(message = "title不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private String title;

    @NotNull(message = "completed不能为空",groups = {AddGroup.class, UpdateGroup.class})
    private Boolean completed;
}
