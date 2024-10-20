package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CangchuxinxiDao;
import com.entity.CangchuxinxiEntity;
import com.service.CangchuxinxiService;
import com.entity.vo.CangchuxinxiVO;
import com.entity.view.CangchuxinxiView;

@Service("cangchuxinxiService")
public class CangchuxinxiServiceImpl extends ServiceImpl<CangchuxinxiDao, CangchuxinxiEntity> implements CangchuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CangchuxinxiEntity> page = this.selectPage(
                new Query<CangchuxinxiEntity>(params).getPage(),
                new EntityWrapper<CangchuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CangchuxinxiEntity> wrapper) {
		  Page<CangchuxinxiView> page =new Query<CangchuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CangchuxinxiVO> selectListVO(Wrapper<CangchuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CangchuxinxiVO selectVO(Wrapper<CangchuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CangchuxinxiView> selectListView(Wrapper<CangchuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CangchuxinxiView selectView(Wrapper<CangchuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
