package com.xsungroup.stomp.message.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 调度池-高德地图-位置
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15
 */
@Data
@Accessors(chain = true)
@TableName("d_map_location")
public class MapLocationEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * app用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 定位纬度
     */
    private String lat;
    /**
     * 定位经度
     */
    private String lon;
    /**
     * 定位精度 单位 米
     */
    private String accuracy;
    /**
     * 海拔高度信息
     */
    private String altitude;
    /**
     * 室内定位建筑物ID
     */
    private String buildingId;
    /**
     * 室内定位楼层
     */
    private String floor;
    /**
     * 当前位置的POI名称
     */
    @TableField("poiName")
    private String poiName;
    /**
     * 当前位置所处AOI名称
     */
    @TableField("aoiName")
    private String aoiName;
    /**
     * 地理位置名称
     */
    private String adr;
    /**
     * 定位时间
     */
    private String utc;
    /**
     * 速度 单位 米/秒
     */
    private String spd;
    /**
     * 国家
     */
    private String country;
    /**
     * 方向
     */
    private String drc;
    /**
     * 省id
     */
    private String provinceId;
    /**
     * 省
     */
    private String province;
    /**
     * 城市id
     */
    private String cityId;
    /**
     * 城市
     */
    private String city;
    /**
     * 城区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 街道门牌号信息
     */
    private String streetNum;
    /**
     * 城市编码信息
     */
    private String cityCode;
    /**
     * 区域编码信息
     */
    private String adCode;
    private Boolean isAble;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    /**
     * 位置的时间
     */
    private Long time;


}
