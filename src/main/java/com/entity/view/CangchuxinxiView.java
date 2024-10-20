package com.entity.view;

import com.entity.CangchuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 仓储信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-30 20:54:05
 */
@TableName("cangchuxinxi")
public class CangchuxinxiView  extends CangchuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CangchuxinxiView(){
	}
 
 	public CangchuxinxiView(CangchuxinxiEntity cangchuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, cangchuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
