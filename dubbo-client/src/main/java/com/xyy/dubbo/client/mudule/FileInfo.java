package com.xyy.dubbo.client.mudule;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class FileInfo {
    private Integer id;

    private String name;

    private String path;

    private Long length;

    private String createdBy;

    private String updateby;

    private Long parentId;

    private Boolean isFolder;

}