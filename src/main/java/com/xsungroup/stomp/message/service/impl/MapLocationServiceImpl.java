package com.xsungroup.stomp.message.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xsungroup.stomp.message.entity.MapLocationEntity;
import com.xsungroup.stomp.message.mapper.MapLocationMapper;
import com.xsungroup.stomp.message.service.MapLocationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 调度池-高德地图-位置 服务实现类
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15
 */
@Service
public class MapLocationServiceImpl extends ServiceImpl<MapLocationMapper, MapLocationEntity> implements MapLocationService {

}
