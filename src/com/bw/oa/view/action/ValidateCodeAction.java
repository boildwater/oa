/**
 * 
 */
package com.bw.oa.view.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bw.oa.base.baseServletAction;

/**
 * @author BoiledWater
 *
 */
//加上注解，交给spring进行管理.
@Controller
@Scope("prototype")
public class ValidateCodeAction extends baseServletAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4153553030052585987L;
	private Logger logger =Logger.getLogger(getClass());
	public String execute() throws Exception {
		logger.info("ValidateCodeAction---->execute! 登录验证码");
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");		//设置响应正文的MIME类型为图片
		int width=60, height=20;
		/**创建一个位于缓存中的图像，宽度60，高度20 */  
		final String valString="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   	
		Graphics g = image.getGraphics();      		//获取用于处理图形上下文的对象，相当于画笔
		Random random = new Random();        		//创建生成随机数的对象
		g.setColor(getRandomColor(200,250));  	  	//设置图像的背景色
		g.fillRect(0, 0, width, height);            //画一个矩形	，坐标（0，0），宽度60，高度20 
		g.setFont(new Font("Times New Roman",Font.PLAIN,18)); 	//设定字体格式
		g.setColor(getRandomColor(160,200));
		for(int i=0;i<130;i++){                     //产生130条随机干扰线
			int x = random.nextInt(width);   
			int y = random.nextInt(height);   
			int xl = random.nextInt(12);   
			int yl = random.nextInt(12);   
			g.drawLine(x,y,x+xl,y+yl);          	//在图象的坐标（x,y）和坐标（x+x1,y+y1）之间画干扰线 
		} 
		String strCode="";  
		for (int i=0;i<4;i++){   
			String strNumber=valString.charAt(random.nextInt(valString.length()))+""; //把随机数转换成String字符串
			strCode=strCode+strNumber;
			//设置字体的颜色
			g.setColor(new Color(15+random.nextInt(120),15+random.nextInt(120),15+random.nextInt(120)));
			g.drawString(strNumber,13*i+6,16);       //将验证码依次画到图像上,坐标（x=13*i+6,y=16）
		}
		session.put("validatecode", strCode);
		g.dispose();  //释放此图像的上下文以及它使用的所有系统资源
		ImageIO.write(image, "JPEG", response.getOutputStream()); 	//输出JPEG格式的图像    
		response.getOutputStream().flush();                     	//刷新输出流 
		response.getOutputStream().close();		
		return null;
	}
	private  Color getRandomColor(int fc,int bc){
		Random random = new Random();
		Color randomColor = null;
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		//设置个0-255之间的随机颜色值
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		randomColor = new Color(r,g,b);
		return randomColor ;  //返回具有指定红色、绿色和蓝色值的不透明的 sRGB 颜色
	}
}
