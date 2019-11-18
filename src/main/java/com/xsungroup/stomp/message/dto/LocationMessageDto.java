package com.xsungroup.stomp.message.dto;

import com.xsungroup.stomp.message.entity.MapLocationEntity;
import lombok.Data;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/15
 * 创建时间： 20:11
 * @version 1.0
 * @since 1.0
 */
@Data
public class LocationMessageDto {

    private String messageId;

    private List<MapLocationEntity> locationList;
}
