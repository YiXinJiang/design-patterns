package com.jyx.test.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: TreeData
 * @Description:
 * @Author: jyx
 * @Date: 2024-02-20 16:23
 **/

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TreeData implements Serializable {

    public TreeData(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;

    private String name;

    private List<TreeData> childs;

}
