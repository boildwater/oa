/**
 * 
 */
package com.bw.oa.utils;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author BoildWater
 *
 */
@Entity
public class JsonUtil {
	//一般数组转换成JSON

			public static String testArrayToJSON(){
			    boolean[] boolArray = new boolean[]{true,false,true};  
			    JSONArray jsonArray = JSONArray.fromObject( boolArray );  
			    
			    System.out.println( jsonArray );  
			    return jsonArray.toString();
			    // prints [true,false,true]  
			}
			
			
			//Collection对象转换成JSON
		
			public static String ListToJson(List list){
			     JSONArray jsonArray = JSONArray.fromObject( list );  
			    return jsonArray.toString();
			    // prints ["first","second"]  
			}
			
			
			//字符串json转换成json， 根据情况是用JSONArray或JSONObject

			public static String JsonStrToJSON(String str){
			    JSONArray jsonArray = JSONArray.fromObject( str );  
			    return jsonArray.toString();
			}
			
			
			//Map转换成json， 是用jsonObject

			@SuppressWarnings("unchecked")
			public static String MapToJSON(Map map){
				@SuppressWarnings("rawtypes")
				JSONObject jsonObject = JSONObject.fromObject( map );  	
				return jsonObject.toString();
			}
			
			//复合类型bean转成成json
	/*
			public void testBeadToJSON(){
				MyBean bean = new MyBean();
				bean.setId("001");
				bean.setName("银行卡");
				bean.setDate(new Date());
				
				List cardNum = new ArrayList();
				cardNum.add("农行");
				cardNum.add("工行");
				cardNum.add("建行");
				cardNum.add(new Person("test"));
				
				bean.setCardNum(cardNum);
				
				JSONObject jsonObject = JSONObject.fromObject(bean);
				System.out.println(jsonObject);
				
			}
			
			//普通类型的json转换成对象

			public void testJSONToObject() throws Exception{
			    String json = "{name=\"json\",bool:true,int:1,double:2.2,func:function(a){ return a; },array:[1,2]}";  
			    JSONObject jsonObject = JSONObject.fromObject( json ); 
			    System.out.println(jsonObject);
			    Object bean = JSONObject.toBean( jsonObject ); 
			    assertEquals( jsonObject.get( "name" ), PropertyUtils.getProperty( bean, "name" ) );  
			    assertEquals( jsonObject.get( "bool" ), PropertyUtils.getProperty( bean, "bool" ) );  
			    assertEquals( jsonObject.get( "int" ), PropertyUtils.getProperty( bean, "int" ) );  
			    assertEquals( jsonObject.get( "double" ), PropertyUtils.getProperty( bean, "double" ) );  
			    assertEquals( jsonObject.get( "func" ), PropertyUtils.getProperty( bean, "func" ) );  
			    System.out.println(PropertyUtils.getProperty(bean, "name"));
			    System.out.println(PropertyUtils.getProperty(bean, "bool"));
			    System.out.println(PropertyUtils.getProperty(bean, "int"));
			    System.out.println(PropertyUtils.getProperty(bean, "double"));
			    System.out.println(PropertyUtils.getProperty(bean, "func"));
			    System.out.println(PropertyUtils.getProperty(bean, "array"));
			    
			    List arrayList = (List)JSONArray.toCollection(jsonObject.getJSONArray("array"));
			    for(Object object : arrayList){
			    	System.out.println(object);
			    }
			    
			}
			
			
			//将json解析成复合类型对象, 包含List

			public void testJSONToBeanHavaList(){
				String json = "{list:[{name:'test1'},{name:'test2'}],map:[{test1:{name:'test1'}},{test2:{name:'test2'}}]}";
//				String json = "{list:[{name:'test1'},{name:'test2'}]}";
				Map classMap = new HashMap();
				classMap.put("list", Person.class);
				MyBeanWithPerson diyBean = (MyBeanWithPerson)JSONObject.toBean(JSONObject.fromObject(json),MyBeanWithPerson.class , classMap);
				System.out.println(diyBean);
				
				List list = diyBean.getList();
				for(Object o : list){
					if(o instanceof Person){
						Person p = (Person)o;
						System.out.println(p.getName());
					}
				}
			}
			
			
			//将json解析成复合类型对象, 包含Map

			public void testJSONToBeanHavaMap(){
				//把Map看成一个对象
				String json = "{list:[{name:'test1'},{name:'test2'}],map:{test1:{name:'test1'},test2:{name:'test2'}}}";
				Map classMap = new HashMap();
				classMap.put("list", Person.class);
				classMap.put("map", Map.class);
				//使用暗示，直接将json解析为指定自定义对象，其中List完全解析,Map没有完全解析
				MyBeanWithPerson diyBean = (MyBeanWithPerson)JSONObject.toBean(JSONObject.fromObject(json),MyBeanWithPerson.class , classMap);
				System.out.println(diyBean);
				
				System.out.println("do the list release");
				List<Person> list = diyBean.getList();
				for(Person o : list){
					Person p = (Person)o;
					System.out.println(p.getName());
				}
				
				System.out.println("do the map release");
				
				//先往注册器中注册变换器，需要用到ezmorph包中的类
				MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
				Morpher dynaMorpher = new BeanMorpher( Person.class,  morpherRegistry);  
				morpherRegistry.registerMorpher( dynaMorpher );  
				
				
				Map map = diyBean.getMap();
				/*这里的map没进行类型暗示，故按默认的，里面存的为net.sf.ezmorph.bean.MorphDynaBean类型的对象*/
			/*
				System.out.println(map);
				List<Person> output = new ArrayList();  
				for( Iterator i = map.values().iterator(); i.hasNext(); ){  
					//使用注册器对指定DynaBean进行对象变换
				   output.add( (Person)morpherRegistry.morph( Person.class, i.next() ) );  
				}  
				
				for(Person p : output){
					System.out.println(p.getName());
				}
				*/
				
}
