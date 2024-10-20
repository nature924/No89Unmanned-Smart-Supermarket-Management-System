package com.dao;

import com.entity.CangchuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CangchuxinxiVO;
import com.entity.view.CangchuxinxiView;


/**
 * 仓储信息
 * 
 * @author 
 * @email 
 * @date 2023-04-30 20:54:05
 */
public interface CangchuxinxiDao extends BaseMapper<CangchuxinxiEntity> {
	
	List<CangchuxinxiVO> selectListVO(@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);
	
	CangchuxinxiVO selectVO(@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);
	
	List<CangchuxinxiView> selectListView(@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);

	List<CangchuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);
	
	CangchuxinxiView selectView(@Param("ew") Wrapper<CangchuxinxiEntity> wrapper);
	

}
