package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CangchuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CangchuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CangchuxinxiView;


/**
 * 仓储信息
 *
 * @author 
 * @email 
 * @date 2023-04-30 20:54:05
 */
public interface CangchuxinxiService extends IService<CangchuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CangchuxinxiVO> selectListVO(Wrapper<CangchuxinxiEntity> wrapper);
   	
   	CangchuxinxiVO selectVO(@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);
   	
   	List<CangchuxinxiView> selectListView(Wrapper<CangchuxinxiEntity> wrapper);
   	
   	CangchuxinxiView selectView(@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CangchuxinxiEntity> wrapper);
   	

}

