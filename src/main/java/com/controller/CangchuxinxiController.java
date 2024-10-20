package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CangchuxinxiEntity;
import com.entity.view.CangchuxinxiView;

import com.service.CangchuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 仓储信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-30 20:54:05
 */
@RestController
@RequestMapping("/cangchuxinxi")
public class CangchuxinxiController {
    @Autowired
    private CangchuxinxiService cangchuxinxiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CangchuxinxiEntity cangchuxinxi,
		HttpServletRequest request){
        EntityWrapper<CangchuxinxiEntity> ew = new EntityWrapper<CangchuxinxiEntity>();

		PageUtils page = cangchuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangchuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CangchuxinxiEntity cangchuxinxi, 
		HttpServletRequest request){
        EntityWrapper<CangchuxinxiEntity> ew = new EntityWrapper<CangchuxinxiEntity>();

		PageUtils page = cangchuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cangchuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CangchuxinxiEntity cangchuxinxi){
       	EntityWrapper<CangchuxinxiEntity> ew = new EntityWrapper<CangchuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cangchuxinxi, "cangchuxinxi")); 
        return R.ok().put("data", cangchuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CangchuxinxiEntity cangchuxinxi){
        EntityWrapper< CangchuxinxiEntity> ew = new EntityWrapper< CangchuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cangchuxinxi, "cangchuxinxi")); 
		CangchuxinxiView cangchuxinxiView =  cangchuxinxiService.selectView(ew);
		return R.ok("查询仓储信息成功").put("data", cangchuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CangchuxinxiEntity cangchuxinxi = cangchuxinxiService.selectById(id);
        return R.ok().put("data", cangchuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CangchuxinxiEntity cangchuxinxi = cangchuxinxiService.selectById(id);
        return R.ok().put("data", cangchuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CangchuxinxiEntity cangchuxinxi, HttpServletRequest request){
    	cangchuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cangchuxinxi);
        cangchuxinxiService.insert(cangchuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CangchuxinxiEntity cangchuxinxi, HttpServletRequest request){
    	cangchuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cangchuxinxi);
        cangchuxinxiService.insert(cangchuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CangchuxinxiEntity cangchuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cangchuxinxi);
        cangchuxinxiService.updateById(cangchuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cangchuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
